package com.skedulo.automation.api.dto

import com.skedulo.automation.api.types.UID

data class BulkModifyResult(
    val result: List<BulkModifyResultItem>
)

data class BulkModifyResultItem(
    val operation: String,
    val ids: List<UID<*>>,
    val temporaryIds: Map<UID<*>, UID<*>>
)
