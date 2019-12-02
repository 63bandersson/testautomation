package com.skedulo.automation.api.dto

enum class SchemaOperation(val operationName: kotlin.String) {
    INSERT("Insert"), UPDATE("Update"), DELETE("Delete");

    companion object {
        @JvmStatic
        fun fromOperationName(operationName: String): SchemaOperation {
            return when (operationName) {
                INSERT.operationName -> INSERT
                UPDATE.operationName -> UPDATE
                DELETE.operationName -> DELETE
                else -> throw IllegalArgumentException("No operation found matching $operationName")
            }
        }
    }
}
