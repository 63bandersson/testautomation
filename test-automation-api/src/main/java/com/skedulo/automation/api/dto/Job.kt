package com.skedulo.automation.api.dto

import com.google.gson.annotations.SerializedName
import com.skedulo.automation.api.AgendaQuery
import com.skedulo.automation.api.dto.awp.HasUid
//import com.skedulo.core.api.dto.awp.HasUid
import com.skedulo.automation.api.types.UID



import org.threeten.bp.Instant

data class Job(
    @SerializedName(FIELD_UID) override val uid: UID<Job>,
    @SerializedName(FIELD_CONTACT_ID) val contactId: UID<Contact>?,
    @SerializedName(FIELD_ACCOUNT_ID) val accountId: UID<Account>?,
    @SerializedName(FIELD_REGION_ID) val regionId: String?,
    @SerializedName(FIELD_NAME) val name: String,
    @SerializedName(FIELD_DESCRIPTION) val description: String?,
    @SerializedName(FIELD_JOB_STATUS) val status: JobStatus,
    @SerializedName(FIELD_TYPE) val type: String?,
    @SerializedName(FIELD_ADDRESS) val address: String?,
    @SerializedName(FIELD_GEO_LONGITUDE) val geoLongitude: Double?,
    @SerializedName(FIELD_GEO_LATITUDE) val geoLatitude: Double?,
    @SerializedName(FIELD_START) val startDate: Instant,
    @SerializedName(FIELD_END) val endDate: Instant,
    @SerializedName(FIELD_TIMEZONE) val timezone: String,
    @SerializedName(FIELD_DURATION) val duration: Int,
    @SerializedName(FIELD_NOTES_COMMENTS) val notesComments: String?,
    @SerializedName(FIELD_CAN_BE_DECLINED) val canBeDeclined: Boolean,
    private val customFields: Map<String, String?>,
    @SerializedName(FIELD_JOB_ALLOCATIONS) val jobAllocations: List<JobAllocation>,
    @SerializedName(FIELD_ACCOUNT) val account: Account?,
    @SerializedName(FIELD_CONTACT) val contact: Contact?

) : HasUid<Job> {

    companion object {
        const val SCHEMA_NAME = "Jobs"

        const val FIELD_UID = "UID"
        const val FIELD_CONTACT_ID = "ContactId"
        const val FIELD_ACCOUNT_ID = "AccountId"
        const val FIELD_REGION_ID = "RegionId"
        const val FIELD_NAME = "Name"
        const val FIELD_DESCRIPTION = "Description"
        const val FIELD_JOB_STATUS = "JobStatus"
        const val FIELD_TYPE = "Type"
        const val FIELD_ADDRESS = "Address"
        const val FIELD_GEO_LONGITUDE = "GeoLongitude"
        const val FIELD_GEO_LATITUDE = "GeoLatitude"
        const val FIELD_START = "Start"
        const val FIELD_END = "End"
        const val FIELD_TIMEZONE = "Timezone"
        const val FIELD_DURATION = "Duration"
        const val FIELD_NOTES_COMMENTS = "NotesComments"

        const val FIELD_CAN_BE_DECLINED = "CanBeDeclined"
        const val FIELD_CLIENT_JOB_NUMBER = "ClientJobNumber"
        const val FIELD_AWP_OFFICE = "Office.OfficeName"
        const val FIELD_REQUIRES_ESTIMATED_PRODUCTS = "JobRequiresEstimatedProductQuantities"
        const val FIELD_IMEI_NUMBERS = "IMEINumbers"
        const val FIELD_STATUS_CHANGE_DISABLED = "StatusChangeDisabled"
        const val FIELD_LEO = "LEO"
        const val FIELD_JOB_INSTRUCTIONS = "JobInstructions"
        const val FIELD_CUSTOMER_BILLING_REFERENCE_NUMBER = "CustomerBillingReferenceNumber"
        const val FIELD_LEO_COMMENT = "LEOComment"
        const val FIELD_MEET_AT_LOCATION = "MeetAtLocation"
        const val FIELD_NEW_JOB_ADDRESS = "NewJobAddress"
        const val FIELD_NEW_CLIENT_JOB = "NewClientJob"
        const val FIELD_SPIN_OFF_JOB = "SpinOffJob"
        const val FIELD_WORK_LOCATION_START = "WorkLocationStart"
        const val FIELD_WORK_ORDER_TYPE = "WorkOrderType"
        const val FIELD_APPROVING_ACCOUNT = "ApprovingAccount"
        const val FIELD_BILLABLE_HOURS = "BillableHours"
        const val FIELD_JOB_ALLOCATIONS = "JobAllocations"
        const val FIELD_OFFICE = "Office"
        const val FIELD_ACCOUNT = "Account"
        const val FIELD_CONTACT = "Contact"
        const val FIELD_RENTAL_TYPE = "RentalType"
        const val FIELD_AWP_OPERATIONS_REGION = "AWPOperationsRegion"

//        private fun getCustomFieldsGql(queryResult: AgendaQuery.Job) = queryResult.run{ mapOf<String, String?>(
//            Pair(FIELD_CLIENT_JOB_NUMBER, ClientJobNumber()),
//            Pair(FIELD_AWP_OFFICE, Office().toString()),
//            Pair(FIELD_REQUIRES_ESTIMATED_PRODUCTS, JobRequiresEstimatedProductQuantities().toString()),
//            Pair(FIELD_IMEI_NUMBERS, IMEINumbers()),
//            Pair(FIELD_STATUS_CHANGE_DISABLED, StatusChangeDisabled().toString()),
//            Pair(FIELD_BILLABLE_HOURS, BillableHours().toString()),
//            Pair(FIELD_LEO, LEO().toString()),
//            Pair(FIELD_LEO_COMMENT, LEOComment()),
//            Pair(FIELD_JOB_INSTRUCTIONS, JobInstructions()),
//            Pair(FIELD_CUSTOMER_BILLING_REFERENCE_NUMBER, CustomerBillingReferenceNumber().toString()),
//            Pair(FIELD_MEET_AT_LOCATION, MeetAtLocation()),
//            Pair(FIELD_NEW_JOB_ADDRESS, NewJobAddress()),
//            Pair(FIELD_NEW_CLIENT_JOB, NewClientJob()),
//            Pair(FIELD_SPIN_OFF_JOB, SpinOffJob()),
//            Pair(FIELD_WORK_LOCATION_START, WorkLocationStart()),
//            Pair(FIELD_WORK_ORDER_TYPE, WorkOrderType()),
//            Pair(FIELD_APPROVING_ACCOUNT, ApprovingAccount()),
//            Pair(FIELD_RENTAL_TYPE, RentalType()),
//            Pair(FIELD_AWP_OPERATIONS_REGION, AWPOperationsRegion())
//        )}
//
//        fun fromGraphql(queryResult: AgendaQuery.Job) = queryResult.run { Job(
//            uid = UID.fromString(UID()),
//            contactId = UID.fromNullableString(ContactId()),
//            accountId = UID.fromNullableString(AccountId()),
//            regionId =  RegionId(),
//            name =  Name(),
//            description =  Description(),
//            status =  JobStatus.fromLabel(JobStatus())!!,
//            type = Type(),
//            address =  Address(),
//            geoLongitude =  GeoLongitude() ?: 0.0,
//            geoLatitude =  GeoLatitude() ?: 0.0,
//            startDate =  Instant.parse(Start()),
//            endDate =  Instant.parse(End()),
//            timezone =  Timezone(),
//            duration =  Duration(),
//            notesComments =  NotesComments(),
//            canBeDeclined =  CanBeDeclined(),
//            customFields =  getCustomFieldsGql(queryResult),
//            jobAllocations =  JobAllocation.fromGraphql(JobAllocations()),
//            account =  Account.fromGraphql(Account()),
//            contact =  Contact.fromGraphql(Contact()))
//        }
    }

    val clientJobNumber: String?
        get() = customFields[FIELD_CLIENT_JOB_NUMBER]

    val awpOffice: String?
        get() = customFields[FIELD_AWP_OFFICE]

    val requiresEstimateProductQuantities: Boolean
        get() = customFields[FIELD_REQUIRES_ESTIMATED_PRODUCTS]?.toBoolean() ?: false

    val imeiNumbers: String?
        get() = customFields[FIELD_IMEI_NUMBERS]

    val statusChangeDisabled: Boolean
        get() = customFields[FIELD_STATUS_CHANGE_DISABLED]?.toBoolean() ?: false

    val billableHours: Double?
        get() = customFields[FIELD_BILLABLE_HOURS]?.toDoubleOrNull()

    val leo: Boolean
        get() = customFields[FIELD_LEO]?.toBoolean() ?: false

    val leoComment: String?
        get() = customFields[FIELD_LEO_COMMENT]

    val jobInstructions: String?
        get() = customFields[FIELD_JOB_INSTRUCTIONS]

    val customerBillingReferenceNumber: String?
        get() = customFields[FIELD_CUSTOMER_BILLING_REFERENCE_NUMBER]

    val meetAtLocation: String?
        get() = customFields[FIELD_MEET_AT_LOCATION]

    val newJobAddress: String?
        get() = customFields[FIELD_NEW_JOB_ADDRESS]

    val newClientJob: String?
        get() = customFields[FIELD_NEW_CLIENT_JOB]

    val spinOffJob: String?
        get() = customFields[FIELD_SPIN_OFF_JOB]

    val workLocationStart: Instant?
        get() = customFields[FIELD_WORK_LOCATION_START]?.let { Instant.parse(it) }

    val workOrderType: String?
        get() = customFields[FIELD_WORK_ORDER_TYPE]

    val approvingAccount: String?
        get() = customFields[FIELD_APPROVING_ACCOUNT]

    val rentalType: String?
        get() = customFields[FIELD_RENTAL_TYPE]

    val awpOperationsRegion: String?
        get() = customFields[FIELD_AWP_OPERATIONS_REGION]

    fun getCustomFields() = mapOf(
        Pair(FIELD_CLIENT_JOB_NUMBER, clientJobNumber),
        Pair(FIELD_AWP_OFFICE, awpOffice),
        Pair(FIELD_REQUIRES_ESTIMATED_PRODUCTS, requiresEstimateProductQuantities),
        Pair(FIELD_IMEI_NUMBERS, imeiNumbers),
        Pair(FIELD_STATUS_CHANGE_DISABLED, statusChangeDisabled),
        Pair(FIELD_BILLABLE_HOURS, billableHours),
        Pair(FIELD_LEO, leo),
        Pair(FIELD_LEO_COMMENT, leoComment),
        Pair(FIELD_JOB_INSTRUCTIONS, jobInstructions),
        Pair(FIELD_CUSTOMER_BILLING_REFERENCE_NUMBER, customerBillingReferenceNumber),
        Pair(FIELD_MEET_AT_LOCATION, meetAtLocation),
        Pair(FIELD_NEW_JOB_ADDRESS, newJobAddress),
        Pair(FIELD_NEW_CLIENT_JOB, newClientJob),
        Pair(FIELD_SPIN_OFF_JOB, spinOffJob),
        Pair(FIELD_WORK_LOCATION_START, workLocationStart),
        Pair(FIELD_WORK_ORDER_TYPE, workOrderType),
        Pair(FIELD_APPROVING_ACCOUNT, approvingAccount),
        Pair(FIELD_RENTAL_TYPE, rentalType),
        Pair(FIELD_AWP_OPERATIONS_REGION, awpOperationsRegion)
    )

    //FIXME copy() doesn't work the way it should in Scala, you can't specify single params.
    // Delete once this is no longer needed.
    fun updateAddress(value: String?): Job = copy(address = value)

    //FIXME copy() doesn't work the way it should in Scala, you can't specify single params.
    // Delete once this is no longer needed.
    fun updateNotesComments(value: String?): Job = copy(notesComments = value)

    fun updateCustomField(fieldName: String, value: Any?): Job = copy(customFields = customFields + (fieldName to value.toString()))


}