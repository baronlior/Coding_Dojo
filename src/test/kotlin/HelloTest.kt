import com.nhaarman.expect.expect
import org.junit.jupiter.api.Test

internal class HelloTest {

  @Test fun foo() {
    expect(2+2).toBe(4)
  }


  @Test fun foo2() {
    expect(2+4).toBe(6)
  }
}
