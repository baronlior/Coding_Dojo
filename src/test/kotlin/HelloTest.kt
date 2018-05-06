import com.nhaarman.expect.expect
import org.junit.jupiter.api.Test

internal class HelloTest {

  @Test fun basic() {
    expect(price(emptyList())).toBe(0.0)
    (0..4).forEach {
      expect(price(listOf(it))).toBe(8.0)
    }
    expect(price(listOf(0, 0))).toBe(8.0 * 2)
    expect(price(listOf(1, 1, 1))).toBe(8.0 * 3)
  }


  @Test fun simpleCombination() {
    expect(price(listOf(0, 1))).toBe(8.0 * 2 * 0.95)
    expect(price(listOf(2, 0, 4))).toBe(8.0 * 3 * 0.90)
    expect(price(listOf(0,1,2,4))).toBe(8.0 * 4 * 0.80)
    expect(price(listOf(0,1,2,3,4))).toBe(8.0 * 5 * 0.75)
  }

  @Test fun testSeveralDiscounts() {
    expect(price(listOf(0, 0, 1))).toBe(8 + (8 * 2 * 0.95))
    expect(price(listOf(0, 0, 1, 1))).toBe(2 * (8 * 2 * 0.95))
    expect(price(listOf(0, 0, 1, 2, 2, 3))).toBe((8 * 4 * 0.8) + (8 * 2 * 0.95))
    expect(price(listOf(0, 1, 1, 2, 3, 4))).toBe(8 + (8 * 5 * 0.75))
  }

  @Test fun testEdgeCases() {
    expect(price(listOf(0, 0, 1, 1, 2, 2, 3, 4))).toBe(2 * (8 * 4 * 0.8))
  }

}
