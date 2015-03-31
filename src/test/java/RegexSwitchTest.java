import com.whirlwin.regex_switch.RegexSwitch;
import org.junit.Test;

public final class RegexSwitchTest {

    @Test
    public void test_no_arg_function__matches_third_case() {
        RegexSwitch.<String>test("foo@bar.com")
                .matches("args!").then(() -> System.out.println("first case"))
                .matches("bar").then(() -> System.out.println("second case"))
                .matches("foo.+").then(() -> System.out.println("third case"))
                .otherwise(() -> System.out.println("fourth case"));
    }
    
    @Test
    public void test_with_regular_return_value() {
        Object res = RegexSwitch.<String>test("foo@bar.com")
                .matches("args!").then("args")
                .matches("foo.+").then("foo")
                .otherwise("bar");
        System.out.println(res);
    }
}
