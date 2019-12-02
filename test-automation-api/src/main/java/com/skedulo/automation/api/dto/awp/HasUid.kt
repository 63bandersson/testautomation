package com.skedulo.automation.api.dto.awp

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.skedulo.automation.api.dto.Job
import com.skedulo.automation.api.types.UID

/**
 * Interface indicating the form is tied to a Job.
 */
interface CustomJobForm<T> : HasJobId, HasUid<T>, SchemaName

interface CustomFormWithParent<Form, Parent> : HasParentId<Parent>, HasUid<Form>, SchemaName

interface SchemaName {
    fun getSchemaName(): String
}

interface HasUid<T> {
    val uid: UID<T>
}

interface HasJobId : HasParentId<Job> {

    val jobId: UID<Job>

    override fun parentId(): UID<Job> {
        return jobId
    }
}

interface HasParentId<T> {
    fun parentId(): UID<T>
}

interface CustomForm {
    fun getRequiredFields() : List<String>

    fun isFormValid(gson: Gson) : Boolean {
        val jsonObject = gson.toJsonTree(this) as JsonObject
        return getRequiredFields().all { requiredField ->
            jsonObject.entrySet().any { set ->
                set.key.toString() == requiredField && set.value.toString().isNotEmpty()
            }
        }
    }
}