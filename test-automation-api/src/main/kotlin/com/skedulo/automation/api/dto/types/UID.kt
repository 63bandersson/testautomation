package com.skedulo.core.api.types

import java.io.Serializable
import java.util.*

/**
 * Holds identifier values that are returned from the backend
 *
 * FIXME This class isn't really used yet, should be applied to all instances of UID in data classes.
 */
data class UID<T>(val value: String) : Serializable {

    companion object {
        private const val LOCAL_PREFIX = "local"

        /**
         * Creates a new temporary ID
         */
        fun <T> createNewLocal(): UID<T> {
            return UID(LOCAL_PREFIX + UUID.randomUUID())
        }

        fun isLocal(value: String): Boolean {
            return value.startsWith(LOCAL_PREFIX)
        }

        fun isRemote(value: String): Boolean {
            return !isLocal(value)
        }

        fun <Type> fromString(string: String?):UID<Type> =
            string?.let { UID<Type>(it) } ?: throw IllegalArgumentException("String cannot be null")

        fun <Type> fromNullableString(string: String?):UID<Type> =
            string?.let { UID<Type>(it) } ?: createNewLocal()

        fun <Type> toString(uid: UID<Type>): String =
            uid.toString().substringAfter("=").substringBefore(")")

    }

    fun isLocal(): Boolean {
        return Companion.isLocal(value)
    }

    fun isRemote(): Boolean {
        return !Companion.isLocal(value)
    }

    fun equalsUnsafe(toCompare: UID<*>): Boolean {
        return this.value == toCompare.value
    }

    fun <NewType> unsafeApplyType(): UID<NewType> {
        @Suppress("UNCHECKED_CAST")
        return this as UID<NewType>
    }

}