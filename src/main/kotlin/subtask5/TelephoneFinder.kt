package subtask5

import kotlin.reflect.KClass

class TelephoneFinder {

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): ArrayList<String>? {
        if(number.any{!it.isDigit()}) return null
        val adjacentDigits = hashMapOf(
            1 to listOf(2, 4),
            2 to listOf(1, 5, 3),
            3 to listOf(2, 6),
            4 to listOf(1, 5, 7),
            5 to listOf(2, 4, 8, 6),
            6 to listOf(3, 5, 9),
            7 to listOf(4, 8),
            8 to listOf(7, 5, 9, 0),
            9 to listOf(6, 8),
            0 to listOf(8))
        val result: ArrayList<String> = ArrayList()
        for ((index, char) in number.withIndex()) {
            adjacentDigits[char.toInt()-'0'.toInt()]?.forEach(){
                result.add(number.replaceRange(index, index+1, it.toString()))
            }
        }
        return result

    }
}
