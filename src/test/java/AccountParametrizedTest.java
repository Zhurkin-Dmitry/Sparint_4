import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountParametrizedTest {

    @Parameterized.Parameter
    public String name;

    @Parameterized.Parameter(1)
    public boolean expectedResult;

    @Parameterized.Parameters(name = ": \"{0}\" | expectedResult = {1}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"D s", true},
                {"D  s", false},
                {"Ds", false},
                {"Ds ", false},
                {" Ds", false},
                {"Dmi try Sy", false},
                {"Dmitry SidoMaxValue", true},
                {"Dmitry STooMachValue", false},
                {null, false}
        };
    }

    @Test
    public void checkName() {
        Account account = new Account(name);
        Assert.assertEquals(expectedResult, account.checkNameToEmboss());
    }
}