package com.skedulo.automation.api.model.mobile.userdata

class FetchInitialUserInformationResponseObject {


    data class AbortReason(
            val controller: Any,
            val controllingField: Any,
            val label: String,
            val validFor: List<Any>,
            val value: String
    )
    data class Activities(
            val Type: List<Type>
    )
    data class Android(
            val version: Any
    )
    data class Attendees(
            val CancelReason: List<CancelReason>,
            val Status: List<Statu>
    )
    data class Automatic(
            val resource: Resource
    )
    data class Availabilities(
            val Status: List<Statu>,
            val Type: List<Type>
    )
    data class CancelReason(
            val controller: Any,
            val controllingField: Any,
            val label: String,
            val validFor: List<Any>,
            val value: String
    )
    data class Category(
            val controller: Any,
            val controllingField: Any,
            val label: String,
            val validFor: List<Any>,
            val value: String
    )
    data class Classification(
            val controller: Any,
            val controllingField: Any,
            val label: String,
            val validFor: List<Any>,
            val value: String
    )
    data class CountryCode(
            val controller: Any,
            val controllingField: Any,
            val label: String,
            val validFor: List<Any>,
            val value: String
    )
    data class CustomerConfirmationStatu(
            val controller: Any,
            val controllingField: Any,
            val label: String,
            val validFor: List<Any>,
            val value: String
    )
    data class DeclineReason(
            val controller: Any,
            val controllingField: Any,
            val label: String,
            val validFor: List<Any>,
            val value: String
    )
    data class EmploymentType(
            val controller: Any,
            val controllingField: Any,
            val label: String,
            val validFor: List<Any>,
            val value: String
    )
    data class Features(
            val accountContactChanges: Boolean,
            val accountContactTags: Boolean,
            val actAvailSchemaChanges: Boolean,
            val activityGroups: Boolean,
            val captureLogRocketEvents: Boolean,
            val chat: Boolean,
            val customerConfirmationStatus: Boolean,
            val disableClassicWebApp: Boolean,
            val disableHtml5App: Boolean,
            val driverUpsertSupport: Boolean,
            val enableUIPermissionsCheck: Boolean,
            val greaterThan24HrJobs: Boolean,
            val groupEvents: Boolean,
            val jaEstimatedTravelDistance: Boolean,
            val jaGeoStatusChange: Boolean,
            val jobAllocationTimes: Boolean,
            val jobOffers: Boolean,
            val jobSwap: Boolean,
            val offerSchemaChanges: Boolean,
            val optionalAddressOnActivity: Boolean,
            val recurringSchedulePattern: Boolean,
            val resourceOverrides: Boolean,
            val resourceRequirementValidation: Boolean,
            val resourceRequirements: Boolean,
            val resourceTravelStats: Boolean,
            val secondaryRegions: Boolean,
            val shiftBreaks: Boolean,
            val shiftOffers: Boolean,
            val shiftSchemaChanges: Boolean,
            val shifts: Boolean,
            val shiftsv2: Boolean,
            val substituteJobAllocationTimes: Boolean,
            val swimlaneCalendarTab: Boolean,
            val tagsForShift: Boolean,
            val useGlobalNavigation: Boolean,
            val useJobOffers: Boolean,
            val usePhoenixBackend: Boolean,
            val useResourceRequirements: Boolean,
            val useShiftOffers: Boolean,
            val useTemporaryRegions: Boolean,
            val workingHoursForResource: Boolean
    )
    data class FollowupReason(
            val controller: Any,
            val controllingField: Any,
            val label: String,
            val validFor: List<Any>,
            val value: String
    )
    data class InitialUserData(
            val result: Result
    )
    data class Ios(
            val version: Any
    )
    data class Job(
            val abortJob: Any,
            val checkIn: Any,
            val complete: Any,
            val completionNotes: Any,
            val confirm: Any,
            val createFollowUp: Any,
            val decline: Any,
            val inProgress: Any,
            val manageTimes: Any,
            val startTravel: Any
    )
    data class JobAllocations(
            val DeclineReason: List<DeclineReason>,
            val NotificationType: List<NotificationType>
    )
    data class Jobs(
            val AbortReason: List<AbortReason>,
            val CustomerConfirmationStatus: List<CustomerConfirmationStatu>,
            val FollowupReason: List<FollowupReason>,
            val JobStatus: List<JobStatu>,
            val Type: List<Type>,
            val Urgency: List<Urgency>
    )
    data class JobOffers(
            val Status: List<Statu>
    )
    data class JobStatu(
            val controller: Any,
            val controllingField: Any,
            val label: String,
            val validFor: List<Any>,
            val value: String
    )
    data class JobTimeConstraints(
            val Type: List<Type>
    )

