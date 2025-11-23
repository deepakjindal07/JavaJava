package supportprograms;

import org.testng.TestNG;

import com.TestUtil.SampleExtentReporter2;
//import com.testpages.ReviewStudentGradPlan;

public class TestRunner {

	static TestNG testng;

	public static void main(String[] args) {
		SampleExtentReporter2 ext = new SampleExtentReporter2();

		testng = new TestNG();
		//testng.setTestClasses(new Class[] {ReviewStudentGradPlan.class});
		testng.addListener(ext);
		testng.run();

	}

}
