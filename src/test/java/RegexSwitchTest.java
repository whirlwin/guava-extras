import org.junit.Test;

public final class RegexSwitchTest {

    @Test
    public void test() {
        RegexSwitch.test("foo@bar.com")
                .matches("foo").then(() -> System.out.println("first fn"))
                .matches("foo.+").then(() -> System.out.println("second fn"));
    }
}
