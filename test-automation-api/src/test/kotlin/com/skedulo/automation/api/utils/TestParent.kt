package com.skedulo.automation.api.utils

import com.skedulo.automation.api.ApiClient
import org.apache.commons.codec.binary.Base64
import org.junit.Test
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

open class TestParent {
    val apiClient: ApiClient

    init {
        apiClient = ApiClient(
                decrypt(env_login),
                decrypt(env_pass),
                env_token
        )
    }
    //@Test
    fun generateEncryption() {
        // 0. This should print "TestTheThing"
        println(""""${decrypt(encrypt("TestTheThing"))}"""")

        // 1. Put your login and password in here.
        println(encrypt("bandersson+dev@skedulo.com"))
        println(encrypt("54321login"))

        // 2. Take the result and store them in 'robinhood_login' and 'robinhood_password' ENV variables
        //    Do not quote the value
    }

    companion object {
        val env_login = "CGqRI+8J2bred+U37KgFxopK8Y0HrNNPrnsd1FiAkAE="
        val env_pass = "Ay+osx5/p5YuIjP9Ew3xSg=="
        val env_token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2FwaS5za2VkdWxvLmNvbS9hdXRoL3Rva2VuIiwiYXVkIjoiNWMwMjMzZTc5MWMyM2Q0ZmFkZGQ2MGM4MDE1MGY3MzYiLCJqdGkiOiJNWFRrOGVkaEdFaHF2YzROeU96NTluczRuWTFDaXRPdiIsImh0dHBzOi8vYXBpLnNrZWR1bG8uY29tL3ZlbiI6eyJ1c2VyX2lkIjoiMDAwMTc0NDQtMTI1ZC00NDI3LWExYjctOWY5ZGQxYjc4NWE2In0sImh0dHBzOi8vYXBpLnNrZWR1bG8uY29tL3VzZXJfaWQiOiJhdXRoMHw1ZDdlZDQ3N2ZkNDE3MTBjNGYxMGE2MjEiLCJodHRwczovL2FwaS5za2VkdWxvLmNvbS9vcmdhbml6YXRpb25faWQiOiJza185YWU0Zjk4MWI4M2E0MjA1ODNmOTFlYmE5MGQ3ZGE1YiIsImh0dHBzOi8vYXBpLnNrZWR1bG8uY29tL3VzZXJuYW1lIjoiYmFuZGVyc3Nvbitwcm9kK3N0YW5kYWxvbmVAc2tlZHVsby5jb20iLCJzdWIiOiJhdXRoMHw1ZDdlZDQ3N2ZkNDE3MTBjNGYxMGE2MjEiLCJodHRwczovL2FwaS5za2VkdWxvLmNvbS92ZW5kb3IiOiJza2VkdWxvIiwiaHR0cHM6Ly9hcGkuc2tlZHVsby5jb20vcmVzb3VyY2VfaWQiOiIwMDA1NjMyNi0yYzJjLTQ1ZTEtYmQzZi1kYzNkZTg5MjE5MTYiLCJodHRwczovL2FwaS5za2VkdWxvLmNvbS9yb2xlcyI6WyJhZG1pbmlzdHJhdG9yIiwic2NoZWR1bGVyIiwicmVzb3VyY2UiXX0.WDPCC8cbRgz105pkxyF-TfehqZmNVktYJRYUsO3vGP0"
        val aesKey = SecretKeySpec("YourFavoritePass".toByteArray(), "AES")

        fun encrypt(valueToEnc: String): String {
            val c = Cipher.getInstance("AES")
            c.init(Cipher.ENCRYPT_MODE, aesKey)
            val encValue = c.doFinal(valueToEnc.toByteArray())
            //println("Encrypted value: ${String(encValue)}")
            return Base64.encodeBase64String(encValue)
        }

        fun decrypt(encryptedValue: String): String {
            val c = Cipher.getInstance("AES")
            c.init(Cipher.DECRYPT_MODE, aesKey)
            val encValue = Base64.decodeBase64(encryptedValue)
            //println("Encrypted value: ${String(encValue)}")
            val decryptedVal = c.doFinal(encValue)
            return String(decryptedVal)

        }
    }
}
