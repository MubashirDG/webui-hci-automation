package HCIPo.HCIPagesPO;

import Base.BasePO;
import Base.Common;
import Base.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class HCI_WhatToExpectPagePO extends BasePO {
    private static HCI_WhatToExpectPagePO hciWhatToExpectPagePO;
    private SingletonBrowser singleton = SingletonBrowser.getInstance();
    private By patientsFamiliesMainNav = By.xpath("//span[text()='PATIENTS & FAMILIES']");
    private By planYourVisiSubNavSubNav = By.xpath("//span[text()='Plan Your Visit']");
    private HCI_WhatToExpectPagePO() {
        super();
    }

    public static final HCI_WhatToExpectPagePO getInstance() {
        if (hciWhatToExpectPagePO == null) {
            hciWhatToExpectPagePO = new HCI_WhatToExpectPagePO();
        }
        return hciWhatToExpectPagePO;
    }

    public void hciWhatToExpectPagePageLoad()throws Exception{
        try {
            Common.implicitlyWait(70);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : hciWhatToExpectPagePageLoad()" + e.getLocalizedMessage());
        }
    }
    public void playVideo2() throws Exception {
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
    public void selectPlanYourVisitSubNav() throws Exception {
        try {
            hoverOverElement(patientsFamiliesMainNav);
            WebElement subNav = singleton.getDriver().findElement(planYourVisiSubNavSubNav);
            Common.waitForElementToBeClickable(singleton.getDriver(),subNav ,10);
            subNav.click();
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : selectWhatToExpectSubNav()" + e.getLocalizedMessage());
        }
    }
}
