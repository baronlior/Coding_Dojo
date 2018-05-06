import com.nhaarman.expect.expect
import org.junit.jupiter.api.Test

internal class HelloTest {


  private fun add(first: String, second: String) = RomanCalculator.add(first, second)


  @Test fun `basic additions`() {
    expect(add("I","I")).toBe("II")
    expect(add("II","I")).toBe("III")
    expect(add("I","II")).toBe("III")
    expect(add("C","C")).toBe("CC")
    expect(add("CC","C")).toBe("CCC")
    expect(add("C","CC")).toBe("CCC")
    expect(add("X","X")).toBe("XX")
    expect(add("XX","X")).toBe("XXX")
    expect(add("X","XX")).toBe("XXX")
  }

  @Test fun `debug`() {
    expect(add("II","I")).toBe("III")
  }

  @Test fun `combine 3x I X C`() {
    expect(add("II","III")).toBe("V")
    expect(add("CC","CCC")).toBe("D")
    expect(add("XX","XXX")).toBe("L")
    expect(add("II","II")).toBe("IV")
    expect(add("XX","XX")).toBe("XL")
    expect(add("CC","CC")).toBe("CD")
    expect(add("III","III")).toBe("VI")
    expect(add("XXX","XXX")).toBe("LX")
    expect(add("CCC","CCC")).toBe("DC")
    expect(add("V","I")).toBe("VI")
    expect(add("V","II")).toBe("VII")
    expect(add("V","III")).toBe("VIII")

//    expect(add("VIII","IV")).toBe("XII")
  }

  @Test fun `combine 3x V L D`() {

    expect(add("V","V")).toBe("X")
    expect(add("L","L")).toBe("C")
    expect(add("D","D")).toBe("M")
  }



  @Test fun `different numerical`() {
    expect(add("XX", "II")).toBe("XXII")
    expect(add("XI", "XI")).toBe("XXII")
    expect(add("I", "VI")).toBe("VII")
  }

  @Test fun `unstable`() {

    expect(add("VI", "III")).toBe("IX")
  }

}
