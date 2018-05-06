object RomanCalculator {

  private val order = listOf("M", "D", "C", "L", "X", "V", "I")

  private val fiveTimesMap = mapOf(
      "I" to "V", "X" to "L", "C" to "D"
  )

  private val twoTimesMap = mapOf(
      "V" to "X", "L" to "C", "D" to "M"
  )

  private val specialMap = mapOf(
      "VIIII" to "IX", "LXXXX" to "XC", "DCCCC" to "CM"
  )

  private fun romanSmaller(digit1: String, digit2:String): Boolean = (order.indexOf(digit1) > order.indexOf(digit2))


  fun add(first: String, second: String): String {

//    return addByDigits(first, second)
    var index1 = 0
    var index2 = 0
    var result = ""
    while (index1 < first.length && index2 < second.length) {
      val digit1 = first[index1].toString()
      val digit2 = second[index2].toString()

      if (digit1 == digit2) {
        result += digit1 + digit2

        index1++; index2++
      } else if(romanSmaller(digit1, digit2)) {
        result += digit2
        index2++
      } else { // (romanSmaller(digit2, digit1))
        result += digit1
        index1++
      }

      //result = reduce(result)

    }
    if (index1 < first.length) {
      result += first.substring(index1)
    }
    if (index2 < second.length) {
      result += second.substring(index2)
    }

    result = reduce(result)


    return result
  }

  private fun reduce(result: String): String {
    var result1 = result


    specialMap.forEach {
      result1 = result1.replace(it.key, it.value)
    }

    fiveTimesMap.forEach {
      result1 = result1.replace(it.key.repeat(5), it.value)
      result1 = result1.replace(it.key.repeat(4), "${it.key}${it.value}")
    }

    twoTimesMap.forEach {
      result1 = result1.replace(it.key.repeat(2), it.value)
    }

    return result1
  }

  fun addByDigits(first: String, second: String) : String {
    val length = if (first.length > second.length) first.length else second.length

    var res = ""
    for (i in 1.. length) {

      //TODO: null check
      val temp = addDigits(first.get(i)+"", second.get(i)+"")
      res += temp
    }
    return res
  }

  private fun addDigits(a: String, b: String): Any {
    if ( a == b && a in twoTimesMap){
      return twoTimesMap.get(a)!!
    }

    return a + b
  }


}
