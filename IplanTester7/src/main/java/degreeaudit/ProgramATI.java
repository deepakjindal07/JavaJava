package degreeaudit;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class ProgramATI {
	private static List<String> list1;
	private static List<String> list2;
	static String Inumber = "926892689";

	static String com3 = "select ExternalId from Enterprise.tblSubaudit ts where SubauditId in (\n"
			+ "select SubauditId from GraduationPlanner.tblGradPlanDetails tgpd where GradPlanId in \n"
			+ "(select GradPlanId from GraduationPlanner.tblGradPlan tgp where iNumber ='" + Inumber
			+ "' and plantype =1 and isdeleted =0))";

	@Test
	public static void degreechecker() throws IOException {

		// Verify Mocking is 0
		// LoginATI.RachaelLogin();
		// SubAuditinATI.RachaelCheck1(Inumber);

		List<String> List1 = SubAuditinATI.RachaelCheck1(Inumber);
		System.out.println("BYUi Subaudits: " + List1);

		// SubAuditinATI.RachaelCheck1(Inumber);

		List<String> List2 = DataBaseTesting.executeQuery(com3);
		System.out.println("ES Subaudits: " + List2);
		// for (String row : List2) {
		// System.out.println(row);
		// }

		// CheckinATI_DB(Inumber);

		// CheckinATI_DB(Inumber);
		VerifyifSame(List1, List2);

	}

	private static void VerifyifSame(List<String> list1, List<String> list2) {
		// list1 = Arrays.asList("20GEBCXP", "20GETCH", "20MJ830", "20RELBCH");
		// list2 = Arrays.asList("20GETCH", "20GEBCHP", "20GEBCXP", "20MJ830");

		Set<String> set2 = new HashSet<>(list2);

		for (String item : list1) {
			if (set2.contains(item)) {
				System.out.println(item + "... match");
			} else {
				System.out.println(item + "... not match");
			}
		}
	}

	private static void CheckinATI_DB(String Inumber) {
		String com3 = "select ExternalId from Enterprise.tblSubaudit ts where SubauditId in (\n"
				+ "select SubauditId from GraduationPlanner.tblGradPlanDetails tgpd where GradPlanId in \n"
				+ "(select GradPlanId from GraduationPlanner.tblGradPlan tgp where iNumber ='" + Inumber
				+ "' and plantype =1 and isdeleted =0))";

		DataBaseTesting.executeQuery(com3);

		// ResultSet rs = DataBaseTesting.executeQuery(com3);

		// Populate list2 with data from the ResultSet
		// list2 = new ArrayList<>();
		// while (rs.next()) {
		// list2.add(rs.getString(1)); // Adjust the column index as per your ResultSet
		// structure
		// }

	}

}
