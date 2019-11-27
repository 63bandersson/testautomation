package com.skedulo.automation.api

import org.junit.Test
import com.skedulo.automation.api.JobsQuery
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

@RunWith(RobolectricTestRunner::class)
class GraphqlTest: TestParent() {


    @Test
    fun testJobsQuery() {
        val TAG = "graphqlTest"
//        val apolloClient = ApolloClient.builder()
//            .serverUrl("https://api.skedulo.com/graphql/graphql")
//            .okHttpClient(
//                OkHttpClient.Builder()
//                    .connectTimeout(30, TimeUnit.SECONDS)
//                    .writeTimeout(30, TimeUnit.SECONDS)
//                    .readTimeout(30, TimeUnit.SECONDS)
//                    .build()
//            )
        val apolloClient = provideApolloClient( )

        var jobQuery = JobsQuery()
        apolloClient!!.query(jobQuery)
            .enqueue(object: ApolloCall.Callback<JobsQuery.Data>() {

                override fun onResponse(response: Response<JobsQuery.Data>) {
                    if (!response.hasErrors()) {
                        // Here response().data() contains the data you requested
                        Log.d(TAG, "Response: ${response.data()}")
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
    internal fun testFetchResources() {
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
    }
    fun provideApolloClient( ): ApolloClient {
        return ApolloClient.builder()
            .serverUrl("https://api.skedulo.com/graphql/graphql")
            .okHttpClient(OkHttpClient().newBuilder().build())
            .build()
    }

}
