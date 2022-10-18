package ABCPo.ABCHomePage;

import Base.BasePO;
import Base.Log;
import Base.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ABCHomePagePo extends BasePO {
    private static ABCHomePagePo dicpHomePagePo;
    private SingletonBrowser singleton = SingletonBrowser.getInstance();

    private ABCHomePagePo() {
        super();
    }

    public static final ABCHomePagePo getInstance() {
        if (dicpHomePagePo == null) {
            dicpHomePagePo = new ABCHomePagePo();
        }
        return dicpHomePagePo;
    }

    public void clickDealerSettings() throws Exception {
        WebElement btnDealerManagementTab = singleton.getDriver().findElement(By.xpath("//span[contains(text(),'Dealer Settings')]"));
        try {
            Log.info("## DICPHomePagePo | clickDealerSettings() ## " + this.getClass().getName());
            uiClick(btnDealerManagementTab);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : clickDealerSettings()" + e.getLocalizedMessage());
        }
    }

    public void clickAppointmentManager() throws Exception {
        WebElement btnAppointmentManager = singleton.getDriver().findElement(By.xpath("//span[contains(text(),'Appointment Manager')]"));
        try {
            Log.info("## DICPHomePagePo | clickAppointmentManager() ## " + this.getClass().getName());
            uiClick(btnAppointmentManager);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : clickAppointmentManager()" + e.getLocalizedMessage());
        }
    }

    public void clickFranchise() throws Exception {
        WebElement btnClickFranchise = singleton.getDriver().findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]"));
        try {
            Log.info("## DICPHomePagePo | clickFranchise() ## " + this.getClass().getName());
            uiClick(btnClickFranchise);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : clickFranchise()" + e.getLocalizedMessage());
        }
    }

    public void selectFranchise() throws Exception {
        WebElement btnSelectFranchise = singleton.getDriver().findElement(By.xpath("//div[@class='MuiAutocomplete-popper']"));
        try {
            Log.info("## DICPHomePagePo | selectFranchise() ## " + this.getClass().getName());
            uiClick(btnSelectFranchise);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : selectFranchise()" + e.getLocalizedMessage());
        }
    }

    public void clickCreateAppointment() throws Exception {
        WebElement btnCreateAppointment = singleton.getDriver().findElement(By.xpath("//header/div[2]/button[1]"));
        try {
            Log.info("## DICPHomePagePo | clickCreateAppointment() ## " + this.getClass().getName());
            uiClick(btnCreateAppointment);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : clickCreateAppointment()" + e.getLocalizedMessage());
        }
    }
}
