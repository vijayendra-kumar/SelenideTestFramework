package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class WikipediaSearchTest {

    @BeforeClass
    public void setUp() {
        // Set up Selenide configuration (optional)
        Configuration.browser = "chrome"; // or "", etc.
       // Configuration.startMaximized = true;
       // Configuration.holdBrowserOpen=true;
    }

    @Test
    public void testWikipediaSearch() {
        // Open Wikipedia homepage
        open("https://en.wikipedia.org");

        // Perform a search for "Java programming language"
        $(By.cssSelector("input[placeholder='Search Wikipedia']")).setValue("Java programming language").pressEnter();

        // Click on the search result link for "Java (programming language)"
        $(By.linkText("Java (programming language)")).click();
     
        // Print the current URL (should be the Selenide Wikipedia page)
        System.out.println("Current Title: " + Selenide.title());
       
     // Get the title text and assert
        String pageTitle = Selenide.title();
        Assert.assertEquals("Category:Java (programming language) - Wikimedia Commons",pageTitle);
        

    }
}

