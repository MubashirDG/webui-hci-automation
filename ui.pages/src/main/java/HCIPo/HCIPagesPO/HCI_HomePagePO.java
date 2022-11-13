package HCIPo.HCIPagesPO;

import Base.BasePO;
import Base.Common;
import Base.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class HCI_HomePagePO extends BasePO {
    private static HCI_HomePagePO hci_HomePagePO;

    private SingletonBrowser singleton = SingletonBrowser.getInstance();

    private HCI_HomePagePO() {
        super();
    }

    public static final HCI_HomePagePO getInstance() {
        if (hci_HomePagePO == null) {
            hci_HomePagePO = new HCI_HomePagePO();
        }
        return hci_HomePagePO;
    }

    public void PlayVideo1() throws Exception {
        try {
            Thread.sleep(6000);
            WebElement videoImage = singleton.getDriver().findElement(By.xpath("//div[@class='elementor-element elementor-element-9208e49 elementor-widget elementor-widget-image']//img[@class='attachment-full size-full']"));
            videoImage.click();
            WebElement video = singleton.getDriver().findElement(By.xpath("//iframe[@class='elementor-video-iframe']"));
            Thread.sleep(4000);
            video.click();
            Thread.sleep(15000);
            video.click();
            Thread.sleep(3000);
            WebElement closeButton = singleton.getDriver().findElement(By.xpath("//i[@class='eicon-close']"));
            closeButton.click();
            Common.pageScroll("window.scrollBy(0,1500)");
            Thread.sleep(3500);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : VerifyHomePagePlayVideo1()" + e.getLocalizedMessage());
        }
    }

//    public boolean isVideoPlaySuccess() throws Exception {
//        try {
//            WebElement isVideoPlay = singleton.getDriver().findElement(By.xpath("end time"));
//            return isVideoPlay.isDisplayed();
//
//        } catch (NoSuchElementException e) {
//            throw new Exception("Failed : VerifyHomePagePlayVideo1()" + e.getLocalizedMessage());
//        }
//    }
}
