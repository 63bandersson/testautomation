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


class ApolloBaseClient {

    companion object {
        private val BASE_URL_GRAPHQL = "https://api.skedulo.com"
        private val AUTH_TOKEN =
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2FwaS5za2VkdWxvLmNvbS9hdXRoL3Rva2VuIiwiYXVkIjpbIjVjMDIzM2U3OTFjMjNkNGZhZGRkNjBjODAxNTBmNzM2Il0sImp0aSI6IlBBdzBHNzNwTWtoY3dETEdNN05jNFo1cWVwNFFnVjh6IiwiaHR0cHM6Ly9hcGkuc2tlZHVsby5jb20vc2ZfZW52Ijoic2FsZXNmb3JjZSIsImh0dHBzOi8vYXBpLnNrZWR1bG8uY29tL3ZlbiI6eyJ1c2VyX2lkIjoiMDA1MnYwMDAwMFdCV3V6QUFIIiwiY29tbXVuaXR5X2lkIjpudWxsfSwiaHR0cHM6Ly9hcGkuc2tlZHVsby5jb20vdXNlcl9pZCI6InNhbGVzZm9yY2V8MDA1MnYwMDAwMFdCV3V6QUFIIiwiaHR0cHM6Ly9hcGkuc2tlZHVsby5jb20vb3JnYW5pemF0aW9uX2lkIjoiMDBEMnYwMDAwMDBReEoyRUFLIiwiaHR0cHM6Ly9hcGkuc2tlZHVsby5jb20vdXNlcm5hbWUiOiJiYW5kZXJzc29uK2RldkBza2VkdWxvLmNvbSIsInN1YiI6InNhbGVzZm9yY2V8MDA1MnYwMDAwMFdCV3V6QUFIIiwiaHR0cHM6Ly9hcGkuc2tlZHVsby5jb20vdmVuZG9yIjoic2FsZXNmb3JjZSIsImh0dHBzOi8vYXBpLnNrZWR1bG8uY29tL3Jlc291cmNlX2lkIjpudWxsLCJodHRwczovL2FwaS5za2VkdWxvLmNvbS9yb2xlcyI6WyJTY2hlZHVsZXIiLCJSZXNvdXJjZSIsIkFkbWluaXN0cmF0b3IiXX0.-up0W4kRDQkHwkuqMQt-amqTIDLwklAZNebDO9RpTeQ"
        //private val BASE_URL_SUBSCRIPTIONS = "ws://localhost:3000/subscriptions"
        private val apolloClient: ApolloClient
        //private val jobsQuery : JobsQuery

        init {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    chain.proceed(
                        chain.request().newBuilder().addHeader(
                            "Authorization",
                            "Bearer $AUTH_TOKEN"
                        ).build()
                    )
                }
                .build()
            apolloClient = ApolloClient.builder()
                .serverUrl(BASE_URL_GRAPHQL)
                .okHttpClient(okHttpClient)
                //.subscriptionTransportFactory(WebSocketSubscriptionTransport.Factory(BASE_URL_SUBSCRIPTIONS, okHttpClient))
                .build()

            //jobsQuery = JobsQuery.builder().build()
            //subscriptionSubscriptionClient = SubscriptionUpdatedSubscription.builder().build()
            //val observer = Rx2Apollo.from(getSubscriptionSubscriptionCall())
            //observer.subscribeWith(SubscriptionSubscriber ())
        }

        fun getApolloClient(): ApolloClient {
            return apolloClient
        }

        //        fun fetchJobsAndActivities(start: Instant, end: Instant): Single<JobAndActivitiesContainer> {
//            //Log.d("START: ", start.toString())
//            //val resourceId = metaData.getUserMetadata()?.resourceId
//            val resourceId = ""
//            val query = AgendaQuery.builder()
//                .resourcesFilter("UID == '${resourceId}'")
//                .activityFilter("ResourceId == '${resourceId}' AND Start >= $start AND End <= $end ")
//                .allocationFilter("Start >= $start AND End <= $end" +
//                        "AND Status != 'Deleted' " +
//                        "AND Status != 'Declined' " +
//                        "AND Status != 'Pending Dispatch'")
//                .build()
//
//            val call = apolloClient?.query(query)!!
//
//            return Rx2Apollo.from(call).singleOrError().map {
//                //Log.d("GOT DATA", it.toString())
//                it.data()?.let { data ->
//                    val jobs = data.resources().edges().first().node().ResourceAllocations().map { allocation ->
//                        Job.fromGraphql(allocation.Job())
//                    }.toList()
//                    val activities = data.activities().edges().map { activities ->
//                        AllocationActivity.fromGraphql(activities.node())
//                    }.toList()
//                    JobAndActivitiesContainer(activities, jobs.filter { job -> job.status !in unAcceptedJobStatus })
//                } ?: throw ApiException(it.errors().firstOrNull()?.message()
//                    ?: "An Error occurred", it.errors().firstOrNull().hashCode())
//            }.doOnError {
//                Log.d("Error fetching data: ", it.message ?: "Parse Error")
//                throw it
//            }
//        }
//    }
//        fun getJobs() : Single<Job> {
//            val query = JobsQuery.Builder()
//                .build()
//            val call = apolloClient?.query(query)!!
//
//            return Rx2Apollo.from(call).singleOrError() {
//                Log.d("GOT DATA", it.toString())
//                it.data()?.let { data ->
//                    val jobs = data.jobs().edges().first().node().ResourceAllocations()
////                        .map { allocation ->
////                            Job.fromGraphql(allocation.Job())
////                        }.toList()
//                }
//            }
//        }
//    fun getSubscriptionQueryClient(): SubscriptionsQuery {
//        return subscriptionQueryClient
//    }
//    fun getSubscriptionMutationClient(id_user: String, data: MutableList<MessageInput>): SubscriptionMutation {
//        val builder = SubscriptionMutation.builder()
//        builder.id_user(id_user)
//        builder.data(data)
//        return builder.build()
//    }
//    fun getSubscriptionSubscriptionClient(): SubscriptionUpdatedSubscription {
//        return subscriptionSubscriptionClient
//    }
//    fun getSubscriptionQueryCall(): ApolloCall<SubscriptionsQuery.Data> {
//        return apolloClient.query(subscriptionQueryClient)
//    }
//    fun getSubscriptionMutationCall(mutationBuilded: SubscriptionMutation): ApolloCall<SubscriptionMutation.Data> {
//        return apolloClient.mutate(mutationBuilded)
//    }
//    fun getSubscriptionSubscriptionCall(): ApolloSubscriptionCall<SubscriptionUpdatedSubscription.Data> {
//        return apolloClient.subscribe(subscriptionSubscriptionClient)
//    }
    }
}
