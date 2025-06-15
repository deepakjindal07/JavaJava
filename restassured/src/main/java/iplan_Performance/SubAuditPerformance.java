package iplan_Performance;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SubAuditPerformance {

	@Test(enabled = false)
	public static void Subaudit() {

		RestAssured.baseURI = "https://rachel.byui.edu";
		RestAssured.basePath = "/Api/AcademicTools";

		Response response = RestAssured.given().header("Accept", "application/json").queryParam("subauditid", "24C151")
				.cookie("BYUIForms",
						"D99BF141DF13108608836DEC64FCBDF430BF1C01EFEF7A7C129F03BC4EFA7EE0C344B98F40687643C74708460360178EA3113B6D39202C9557BE43D21758EE9CEFE0F7E706BE41CC795BE89EB14D4FBE91FFAC196A3D1055CCA1C8AB77202B71D41E321F8205B5CDF78205B7D55E82AA676D9E2E")
				.when().get("/v1/Subaudits/24C151/details").then().extract().response();

		System.out.println("API took: " + response.getTime() + " ms");

	}

	@Test
	public static void GetPersonByINumber() {

		RestAssured.baseURI = "https://rachel.byui.edu";
		RestAssured.basePath = "https://rachel.byui.edu/Api/AcademicTools";

		for (int i = 1; i <= 3; i++)
		{
			long start = System.currentTimeMillis();

			Response response = RestAssured.given().header("Accept", "application/json")
					.queryParam("iNumber", "115018352031974689368")
					// .queryParam("Version", "550829e4ed58a72a6041499c810d2a8744fcc7")

					.cookie("BYUIForms",
							"D99BF141DF13108608836DEC64FCBDF430BF1C01EFEF7A7C129F03BC4EFA7EE0C344B98F40687643C74708460360178EA3113B6D39202C9557BE43D21758EE9CEFE0F7E706BE41CC795BE89EB14D4FBE91FFAC196A3D1055CCA1C8AB77202B71D41E321F8205B5CDF78205B7D55E82AA676D9E2E")
					.when().get("/GetPersonByINumber").then().extract().response();

			long end = System.currentTimeMillis();

			// System.out.println("Raw Response:\n" + response.getBody().asString());
			// System.out.println("Status code: " + response.getStatusCode());

			// System.out.println("API took: " + response.getTime() + " ms");

			System.out.println("Call " + i + " took: " + (end - start) + " ms - Status: " + response.getStatusCode());
		}

	}

}
