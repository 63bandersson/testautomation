package com.skedulo.automation.api.model.mobile.availability

data class AvailabilityResponseObject(
    val result: Result
)
data class AdditionalProp(
        val Finish: String,
        val IsAvailable: Boolean,
        val Reason: String,
        val Start: String
)
data class Result(
        val additionalProp: List<AdditionalProp>
)