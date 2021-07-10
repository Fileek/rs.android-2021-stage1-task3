package subtask2

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        if (number < 5) return null

        val nextNumber = number - 1
        val sequenceArray = mutableListOf(nextNumber)
        var array: Array<Int>? = null

        fun composeArray(remainer: Int) {
            if (remainer == 0) {
                array = sequenceArray.toTypedArray().reversedArray()
                return
            }

            var nx = kotlin.math.sqrt(remainer.toDouble()).toInt()

            while (nx.square() * 2 > remainer) {
                sequenceArray.add(nx)
                composeArray(remainer - nx.square())
                if (array != null) return
                sequenceArray.remove(nx)
                nx--
            }
        }

        composeArray(number.square() - nextNumber.square())
        return array
    }
}

fun Int.square(): Int = this * this
