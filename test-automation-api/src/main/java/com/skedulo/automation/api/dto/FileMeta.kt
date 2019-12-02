package com.skedulo.automation.api.dto

import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.annotations.SerializedName
import com.skedulo.automation.api.dto.awp.HasUid
import com.skedulo.automation.api.types.UID
import org.threeten.bp.Instant

data class FileMeta(
    @SerializedName("filePtr") override val uid: UID<FileMeta>,
    @SerializedName("parentId") val parentId: UID<*>,
    @SerializedName("contentType") val contentType: String,
    @SerializedName("fileName") val fileName: String,
    @SerializedName("uploadDate") val uploadDate: Instant?,
    @SerializedName("size") val size: Int?,
    @SerializedName("description") val description: String?,
    @SerializedName("downloadUrl") val downloadUrl: String?,
    // device-only fields. Ensure they are added to shouldSkipField()

    val existsOnRemote: Boolean,
    val dataFetchedFromRemote: Boolean,
    // while this will indicate that we aren't synced with remote yet, we need to use dataFetchedFromRemote to
    // handle 'currently downloading' status
    val localFileLocation: String?
) : HasUid<FileMeta> {
    //FIXME add field names here as per Job

    object Exclusions : ExclusionStrategy {
        override fun shouldSkipClass(arg0: Class<*>): Boolean {
            return false
        }

        // This prevents some fields from being serialised to JSON
        override fun shouldSkipField(f: FieldAttributes): Boolean {
            return f.declaringClass == FileMeta::class.java &&
                (f.name == "dataFetchedFromRemote" || f.name == "localFileLocation" || f.name == "existsOnRemote")
        }
    }
}
