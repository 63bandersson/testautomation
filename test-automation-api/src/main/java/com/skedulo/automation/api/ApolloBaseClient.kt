package com.skedulo.automation.api

import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.rx2.Rx2Apollo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import org.threeten.bp.Instant
import io.reactivex.*
import android.util.Log
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.skedulo.automation.api.types.UID
import okhttp3.Interceptor


class ApolloBaseClient {

    companion object {
        private val BASE_URL_GRAPHQL = "https://api.skedulo.com/graphql/graphql"
        private val AUTH_TOKEN =
            //"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IlEwWXdOekF5UTBFME1UTXdRa05FTWpWQ05rRTVSRFUxTURoRk16TXhNa1kyTVRFelFVSkJRUSJ9.eyJodHRwczovL2FwaS5za2VkdWxvLmNvbS91c2VyX2lkIjoiYXV0aDB8NWQ3ZWQ0NzdmZDQxNzEwYzRmMTBhNjIxIiwiaHR0cHM6Ly9hcGkuc2tlZHVsby5jb20vdmVuZG9yIjoic2tlZHVsbyIsImh0dHBzOi8vYXBpLnNrZWR1bG8uY29tL3VzZXJuYW1lIjoiYmFuZGVyc3Nvbitwcm9kK3N0YW5kYWxvbmVAc2tlZHVsby5jb20iLCJodHRwczovL2FwaS5za2VkdWxvLmNvbS9vcmdhbml6YXRpb25faWQiOiJza185YWU0Zjk4MWI4M2E0MjA1ODNmOTFlYmE5MGQ3ZGE1YiIsImh0dHBzOi8vYXBpLnNrZWR1bG8uY29tL25hbWUiOiJiYW5kZXJzc29uK3Byb2Qrc3RhbmRhbG9uZUBza2VkdWxvLmNvbSIsImh0dHBzOi8vYXBpLnNrZWR1bG8uY29tL3Jlc291cmNlX2lkIjoiMDAwNTYzMjYtMmMyYy00NWUxLWJkM2YtZGMzZGU4OTIxOTE2IiwiaHR0cHM6Ly9hcGkuc2tlZHVsby5jb20vcm9sZXMiOlsiYWRtaW5pc3RyYXRvciIsInNjaGVkdWxlciIsInJlc291cmNlIl0sImh0dHBzOi8vYXBpLnNrZWR1bG8uY29tL3ZlbiI6eyJ1c2VyX2lkIjoiMDAwMTc0NDQtMTI1ZC00NDI3LWExYjctOWY5ZGQxYjc4NWE2In0sImlzcyI6Imh0dHBzOi8vc2tlZHVsby5hdXRoMC5jb20vIiwic3ViIjoiYXV0aDB8NWQ3ZWQ0NzdmZDQxNzEwYzRmMTBhNjIxIiwiYXVkIjpbImh0dHBzOi8vYXBpLnNrZWR1bG8uY29tIiwiaHR0cHM6Ly9za2VkdWxvLmF1dGgwLmNvbS91c2VyaW5mbyJdLCJpYXQiOjE1NzQ4OTU3MjEsImV4cCI6MTU3NDkzODkyMSwiYXpwIjoiOW1FSkMwcUtFWkluVGE4TzJ1UzMwbWR3TFV5ajZZckgiLCJzY29wZSI6Im9wZW5pZCJ9.d_Q8vrRNLkRUst8FM5o6tsvFdK0VVlIlqO9sc2G8404jcCoseFvoeCszkZQcj5oR78-lHlTaS1LpjXx-8dP1rfGBAt_WgCSCFYI_GMtGWm5Egm_lj-rNTP45hoxW"
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2FwaS5za2VkdWxvLmNvbS9hdXRoL3Rva2VuIiwiYXVkIjoiNWMwMjMzZTc5MWMyM2Q0ZmFkZGQ2MGM4MDE1MGY3MzYiLCJqdGkiOiJNWFRrOGVkaEdFaHF2YzROeU96NTluczRuWTFDaXRPdiIsImh0dHBzOi8vYXBpLnNrZWR1bG8uY29tL3ZlbiI6eyJ1c2VyX2lkIjoiMDAwMTc0NDQtMTI1ZC00NDI3LWExYjctOWY5ZGQxYjc4NWE2In0sImh0dHBzOi8vYXBpLnNrZWR1bG8uY29tL3VzZXJfaWQiOiJhdXRoMHw1ZDdlZDQ3N2ZkNDE3MTBjNGYxMGE2MjEiLCJodHRwczovL2FwaS5za2VkdWxvLmNvbS9vcmdhbml6YXRpb25faWQiOiJza185YWU0Zjk4MWI4M2E0MjA1ODNmOTFlYmE5MGQ3ZGE1YiIsImh0dHBzOi8vYXBpLnNrZWR1bG8uY29tL3VzZXJuYW1lIjoiYmFuZGVyc3Nvbitwcm9kK3N0YW5kYWxvbmVAc2tlZHVsby5jb20iLCJzdWIiOiJhdXRoMHw1ZDdlZDQ3N2ZkNDE3MTBjNGYxMGE2MjEiLCJodHRwczovL2FwaS5za2VkdWxvLmNvbS92ZW5kb3IiOiJza2VkdWxvIiwiaHR0cHM6Ly9hcGkuc2tlZHVsby5jb20vcmVzb3VyY2VfaWQiOiIwMDA1NjMyNi0yYzJjLTQ1ZTEtYmQzZi1kYzNkZTg5MjE5MTYiLCJodHRwczovL2FwaS5za2VkdWxvLmNvbS9yb2xlcyI6WyJhZG1pbmlzdHJhdG9yIiwic2NoZWR1bGVyIiwicmVzb3VyY2UiXX0.WDPCC8cbRgz105pkxyF-TfehqZmNVktYJRYUsO3vGP0"
        private val apolloClient: ApolloClient

        init {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor { addHeadersInterceptor(it) }
                .addInterceptor(logging).build()
            apolloClient =
                ApolloClient.builder().serverUrl(BASE_URL_GRAPHQL).okHttpClient(okHttpClient)
                    .build()
        }

        fun addHeadersInterceptor(chain: Interceptor.Chain): okhttp3.Response {
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.addHeader("authorization", "Bearer $AUTH_TOKEN")
            return chain.proceed(requestBuilder.build())
        }

        fun getApolloClient(): ApolloClient {
            return apolloClient
        }

        fun fetchRegions(): Single<FetchRegionsQuery.Region> {
            //val apolloClient = getApolloClient()
            val fetchRegions = FetchRegionsQuery()
            val call = apolloClient.query(fetchRegions)
            return Rx2Apollo.from(call).singleOrError().map {
                it.data()?.run { regions }
            }
        }


        fun fetchJobs(filterQuery: String): Single<FetchJobsQuery.Job> {
            //val apolloClient = getApolloClient()
            val jobsQuery = FetchJobsQuery(filterQuery)
            val call = apolloClient.query(jobsQuery)
            return Rx2Apollo.from(call).singleOrError().map {
                it.data()?.run { jobs }
            }
        }

        fun fetchJobOffers(filterQuery: String): Single<FetchJobOffersQuery.JobOffer> {
            //val apolloClient = getApolloClient()
            val jobOffersQuery = FetchJobOffersQuery(filterQuery)
            val call = apolloClient.query(jobOffersQuery)
            return Rx2Apollo.from(call).singleOrError().map {
                it.data()?.run { jobOffers }
            }
        }
    }
}
