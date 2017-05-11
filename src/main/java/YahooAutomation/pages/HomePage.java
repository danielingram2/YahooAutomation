package YahooAutomation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by daniel.ingram on 20/01/2016.
 */


public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


////////////////Elements//////////////////

    @FindBy(id = "uh-search-box")
    private WebElement SearchBar;


    @FindBy(id = "UHSearchWeb")
    private WebElement SearchButton;

    @FindBy( id="yui_3_10_0_1_1453825382440_583")
    private WebElement searchResult;


/////////////////////methods////////////////////////

    //Enter a search criteria
    public void EnterSearchCriteria(String searchcriteria) {

        SearchBar.clear();
        SearchBar.sendKeys(searchcriteria);
    }


    //Delete Search Criteria
    public void ClearSearchCriteria(String searchcriteria) {

        SearchBar.clear();
    }


    //Click Search Button
    public void ClickSearchButton() {

        SearchButton.click();
    }

    //Click Search Result
    public void clickSearchResult() {
        searchResult.click();
    }

}