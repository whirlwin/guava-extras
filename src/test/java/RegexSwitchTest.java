import com.whirlwin.regex_switch.RegexSwitch;
import org.junit.Test;

public final class RegexSwitchTest {

    @Test
    public void test_with_regular_return_value() {
        String res = RegexSwitch.<String>test("foo@bar.com")
                .matches("args!").then("args")
                .matches("foo.+").then("foo")
                .otherwise("bar");
        System.out.println(res);
    }
}
