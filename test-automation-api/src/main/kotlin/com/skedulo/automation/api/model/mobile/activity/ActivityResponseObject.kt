package com.skedulo.automation.api.model.mobile.activity

data class ActivityResponseObject(
    val result: Result
)
data class Result(
        val Address: String,
        val End: String,
        val GeoLatitude: Int,
        val GeoLongitude: Int,
        val LocationId: String,
        val Name: String,
        val Notes: String,
        val ResourceId: String,
        val Start: String,
        val Timezone: String,
        val Type: String,
        val UID: String
)