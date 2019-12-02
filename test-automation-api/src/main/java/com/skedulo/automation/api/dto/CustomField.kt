package com.skedulo.automation.api.dto

import com.google.gson.annotations.SerializedName

data class CustomField(
    @SerializedName("schemaName") val schema: String,
    val name: String,
    @SerializedName("fieldType") val fieldType: String,
    val label: String,
    val displayOrder: Int?,
    @SerializedName("showMobile") val displayMobile: Boolean,
    @SerializedName("editableOnMobile") val editMobile: Boolean
    //FIXME add field names here as per Job
) {
    companion object {
        // Field types returned by the API. May be worth turning into an enum at some stage?
        const val CUSTOM_FIELD_BOOLEAN: String = "boolean"
        const val CUSTOM_FIELD_DATE: String = "date"
        const val CUSTOM_FIELD_DATE_TIME: String = "datetime"
        const val CUSTOM_FIELD_PICKLIST: String = "picklist"
        const val CUSTOM_FIELD_PICKLIST_MULTI: String = "MultiPicklist"
        const val CUSTOM_FIELD_TEXT_AREA: String = "textarea"
        const val CUSTOM_FIELD_URL: String = "Url"
        const val CUSTOM_FIELD_REFERENCE: String = "reference"
        const val CUSTOM_FIELD_INT: String = "int"
        const val CUSTOM_FIELD_DOUBLE: String = "double"
        const val CUSTOM_FIELD_STRING: String = "string"
    }
}

