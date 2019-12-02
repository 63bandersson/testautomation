package com.skedulo.automation.api.dto

import com.google.gson.annotations.SerializedName

enum class JobAllocationStatus(val label: String, val transitionName: String,val negative: Boolean = false) {

    @SerializedName("Empty")
    EMPTY("Empty", "Empty"),

    @SerializedName("Pending Dispatch")
    PENDING_DISPATCH("Pending Dispatch", "Pending Dispatch"),

    @SerializedName("Dispatched")
    DISPATCHED("Dispatched", "Dispatched"),

    @SerializedName("Confirmed")
    CONFIRMED("Confirmed", "Confirm"),

    @SerializedName("En Route")
    EN_ROUTE("En Route", "Start Travel"),

    @SerializedName("Checked In")
    CHECKED_IN("Checked In", "Check In"),

    @SerializedName("In Progress")
    IN_PROGRESS("In Progress", "Start Work"),

    @SerializedName("Complete")
    COMPLETE("Complete", "Complete Work"),

    @SerializedName("Deleted")
    DELETED("Deleted", "Deleted"),

    @SerializedName("Declined")
    DECLINED("Declined", "Decline", true);

    fun toPersisted(): String {
        return name
    }

    companion object {
        @JvmStatic
        fun fromPersisted(text: String): JobAllocationStatus? {
            return values().firstOrNull { it.name.equals(text, true) }
        }

        @JvmStatic
        fun fromLabel(label: String): JobAllocationStatus? {
            return values().firstOrNull { it.label.equals(label, true) }
        }

        fun getAllowedActions(
            status: JobAllocationStatus,
            canBeDeclined: Boolean
        ): List<JobAllocationStatus> {
            return when (status) {
                DISPATCHED -> if (canBeDeclined) listOf(CONFIRMED, DECLINED) else listOf(CONFIRMED)
                CONFIRMED -> listOf(EN_ROUTE)
                EN_ROUTE -> listOf(CHECKED_IN)
                CHECKED_IN -> listOf(IN_PROGRESS)
                IN_PROGRESS -> listOf(COMPLETE)
                else -> listOf()
            }
        }
    }
}
