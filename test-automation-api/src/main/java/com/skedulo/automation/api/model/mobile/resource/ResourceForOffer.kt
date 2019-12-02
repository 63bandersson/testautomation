package com.skedulo.automation.api.model.mobile.resource

data class ResourceForOffer(
    val result: List<Result>
)
data class Result(
        val Name: String,
        val SmallPhotoUrl: String,
        val UID: String
)