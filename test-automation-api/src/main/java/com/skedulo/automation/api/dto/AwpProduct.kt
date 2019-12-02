package com.skedulo.automation.api.dto

import com.google.gson.annotations.SerializedName
import com.skedulo.automation.api.dto.awp.HasUid
import com.skedulo.automation.api.types.UID

data class AwpProduct(
    @SerializedName(FIELD_UID) override val uid: UID<AwpProduct>,
    @SerializedName(FIELD_NAME) val name: String,
    @SerializedName(FIELD_RECORD_TYPE) val recordType: String?,
    @SerializedName(FIELD_AWP_OFFICE) val officeName: String?,
    @SerializedName(FIELD_PRODUCT_FAMILY) val productFamily: String?
) : HasUid<AwpProduct> {
    companion object {
        fun requiresUnitNumber(productName: String): Boolean {
            return productName.startsWith("Steel Plate") || prodsRequireUnit.contains(productName)
        }

        private val prodsRequireUnit = setOf("Arrow Board", "Flagging Truck", "Plate Truck", "Stake Body Truck", "Trailer Truck",
            "Trailer", "TMA (Truck Mounted Attenuator)", "TTMA (Trailered Truck Mounted Attenuator)",
            "PCMS (Mini Portable Changeable Message Sign)", "PCMS (Portable Changeable Message Sign)", "Light Tower",
            "Portable Radar Speed Display", "Smart Board", "ICone")

        const val SCHEMA_NAME = "AWPProduct"

        const val FIELD_UID = "UID"
        const val FIELD_NAME = "Name"
        const val FIELD_RECORD_TYPE = "RecType"
        const val FIELD_AWP_OFFICE = "Office"
        const val FIELD_PRODUCT_FAMILY = "ProductFamily"
    }

    val unitRequired = AwpProduct.requiresUnitNumber(this.name)

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
