package com.skedulo.automation.api.dto

import com.google.gson.annotations.SerializedName
import com.skedulo.automation.api.types.UID

data class Resource(
    @SerializedName(FIELD_UID) val uid: UID<Resource>,
    @SerializedName(FIELD_NAME) val name: String
) {
    companion object {
        const val FIELD_UID = "UID"
        const val FIELD_NAME = "Name"
    }
}
