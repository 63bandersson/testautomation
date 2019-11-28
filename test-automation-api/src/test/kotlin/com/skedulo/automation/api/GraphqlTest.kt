package com.skedulo.automation.api

import org.junit.Test
import com.skedulo.automation.api.*
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.apollographql.apollo.rx2.Rx2Apollo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import org.threeten.bp.Instant
import io.reactivex.*
import android.util.Log
import com.skedulo.automation.api.utils.TestParent
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import com.skedulo.automation.api.ApolloBaseClient
import kotlin.test.assertTrue
import java.util.function.Predicate

@RunWith(RobolectricTestRunner::class)
class GraphqlTest: TestParent() {


    @Test
    fun testJobsQueryEnque() {
        val TAG = "graphqlTest:testJobsQuery"

        //val apolloClient = provideApolloClient()
        val apolloClient = ApolloBaseClient.getApolloClient()
        var jobQuery = JobsQuery()
        apolloClient!!.query(jobQuery)
            .enqueue(object: ApolloCall.Callback<JobsQuery.Data>() {

                override fun onResponse(response: Response<JobsQuery.Data>) {
                    if (!response.hasErrors()) {
                        // Here response().data() contains the data you requested
                        Log.d(TAG, "Response: ${response.data()}")
                        println("Response data = ${response.data()}")
                    } else {
                        Log.d(TAG, "Request Failure ${response.errors()}")
                    }
                }

                override fun onFailure(e: ApolloException) {
                    e.printStackTrace()
                }
            })

    }
    @Test
    fun testJobsQueryRx2Appollo() {
        val TAG = "graphqlTest:testJobsQuery"

        //val apolloClient = provideApolloClient()
        val apolloClient = ApolloBaseClient.getApolloClient()
        var jobQuery = JobsQuery()
        apolloClient!!.query(jobQuery)
            .enqueue(object: ApolloCall.Callback<JobsQuery.Data>() {

                override fun onResponse(response: Response<JobsQuery.Data>) {
                    if (!response.hasErrors()) {
                        // Here response().data() contains the data you requested
                        Log.d(TAG, "Response: ${response.data()}")
                        println("Response data = ${response.data()}")
                    } else {
                        Log.d(TAG, "Request Failure ${response.errors()}")
                    }
                }

                override fun onFailure(e: ApolloException) {
                    e.printStackTrace()
                }
            })

    }


    @Test
    fun testFetchResources() {

        val TAG = "graphqlTest:testFetchResources"
        //val apolloClient = provideApolloClient()
        val apolloClient = ApolloBaseClient.getApolloClient()

        var fetchResourcesQuery = FetchResourcesQuery()
        apolloClient!!.query(fetchResourcesQuery)
            .enqueue(object : ApolloCall.Callback<FetchResourcesQuery.Data>() {

                override fun onResponse(response: Response<FetchResourcesQuery.Data>) {
                    if (!response.hasErrors()) {
                        // Here response().data() contains the data you requested
                        Log.d(TAG, "Response: ${response.data()}")
                        //println("Response data = ${response.data()}")
                    } else {
                        Log.d(TAG, "Request Failure ${response.errors()}")
                    }
                }

                override fun onFailure(e: ApolloException) {
                    e.printStackTrace()
                }
            })
    }
    @Test
    fun testFetchRegions() {
        val TAG = "graphqlTest:testFetchResources"
        val apolloClient = ApolloBaseClient.getApolloClient()
        val fetchRegions = FetchRegionsQuery()
        apolloClient!!.query(fetchRegions)
            .enqueue(object : ApolloCall.Callback<FetchRegionsQuery.Data>() {

                override fun onResponse(response: Response<FetchRegionsQuery.Data>) {
                    if (!response.hasErrors()) {
                        // Here response().data() contains the data you requested
                        Log.d(TAG, "Response: ${response.data()}")
                        //println("Response data = ${response.data()}")
                    } else {
                        Log.d(TAG, "Request Failure ${response.errors()}")
                    }
                }

                override fun onFailure(e: ApolloException) {
                    e.printStackTrace()
                }
            })
    }
    @Test
    fun testFetchRegionsRx2Apollo() {
        val TIME_OUT_SECONDS = 5L
        val TAG = "graphqlTest:testFetchRegions"
        val apolloClient = ApolloBaseClient.getApolloClient()
        Rx2Apollo
            .from(apolloClient.query(FetchRegionsQuery()))
            .test()
            .awaitDone(TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .assertNoErrors()
            .assertComplete()
//            .assertValue(Predicate<Response<FetchRegionsQuery.Data>>() {
//                fun test(response: Response<FetchRegionsQuery.Data>): Boolean  {
//                    //Assert.assertTrue(response.data().edges().node().Name()).isEqualTo("Brisbane")
//                    return response.data().edges().node().Name().isEqualTo("Brisbane")
//                }
//            })
    }



        /*    var client = ApolloBaseClient.getApolloClient()
            client=setupApollo()
            client.query(fetchResourcesQuery    //From the auto generated class
                .builder()
                .name(repo_name_edittext.text.toString()) //Passing required arguments
                .owner(owner_name_edittext.text.toString()) //Passing required arguments
                .build())
                .enqueue(object : ApolloCall.Callback<fetchResources.Data>() {
                    override fun onFailure(e: ApolloException) {
                        Log.info(e.message.toString())
                    }
                    override fun onResponse(response: Response<fetchResources.Data>) {
                        Log.info(" " + response.data()?.repository())
    //                    runOnUiThread({
    //                        progress_bar.visibility = View.GONE
    //                        name_text_view.text = String.format(getString(R.string.name_text),
    //                            response.data()?.repository()?.name())
    //                        description_text_view.text = String.format(getString(R.string.description_text),
    //                            response.data()?.repository()?.description())
    //                        forks_text_view.text = String.format(getString(R.string.fork_count_text),
    //                            response.data()?.repository()?.forkCount().toString())
    //                        url_text_view.text = String.format(getString(R.string.url_count_text),
    //                            response.data()?.repository()?.url().toString())
    //                    })
                    }
                })*/
    fun provideApolloClient( ): ApolloClient {
        return ApolloClient.builder()
            .serverUrl("https://api.skedulo.com/graphql/graphql")
            .okHttpClient(OkHttpClient().newBuilder().build())
            .build()
    }

}
