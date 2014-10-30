import com.whirlwin.regex_switch.RegexSwitch;
import org.junit.Test;

public final class RegexSwitchTest {

    @Test
    public void test() {
        RegexSwitch.test("foo@bar.com")
                .matches("foo").then(() -> System.out.println("first option"))
                .matches("foo.+").then(() -> System.out.println("second option"))
                .matches("foo.+").then(() -> System.out.println("third option"))
                .otherwise(() -> System.out.println("fourth option"));
    }
}
