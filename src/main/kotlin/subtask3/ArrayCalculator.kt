package subtask3

import kotlin.math.abs

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val numericValues = itemsFromArray.filterIsInstance<Int>()
        val adjustedAmount = if(numberOfItems > numericValues.size) numericValues.size else numberOfItems
        if(adjustedAmount == 0) return 0
        val sortedPositive = numericValues.filter{it > 0}.sortedDescending()
        val posProd = if(sortedPositive.isNotEmpty()) sortedPositive.reduce{ p, e -> p*e} else 0
        val sortedNegative = numericValues.filter{it < 0}.sorted()
        val negProd = if(sortedNegative.isNotEmpty()) sortedNegative.reduce{ p, e -> p*e} else 0
        return if(adjustedAmount % 2 == 0 && adjustedAmount > 0) {
            (sortedPositive.subList(0,adjustedAmount/2)
                    + sortedNegative.subList(0,adjustedAmount/2)).reduce{p, e -> p*e}
        } else {
            when {
                posProd > abs(negProd) -> {
                    sortedPositive.subList(0, adjustedAmount).reduce{ p, e -> p*e}
                }
                negProd > 0 -> {
                    sortedNegative.subList(0, adjustedAmount).reduce{ p, e -> p*e}
                }
                sortedNegative.size > adjustedAmount -> {
                    sortedNegative.subList(0, adjustedAmount-1).reduce{ p, e -> p*e}*sortedPositive[0]
                }
                else -> {
                    sortedPositive.subList(0, adjustedAmount).reduce{ p, e -> p*e}
                }
            }
        }

    }
}
