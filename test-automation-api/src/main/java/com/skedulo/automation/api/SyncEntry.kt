package com.skedulo.automation.api

import org.threeten.bp.Instant

interface SyncEntry {
    fun getIdentifier(): String
    fun getEnglish(): String
    fun getTime(): Instant
}
