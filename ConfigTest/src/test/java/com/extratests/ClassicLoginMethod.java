package com.extratests;

import org.testng.annotations.Test;
import com.setup.Base;

public class ClassicLoginMethod extends Base {

	//@BeforeTest
	//public void setup() throws IOException, InterruptedException {
		
		

		//WebDriverManager.chromedriver().setup();
		//contr0l = new ChromeDriver();
	//}

	@Test
	public void DashBoardLogin() throws InterruptedException {
		contr0l.get("https://gps-qa-sql.excelindia.com/");

		// Perform login actions
		Thread.sleep(10000);

	//	contr0l.close(); // Close the current tab
	}

	//@AfterTest
	//public void tearDown() {
	//	contr0l.quit();
	//}
}
