package Featurefiles;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumDemoOne {

	@Given("^I work in ([^\"]*)$")
	public void ln(String str) {
		if (str.equals("Latenights")) {
			System.out.println("latenight automation");
		}

		if (str.equals("Mornings")) {
			System.out.println("Morning automation");
		}
	}

	@When("^I meet ([^\"]*)$")
	public void Imeet(String str) {
		if (str.equals("watchmen")) {
			System.out.println("watchmen automation");
		}
		if (str.equals("NewspaperBoy")) {
			System.out.println("NewspaperBoy automation");
		}
	}

	@Then("^I ([^\"]*) him$")
	public void gre(String str) {
		if (str.equals("Greeted")) {
			System.out.println("Greeted automation");
		}
		if (str.equals("skipGreeting")) {
			System.out.println("skipGreeting automation");
		}
	}

}
