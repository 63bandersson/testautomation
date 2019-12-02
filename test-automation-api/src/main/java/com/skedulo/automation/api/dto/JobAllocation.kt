package com.skedulo.automation.api.dto

import com.google.gson.annotations.SerializedName
import com.skedulo.automation.api.AgendaQuery
import com.skedulo.automation.api.dto.awp.HasParentId
import com.skedulo.automation.api.dto.awp.HasUid
import com.skedulo.automation.api.types.UID
import org.threeten.bp.Instant

data class JobAllocation(
    @SerializedName(FIELD_UID) override val uid: UID<JobAllocation>,
    @SerializedName(FIELD_JOB_ID) val jobId: UID<Job>,
    @SerializedName(FIELD_NAME) val name: String,
    @SerializedName(FIELD_RESOURCE_ID) val resourceId: UID<Resource>,
    @SerializedName(FIELD_STATUS) val status: JobAllocationStatus,
    @SerializedName(FIELD_TIME_CHECKED_IN) val checkedIn: Instant?,
    @SerializedName(FIELD_TIME_RESPONDED) val responded: Instant?,
    @SerializedName(FIELD_TIME_COMPLETED) val completed: Instant?,
    @SerializedName(FIELD_TIME_START_TRAVEL) val startTravel: Instant?,
    @SerializedName(FIELD_TIME_IN_PROGRESS) val inProgress: Instant?,
    @SerializedName(FIELD_SFC_DRIVER) val sfcDriver : Boolean?,
    @SerializedName(FIELD_SFC_SIGNER) val sfcSigner : Boolean?,
    @SerializedName(FIELD_SFC_EQUIP_CARRIER) val sfcEquipCarrier : Boolean?
) : HasUid<JobAllocation>, HasParentId<Job> {

    companion object {
        const val SCHEMA_NAME = "JobAllocations"

        const val FIELD_UID = "UID"
        const val FIELD_JOB_ID = "JobId"
        const val FIELD_NAME = "Name"
        const val FIELD_RESOURCE_ID = "ResourceId"
        const val FIELD_STATUS = "Status"
        const val FIELD_TIME_CHECKED_IN = "TimeCheckedIn"
        const val FIELD_TIME_RESPONDED = "TimeResponded"
        const val FIELD_TIME_COMPLETED = "TimeCompleted"
        const val FIELD_TIME_START_TRAVEL = "TimeStartTravel"
        const val FIELD_TIME_IN_PROGRESS = "TimeInProgress"
        const val FIELD_SFC_DRIVER = "SFCDriver"
        const val FIELD_SFC_SIGNER = "SFCSigner"
        const val FIELD_SFC_EQUIP_CARRIER = "SFCEquipCarrier"

//        fun fromGraphql(queryResult: List<AgendaQuery.JobAllocation>): List<JobAllocation>{
//            val allocations: MutableList<JobAllocation> = mutableListOf<JobAllocation>()
//            queryResult.map { allocations.add( JobAllocation(
//                uid = UID.fromString(it.UID()),
//                jobId = UID.fromString(it.JobId()),
//                name = it.Name(),
//                resourceId =  UID.fromString(it.ResourceId()),
//                status =  JobAllocationStatus.fromLabel(it.Status()) ?: JobAllocationStatus.EMPTY,
//                checkedIn = it.TimeCheckedIn()?.run { Instant.parse(this) },
//                responded =  it.TimeResponded()?.run { Instant.parse(this) },
//                completed =  it.TimeCompleted()?.run { Instant.parse(this) },
//                startTravel =  it.TimeStartTravel()?.run { Instant.parse(this) },
//                inProgress =  it.TimeInProgress()?.run { Instant.parse(this) },
//                sfcDriver =  it.SFCDriver(),
//                sfcSigner =  it.SFCSigner(),
//                sfcEquipCarrier =  it.SFCEquipCarrier()))
//            }
//            return allocations
//        }
    }

    override fun parentId(): UID<Job> {
        return jobId
    }

}
