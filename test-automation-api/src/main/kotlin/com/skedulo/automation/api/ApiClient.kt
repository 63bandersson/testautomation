package com.skedulo.automation.api

import com.google.common.base.Stopwatch

import com.skedulo.automation.api.annotations.Authorization
import com.skedulo.automation.api.annotations.AuthorizationType
import com.skedulo.automation.api.annotations.BaseUrl
import com.skedulo.automation.api.retrofit.EnumConverterFactory
import com.skedulo.automation.api.retrofit.EnumRetrofitConverterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient (
    username: String,
    password: String,
    token: String? = null
){
    val auth:SkeduloAuthApi
    val graphQLApi: SkeduloGraphQLApi
    val mobileApi: SkeduloMobileApi
    //val skeduloSqlApi: SkeduloSqlApi

    init{
        fun <T> buildApi(clazz: Class<T>, clients: Map<AuthorizationType, OkHttpClient>): T {
            // Inspect annotations
            val type = clazz.getDeclaredAnnotation(Authorization::class.java).auth
            val url = clazz.getDeclaredAnnotation(BaseUrl::class.java).url

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(EnumConverterFactory())
                .baseUrl(url)
                .client(clients[type])
                .build()
                .create(clazz)
        }
        // Create clients (auth must be built early to get a token)
        val noAuthClient = OkHttpClient.Builder().build()
        auth = buildApi(SkeduloAuthApi::class.java, mapOf(AuthorizationType.BEARERTOKEN to noAuthClient))
        val newToken = getToken(token, username, password, auth)
        print("newtoken = $newToken")
//        val tokenClient = OkHttpClient.Builder()
//            .addInterceptor(TokenInterceptor(newToken))
//            .build()
//        val oAuthClient = OkHttpClient.Builder()
//            .addInterceptor(OAuth2Interceptor(newToken, auth))
//            .build()
        val bearerTokenClient = OkHttpClient.Builder()
            .addInterceptor(BearerTokenInterceptor(newToken))
            .build()
        val clients:Map<AuthorizationType,OkHttpClient> = mapOf(
            //AuthorizationType.NO_AUTH to noAuthClient,
            //AuthorizationType.TOKEN to tokenClient,
            //AuthorizationType.OAUTH2 to oAuthClient,
            AuthorizationType.BEARERTOKEN to bearerTokenClient
        )
        // Build retrofit objects
        graphQLApi = buildApi(SkeduloGraphQLApi::class.java, clients)
        mobileApi = buildApi(SkeduloMobileApi::class.java, clients)
        //skeduloSqlApi = buildApi(SkeduloSqlApi::class.java, clients)
          println("graphQLApi = $graphQLApi")
//        println("skeduloSqlApi = $skeduloSqlApi")
    }

    /**
     * Use the auth api to grab a valid token.
     */
    private fun getToken(
        optToken: String?,
        username: String,
        password: String,
        auth: SkeduloAuthApi
    ) : String {
        return if (optToken != null) {
            optToken
        } else {
            val tokens = auth.apiTokenAuth(username, password).execute()
            val response = tokens.body()
                ?: throw RuntimeException("No respone from authentication")

            if (response.mfa_required != null)
                throw RuntimeException("MFA Apps Must Provide Token")

            if (response.token == null)
                throw RuntimeException("No token returned")

            response.token
        }
    }

    /**
     * Inject static authorization token into the request.
     */
    private class TokenInterceptor(private val token: String) : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val newRequest = chain.request().newBuilder()
                .addHeader("Authorization", "Token $token")
                .build()
            return chain.proceed(newRequest)
        }
    }

    /**
     * Inject bearer token into the request.
     */
    private class BearerTokenInterceptor(private val bearerToken: String) : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val newRequest = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $bearerToken")
                    .addHeader("Content-Type", "application/json")
                .build()
            return chain.proceed((newRequest))
        }
    }

    /**
     * Inject oauth authorization token into request, refreshing as necessary.
     * TODO: Use the refresh token
     */
    private class OAuth2Interceptor(
        private val token: String,
        private val auth: SkeduloAuthApi
    ) : Interceptor {
        private var bearer = OAuth2Token("", "", 0, "", "")
        private var updated = Stopwatch.createStarted()

        init {
            updateBearerToken(token, true)
        }

        /**
         * Helper to update the bearer token if it has expired.
         * // TODO: is expires_in seconds or minutes?
         */
        private fun updateBearerToken(authToken:String, force: Boolean = false) {
            // Update
            if (force || updated.elapsed(TimeUnit.SECONDS) > bearer.expires_in) {
                val bearerTokenResponse = auth.toOAuth2("Token $authToken").execute()
                val bearerToken = bearerTokenResponse.body()

                if (!bearerTokenResponse.isSuccessful || bearerToken == null)
                    throw RuntimeException("Unable to get OAuth2 token.")

                bearer = bearerToken
                updated = Stopwatch.createStarted()
            }
        }

        override fun intercept(chain: Interceptor.Chain): Response {
            updateBearerToken(token, true)
            val newRequest = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer ${bearer.access_token}")
                .build()
            return chain.proceed(newRequest)
        }
    }
}
