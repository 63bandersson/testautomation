package com.skedulo.automation.api.model.mobile.offerallocated

data class OfferAllocatedResponseObject(
    val result: Result
)
data class Data(
        val jobOfferId: String
)
data class Error(
        val id: String,
        val message: String
)
data class Result(
        val `data`: Data,
        val error: Error,
        val success: Boolean
)