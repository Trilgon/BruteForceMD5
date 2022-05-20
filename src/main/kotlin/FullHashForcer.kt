import HashMaker.toMD5
import java.math.BigInteger
import java.security.MessageDigest

class FullHashForcer(
    private val values: Array<Char>,
    private val target: String,
    private val startIndex: Int,
    private val endIndex: Int
) : Thread() {

    override fun run() {
        super.run()
        forceMD5()
    }

    private fun forceMD5() {
        var password = ""
        val symbols = CharArray(6)
        for (i in startIndex..endIndex) {
            symbols[0] = values[i]
            for (character in values) {
                symbols[1] = character
                for (char3 in values) {
                    symbols[2] = char3
                    for (char4 in values) {
                        symbols[3] = char4
                        for (char5 in values) {
                            symbols[4] = char5
                            for (char6 in values) {
                                symbols[5] = char6
                                password = String(symbols)
                                val fullHash = toMD5(password)
                                val partHash = fullHash.substring(fullHash.lastIndex - 3..fullHash.lastIndex)
                                if (partHash == target) {
                                    println("$password:$partHash")
                                    val actualHash = readln()
                                    val secret = readln()
                                    println(toMD5(actualHash + secret))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}