package HCIPo.HCIPagesPO;

import Base.BasePO;
import Base.Common;
import Base.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class HCI_BreastCancerPagePO extends BasePO {
    private static HCI_BreastCancerPagePO hciBreastCancerPagePO;
    private SingletonBrowser singleton = SingletonBrowser.getInstance();
    private By cancersWeTreatMainNav = By.xpath("//span[text()='CANCERS WE TREAT']");
    private By colonRectalSubNav = By.xpath("//span[text()='Colon & Rectal']");
    private HCI_BreastCancerPagePO() {
        super();
    }

    public static final HCI_BreastCancerPagePO getInstance() {
        if (hciBreastCancerPagePO == null) {
            hciBreastCancerPagePO = new HCI_BreastCancerPagePO();
        }
        return hciBreastCancerPagePO;
    }
    public void hciBreastCancerPageLoad()throws Exception{
        try {
            Common.implicitlyWait(70);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : hciBreastCancerPageLoad()" + e.getLocalizedMessage());
        }
    }
    public void playVideoBreastCancer() throws Exception {
        try {
            WebElement PlayButton = singleton.getDriver().findElement(By.xpath("//div[@role ='button']"));
            Common.waitForVisibilityOf(singleton.getDriver(),PlayButton ,8);
            PlayButton.click();
            Thread.sleep(4000);

            WebElement iFrame = singleton.getDriver().findElement(By.xpath("//iframe[@class='elementor-video-iframe']"));
            singleton.getDriver().switchTo().frame(iFrame);

            WebElement videoPlayButton = singleton.getDriver().findElement(By.xpath("//button[@aria-label='Play']"));
            Common.waitForVisibilityOf(singleton.getDriver(),videoPlayButton ,8);
            videoPlayButton.click();
            Thread.sleep(10000);

            WebElement videoPauseButton = singleton.getDriver().findElement(By.xpath("//button[@aria-label='Pause']"));
            JavascriptExecutor js = (JavascriptExecutor)singleton.getDriver();
            js.executeScript("arguments[0].click();", videoPauseButton);
            Thread.sleep(3000);

            singleton.getDriver().switchTo().defaultContent();

            Common.pageScroll("window.scrollBy(0,4000)");
            Thread.sleep(3000);

        } catch (NoSuchElementException e) {
            throw new Exception("Failed : VerifyHomePagePlayVideo1()" + e.getLocalizedMessage());
        }
    }
    public void selectCancersWeTreatColonRectalSubNav() throws Exception {
        try {
            hoverOverElement(cancersWeTreatMainNav);
            WebElement subNav = singleton.getDriver().findElement(colonRectalSubNav);
            Common.waitForElementToBeClickable(singleton.getDriver(),subNav ,8);
            subNav.click();
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : selectCancersWeTreatColonRectalSubNav()" + e.getLocalizedMessage());
        }
    }
}
