package com.ADM.Runner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
		"C:\\Users\\aathi\\eclipse-workspace\\Eclipse_latest\\excelReadWrite\\src\\main\\java\\com\\ADM\\feature\\ExcelReadWrite.feature" }
		, glue = "com.ADM.stepdef"
		, dryRun = false
		, plugin = {"pretty", "html:test-outout"}
		, monochrome = true)

public class TestRunner {

}
