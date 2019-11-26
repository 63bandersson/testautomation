package com.skedulo.automation.api
import com.skedulo.automation.api.annotations.Authorization
import com.skedulo.automation.api.annotations.AuthorizationType
import com.skedulo.automation.api.annotations.BaseUrl
//import com.skedulo.automation.api.graphql.JobOffersGraphql
import com.skedulo.automation.api.model.mobile.jobs.JobsResponseObject
import okhttp3.RequestBody
import retrofit2.http.*

data class QueryResponseObject(
    val `data`: Data
)

data class Data(
    val resources: Resources
)

data class Resources(
    val edges: List<Edge>
)

data class Edge(
    val node: Node
)

data class Node(
    val AccountScores: List<Any>,
    val Alias: Any,
    val Category: String,
    val CountryCode: String,
    val EmploymentType: String,
    val GeoLatitude: Any,
    val GeoLongitude: Any,
    val HomeAddress: String,
    val IsActive: Boolean,
    val LocationScores: List<Any>,
    val MobilePhone: Any,
    val Name: String,
    val Notes: Any,
    val NotificationType: String,
    val PrimaryPhone: Any,
    val PrimaryRegion: PrimaryRegion,
    val Rating: Any,
    val ResourceTags: List<Any>,
    val ResourceType: String,
    val UID: String,
    val User: User,
    val WeeklyHours: Any,
    val WorkingHourType: Any
)

data class User(
    val UID: String
)

data class PrimaryRegion(
    val CountryCode: Any,
    val GeoLatitude: Any,
    val GeoLongitude: Any,
    val Name: String,
    val Radius: Any,
    val Timezone: String,
    val UID: String
)
@Authorization(AuthorizationType.BEARERTOKEN)
//@BaseUrl("https://dev-api.test.skl.io")
@BaseUrl("https://api.skedulo.com")
interface SkeduloGraphQLApi {
    data class RegionsResponseObject(
        val `data`: Data
    )

    data class Data(
        val regions: Regions
    )

    data class Regions(
        val edges: List<Edge>
    )

    data class Edge(
        val node: Node
    )

    data class Node(
        val UID: String,
        val Name: String
    )

    @POST("graphql/graphql")
    fun getRegions(
            @Body data: RequestBody
            ): retrofit2.Call<RegionsResponseObject>


    @POST("graphql/graphql")
    fun getQueuedJobs(
            @Body data: RequestBody
        ): retrofit2.Call<JobsResponseObject>
}


//    @GET("graphql/graphql")
//    fun getData(
//        @Body getJobsGraphQLQuery: getJobsGraphQLQuery
//    ) : retrofit2.Call<JobOffersGraphql.QueryResponseObject> {
//    }

//}
