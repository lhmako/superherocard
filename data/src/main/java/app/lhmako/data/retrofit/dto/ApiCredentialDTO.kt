package app.lhmako.data.retrofit.dto

import java.math.BigInteger
import java.security.MessageDigest

data class ApiCredentialDTO(
    val timestamp: Int,
    val publicKey: String,
    private val privateKey: String
) {
    fun hash(): String {
        val input = "$timestamp$privateKey$publicKey"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}
