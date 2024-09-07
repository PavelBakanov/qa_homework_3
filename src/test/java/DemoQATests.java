import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQATests {
    @BeforeAll
    static void beforeAll()
    {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void demoQATest()
    {
      open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov@ivan.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("89991112233");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$("option[value='1992']").click();
        $(".react-datepicker__year-select").$("option[value='1992']").click();
        $(".react-datepicker__day--028").click();

        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();

        //$("hobbiesWrapper").$("hobbies-checkbox-2").click();

    }
}
