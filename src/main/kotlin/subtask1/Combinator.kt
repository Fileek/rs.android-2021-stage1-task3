package subtask1

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val posters: Long = array[0].toLong()
        val colors: Long = array[1].toLong()
        for (k in 1..colors) {
            if (colors.factorial() /
                (k.factorial() * (colors - k).factorial()) == posters) return k.toInt()
        }
        return null
    }
}

fun Long.factorial() : Long {
    var factorial: Long = 1
    for (i in 1..this) {
        factorial *= i
    }
    return factorial
}
