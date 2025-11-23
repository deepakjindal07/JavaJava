package OldCodeRemoveThese;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codesetup.Core;
import com.elements.Page_LoginToDashboard;

public class AdvisorDeclaredPlanSingleTest extends Core {
	public Page_LoginToDashboard dashBoardElement;

	@BeforeTest
	public void CodeSetup() throws Exception {
		dashBoardElement = new Page_LoginToDashboard(contr0l);

	}

	@Test(priority = 1, enabled = false)
	public void searchInumber() {


	}

}
