package com.skedulo.automation.api.dto

import com.google.gson.annotations.SerializedName
import com.skedulo.automation.api.dto.awp.HasUid
import com.skedulo.automation.api.types.UID
import com.skedulo.automation.api.AgendaQuery

data class Contact(
    @SerializedName("UID") override val uid: UID<Contact>,
    @SerializedName("FirstName") val firstName: String?,
    @SerializedName("LastName") val lastName: String?,
    @SerializedName("Phone") val phone: String?,
    @SerializedName("MobilePhone") val mobilePhone: String?,
    @SerializedName("Email") val email: String?,
    @SerializedName("Title") val title: String?,
    @SerializedName("AccountId") val accountId: UID<Account>?
) : HasUid<Contact> {
    companion object {
//        fun fromGraphql(queryResult: AgendaQuery.Contact?): Contact? =
//            queryResult?.run{
//                Contact(
//                    uid =  UID.fromString(UID()),
//                    firstName =  FirstName(),
//                    lastName =  LastName(),
//                    phone =  Phone(),
//                    mobilePhone =  MobilePhone(),
//                    email =  Email(),
//                    title =  Title(),
//                    accountId =  UID.fromString(AccountId()))
//            }
    }
}