package com.skedulo.automation.api.dto

import com.google.gson.JsonObject
import com.skedulo.automation.api.types.UID

data class StoredCustomForm(val uid: UID<*>, val schema: String, val data: JsonObject, val jobId: UID<Job>?)
