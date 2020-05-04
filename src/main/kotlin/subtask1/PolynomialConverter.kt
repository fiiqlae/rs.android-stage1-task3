package subtask1

import java.lang.StringBuilder
import kotlin.math.max
import kotlin.math.sign

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        if(numbers.isEmpty()) return null
        var maxPower = numbers.size - 1
        val result = StringBuilder()
        numbers.map {
            val postfix = when(maxPower){0 -> ""; 1 -> "x"; else -> "x^$maxPower"}
            maxPower--
            when {
                it > 0 -> result.append(" + $it$postfix")
                it == 1 -> result.append(" + $postfix")
                it == -1 -> result.append(" - $postfix")
                it == 0 -> result.append("")
                else -> result.append(" - ${it * -1}$postfix")
            }
        }
        return result.toString().substring(3)
    }

}


