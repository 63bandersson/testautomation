package com.skedulo.automation.api.model.mobile.agenda

data class AgendaResponseObject(
    val result: Result
)
data class Account(
        val BillingCity: String,
        val BillingPostalCode: String,
        val BillingState: String,
        val BillingStreet: String,
        val Fax: String,
        val Name: String,
        val Phone: String,
        val Rank: Int,
        val ShippingCity: String,
        val ShippingPostalCode: String,
        val ShippingState: String,
        val ShippingStreet: String,
        val UID: String
)
data class Activity(
        val Address: String,
        val End: String,
        val GeoLatitude: Int,
        val GeoLongitude: Int,
        val LocationId: String,
        val Name: String,
        val Notes: String,
        val ResourceId: String,
        val Start: String,
        val Timezone: String,
        val Type: String,
        val UID: String
)
data class Attendee(
        val Contact: Contact,
        val Status: String,
        val UID: String
)
data class Availability(
        val Finish: String,
        val IsAvailable: String,
        val Notes: String,
        val ResourceId: String,
        val Start: String,
        val Status: String,
        val Type: String,
        val UID: String
)
data class Contact(
        val AccountId: String,
        val Email: String,
        val FirstName: String,
        val LastName: String,
        val MobilePhone: String,
        val Phone: String,
        val Title: String,
        val UID: String
)
data class Followup(
        val Name: String,
        val UID: String
)
data class Job(
        val AbortReason: String,
        val Account: Account,
        val AccountId: String,
        val ActualEnd: String,
        val ActualStart: String,
        val Address: String,
        val Attendees: List<Attendee>,
        val AutoSchedule: Boolean,
        val CanBeDeclined: Boolean,
        val CompletionNotes: String,
        val Contact: Contact,
        val ContactId: String,
        val CreatedById: String,
        val CreatedDate: String,
        val Description: String,
        val Duration: Int,
        val End: String,
        val EstimatedEnd: String,
        val EstimatedStart: String,
        val FollowupReason: String,
        val Followups: List<Followup>,
        val GeoLatitude: Int,
        val GeoLongitude: Int,
        val IsGroupEvent: Boolean,
        val JobAllocationCount: Int,
        val JobAllocations: List<JobAllocation>,
        val JobStatus: String,
        val JobTasks: List<JobTask>,
        val JobTimeConstraints: List<JobTimeConstraint>,
        val LastModifiedDate: String,
        val LocationId: String,
        val Locked: Boolean,
        val MaxAttendees: Int,
        val MinAttendees: Int,
        val Name: String,
        val NotesComments: String,
        val NotifyBy: String,
        val NotifyPeriod: Int,
        val ParentId: String,
        val RecurringSchedule: RecurringSchedule,
        val RecurringScheduleId: String,
        val RegionId: String,
        val Start: String,
        val Timezone: String,
        val Type: String,
        val UID: String,
        val Urgency: String,
        val _Warnings: List<Warning>
)
data class JobAllocation(
        val JobId: String,
        val Name: String,
        val ResourceId: String,
        val Status: String,
        val TeamLeader: Boolean,
        val TimeCheckedIn: String,
        val TimeCompleted: String,
        val TimeInProgress: String,
        val TimePublished: String,
        val TimeResponded: String,
        val TimeStartTravel: String,
        val UID: String
)
data class JobTask(
        val Completed: Boolean,
        val Description: String,
        val JobId: String,
        val Name: String,
        val Seq: Int,
        val UID: String
)
data class JobTimeConstraint(
        val EndBefore: String,
        val JobId: String,
        val Required: Boolean,
        val StartAfter: String,
        val StartBefore: String,
        val Type: String,
        val UID: String
)
data class RecurringSchedule(
        val AckAllJobs: Boolean,
        val UID: String
)
data class Result(
        val activities: List<Activity>,
        val availabilities: List<Availability>,
        val jobs: List<Job>
)
data class Warning(
        val Field: String,
        val Message: String
)