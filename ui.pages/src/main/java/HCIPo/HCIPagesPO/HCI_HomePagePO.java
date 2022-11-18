package HCIPo.HCIPagesPO;

import Base.BasePO;
import Base.Common;
import Base.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HCI_HomePagePO extends BasePO {
    private static HCI_HomePagePO hci_HomePagePO;

    private SingletonBrowser singleton = SingletonBrowser.getInstance();
    private By hyperthermiaMainNav = By.xpath("//span[text()='HYPERTHERMIA']");
    private By hyperthermiaSubNav = By.xpath("//span[text()='Hyperthermia']");
    private By detSubNav = By.xpath("//a[text()='Diagnosis & Early Treatment']");
    private By hcSubNav = By.xpath("//a[text()='Hyperthermia & Chemotherapy']");
    private By hrtSubNav = By.xpath("//a[text()='Hyperthermia & Radiation Therapy']");
    private HCI_HomePagePO() {
        super();
    }

    public static final HCI_HomePagePO getInstance() {
        if (hci_HomePagePO == null) {
            hci_HomePagePO = new HCI_HomePagePO();
        }
        return hci_HomePagePO;
    }
    public void homePageLoad()throws Exception{
        try {
            Common.implicitlyWait(50);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : enterFirstName()" + e.getLocalizedMessage());
        }
    }
    public void playVideo1() throws Exception {
        try {
            WebElement videoImage = singleton.getDriver().findElement(By.xpath("//div[@class='elementor-element elementor-element-9208e49 elementor-widget elementor-widget-image']//img[@class='attachment-full size-full']"));
            Common.implicitlyWait(80);
            videoImage.click();

            WebElement iFrame = singleton.getDriver().findElement(By.xpath("//iframe[@class='elementor-video-iframe']"));
            singleton.getDriver().switchTo().frame(iFrame);

            WebElement videoPlayButton = singleton.getDriver().findElement(By.xpath("//button[@aria-label='Play']"));
            Common.waitForVisibilityOf(singleton.getDriver(),videoPlayButton ,8);
            videoPlayButton.click();
            Thread.sleep(13000);

            WebElement videoPauseButton = singleton.getDriver().findElement(By.xpath("//button[@aria-label='Pause']"));
            JavascriptExecutor js = (JavascriptExecutor)singleton.getDriver();
            js.executeScript("arguments[0].click();", videoPauseButton);
            Thread.sleep(3000);

            singleton.getDriver().switchTo().defaultContent();

            WebElement closeButton = singleton.getDriver().findElement(By.xpath("//i[@class='eicon-close']"));
            closeButton.click();

            Common.pageScroll("window.scrollBy(0,1500)");
            Thread.sleep(3000);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : VerifyHomePagePlayVideo1()" + e.getLocalizedMessage());
        }
    }
    public void selectHyperthermiaNavBarHyperthermiaSubNav() throws Exception {
        try {

            //hoverOverElement(hyperthermiaMainNav);
            WebElement firstElement = singleton.getDriver().findElement(hyperthermiaMainNav);
            WebElement secondElement = singleton.getDriver().findElement(hyperthermiaSubNav);
            Actions actions = new Actions(singleton.getDriver());
            actions.moveToElement(firstElement);
            actions.click(secondElement);
            actions.build().perform();;
            //Common.waitTillVisibilityOfElementLocated(singleton.getDriver(), hyperthermiaSubNav,20);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : selectHyperthermiaNavBarHyperthermiaSubNav()" + e.getLocalizedMessage());
        }
    }

}


