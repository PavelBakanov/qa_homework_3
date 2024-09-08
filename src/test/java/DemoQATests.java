import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQATests {

    //объявляем переменные
    String firstName = "Ivan";
    String lastName = "Ivanov";
    String userEmail = "ivanov@ivan.com";
    String gender = "Male";
    String userNumber = "8999111223";
    String subjectsOne = "English";
    String subjectsTwo = "Maths";
    String hobbiesOne = "Reading";
    String hobbiesTwo = "Music";
    String pictureName = "example.jpg";
    String address = "Same street, 1";
    String state = "Uttar Pradesh";
    String city = "Merrut";



    //настройка
    @BeforeAll
    static void beforeAll()
    {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }
    //заполнение формы
    @Test
    void demoQATest()
    {
      open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$("option[value='1992']").click();
        $(".react-datepicker__month-select").$("option[value='5']").click();
        $(".react-datepicker__day--028").click();

        $("#subjectsInput").setValue(subjectsOne).pressEnter();
        $("#subjectsInput").setValue(subjectsTwo).pressEnter();

        $("#hobbiesWrapper").$(byText(hobbiesOne)).click();
        $("#hobbiesWrapper").$(byText(hobbiesTwo)).click();

        $("#uploadPicture").uploadFromClasspath(pictureName);

        $("#currentAddress").setValue(address);

        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("#submit").click();

        //проверка
        $(".table-responsive").shouldHave(text(firstName));
        $(".table-responsive").shouldHave(text(lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text(userNumber));
        $(".table-responsive").shouldHave(text("28 june,1992"));
        $(".table-responsive").shouldHave(text(subjectsOne));
        $(".table-responsive").shouldHave(text(subjectsTwo));
        $(".table-responsive").shouldHave(text(hobbiesOne));
        $(".table-responsive").shouldHave(text(hobbiesTwo));
        $(".table-responsive").shouldHave(text(pictureName));
        $(".table-responsive").shouldHave(text(address));
        $(".table-responsive").shouldHave(text(state));
        $(".table-responsive").shouldHave(text(city));
    }
}
