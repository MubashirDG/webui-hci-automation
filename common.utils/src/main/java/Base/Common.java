package Base;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
    public static String getCssValue_H1FontSize;
    SingletonBrowser singletonClass = SingletonBrowser.getInstance();
    private String value = null;



    //Common method save the screenshot in d drive with name "screenshot.png"
    public void getscreenshot(String nameStr) {
        File scrFile = ((TakesScreenshot) singletonClass.getDriver()).getScreenshotAs(OutputType.FILE);
        String fileName = nameStr + "_" + getRandomCurrentDateTime() + "screenshot.png";
        try {
            FileUtils.copyFile(scrFile, new File("target/ScreenShot/" + fileName));
        } catch (IOException e) {
            Log.error(" IOException: Get Screenshot()");
        }
        Log.info("ScreenShot :" + fileName);
    }

    public void loggerErr(String step, Exception e) {
        Log.error(step + "\n" + e);
        getscreenshot(step);
    }

    //Common method to get current date which is use to save screen shot
    public String getRandomCurrentDateTime() {
        SimpleDateFormat formDate = new SimpleDateFormat("ddHHmmss");
        String strDate = formDate.format(new Date());
        return strDate;
    }

    //Common method for get the properties from the property file as text
    public String getProperty(String text)
    {
        //value = null;
        try {
            System.err.println("Text................ "+ text);
            value = SingletonBrowser.getInstance().getProp().getProperty(text);
            System.out.println("Get Property As "+ value);

        } catch (Exception e) {
            System.out.println("Unable to  get Text :"+e.toString());
        }
        return value;
    }

    //This method is a common method for set the properties
    public String setProperty(String property,String text)
    {
        value = null;
        try {
            SingletonBrowser.getInstance().getProp().setProperty(property, text);
            System.out.println("Set Property As "+value);
        } catch (Exception e) {
            System.out.println("Unable to  get Text :"+e.toString());
        }
        return value;
    }

    //Common methods for wait
    public void sleepSetup() {
        int sleepVar = 0;

    }

    public void sleep(int sleepVar, String xpath) throws Exception{

        int timeInSeconds	=	(sleepVar*Integer.parseInt(SingletonBrowser.getInstance().getProp("SleepSetup")))/1000;
        WebDriverWait wait	=	new WebDriverWait(SingletonBrowser.getInstance().getDriver(), timeInSeconds);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

    }

    public void sleep(int sleepVar) throws Exception{
        int i	=	1;
        while (i <= 3) {

            try {
                Boolean tt =SingletonBrowser.getInstance().getDriver().findElement(By.xpath("//*[@id='myNavbar']/ul[2]/li[1]/a")).isDisplayed();
                if (tt==true) {
                    break;
                } else {
                    Thread.sleep(sleepVar*Integer.parseInt(SingletonBrowser.getInstance().getProp("SleepSetup")));
                }
                i++;
            } catch (NoSuchElementException e) {
                break;
            }
        }
        System.out.println("i = "+i);
        if(i == 4){
            System.err.println("Loading Element Not Found.");
        }

    }
    //Replace text value inside the path
    public String replaceValues(String one, String elementName) {
        return elementName.replaceAll("\\{1}", one);
    }

    public String replaceValues(String one,String two,String elementName) {
        return elementName.replaceAll("\\{1}", one).replaceAll("\\{2}", two);
    }

    public String replaceValues(String one,String two,String three,String elementName) {
        return elementName.replaceAll("\\{1}", one).replaceAll("\\{2}", two).replaceAll("\\{3}", three);
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

    public static void navigateToNewTab(int tabIndex) throws Exception {
        ArrayList<String> tabs2 = new ArrayList<String> (SingletonBrowser.getInstance().getDriver().getWindowHandles());
        SingletonBrowser.getInstance().getDriver().switchTo().window(tabs2.get(tabIndex));
    }

    public static void pageRefresh() throws Exception {
        SingletonBrowser.getInstance().getDriver().navigate().refresh();
    }

    public static void pageScroll() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) SingletonBrowser.getInstance().getDriver();
        js.executeScript("window.scrollBy(0,350)", "");
    }

    public static void pageNavigation(String PageUrl) throws Exception {
        SingletonBrowser.getInstance().getDriver().navigate().to(PageUrl);
    }

    public static String getCssValueFontSize_14pxNavBar() throws Exception {
        //waitForLoad(15000);
        String fontSizes14pxNavBar = SingletonBrowser.getInstance().getDriver().findElement(By.xpath("//span[@class='ubermenu-target-title ubermenu-target-text']")).getCssValue("font-size");
        System.out.println("14pxNavBar font-size :" + fontSizes14pxNavBar);
        return fontSizes14pxNavBar;
    }
    public static String getCssValueFontSize_42pxH1() throws Exception {
        //waitForLoad(15000);
        String fontSizes42pxH1 = SingletonBrowser.getInstance().getDriver().findElement(By.xpath("//h1[@class='elementor-heading-title elementor-size-default']")).getCssValue("font-size");
        System.out.println("42pxH1 font-size :" + fontSizes42pxH1);
        return fontSizes42pxH1;
    }
    public static String getCssValueFontSizes_35pxH2() throws Exception {
        //waitForLoad(15000);
        String fontSizes35pxH2 = SingletonBrowser.getInstance().getDriver().findElement(By.xpath("//h2[@class='elementor-heading-title elementor-size-default']")).getCssValue("font-size");
        System.out.println("35pxH2 font-size :" + fontSizes35pxH2);
        return fontSizes35pxH2;
    }
    public static String getCssValueFontSize_45pxH2() throws Exception {
        //waitForLoad(15000);
        String fontSizes45pxH2 = SingletonBrowser.getInstance().getDriver().findElement(By.xpath("//h2[@class='elementor-heading-title elementor-size-default']")).getCssValue("font-size");
        System.out.println("45pxH2 font-size :" + fontSizes45pxH2);
        return fontSizes45pxH2;
    }

    public static String getCssValueFontSize_20pxPG() throws Exception {
        //waitForLoad(15000);
        String fontSizes20pxPG = SingletonBrowser.getInstance().getDriver().findElement(By.xpath("//div[@class='elementor-text-editor elementor-clearfix']")).getCssValue("font-size");
        System.out.println("20pxPG font-size :" + fontSizes20pxPG);
        return fontSizes20pxPG;
    }
    public static String getCssValueFontSize_20pxLinkButton() throws Exception {
        //waitForLoad(15000);
        String fontSizes20pxLinkButton = SingletonBrowser.getInstance().getDriver().findElement(By.xpath("//div[@class='elementor-text-editor elementor-clearfix']")).getCssValue("font-size");
        System.out.println("20pxLinkButton font-size :" + fontSizes20pxLinkButton);
        return fontSizes20pxLinkButton;
    }

    public static String getCssValueFontSize_14pxButton() throws Exception {
        //waitForLoad(15000);
        String fontSizes14pxButton = SingletonBrowser.getInstance().getDriver().findElement(By.xpath("//span[@class='elementor-button-text']")).getCssValue("font-size");
        System.out.println("getCssValueFontSize_14pxButton font-size :" + fontSizes14pxButton);
        return fontSizes14pxButton;
    }
}
