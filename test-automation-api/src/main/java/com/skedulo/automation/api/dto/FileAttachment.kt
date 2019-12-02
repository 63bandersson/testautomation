package com.skedulo.automation.api.dto

import com.skedulo.automation.api.types.UID

data class FileAttachment(val parentId: UID<*>, val name: String, val data: ByteArray, val contentType: String)
