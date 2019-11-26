package com.skedulo.automation.api

import com.skedulo.automation.api.annotations.Authorization
import com.skedulo.automation.api.annotations.AuthorizationType
import com.skedulo.automation.api.annotations.BaseUrl
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

@Authorization(AuthorizationType.BEARERTOKEN)
@BaseUrl("https://dev-api.test.skl.io")

data class Results<out T>(
    val next: String?,
    val previous: String?,
    val results: List<T>
)
data class Region(
    val uid: String,
    val GeoLatitude: String,
    val Timezone: String,
    val name: String,
    val GeoLongitude: String
)

interface SkeduloSqlApi {

    @GET("/standalone/driver/fetch")
    fun getRegions(
        @Query("queryString") queryString: String
    ): Call<Results<Region>>
}
