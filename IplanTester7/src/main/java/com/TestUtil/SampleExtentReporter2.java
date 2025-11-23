package com.TestUtil;

import org.testng.IReporter;


    public class SampleExtentReporter2 implements IReporter {

    	/**
    	 *
        private ExtentReports extent;

        public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
                                   String outputDirectory) {
            extent = new ExtentReports();

            for (ISuite suite : suites) {
                Map<String, ISuiteResult> result = suite.getResults();

                for (ISuiteResult r : result.values()) {
                    ITestContext context = r.getTestContext();

                    buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                    buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                    buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
                }
            }

            extent.flush();
        }

        private void buildTestNodes(IResultMap tests, LogStatus status) {
            ExtentTest test;

            if (tests.size() > 0) {
                for (ITestResult result : tests.getAllResults()) {
                    test = extent.startTest(result.getMethod().getMethodName());

                    test.setStartedTime(getTime(result.getStartMillis()));
                    test.setEndedTime(getTime(result.getEndMillis()));

                    for (String group : result.getMethod().getGroups())
                        test.assignCategory(group);

                    if (result.getThrowable() != null) {
                        test.log(status, result.getThrowable());
                    } else {
                        test.log(status, "Test " + status.toString().toLowerCase()
                                + "ed");
                    }

                    ((Object) extent).endTest(test);
                }
            }
        }

        private Date getTime(long millis) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(millis);
            return calendar.getTime();
        }

        **/
    }
