
package OldCodeRemoveThese;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codesetup.Core;

public class SampleCASLogin extends Core
{

	@BeforeClass
	public void setup() throws Exception
	{
		System.out.println("Sample test");
	}

	@Test(priority = 1)
	public void CASLoginTest() throws InterruptedException
	{
		contr0l.get("https://www.google.com/");
		Thread.sleep(10000);
		contr0l.close();
	}
}