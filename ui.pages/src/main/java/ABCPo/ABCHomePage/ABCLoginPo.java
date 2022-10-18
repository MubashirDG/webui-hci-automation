package ABCPo.ABCHomePage;

import Base.BasePO;
import Base.Log;
import Base.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ABCLoginPo extends BasePO {
    private static ABCLoginPo abcLoginPo;
    private SingletonBrowser singleton = SingletonBrowser.getInstance();

    private ABCLoginPo() {
        super();
    }

    public static final ABCLoginPo getInstance() {
        if (abcLoginPo == null) {
            abcLoginPo = new ABCLoginPo();
        }
        return abcLoginPo;
    }

    public void enterUserName(String username) throws Exception {
        WebElement uiUsername = singleton.getDriver().findElement(By.xpath("//input[@id='username']"));
        try {
            Log.info("## ABCLoginPo | enterUserName() ## " + this.getClass().getName());
            if (username.trim().length() != 0) {
                uiSendKeys(uiUsername, username);
            }
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : enterUserName()" + e.getLocalizedMessage());
        }
        Sleep.run(1000);

    }

    public void enterPassword(String password) throws Exception {
        WebElement uiPassword = singleton.getDriver().findElement(By.xpath("//input[@id='password']"));
        try {
            Log.info("## ABCLoginPo | enterPassword() ## " + this.getClass().getName());
            if (password.trim().length() != 0) {
                uiSendKeys(uiPassword, password);
            }
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : enterPassword()" + e.getLocalizedMessage());
        }
        Sleep.run(1000);

    }

    public void Password(String password) throws Exception {
        WebElement uiPassword = singleton.getDriver().findElement(By.xpath("//input[@id='password']"));
        try {
            Log.info("## ABCLoginPo | enterPassword() ## " + this.getClass().getName());
            if (password.trim().length() != 0) {
                uiSendKeys(uiPassword, password);
            }
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : enterPassword()" + e.getLocalizedMessage());
        }
        Sleep.run(1000);
    }


    public void clickSignIn() throws Exception {
        WebElement uiSignIn = singleton.getDriver().findElement(By.xpath("//a[@id='log-in']"));
        try {
            Log.info("## ABCLoginPo | clickSignIn() ## " + this.getClass().getName());
            uiClick(uiSignIn);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : clickSignIn()" + e.getLocalizedMessage());
        }
    }

    public boolean isCustomerNameDisplayed() throws Exception {
        WebElement customerName = singleton.getDriver().findElement(By.xpath("//div[contains(text(),'Jack Gomez')]"));
        return customerName.isDisplayed();
    }
}
