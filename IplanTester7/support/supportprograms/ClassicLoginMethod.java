package supportprograms;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codesetup.Core;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassicLoginMethod extends Core {

    @BeforeTest
    public void setup() throws IOException, InterruptedException {

    	WebDriverManager.chromedriver().setup();
        contr0l = new ChromeDriver();

    }

    @Test
    public void DashBoardLogin() throws InterruptedException {
    	contr0l.get("https://gps-qa-sql.excelindia.com/");

        // Perform login actions
        Thread.sleep(10000);

        contr0l.close(); // Close the current tab
    }

    @Override
	@AfterTest
    public void tearDown() {
    	contr0l.quit();
    }
}
