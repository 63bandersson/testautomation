package com.skedulo.automation.api

import com.skedulo.automation.api.utils.TestParent
//import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ApiClientTest : TestParent() {
    @Test
    fun testGetQueuedJobs() {
        val json =
            "{\"query\":\"\\nquery fetchQueuedJobs(\$filter: EQLQueryFilterJobs!) {\\n  jobs(filter: \$filter) {\\n    edges {\\n      node {\\n        UID\\n        Name\\n        Description\\n        JobStatus\\n        GeoLatitude\\n        GeoLongitude\\n      }\\n    }\\n  }\\n}\\n\\n\",\"variables\":{\"filter\":\"JobStatus == \"Queued\"\"},\"operationName\":\"fetchQueuedJobs\"}"
        val requestBody: RequestBody =
            RequestBody.create("application/json; charset=utf-8".toMediaType(), json.toString())
        val call = apiClient.graphQLApi.getQueuedJobs(requestBody)
        val response = call.execute()
        println("response code = ${response.code()}")
        if (response.isSuccessful) {
            val data = response.body()
            println(data)
        }
    }

    @Test
    fun testGetRegions() {
        val json =
            "{\"query\":\"\\nquery fetchResources {\\n  resources {\\n    edges {\\n      node {\\n        UID\\n        Name\\n        HomeAddress\\n        GeoLatitude\\n        GeoLongitude\\n        PrimaryRegion {\\n          UID\\n          Name\\n        }\\n      }\\n    }\\n  }\\n}\\n\\n\",\"variables\":null,\"operationName\":\"fetchResources\"}"
        val requestBody: RequestBody =
            RequestBody.create("application/json; charset=utf-8".toMediaType(), json.toString())
        val call = apiClient.graphQLApi.getRegions(requestBody)
        val response = call.execute()
        println("response code = ${response.code()}")
        if (response.isSuccessful) {
            val data = response.body()
            println(data)
        }
    }
}
