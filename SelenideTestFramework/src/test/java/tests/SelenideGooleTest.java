package tests;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SelenideGooleTest {

    @BeforeClass
    public void setUp() {
        // Configure Selenide (optional)
    	Configuration.browser = "chrome";
    	Configuration.browserSize="defalult";
        //Configuration.startMaximized = true;
        Configuration.baseUrl = "https://www.google.com";
    }

    @Test
    public void testGoogleSearch() {
        // Open Google homepage
        open("/");

        // Perform search
        $(By.name("q")).setValue("Selenide").pressEnter();

        // Verify search results
        $$("#search .g").first().shouldHave(text("Selenide: concise UI tests in Java"));

        // Click on the search result
        $(By.xpath("//h3[contains(text(),'Selenide: concise UI tests in Java')]")).click();

        // Verify landing on the correct page
           // $("h1").shouldHave(exactText("Selenide: concise UI tests in Java"));
        $("h3").shouldHave(text("What is Selenide?"));
    }
}
