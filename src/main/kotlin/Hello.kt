
val priceMap = mapOf(
  1 to 1.0,
  2 to 0.95,
  3 to 0.9,
  4 to 0.80,
  5 to 0.75
)



fun price(books : List<Int>) : Double {
  if (books.isEmpty())
    return 0.0

  val buckets = books.groupBy {it }
  val thisPrice = buckets.size *8.0 * priceMap[buckets.size]!!
//  val rest_price = price(buckets.flatMap { it.value.drop(1)})



  val rest_price = priceOf(books)
  return rest_price
}


fun priceOf(books : List<Int>) : Double {
  if (books.isEmpty())
    return 0.0

  val uniqueBooksNumber = books.groupBy {it }.size
  val otherBooksCount = books.size - uniqueBooksNumber
  return priceMap[uniqueBooksNumber]!! * uniqueBooksNumber * 8.0+  otherBooksCount *8.0
}

fun priceless(books : List<Int>) : Double {
  if (books.isEmpty())
    return 0.0

  val buckets = books.groupBy {it }
  val thisPrice = buckets.size *8.0 * priceMap[buckets.size]!!
  val rest_price = priceless(buckets.flatMap { it.value.drop(1)})
  return thisPrice + rest_price
}

