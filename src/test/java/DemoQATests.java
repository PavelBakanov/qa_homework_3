import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
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
        $(".react-datepicker__year-select").$(byText("1992")).click();
        $(".react-datepicker__month-select").$(byText("June")).click();
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

        //4. проверка
        $(".table-responsive").$(byTagAndText("td", "Student Name")).sibling(0).shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byTagAndText("td", "Student Email")).sibling(0).shouldHave(text(userEmail));
        $(".table-responsive").$(byTagAndText("td", "Gender")).sibling(0).shouldHave(text(gender));
        $(".table-responsive").$(byTagAndText("td", "Mobile")).sibling(0).shouldHave(text(userNumber));
        $(".table-responsive").$(byTagAndText("td", "Date of Birth")).sibling(0).shouldHave(text("28 June,1992"));
        $(".table-responsive").$(byTagAndText("td", "Subjects")).sibling(0).shouldHave(text(subjectsOne + ", " + subjectsTwo));
        $(".table-responsive").$(byTagAndText("td", "Hobbies")).sibling(0).shouldHave(text(hobbiesOne + ", " + hobbiesTwo));
        $(".table-responsive").$(byTagAndText("td", "Picture")).sibling(0).shouldHave(text(pictureName));
        $(".table-responsive").$(byTagAndText("td", "Address")).sibling(0).shouldHave(text(address));
        $(".table-responsive").$(byTagAndText("td", "State and City")).sibling(0).shouldHave(text(state + " " + city));


    }
}
