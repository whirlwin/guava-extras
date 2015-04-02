import com.whirlwin.regex_switch.RegexSwitch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class RegexSwitchTest {

    @Test
    public void test_case() {
        final String res = RegexSwitch.<String>test("foo@bar.com")
                .matches("args!").then("args")
                .matches("foo.+").then("foo")
                .otherwise("bar");
        assertEquals(res, "foo");
    }

    @Test
    public void test_default() {
        final String res = RegexSwitch.<String>test("foo@bar.com")
                .matches("args!").then("args")
                .matches("foobar.+").then("foo")
                .otherwise("bar");
        assertEquals(res, "bar");
    }
}
