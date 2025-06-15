package iplan_Performance;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchMajor {

	@Test(enabled = true)
	public static void FetchMajorTest() {

		RestAssured.baseURI = "https://sirius-qa.excelindia.com";
		//RestAssured.basePath = "/apihost/GraduationPlanner/api/DegreeAudit";
		String[] iNumbers = { "361578651", "519172879" };
		String catalogYear = "UG24";
		String version = "54240509eb6b0641b2554bf4bf091f12813910d7";
		
		String Payload ="{\"Results\":[],\"PageNumber\":0,\"PageSize\":10,\"TotalCount\":\"\",\"Query\":{\"MajorName\":\"\",\"MajorCode\":\"\",\"DegreeType\":null,\"SubProgram\":\"\",\"DepartmentIds\":[],\"IsForAllCatalogYears\":true,\"ShowFavourites\":false,\"ShowForAssessmentRecommendations\":false,\"IsDeclaredMajorSelected\":false,\"StudentCatalogYear\":\"UG22\",\"SubAuditType\":\"\",\"MinorsIn\":[],\"ClustersIn\":[],\"ConcentrationsIn\":[],\"CurrentCatalogYear\":\"\",\"likeFiltered\":false,\"diableAllCatalogYearChBx\":false,\"catalogBtwStudentNCurrent\":[\"UG17\",\"UG19\",\"UG20\",\"UG21\",\"UG22\",\"UG23\",\"UG24\",\"UG25\",\"UG26\",\"UG27\",\"UG28\"],\"FirstAttendedCatalogCode\":\"UG22\",\"CompletedCourseList\":[],\"IsPublicUserPreferenceOnline\":false},\"Filter\":\"663-256\"}";

		for (String iNumber : iNumbers)
		{
			long start = System.currentTimeMillis();

			Response response = RestAssured.given()
		            .header("Accept", "application/json")
		            .header("Content-Type", "application/json")
		            .header("Origin", "https://sirius-qa.excelindia.com")
		            .header("requestverificationtoken", "fx13Y-q0k43M3Dyh6FeTkIuQ1L3AojRLp-c1IYlWCVHRYPR--iKhRTzWORRJvB96CfEtsxoHgFeA1z4lrzmJyyjE5EM1")
		            .cookie("XSRF-TOKEN", "U2FsdGVkX19RVSM1g%2B7kaVLRMCbO81x1hrtRNFCXLXUpDXz3YOejcMZkA0KMiqXn8aBn1b8oaUR%2FPzv8g3XsYMAgNPK33FO%2BQdh0RsbXjcsbmbrnqTcOXcZeao9AbtUN0MMQg09NtucaPEYY4oIjfQ%3D%3D")
		            .cookie("SessionId", "0f8742ab-cd84-43fe-b789-2c7065e69ad6")
		            .cookie("_ei", "S_eOT1semhlvw8pU0B2L1fvR1JnvxfWRb-Uz8sYOkHLqGvbMigGCVAj0xLdzqKtkS6FEUKSyFda9EtYGKISamM8FcUMLMtAe4ayubWMrPdFjzLPnUXcc4iatYw96dQ-SrfGIjXfthRypLFyfiwX3CM89SMaIiGDcNDqkfduEPLeg6wLi51jIxNoQyZw7R62HoLE87DJx54prCQyH2OPsFQSAdO1pInVQ-EX8Ii5y14J367RHcb9XfvteIcW7iXkvt2ju7jlcYYTVa6B8fGB8EyNor6gy4PESAT8YK2z_zb8K5XGBEHAXl0D1YSJQRF3d588R9iLkhKrl-2jx0UBMLlzstB0mHJ1xS8rT2838xm9e-QElzD2aAFw-_F0vY4FUfEL4eYyzgY2qZi3Dw4QLewKC_uCmDLssz4aijaI4Ez92onl9TlP-0IqGWbjI0yiZzKgbraGWdVQNwJ5IEEMiYkBRpCNkR0e5xDQgYHTXlxXGjRmhwfXXmB3QYV75KEFOe-LHBYZvJALcZPfoo-o558OvM-K7eus_CwRKli6BLmgp7rK1NqnQ7oFYCainnLuweJ_NqPUnu0EADi_csaHA3yR5CitUkqGWpxVkkRZWI5PQncs73hWnL9aGommbJFWupkh000xUT3tavEh33ZApMU0LCoXbhumB2uF3dE_R2FRlCQWWwYmbmlle5WAhRTboiP76u4KY3n9rPm1tV4S3_v4kDtadR0q8kk8QaWxexugNNW--Rx9fQSdVAvfFzKl8ca7otBt4kcBczlIzqrsfQAjL17wmXsW5CcslH6stSyat2LIXRXjPPqWunRr5yTN8HfuaSHb7ZTswhOOVqTBU6u2VP9SCbbiRXDZgV-lDNtDJyr0_FBGoVuIz8ibdJi1UN1gB_-qgKikasJKkuzfE1wEh4Ql4AHOz2HycUP8RvElGmO-8xSRNvzAMDZNlyHOFbXZqiwzYjwQxBwmd26HORQ95FptdI-dOEiD-pqzUzgIwkReLckXqDY3Eqq25p6UUDN88j5IJrSFW4H7UzQgpLdJ4Qavn4D4EQHj9jNWQR5BsmNPnn9R1hCeBsXgCgEKvG9at4o0dJU5xqac6-IqL1LASeJDfsKEiKDOfy4c58YKtvdD3j_u61S3A2EJhlW5w_PPSZFJ4kZPTDhz5MoazJuKReCefxHekS2MJA5FESEAWyDUvidXlDjLA-6sjHIUkDgXv6jNmSUFzbFjT80xXLx2h1PE68W1vOsTuHnY9ErDTR7DI")
		            .cookie("_ii_409526", "U-NuJj9XGta7TIUfcciqZ8pbhGQNPPUpP9bamqMP1k3o_4p2F7dUUFoubNrbEn-z8O4gDCFHRhkaaQD0NyWdTcbR5Bg1xk8-NtthFK0rofJk6YOO4_eTWAvSmBXyw_29E-6VDlk9mfzbDsKJYqgsoStspl9WOF4WjHMAJ9NCzI5h5IBXGuTMCPjjb8dGVrpAdA_gYuPfw3jr7GcRcW4za52HRlHLd_SotuAYdFag-w4-gttOXEf2PtXh1c_FJQBj1LWJtgPVYn8Vko_x4_2PjPKJxjx2NVsKFRxMqYj8QxtfkTZ5aTaXN_ZYwYaNG0PMM-6-0VGT7Gnu8B12BineDVXPEBiAn6NTcBLOcEZtQtSkW6TjMH7_IWUJriU3ANLJ0WIDC2EV2bWzJuU3gTLi9gPqpn92GGzIPo5PgPwS4P2PozJibv9y4JgLh1CER5T-ecYQ-USBMZhVe50kjiRAn9YQ_Jf95jGZW6VsivO-A8aJ460w41xvK9eOOsw9xBY2gZVS57V5WWqObvrlRKK195ZfIkrPgKe6OMhMZbG_RC38wQfgqUqV5CLV8BjUYPbqpU90j-uxq0jUkqc7753ArDzQ-SE9J8qi9bIINAD6kBbkbPWmqhnGpIjEtd4r506sq404hSyTr9_qCqf2tc7qPgRSF0LW0sDigoYXGqcbn0QvNUcuccuxMMAmhawNowZeR-3arruQvl2dB5tVSMlaWX3irSVFLDJLf3PZjNs0ysWXacLS8n4kuy2YJVlTgGFsp9w9iZ2MRodwqQta5_NZcv-SLJpxnLSIVGA0wtNWC6hKugd0Eb0GQ171daygR0eZlqXOQ1toIULMbNbaDaRj0rkHvPQA8sAWSzvdJ32qIt_MpP0I_fsA4qAxMxLPsxgVG0afIkMNKWrXmnAU-n-nGQP2nespE11FHn2bdz-9enyP0IRTexob9zniUxDeTlDXlaffPQ")
		            .queryParam("isLikeFilterOn", false)
		            .queryParam("isRelatedMajorCall", false)
		            .queryParam("careerID", "")
		            .queryParam("iNumber", "389722569")
		            .queryParam("execCatalogyear", "UG17")
		            .queryParam("connectionId", "")
		            .queryParam("Version", "54240509eb6b0641b2554bf4bf091f12813910d7")
		            .body(Payload) // Replace with actual body structure from browser's payload
		            .post("/apihost/GraduationPlanner/api/DegreeAudit/FetchBestMatchingMajors");



//					.cookie("BYUIForms",
//							"D99BF141DF13108608836DEC64FCBDF430BF1C01EFEF7A7C129F03BC4EFA7EE0C344B98F40687643C74708460360178EA3113B6D39202C9557BE43D21758EE9CEFE0F7E706BE41CC795BE89EB14D4FBE91FFAC196A3D1055CCA1C8AB77202B71D41E321F8205B5CDF78205B7D55E82AA676D9E2E")
//					.when().post("/apihost/GraduationPlanner/api/DegreeAudit/FetchBestMatchingMajorsAsync")
//					.body(requestBody).post("/FetchBestMatchingMajors");
//			// .then().extract().response();

			long end = System.currentTimeMillis();

			System.out.println("\n→ iNumber: " + iNumber);
			System.out.println("Status Code: " + response.getStatusCode());
			System.out.println("API call took: " + (end - start) + " ms");
		}
	}

	@Test(enabled = false)
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
