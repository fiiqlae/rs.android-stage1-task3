package subtask2

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        var curRes = 1
        var limit = array[1]
        for( x in 1..limit) {
            curRes = curRes * limit / x
            if(curRes == array[0]) return x
            limit--
        }
        return null
    }
}
