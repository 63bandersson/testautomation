package com.skedulo.automation.api
import org.junit.Test
import com.apollographql.apollo.rx2.Rx2Apollo
import com.skedulo.automation.api.JobsQuery



class GraphqlTest {

    @Test
    fun testJobsQuery() {

FetchJobsByIdQuery
        val query = JobsQuery.builder().build()

        var call = ApolloBaseClient.getApolloClient().query(query)

        val response = Rx2Apollo.from(call)


    }

//        client.query(JobsQuery    //From the auto generated class
//            .builder()
//            .build())
//            .enqueue(object : ApolloCall.Callback<JobsQuery.Data>() {
//                override fun onFailure(e: ApolloException) {
//                    Log.info(e.message.toString())
//                }
//                override fun onResponse(response: Response<JobsQuery.Data>) {
//                    Log.info(" " + response.data()?.repository())
////                   runOnUiThread({
//                       progress_bar.visibility = View.GONE
//                       name_text_view.text = String.format(getString(R.string.name_text),
//                           response.data()?.repository()?.name())
//                       description_text_view.text = String.format(getString(R.string.description_text),
//                           response.data()?.repository()?.description())
//                       forks_text_view.text = String.format(getString(R.string.fork_count_text),
//                           response.data()?.repository()?.forkCount().toString())
//                       url_text_view.text = String.format(getString(R.string.url_count_text),
//                           response.data()?.repository()?.url().toString())
//                   })
//                }
//            })
    //}

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

}
