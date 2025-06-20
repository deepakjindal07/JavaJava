package com.example.demo;
import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
//@CucumberOptions(glue = "com.example.application")
@CucumberOptions(
	    glue = "com.example.demo"
	)
public class TestRunner {
}