
@echo off
set SELENIUM_JAR="C:\eclipse\selenium-java\selenium-manager-4.19.0.jar"
set TESTNG_XML="C:\Users\ExcelSoft\Desktop\eclipse-workspace\GradPlannerV4\Launchers\TestPages.xml"

mvn clean test -Dsurefire.suiteXmlFiles=%TestPages.xml%
