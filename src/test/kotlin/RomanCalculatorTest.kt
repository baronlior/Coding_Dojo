import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class RomanCalculatorTest {
  @Test
  fun testExpand() {
    assertEquals("IIII", expand(R("IV")))
    assertEquals("VIIII", expand(R("IX")))
    assertEquals("MVIIII", expand(R("MIX")))
    assertEquals("MLXXXX", expand(R("MXC")))
    assertEquals("MXXXX", expand(R("MXL")))
  }


  @Test
  fun testSort(){
    assertEquals("VII", sort("IVI"))
    assertEquals("VII", sort("IIV"))
    assertEquals("XVI", sort("VIX"))
    assertEquals("XXVI", sort("VIXX"))
    assertEquals("MDCLXVI", sort("IVDMCXL"))
  }
  @Test
  fun simpleCases() {
    val one = R("I")
    assertEquals(R("II"),one + one)
    assertEquals(R("III"), R("II") + "I")
    assertEquals(R("IV"), R("II") + "II")
    assertEquals(R("V"), R("III") + "II")
    assertEquals(R("X"), R("V") + "V")
  }

  @Test
  fun complexCases() {
    assertEquals(R("IX"), R("IV") + "V")
    assertEquals(R("IX"), R("V") + "IV")
    assertEquals(R("VII"), R("V") + "II")
    assertEquals(R("XII"), R("VI") + "VI")
    assertEquals(R("XVII"), R("XI") + "VI")
    assertEquals(R("XXII"), R("XI") + "XI")
    assertEquals(R("XVIII"), R("XIV") + "IV")
    assertEquals(R("CCXVIII"), R("CXIV") + "CIV")
    assertEquals(R("CXX"), R("XIV") + "CVI")
    assertEquals(R("XVIII"), R("IX") + "IX")
    assertEquals(R("CMXCVIII"), R("CDXCIX") + "CDXCIX")

  }
}
