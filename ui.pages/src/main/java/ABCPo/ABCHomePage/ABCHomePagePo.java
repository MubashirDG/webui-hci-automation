package ABCPo.ABCHomePage;

import Base.BasePO;
import Base.Log;
import Base.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ABCHomePagePo extends BasePO {
    private static ABCHomePagePo abcHomePagePo;
    private SingletonBrowser singleton = SingletonBrowser.getInstance();

    private ABCHomePagePo() {
        super();
    }

    public static final ABCHomePagePo getInstance() {
        if (abcHomePagePo == null) {
            abcHomePagePo = new ABCHomePagePo();
        }
        return abcHomePagePo;
    }

}
