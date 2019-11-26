package com.skedulo.automation.api.model.mobile.offers

data class OffersResponseObject(
    val result: List<Result>
)
data class Result(
        val AccountName: String,
        val Address: String,
        val Description: String,
        val End: String,
        val IsAllocated: Boolean,
        val LocationName: String,
        val Name: String,
        val OfferType: String,
        val ResourceOfferId: String,
        val Response: String,
        val Start: String,
        val Status: String,
        val WorkId: String
)