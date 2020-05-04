package subtask4

import kotlin.math.sqrt

class SquareDecomposer {

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        return processNumber(number*number, number-1)
    }

    private fun processNumber(v: Int, offset: Int): Array<Int>?{
        (offset downTo 1).forEach { i ->
            val rem = v-i*i
            when {
                rem == 0 -> return arrayOf(i)
                rem < 0 -> return null
            }
            val next = sqrt(rem.toDouble()).toInt()
            val nextVal = if(next >= i) processNumber(rem, i - 1) else processNumber(rem, next)
            if (!nextVal.isNullOrEmpty()) return nextVal + arrayOf(i)
        }
        return null
    }
}
