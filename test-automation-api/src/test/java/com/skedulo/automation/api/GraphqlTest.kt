package com.skedulo.automation.api

import android.os.Build
import android.util.Log
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.Operation.Variables
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.apollographql.apollo.rx2.Rx2Apollo
import com.skedulo.automation.api.utils.TestParent
import io.reactivex.Single
import okhttp3.OkHttpClient
import org.bouncycastle.crypto.tls.ConnectionEnd.server
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.util.concurrent.TimeUnit
//import java.util.function.Predicate
import io.reactivex.functions.Predicate;
import org.robolectric.annotation.Config
import kotlin.test.assertEquals
import kotlin.test.assertTrue


@RunWith(RobolectricTestRunner::class)
 class GraphqlTest: TestParent() {


//    @Test
//    fun testJobsQueryEnque() {
//        val TAG = "graphqlTest:testJobsQuery"
//
//        //val apolloClient = provideApolloClient()
//        val apolloClient = ApolloBaseClient.getApolloClient()
//        var jobQuery = JobsQuery()
//        apolloClient!!.query(jobQuery)
//            .enqueue(object: ApolloCall.Callback<JobsQuery.Data>() {
//
//                override fun onResponse(response: Response<JobsQuery.Data>) {
//                    if (!response.hasErrors()) {
//                        // Here response().data() contains the data you requested
//                        //Log.d(TAG, "Response: ${response.data()}")
//                        println("Response data = ${response.data()}")
//                    } else {
//                        //Log.d(TAG, "Request Failure ${response.errors()}")
//                        println("Respnse error = ${response.errors()}")
//                    }
//                }
//
//                override fun onFailure(e: ApolloException) {
//                    e.printStackTrace()
//                }
//            })
//
//    }
//    @Test
//    fun testJobsQueryRx2Appollo() {
//        val TAG = "graphqlTest:testJobsQuery"
//
//        //val apolloClient = provideApolloClient()
//        val apolloClient = ApolloBaseClient.getApolloClient()
//        var jobQuery = JobsQuery()
//        apolloClient!!.query(jobQuery)
//            .enqueue(object: ApolloCall.Callback<JobsQuery.Data>() {
//
//                override fun onResponse(response: Response<JobsQuery.Data>) {
//                    if (!response.hasErrors()) {
//                        // Here response().data() contains the data you requested
//                        //Log.d(TAG, "Response: ${response.data()}")
//                        println("Response data = ${response.data()}")
//                    } else {
//                        //Log.d(TAG, "Request Failure ${response.errors()}")
//                        println("Response error = ${response.errors()}")
//                    }
//                }
//
//                override fun onFailure(e: ApolloException) {
//                    e.printStackTrace()
//                }
//            })
//
//    }
//
//
//    @Test
//    fun testFetchResources() {
//
//        val TAG = "graphqlTest:testFetchResources"
//        //val apolloClient = provideApolloClient()
//        val apolloClient = ApolloBaseClient.getApolloClient()
//
//        var fetchResourcesQuery = FetchResourcesQuery()
//        apolloClient!!.query(fetchResourcesQuery)
//            .enqueue(object : ApolloCall.Callback<FetchResourcesQuery.Data>() {
//
//                override fun onResponse(response: Response<FetchResourcesQuery.Data>) {
//                    if (!response.hasErrors()) {
//                        // Here response().data() contains the data you requested
//                        //Log.d(TAG, "Response: ${response.data()}")
//                        println("Response data = ${response.data()}")
//                    } else {
//                        //Log.d(TAG, "Request Failure ${response.errors()}")
//                        println("Response error = ${response.errors()}")
//                    }
//                }
//
//                override fun onFailure(e: ApolloException) {
//                    e.printStackTrace()
//                }
//            })
//    }
    //Works!!
   @Test
    fun testFetchRegions() {
        val TAG = "graphqlTest:testFetchResources"
        val apolloClient = ApolloBaseClient.getApolloClient()
        val fetchRegions = FetchRegionsQuery()
        apolloClient!!.query(fetchRegions)
            .enqueue(object : ApolloCall.Callback<FetchRegionsQuery.Data>() {

                override fun onResponse(response: Response<FetchRegionsQuery.Data>) {
                    println("RESPOMSE")

                    if (!response.hasErrors()) {
                        // Here response().data() contains the data you requested
                        //Log.d(TAG, "Response: ${response.data()}")
                        println("Response data = ${response.data()}")
                        val regions =response.data()!!.regions.edges.first().node.name
                        assertEquals("Brisbane", regions,"Region not found" )
                    } else {
                        //Log.d(TAG, "Request Failure ${response.errors()}")
                        println("Response error = ${response.errors()}")
                    }
                }

                override fun onFailure(e: ApolloException) {
                    e.printStackTrace()
                }
            })
    }
    /*
    @Test
    fun testFetchRegionFromName() {
        val regionUid = ApolloBaseClient.fetchRegion("Brisbane")
        assertTrue(regionUid.equals("0003a4e6-973c-4a2b-8cad-e8f9c216106c"),  "Region not found")
    }
    @Test
    fun testFetchJobs(){
        ApolloBaseClient.fetchJobs()
    }*/


//    @Test
//    fun testFetchRegionsRx2Apollo() {
//        val TIME_OUT_SECONDS = 5L
//        val TAG = "graphqlTest:testFetchRegions"
//        val apolloClient = ApolloBaseClient.getApolloClient()
//        val fetchRegions = FetchRegionsQuery()
//        //val call = apolloClient!!.query(fetchRegions)
//        Rx2Apollo
//            .from(apolloClient
//            .query(fetchRegions))
//            .test()
//            .awaitDone(TIME_OUT_SECONDS, TimeUnit.SECONDS)
//            .assertNoErrors()
//            .assertComplete()
//            .assertValue { response -> !response.hasErrors() }
//
//    }
    //This is not working for some reason

    @Test
    fun testFetchRegionsRx2Apollo2() {
        val TIME_OUT_SECONDS = 5L
        val buffer = "Brisbane"
        val TAG = "graphqlTest:testFetchRegions"
        val apolloClient = ApolloBaseClient.getApolloClient()
        val fetchRegions = FetchRegionsQuery()
        val call = apolloClient!!.query(fetchRegions)
        Rx2Apollo
            .from(call).singleElement().map {
            it.data()?.let {data ->
                val regions = data.regions.edges.first().node.name
                assertEquals("Brisbane", regions,"Region not found" )
            }}
    }
    //@Test
    fun testFetchRegionsCall() {
//        var response: Single<Response<FetchRegionsQuery.Data>> = ApolloBaseClient.fetchRegions()
//        val regions = response.data.regions.edges.first().node.name
//        assertEquals()
    }

    ///Assert.assertTrue(response.data().edges().node().Name()).isEqualTo("Brisbane")
    //val result: String = response.data().regions.edges.get(0).node.name
    //return result.contentEquals("Brisbane")

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
