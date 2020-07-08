package firstTests;

import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.TopLinkSelector;


public class HomePageTest extends BaseTest {

    @Test
    public void verifyClickingNewWillOpenNewArrPage (){
        homePage.linksNavbarModule.click(TopLinkSelector.NEW);
        Assert.assertEquals(driver.getCurrentUrl().contains(TopLinkSelector.NEW.getCssSelectorSuffix()),true);
    }
    @Test
    //@Description(value = "Тест кликает на Shipping в хеддере и проверяет, что юзер перешел на URL /shipping")
    //как поссмотреть содержание метода getCurrentUrl
    public void verifyClickingShippingWillOpenShippingPage (){
        homePage.linksNavbarModule.click(TopLinkSelector.SHIPPING);
        Assert.assertEquals(driver.getCurrentUrl().contains(TopLinkSelector.SHIPPING.getCssSelectorSuffix()),true);
    }
    //TODO: data provider  - to do one test for all links
    //@Test(dataProvider=”cross-browser-testing”)// атрибут задает поставщика данных
    /*@DataProvider(name = "LINKS", parallel = true) //
    protected Object[][] urlActionDataProviderForLinks(final ITestContext context) {
        return BaseDataProvider.getDataProviderFromEnum(Link.values(), context);
    }

    @Test(dataProvider = "LINK", retryAnalyzer = BaseTestRetryAnalyzer.class,
            description = "Webpage Links Test")
    public void testLinksOnPage(Link keyword) {
        driver.get('http://example.com');
        keyword.click;
        assertNonEmpty(keyword.getLinkText());
    }*/
}