    data class Labels(
            val job: Job,
            val menu: Menu
    )
    data class Menu(
            val customForms: Any
    )
    data class Mobile(
            val allowAutomaticRefreshOfJobs: Boolean,
            val allowManagementOfActivities: Boolean,
            val allowManagementOfAvailabilities: Boolean,
            val allowManagementOfUnavailabilities: Boolean,
            val android: Android,
            val completedJobsAreReadonlyOnMobile: Boolean,
            val enableCreateActivity: Boolean,
            val enableCreateJob: Boolean,
            val enableDeleteActivity: Boolean,
            val enableFollowupAssignToSelf: Boolean,
            val enableFollowups: Boolean,
            val enableManageTimes: Boolean,
            val enableProximityNotifications: Boolean,
            val ios: Ios,
            val preloadJobRangeMaxDays: Int,
            val preloadJobRangeMinDays: Int,
            val supportEmail: String
    )
    data class Notifications(
            val automatic: Automatic
    )
    data class NotificationType(
            val controller: Any,
            val controllingField: Any,
            val label: String,
            val validFor: List<Any>,
            val value: String
    )
    data class OrgPreferences(
            val allowAbortJob: Boolean,
            val allowJobsToBeDeclined: Boolean,
            val attachmentsDownload: Boolean,
            val autoAllocateJobOffers: Boolean,
            val autoAllocateShiftOffers: Boolean,
            val autoApproveAvailabilities: Boolean,
            val autoDeleteJobAllocations: Boolean,
            val disableEnRoute: Boolean,
            val disableOnSite: Boolean,
            val dispatchJobsToConfirmedStatus: Boolean,
            val enableCompletionNotes: Boolean,
            val enableHIPAACompliance: Boolean,
            val enableJobSwap: Boolean,
            val enableSMSResponse: Boolean,
            val enableShifts: Boolean,
            val excludePendingDispatchAllocationsInICal: Boolean,
            val futureJobBuffer: Int,
            val jobTasksAreOptional: Boolean,
            val labels: Labels,
            val mobile: Mobile,
            val notifications: Notifications,
            val notifyExpiredOffers: Boolean,
            val popupCompletionNotes: Boolean,
            val preventSchedulersFromCreatingJobs: Boolean,
            val restrictResourcesFromWebApp: Boolean,
            val salesforceEventSynchronisation: Boolean,
            val saveAttachmentAsFile: Boolean,
            val services: Services,
            val teamLeader: Boolean,
            val turnOnChatter: Boolean,
            val visualforce: Visualforce,
            val web: Web
    )

    data class Region(
            val CountryCode: Any,
            val GeoLatitude: Double,
            val GeoLongitude: Double,
            val Name: String,
            val Radius: Any,
            val Timezone: String,
            val UID: String
    )
    data class Resource(
            val job: Boolean,
            val shift: Boolean
    )
    data class Regions(
            val CountryCode: List<CountryCode>
    )
    data class ResourceJobOffers(
            val Response: List<Response>,
            val Status: List<Statu>
    )
    data class Resources(
            val Category: List<Category>,
            val CountryCode: List<CountryCode>,
            val EmploymentType: List<EmploymentType>,
            val NotificationType: List<NotificationType>,
            val ResourceType: List<ResourceType>,
            val WorkingHourType: List<WorkingHourType>
    )
    data class ResourceType(
            val controller: Any,
            val controllingField: Any,
            val label: String,
            val validFor: List<Any>,
            val value: String
    )
    data class ResourceShiftOffers(
            val Response: List<Response>,
            val Status: List<Statu>
    )
    data class Response(
            val controller: Any,
            val controllingField: Any,
            val label: String,
            val validFor: List<Any>,
            val value: String
    )
    data class Result(
            val features: Features,
            val locations: List<Any>,
            val orgPreferences: OrgPreferences,
            val regions: List<Region>,
            val resources: List<Any>,
            val userMetadata: UserMetadata,
            val vocabulary: Vocabulary
    )
    data class Services(
            val mapVendor: Any,
            val vendorApiKey: Any
    )
    data class ShiftOffers(
            val Status: List<Statu>
    )

    data class Statu(
            val controller: Any,
            val controllingField: Any,
            val label: String,
            val validFor: List<Any>,
            val value: String
    )
    data class Tags(
            val Classification: List<Classification>,
            val Type: List<Type>
    )
    data class Type(
            val controller: Any,
            val controllingField: Any,
            val label: String,
            val validFor: List<Any>,
            val value: String
    )
    data class Urgency(
            val controller: Any,
            val controllingField: Any,
            val label: String,
            val validFor: List<Any>,
            val value: String
    )
    data class Users(
            val UserTypes: List<UserType>
    )
    data class UserData(
            val result: Result
    )
    data class UserMetadata(
            val address: Any,
            val category: Any,
            val country: String,
            val email: String,
            val fullName: String,
            val id: String,
            val isSkeduloAdmin: Boolean,
            val isSkeduloScheduler: Boolean,
            val isSkeduloUser: Boolean,
            val latitude: Any,
            val longitude: Any,
            val orgId: String,
            val orgName: String,
            val profileId: String,
            val resourceId: Any,
            val roleId: String,
            val sfdcDomain: String,
            val smallPhotoUrl: String,
            val team: Any,
            val timezone: Any,
            val username: String,
            val userroles: String
    )
    data class UserType(
            val controller: Any,
            val controllingField: Any,
            val label: String,
            val validFor: List<Any>,
            val value: String
    )
    data class Visualforce(
            val jobItems: List<Any>,
            val labelFromJob: Any,
            val labelFromMenu: Any,
            val menuItems: List<Any>,
            val nameFromJob: Any,
            val nameFromMenu: Any
    )
    data class Vocabulary(
            val Activities: Activities,
            val Attendees: Attendees,
            val Availabilities: Availabilities,
            val JobAllocations: JobAllocations,
            val JobOffers: JobOffers,
            val JobTimeConstraints: JobTimeConstraints,
            val Jobs: Jobs,
            val Regions: Regions,
            val ResourceJobOffers: ResourceJobOffers,
            val ResourceShiftOffers: ResourceShiftOffers,
            val Resources: Resources,
            val ShiftOffers: ShiftOffers,
            val Tags: Tags,
            val Users: Users
    )
    class Web(
    )
    data class WorkingHourType(
            val controller: Any,
            val controllingField: Any,
            val label: String,
            val validFor: List<Any>,
            val value: String
    )
}