package subtask3

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        val numbers = mutableListOf<String>()

        for (i in number.indices) {
            val digit = number.get(i)
            val neighbourDigits = mutableListOf<Char>()

            with (neighbourDigits) {
                if (digit != '0') {
                    when (digit.toInt() % 3) {
                        1 -> add(digit + 1)
                        2 -> addAll(listOf(digit - 1, digit + 1))
                        0 -> add(digit - 1)
                    }
                    when {
                        digit < '4' -> add(digit + 3)
                        digit < '7' -> addAll(listOf(digit - 3, digit + 3))
                        else -> add(digit - 3)
                    } 
                } else add('8')
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
