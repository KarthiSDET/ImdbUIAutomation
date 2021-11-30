package Pages;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.PageHandler;

import java.util.ArrayList;
import java.util.List;


public class SearchPage extends PageHandler {

    public void userEntersInSearchTextBox(String searchTerm) {
        try {
            WebElement searchTextBox =
                getDriver().findElement(By.xpath("//input[@id='suggestion-search']"));
            fluentWait(searchTextBox, 10);
            searchTextBox.sendKeys(searchTerm);
        } catch (Exception e) {
            getDriver().quit();
            throw new RuntimeException("Unable to enter in search text box", e);
        }
    }

    public void clickOnSearchBtn() {
        try {
            WebElement searchBtn =
                getDriver().findElement(By.xpath("//button[contains(@type,'submit')]"));
            fluentWait(searchBtn, 10);
            searchBtn.click();
        } catch (Exception e) {
            getDriver().quit();
            throw new RuntimeException("Unable to click on search btn", e);
        }
    }

    public void clickOnDirectorNameInNameSection(String searchTerm) {
        try {
            WebElement directorNameInNameSection = getDriver().findElement(By.xpath(
                new StringBuilder().append("//a[@name='nm']/../..//a[contains(text(),'")
                    .append(searchTerm).append("')]").toString()));
            fluentWait(directorNameInNameSection, 10);
            directorNameInNameSection.click();
        } catch (Exception e) {
            getDriver().quit();
            throw new RuntimeException("Unable to click on director name", e);
        }
    }

    public void clickOnDirectorInDirectorDetailsPage() {
        WebElement directorBtn = getDriver().findElement(
            By.xpath("//div[@id='filmo-head-director']//a[contains(text(),'Director')]"));
        scrollUntilElementIsFoundAndClick(directorBtn, 10000);
    }

    public void scrollUntilElementIsFoundAndClick(WebElement element, int scrollHeightStart) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        int xCoordinate = 0, yCoordinate;
        Long BottomPageYCoordinate =
            (Long) js.executeScript("return window.document.body.scrollHeight");
        for (
            yCoordinate = scrollHeightStart;
            yCoordinate <= BottomPageYCoordinate; yCoordinate += 30) {
            js.executeScript("window.scrollBy(" + xCoordinate + ", " + yCoordinate + ");");
            if (element.isDisplayed()) {
                WebElement showBtn = getDriver().findElement(By.xpath(
                    "//div[@id='filmo-head-director']//a[contains(text(),'Director')]/..//span[contains(@class,'show-link')]"));
                showBtn.click();
                break;
            }
        }
    }

    public void getAllMovies(String searchTerm) {
        List<String> directorMoviesList = new ArrayList<>();
        List<WebElement> moviesList = getDriver().findElements(By.xpath(
            "//div[@id='filmo-head-director']//a[contains(text(),'Director')]/..//following-sibling::div[1]//b"));

        for (WebElement movies : moviesList) {
            directorMoviesList.add(movies.getText());
        }
        System.out.println("The list of movies of director " + searchTerm + ":");
        for (String movie : directorMoviesList) {
            System.out.println(movie);
        }
        WebElement directorBtn = getDriver().findElement(
            By.xpath("//div[@id='filmo-head-director']//a[contains(text(),'Director')]"));

        Select obj = new Select(directorBtn);
        obj.getAllSelectedOptions();

    }

}
