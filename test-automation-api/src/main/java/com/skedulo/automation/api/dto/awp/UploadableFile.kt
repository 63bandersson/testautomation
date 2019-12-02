package com.skedulo.automation.api.dto.awp

import com.skedulo.automation.api.types.UID
import java.util.*

data class UploadableFile(
    val parentId: UID<*>,
    val fileName: String,
    val data: ByteArray
) {

    val contentType: String = "image/png"
    val description: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UploadableFile

        if (parentId != other.parentId) return false
        if (fileName != other.fileName) return false
        if (!Arrays.equals(data, other.data)) return false
        if (contentType != other.contentType) return false
        if (description != other.description) return false

        return true
    }

    override fun hashCode(): Int {
        var result = parentId.hashCode()
        result = 31 * result + fileName.hashCode()
        result = 31 * result + Arrays.hashCode(data)
        result = 31 * result + contentType.hashCode()
        result = 31 * result + (description?.hashCode() ?: 0)
        return result
    }
}

