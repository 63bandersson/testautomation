import com.google.gson.annotations.SerializedName
import com.skedulo.automation.api.AgendaQuery
import com.skedulo.automation.api.dto.awp.HasUid
import com.skedulo.automation.api.types.UID

import org.threeten.bp.Instant

data class AllocationActivity(

    @SerializedName(FIELD_UID) override val uid: UID<AllocationActivity>,
    @SerializedName(FIELD_RESOURCE_ID) val resourceId: UID<AgendaQuery.Resource>,
    @SerializedName(FIELD_START) val start: Instant?,
    @SerializedName(FIELD_END) val end: Instant?,
    @SerializedName(FIELD_ADDRESS) val address: String?,
    @SerializedName(FIELD_TYPE) val activityType: String?,
    @SerializedName(FIELD_NOTES) val notes: String?

) : HasUid<AllocationActivity> {

    companion object {

        const val SCHEMA_NAME = "Activity"

        const val FIELD_UID = "UID"
        const val FIELD_RESOURCE_ID = "ResourceId"
        const val FIELD_START = "Start"
        const val FIELD_END = "End"
        const val FIELD_ADDRESS = "Address"
        const val FIELD_TYPE = "Type"
        const val FIELD_NOTES = "Notes"

//        fun fromGraphql(queryResult: AgendaQuery.Node1): AllocationActivity = queryResult.run { AllocationActivity(
//            uid = UID.fromString(UID()),
//            resourceId = UID.fromString(ResourceId()),
//            start = Instant.parse(Start()),
//            end = Instant.parse(End()),
//            address = Address(),
//            activityType = Type(),
//            notes = Notes()
//        )}
    }
}