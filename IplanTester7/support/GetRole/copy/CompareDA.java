package GetRole.copy;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import com.codesetup.CommonUtils;

public class CompareDA {

	static String Inumber = "926892689";

	static String[] Inumbers = { "944562236", "401770021", "401409577", "797667150", "288960700", "070275076",
			"040741664", "362950917", "912315068", "491773176", "830752192", "950889555", "164694346", "899470712",
			"829248050", "089815305", "509248055", "259904691", "926892689", "582304407", "122071980", "138957724",
			"478903582", "571296967", "395564280", "913458037", "538843665", "694084863", "862681243", "533658408",
			"799719918", "425956616", "828409655", "209089034", "626599588", "166798478", "595869516", "294782133",
			"829595070", "877154873", "703644527", "169135806", "591513240", "705258268", "907768370", "331788418",
			"460546684", "661596848", "954785518", "880155797", "030256092", "601501808", "360801375", "595524975",
			"689645660", "610179685", "566668592", "668166974", "318870188", "202964080", "283703963", "780787179",
			"718808460", "492286654", "459867732", "003941299", "956543147", "526857991", "764279446", "575126334",
			"984869763", "560533579", "077172558", "639550174", "074426892", "066128270", "114299514", "004120161",
			"481306461", "521158051", "588736262", "670250491", "976307778", "337526234", "149334766", "166798478",
			"153588917", "480851721", "552372675", "931743142", "710798735", "642745090", "354183012", "779563480",
			"049271888", "765886169", "822991478", "162396888", "266606005", "538843665", "572876842", "581869064",
			"871397646", "314911117", "601501808", "257931411", "300928105", "123300058", "626599588", "089815305",
			"509248055", "139334462", "666244443", "591513240", "586637831", "993498193", "063029603", "074426892",
			"102139399", "103496829", "106366688", "119967393", "120990261", "166798478", "178296397", "242953148",
			"280385299", "294782133", "306527915", "314378037", "795819922", "732539904", "829595070", "826166636",
			"266606005", "389613384", "705258268", "197351288", "626599588", "602833770", "331788418", "612732601",
			"337995745", "517172424", "933232178", "437481045", "106692553", "695460472", "308824502", "474023470",
			"730405424", "303304184", "254095748", "360801375", "595524975", "610179685", "566668592", "668166974",
			"318870188", "202964080", "040741664", "066128270", "487542940", "857676555", "428670686", "132513522",
			"162755009", "527222836", "716169795", "000174787", "002232985", "006408087", "007578984", "009109325",
			"015610853", "016525801", "016946322", "018064978", "021812848", "022505318", "023968950", "028645408",
			"036116909", "038522974", };

	@Test
	public static void CompareDegreeAudit() throws IOException {

		for (String Inumber : Inumbers) {
			System.out.println("Checking for: " + Inumber);

			String com3 = "select ExternalId from Enterprise.tblSubaudit ts where SubauditId in (\n"
					+ "select SubauditId from GraduationPlanner.tblGradPlanDetails tgpd where GradPlanId in \n"
					+ "(select GradPlanId from GraduationPlanner.tblGradPlan tgp where iNumber ='" + Inumber
					+ "' and plantype =1 and isdeleted =0))";
			List<String> List1;
			try {
				List1 = SubAuditinATI.RachaelCheck1(Inumber);
				if (List1 == null) {
					System.err.println("Error: SubAuditinATI.RachaelCheck1 returned null for Inumber: " + Inumber);
					continue; // Skip this iteration and move to the next Inumber
				}
			} catch (Exception e) {
				System.err.println("Error processing RachaelCheck1 for Inumber: " + Inumber);
				// e.printStackTrace();
				continue;
			}
			System.out.println("BYUi Subaudits: " + List1);

			List<String> List2;
			try {
				List2 = DataBaseTesting.executeQuery(com3);
				if (List2 == null) {
					System.err.println("Error: DataBaseTesting.executeQuery returned null for Inumber: " + Inumber);
					continue; // Skip this iteration and move to the next Inumber
				}
			} catch (Exception e) {
				System.err.println("Error processing executeQuery for Inumber: " + Inumber);
				// e.printStackTrace();
				continue;
			}
			System.out.println("ES Subaudits: " + List2);

			try {
				VerifyifSame(List1, List2, Inumber);
			} catch (Exception e) {
				System.err.println("Error verifying lists for Inumber: " + Inumber);
				// e.printStackTrace();
			}
		}
	}

	public static void SimpleCompareDegreeAudit() throws IOException {

		System.out.println("Checking for: " + Inumber);
		List<String> List1 = SubAuditinATI.RachaelCheck1(Inumber);
		System.out.println("BYUi Subaudits: " + List1);

		// SubAuditinATI.RachaelCheck1(Inumber);

		// List<String> List2 = DataBaseTesting.executeQuery(com3);
		// System.out.println("ES Subaudits: " + List2);

		// VerifyifSame(List1, List2);

	}

	private static void VerifyifSame(List<String> list1, List<String> list2, String Inumber) {
		// list1 = Arrays.asList("20GEBCXP", "20GETCH", "20MJ830", "20RELBCH");
		// list2 = Arrays.asList("20GETCH", "20GEBCHP", "20GEBCXP", "20MJ830");

		Set<String> set2 = new HashSet<>(list2);

		boolean allMatch = true;

		for (String item : list1) {
			// Check if the item contains "UN" or "UP" as part of the prefix
			if (item.contains("UN") || item.contains("UP")) {
				System.out.println(item + "... not match (expected due to UN/UP prefix)");
				continue;
			}

			if (set2.contains(item)) {
				System.out.println(item + "... match");
			} else {
				System.out.println(item + "... not match");
				allMatch = false;
			}
		}

		if (allMatch) {
			System.out.println("\n##### Inumber is matching: " + Inumber);
			CommonUtils.saveResultToFile("report/MatchDA.txt", Inumber);
		}
	}
}
