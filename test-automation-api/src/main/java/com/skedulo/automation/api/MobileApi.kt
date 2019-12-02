package com.skedulo.automation.api

import com.skedulo.automation.api.annotations.Authorization
import com.skedulo.automation.api.annotations.AuthorizationType
import com.skedulo.automation.api.annotations.BaseUrl
import com.skedulo.automation.api.model.mobile.activity.ActivityResponseObject
import com.skedulo.automation.api.model.mobile.agenda.AgendaResponseObject
import com.skedulo.automation.api.model.mobile.availability.AvailabilityResponseObject
import com.skedulo.automation.api.model.mobile.bulkmodify.BulkModifyResponseObject
import com.skedulo.automation.api.model.mobile.jobs.JobsResponseObject
import com.skedulo.automation.api.model.mobile.offerallocated.OfferAllocatedResponseObject
import com.skedulo.automation.api.model.mobile.offers.OffersResponseObject
import com.skedulo.automation.api.model.mobile.resource.ResourceForOffer
import com.skedulo.automation.api.model.mobile.userdata.FetchInitialUserInformationResponseObject
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

@Authorization(AuthorizationType.BEARERTOKEN)
//@BaseUrl("https://dev-api.test.skl.io")
@BaseUrl("https://api.skedulo.com")


interface SkeduloMobileApi {

    @GET("/mobile/initial")
    fun getInitialUserData(
    ): Call<FetchInitialUserInformationResponseObject.InitialUserData>

    @GET("/mobile/agenda")
    fun getAgenda(
            @Query("start") start: String,
            @Query("end") end: String
    ): Call<AgendaResponseObject>

    @GET("/mobile/offers")
    fun getOffers(
    ): Call<OffersResponseObject>

    @GET("/mobile/jobs")
    fun getJobs():Call<JobsResponseObject>

    @GET("/mobile/activity")
    fun getActivity(
            @Query( "activityId") activityId: String
    ): Call<ActivityResponseObject>

    @GET("/mobile/job/{jobId}/resources_for_offer")
    fun getResourceForOffer(
            @Path("jobId") jobId: String
    ): Call<ResourceForOffer>

    @POST("/mobile/job/{jobId}/offer_allocated")
    fun setOfferAllocated(
            @Path("jobId") jobId: String,
            @Body data: RequestBody
    ): Call<OfferAllocatedResponseObject>

    @POST("/mobile/bulk_modify")
    fun setBulkModify(
            @Body data: RequestBody
    ): Call<BulkModifyResponseObject>

    @GET("/mobile/availability?resource_ids={resourceId}&start={start}&finish={finish}")
    fun getAvailability(
            @Path("resourceId") resourceId: String,
            @Query("start") start: String,
            @Query("finish") finish: String
    ): Call<AvailabilityResponseObject>
}