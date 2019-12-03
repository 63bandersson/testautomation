package com.skedulo.automation.api

//import java.util.function.Predicate
import com.skedulo.automation.api.utils.TestParent
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import kotlin.test.assertTrue


@RunWith(RobolectricTestRunner::class)
 class GraphqlTest: TestParent() {
//    @Test
//    fun testFetchRegionFromName() {
//        val regionUid = ApolloBaseClient.fetchRegionUidFromName("Brisbane")
//        assertTrue(regionUid.equals("0003a4e6-973c-4a2b-8cad-e8f9c216106c"), "Region not found")
//    }
    @Test
    fun testFetchRegions() {
        ApolloBaseClient.fetchRegions()
            .doOnError { throw it }
            .test()
            .await()
            .assertNoErrors()
            .assertComplete()
            .assertOf { response ->
                val result = response.values().firstOrNull()?.let {
                    it.edges.first().node.name == "Brisbane"
                } ?: false
                println("Test result is $result")
                assertTrue(result)
            }
    }
    @Test
    fun testFetchQueuedJobs() {
        val filterQuery ="JobStatus == \"Queued\""
        ApolloBaseClient.fetchJobs(filterQuery)
            .doOnError { throw it }
            .test()
            .await()
            .assertNoErrors()
            .assertComplete()
            .assertOf { response ->
                val result = response.values().firstOrNull()?.let {
                    it.edges.first().node.name == "JOB-0009"
                } ?: false
                println("Test result is $result")
                assertTrue(result)
            }
    }
    @Test
    fun testFetchJobOffers() {
        val filterQuery = "JobId IN []"
        ApolloBaseClient
            .fetchJobOffers(filterQuery)
            .doOnError { throw it }
            .test()
            .await()
            .assertNoErrors()
            .assertComplete()
//            .assertOf { response ->
//                val result = response.values().firstOrNull()?.let {
//                    it.edges.first().node.job.name == "JOB-0009"
//                } ?: false
//                println("Test result is $result")
//                assertTrue(result)
//            }
    }

}

