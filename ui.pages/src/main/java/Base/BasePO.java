package Base;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

public class BasePO {
    public String text = null;
    public int status = 0;

    private SingletonBrowser singleton = SingletonBrowser.getInstance();
    public static uiRunnable Sleep = new uiRunnable() {

        public void run(int data) {
            try {
                Thread.sleep(data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    };


    //This method can use to click event
    public void uiClick(WebElement uiElement) {
        String[] element = null;
        element = uiElement.toString().split("->");
        try {
            if (uiIsDisplayed(uiElement) == true) {
                System.out.println(element[1]+"sucess");
                uiElement.click();
            }
            else
                System.out.println(element[1]+"fail");
        } catch (Exception e) {
            System.out.println("unbale to click ---------- "+e);
        }

    }

    //This method use to enter text on field
    public void uiSendKeys(WebElement uiElement, String value) throws uiDriverException {
        try{
            uiElement.clear();
            uiElement.sendKeys(value);
        }
        catch(Exception e){
            System.out.println("Unable to send keys"+e);
        }

    }

    //This method use to verify UI element display or not
    public Boolean uiIsDisplayed(WebElement uiElement) throws uiDriverException {
        int i = 0;
        SingletonBrowser.getInstance().getscreenshot();
        while (i < 8) {
            if (uiElement.isDisplayed() == true) {
                return true;

            } else {

                Sleep.run();
            }

            i++;
        }

        if (i == 5) {
            Log.error("not display,timed out" + uiElement);
        }
        return false;
    }

    //This method use to clear the content
    public void uiClear(WebElement uiElement) throws uiDriverException {
        try{
            if(uiIsDisplayed(uiElement) == true) {
                uiElement.clear();
            }
        }
        catch(Exception e){
            //Assert.fail();
        }
    }

    //This method use to verify element is display
    public String isElementPresent(WebElement  element) throws Exception{
        String isPresent = "true";
        waitForLoad();
        //search for elements and check if list is empty

        if (element == null) {
            isPresent = "false";
            System.out.println("No element found");
        }
        return isPresent;
    }

    public void waitForLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {
                return "complete".equals(((JavascriptExecutor) wd).executeScript("return document.readyState"));
            }
        };

        SingletonBrowser.getInstance().getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    }

    //This is common method for navigate to URL
    public void navigateUrl(String Url) {
        SingletonBrowser.getInstance().getDriver().navigate().to(Url);
    }

    //This method use to click text feilds s
    public void clickTextFeild(WebElement element){
        element.click();

    }

    public void scrollDown(){
        JavascriptExecutor jse = (JavascriptExecutor)SingletonBrowser.getInstance().getDriver();
        jse.executeScript("window.scrollBy(0,250)", "");
    }

    public void scrollDownUsingSendKeys(){
        Actions actions = new Actions(SingletonBrowser.getInstance().getDriver());
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
    }

    public void scrollUpUsingSendKeys(){
        Actions actions = new Actions(SingletonBrowser.getInstance().getDriver());
        actions.keyUp(Keys.CONTROL).sendKeys(Keys.PAGE_UP).perform();
    }

    public void scrollDownLong(){
        JavascriptExecutor jse = (JavascriptExecutor)SingletonBrowser.getInstance().getDriver();
        jse.executeScript("window.scrollBy(0,500)", "");
    }

    public void alert() throws AWTException, InterruptedException{
        //Save the Username in user string
        StringSelection user = new StringSelection("Lakmali_jkcs");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(user, null); //User which replace with entered user name
        Robot rb = new Robot();
        //Copy Username data using Ctrl+v as below
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        //Now release the KEYs
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);

        //Press TAB to enter password
        rb.keyPress(KeyEvent.VK_TAB);
        //Now Release the TAB key
        rb.keyRelease(KeyEvent.VK_TAB);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Same above code for Password
        StringSelection passwd = new StringSelection("Sama@12345");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(passwd, null); //passwd which replace with entered password

        //Copy password data using Ctrl+v as below
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        //Now release the KEYs Ctrl+v as below
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);

        //Press Enter using VK_ENTER key
        rb.keyPress(KeyEvent.VK_ENTER);
        //Now Release the key ENTER
        rb.keyRelease(KeyEvent.VK_ENTER);
        System.out.println("Authentication is successfull....WebSite is opened.");
    }

    //Common method for drag and drop an element
    public void dragAndDrop(WebElement sourceElement, WebElement destinationElement) {
        try {
            if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
                Actions action = new Actions(SingletonBrowser.getInstance().getDriver());
                action.dragAndDrop(sourceElement, destinationElement).build().perform();
            } else {
                System.out.println("Element was not displayed to drag");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element with " + sourceElement + "or" + destinationElement + "is not attached to the page document "
                    + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element " + sourceElement + "or" + destinationElement + " was not found in DOM "+ e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Error occurred while performing drag and drop operation "+ e.getStackTrace());
        }
    }

    //Common method which use to select list item using index
    public void selectItemByIndex(WebElement uiWebElement,int index){

        if(uiWebElement != null){
            Select sel = new Select(uiWebElement);
            sel.selectByIndex(index);
        }
        else{
            //Assert.fail();
            System.out.println("Unbale to select");
        }
    }

    public class uiDriverException extends Exception
    {

        private String message = null;
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public uiDriverException() {

        }

        public uiDriverException(String message) {
            super(message);
            this.message= message;
        }

        public uiDriverException(Throwable cause)
        {
            super(cause);

        }
    }

    public interface uiRunnable extends Runnable {
        public void run(int data);

    }

    public static long generateRandom(int length) {
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
    }

    public static String testIdGenerator() {
        long randomNum = generateRandom(1);
        return randomNum+"QA_Automation";
    }

    public void hoverOverElement(By locator) {
        WebElement firstElement = singleton.getDriver().findElement(locator);
        Actions actions = new Actions(singleton.getDriver());
        actions.moveToElement(firstElement).perform();
    }
}
