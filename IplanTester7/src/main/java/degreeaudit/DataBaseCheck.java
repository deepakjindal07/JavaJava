
package degreeaudit;

import java.sql.SQLException;

import org.testng.annotations.Test;



public class DataBaseCheck {

//	 @BeforeTest
//	 public void set()
//	 {
//		 System.out.println("Current env is "+prop.getProperty("env"));
//
//	 }

	@Test(priority =1, enabled = true)
	public static void DB_check() throws SQLException {
		String com1 = "SELECT DISTINCT (tgp.iNumber), tgp.MajorCode ,\n"
				+ "tcy.code,tsd.firstAttendedCatalogCode, rp.MajorId \n"
				+ "FROM GraduationPlanner.tblGradPlan tgp\n"
				+ "JOIN GraduationPlanner.tblPlannedCourseHistory tpch ON tgp.GradPlanId = tpch.PlanId\n"
				+ "JOIN Enterprise.tblStudentDetail tsd ON tgp.PersonId = tsd.PersonId\n"
				+ "JOIN Enterprise.tblPersonAssociation tpa ON tsd.PersonId = tpa.PersonId\n"
				+ "JOIN Enterprise.tblMajor tm ON tgp.MajorCode = tm.Code\n"
				+ "JOIN Enterprise.tblCatalogYear tcy ON tgp.CatalogYearId = tcy.CatalogYearId\n"
				+ "JOIN GraduationPlanner.tblPreferences tp ON tgp.GradPlanId = tp.PlanId\n"
				+ "JOIN GraduationPlanner.tblRecommendedPlan rp ON rp.RecommendedPlanId = tp.AppliedRecommendedPlanId\n"
				+ "WHERE tpa.PersonRole = 1\n"
				+ "AND tgp.isPlanDeleted = 0\n"
				+ "AND tsd.firstAttendedCatalogCode IN ('UG22', 'UG23', 'UG24')\n"
				+ "AND tsd.CurrentProgramEnrollmentStatus IN ('Continuing', 'Returning', 'New')\n"
				+ "AND tm.IsDeleted = '0'\n"
				+ "AND tm.DegreeType = 'Bachelor'\n"
				+ "--AND tcy.code IN ('UG22', 'UG23', 'UG24')\n"
				+ "AND tm.approvalLevel = 'OpenAssignments'\n"
				+ "AND rp.IsDeleted = '0'\n"
				+ "AND rp.isValidPlan = 1\n"
				+ "AND rp.PlanType = 1\n"
				+ "AND tp.IsDeleted = '0'\n"
				+ "AND tp.isRecommendedPlanApplied = '1';\n"
				+ "";
		//System.out.println("Working Inumbers to test: \n ");
		//DataBaseTesting.executeQuery(com1,prop.getProperty("env"));

		String com2 = "select DefaultValue from EPS_QA.config.tblAppSetting tas where [Key] ='StartMocking'";
		System.out.println("Mocking Enabled/Disabled: ");


		String com3 = "select ExternalId from Enterprise.tblSubaudit ts where SubauditId in (\n"
				+ "select SubauditId from GraduationPlanner.tblGradPlanDetails tgpd where GradPlanId in \n"
				+ "(select GradPlanId from GraduationPlanner.tblGradPlan tgp where iNumber ='752624096' and plantype =1))";

		String com4 ="select * from config.tblAppSetting tas where [Key] ='StartMocking'";

		DataBaseTesting.executeQuery(com3);

	}

	@Test(priority =1, enabled = false)
	public static void RachaelATI_check() throws SQLException {
		//com.TestUtil.ATI_Check.getResponseBody1();
	}
}






