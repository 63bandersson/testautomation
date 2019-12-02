package com.skedulo.automation.api.dto

import com.google.gson.annotations.SerializedName
import com.skedulo.automation.api.AgendaQuery
import com.skedulo.automation.api.dto.awp.HasUid
import com.skedulo.automation.api.types.UID

data class Account(
    @SerializedName("UID") override val uid: UID<Account>,
    @SerializedName("Name") val name: String,
    @SerializedName("Phone") val phone: String? = null,
    @SerializedName("Fax") val fax: String? = null,

    @SerializedName("BillingStreet") val billingStreet: String? = null,
    @SerializedName("BillingCity") val billingCity: String? = null,
    @SerializedName("billingState") val billingState: String? = null,
    @SerializedName("BillingPostalCode") val billingPostalCode: String? = null,

    @SerializedName("ShippingStreet") val shippingStreet: String? = null,
    @SerializedName("ShippingCity") val shippingCity: String? = null,
    @SerializedName("ShippingState") val shippingState: String? = null,
    @SerializedName("ShippingPostalCode") val shippingPostalCode: String? = null,

    @SerializedName("PreJobSafetyRequired") val preJobSafetyRequired: Boolean
) : HasUid<Account> {
    companion object {
//        fun fromGraphql(queryResult: AgendaQuery.Account?): Account? =
//            queryResult?.run {
//                Account(
//                    uid = UID.fromString(UID()),
//                    name = Name(),
//                    preJobSafetyRequired = PreJobSafetyRequired())
//            }
    }
}
