import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQaTests {
    @Test
    void fillFormTest() {
        Configuration.pageLoadTimeout = 80000;
        Configuration.timeout = 30000;
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov_alex1@google.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("9050050506");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").$(byText("1999")).click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").$(byText("June")).click();
        $(".react-datepicker__month-select").click();
        $("[aria-label='Choose Monday, June 28th, 1999']").click();
        $("#subjectsInput").val("Physics").pressEnter();
        $("[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFromClasspath("./Test-File-Upload.jpg");
        $("#currentAddress").val("Test Address");
        $("#react-select-3-input").val("NCR").pressEnter();
        $("#react-select-4-input").val("Noida").pressEnter();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).sibling(0)
                .shouldHave(text("Alex Ivanov"));
        $(".table-responsive").$(byText("Student Email")).sibling(0)
                .shouldHave(text("ivanov_alex1@google.com"));
        $(".table-responsive").$(byText("Gender")).sibling(0)
                .shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).sibling(0)
                .shouldHave(text("9050050506"));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0)
                .shouldHave(text("28 June,1999"));
        $(".table-responsive").$(byText("Subjects")).sibling(0)
                .shouldHave(text("Physics"));
        $(".table-responsive").$(byText("Hobbies")).sibling(0)
                .shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).sibling(0)
                .shouldHave(text("Test-File-Upload.jpg"));
        $(".table-responsive").$(byText("Address")).sibling(0)
                .shouldHave(text("Test Address"));
        $(".table-responsive").$(byText("State and City")).sibling(0)
                .shouldHave(text("NCR Noida"));
    }
}