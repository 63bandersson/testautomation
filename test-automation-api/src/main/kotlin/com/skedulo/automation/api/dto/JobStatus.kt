package com.skedulo.automation.api.dto
import com.google.gson.annotations.SerializedName

enum class JobStatus(val label: String) {
    @SerializedName("Queued")
    QUEUED("Queued"),

    @SerializedName("Pending Allocation")
    PENDING_ALLOCATION("Pending Allocation"),

    @SerializedName("Pending Dispatch")
    PENDING_DISPATCH("Pending Dispatch"),

    @SerializedName("Dispatched")
    DISPATCHED("Dispatched"),

    @SerializedName("Ready")
    READY("Ready"),

    @SerializedName("En Route")
    EN_ROUTE("En Route"),

    @SerializedName("On Site")
    ON_SITE("On Site"),

    @SerializedName("In Progress")
    IN_PROGRESS("In Progress"),

    @SerializedName("Complete")
    COMPLETE("Complete"),

    @SerializedName("Cancelled")
    CANCELLED("Cancelled");

    companion object {

        @JvmStatic
        fun fromPersisted(text: String): JobStatus? {
            return JobStatus.values().firstOrNull { it.name.equals(text, true) }
        }

        @JvmStatic
        fun fromLabel(label: String): JobStatus? {
            return JobStatus.values().firstOrNull { it.label.equals(label, true) }
        }
    }

    fun toPersisted(): String {
        return name
    }


}