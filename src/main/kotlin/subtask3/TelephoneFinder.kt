package subtask3

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.startsWith('-')) return null

        val numbers = mutableListOf<String>()

        for (i in number.indices) {
            val digit = number[i]
            val neighbourDigits = mutableListOf<Char>()

            with (neighbourDigits) {
                if (digit == '0') add('8') // "0" has only neighbour "8"
                else {
                    when (digit.toInt() % 3) { // add horizontal neighbours
                        1 -> add(digit + 1)
                        2 -> addAll(listOf(digit - 1, digit + 1))
                        0 -> add(digit - 1)
                    }
                    when (digit) { // add vertical neighbours
                        in '1'..'3' -> add(digit + 3)
                        in '4'..'6' -> addAll(listOf(digit - 3, digit + 3))
                        '8' -> addAll(listOf('0', digit - 3))
                        else -> add(digit - 3)
                    }
                }
            }
            with (number) {
                val digitsBefore = if (i != 0) substring(0 until i) else ""
                val digitsAfter = if (i + 1 < length) substring(i + 1 until length) else ""
                neighbourDigits.forEach { digit -> numbers.add(digitsBefore + digit + digitsAfter) }
            }
        }
        return numbers.toTypedArray()
    }
}
