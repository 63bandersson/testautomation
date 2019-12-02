package com.skedulo.automation.api.dto

import com.google.gson.JsonObject
import com.skedulo.automation.api.SyncEntry
import com.skedulo.automation.api.types.UID
import org.threeten.bp.Instant

data class SchemaChangeset(
    val schema: String,
    val uid: UID<*>,
    val operation: SchemaOperation,
    val newValues: JsonObject,
    val oldValues: JsonObject? = null,
    val date: Instant = Instant.now()
) : SyncEntry {

    override fun getIdentifier(): String {
        return "$schema|$uid"
    }

    override fun getTime(): Instant {
        return date
    }

    override fun getEnglish(): String {
        return "$schema|$uid: changing: \n$oldValues \nto: \n$newValues"
    }

    companion object {

        @JvmStatic
        val OPERATION_INSERT = "Insert"

        @JvmStatic
        val OPERATION_UPDATE = "Update"
    }

}
