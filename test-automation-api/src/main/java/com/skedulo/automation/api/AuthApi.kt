package com.skedulo.automation.api

import com.skedulo.automation.api.annotations.Authorization
import com.skedulo.automation.api.annotations.AuthorizationType
import com.skedulo.automation.api.annotations.BaseUrl
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

data class Token(
    val token: String?,
    val mfa_type: String?,
    val mfa_required: Boolean?
)

data class OAuth2Token(
    val access_token: String,
    val scope: String,
    val expires_in: Int,
    val refresh_token: String,
    val token_type: String
)
data class SessionToken(
    val sessionToken: String
)

@Authorization(AuthorizationType.BEARERTOKEN)
//@BaseUrl("https://dev-api.test.skl.io")
@BaseUrl("https://api.skedulo.com")
interface SkeduloAuthApi {

    /**
     * Creates an authentication token with Multi-Factor Authentication (MFA).
     */
    @FormUrlEncoded
    @POST("api-token-auth/")
    fun apiTokenAuth(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("mfa_code") mfa_code: String): Call<Token>

    /**
     * Creates an authentication token. If Multi-Factor Authentication (MFA) is enabled [mfa_type]
     * and [mfa_required] will be set, and your MFA tool will be notified.
     */
    @FormUrlEncoded
    @POST("api-token-auth/")
    fun apiTokenAuth(
        @Field("username") username: String,
        @Field("password") password: String): Call<Token>

    /**
     */
    @POST("oauth2/migrate_token/")
    fun toOAuth2(
        @Header("Authorization") authHeader: String
    ): Call<OAuth2Token>

//    @POST("auth/whoami")
//    fun bearerTokenAuth(
//        @Header("Authorization" bearerToken: String
//    ): Call<SessionToken>
}
