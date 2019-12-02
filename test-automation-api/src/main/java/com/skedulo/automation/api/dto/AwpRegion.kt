package com.skedulo.automation.api.dto

import com.google.gson.annotations.SerializedName
import com.skedulo.automation.api.dto.awp.HasUid
import com.skedulo.automation.api.types.UID

data class AwpRegion(

    @SerializedName(FIELD_UID) override val uid: UID<AwpRegion>

    , @SerializedName(FIELD_NAME) val name: String

    , @SerializedName(FIELD_COUNTRY_CODE) val countryCode: String?

    , @SerializedName(FIELD_DESCRIPTION) val description: String?

    , @SerializedName(FIELD_TIME_ZONE) val timeZone: String?

    , @SerializedName(FIELD_GEO_LONGITUDE) val geoLongitude: Double?

    , @SerializedName(FIELD_GEO_LATITUDE) val geoLatitude: Double?

    , @SerializedName(FIELD_RADIUS) val radius: Double?

) : HasUid<AwpRegion> {
    companion object {

        const val FIELD_UID = "UID"
        const val FIELD_NAME = "Name"
        const val FIELD_COUNTRY_CODE = "CountryCode"
        const val FIELD_DESCRIPTION = "Description"
        const val FIELD_TIME_ZONE = "Timezone"
        const val FIELD_GEO_LONGITUDE = "GeoLongitude"
        const val FIELD_GEO_LATITUDE = "GeoLatitude"
        const val FIELD_RADIUS = "Radius"
    }

    enum class COUNTRY(val s: String) {
        USA("AF"),
        CANADA("CA");

        fun getName(): String {
            return s
        }
    }

    // FIXME we need to validate this during deserialisation but Kotlin + GSON doesn't yet have a compelling solution.
    fun validate() {
        // This is not senseless because GSON still deserialises null values without Kotlin realising.
        @Suppress("SENSELESS_COMPARISON")
        if (uid == null) {
           // throw DeserializationException("Item is missing a UID: $this")
        }
        // This is not senseless because GSON still deserialises null values without Kotlin realising.
        @Suppress("SENSELESS_COMPARISON")
        if (name == null) {
            //throw DeserializationException("Item is missing a Name: $this")
        }
    }
}
