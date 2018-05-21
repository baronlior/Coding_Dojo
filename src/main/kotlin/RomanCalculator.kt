
data class R(val value: String)

val numbersMap = listOf(
    "IIIIIIIII" to "IX",
    "IIIII" to "V",
    "VIIII" to "IX",
    "IIII" to "IV",
    "VV" to "X",
    "XXXXXXXXX" to "XC",
    "XXXXX" to "L",
    "XXXX" to "XL",
    "LL" to "C",
    "CCCCCCCCC" to "CM",
    "CCCCC" to "D",
    "CCCC" to "CD",
    "DD"  to "M"

)

val expandCases = listOf(
    "IV" to "IIII",
    "IX" to "VIIII",
    "XL" to "XXXX",
    "XC" to "LXXXX",
    "CD" to "CCCC",
    "CM" to "DCCCC"
)

val charValues = listOf('I', 'V', 'X', 'L', 'C', 'D', 'M')

operator fun R.plus(other : String) : R{
  return this + R(other)
}

operator fun R.plus(other : R) : R{
  var resultStr = expand(this) + expand(other)
  resultStr = reduce(sort(resultStr))
  return R(resultStr)
}

fun expand(n: R) : String {
  var result = n.value
  expandCases.forEach {
    result = result.replace(it.first, it.second)
  }

  return result
}


private fun reduce(resultStr: String): String {
  var result = resultStr
  println("Before reduce $result")
  numbersMap.forEach {
    result = result.replace(it.first, it.second)
  }
  println("After reduce $result")
  return result
}

fun sort(value: String): String {
  println("Before sort: $value")
  val result = value.toCharArray().sortedWith(Comparator { o1, o2 -> charValues.indexOf(o2) - charValues.indexOf(o1) }).joinToString("")
  println("After sort: $result")
  return result
}

