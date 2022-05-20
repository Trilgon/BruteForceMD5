import java.math.BigInteger
import java.security.MessageDigest

object HashMaker {
    fun toMD5(value: String): String {
        synchronized(this) {
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(value.toByteArray())).toString(16).padStart(32, '0')
        }
    }
}