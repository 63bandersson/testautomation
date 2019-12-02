package com.skedulo.automation.api.model.mobile.bulkmodify

data class BulkModifyResponseObject(
    val result: List<Result>
)
data class Result(
        val ids: List<String>,
        val operation: String,
        val temporaryIds: TemporaryIds
)
class TemporaryIds(
)