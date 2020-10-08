package com.ADM.stepdef;

import com.ADM.utils.Excel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.io.IOException;

import org.junit.Assert;

public class WriteExcel {
	String[][] values;
	String source = "";

	@Given("^I locate the source file \"([^\"]*)\" and I confirm its name \"([^\"]*)\"$")
	public void i_locate_the_source_file_and_I_confirm_its_name(String path, String name) {
		boolean flag = Excel.checkFile(path, name);
		if (!flag)
			Assert.fail("File not found");
		source = path + "\\\\" + name;
		System.out.println(source);
	}

	@Then("^I Start reading values from located file$")
	public void I_Start_reading_values_from_located_file() {
		values = Excel.readExcel(source, 0);
	}

	@Then("^I write those values to the target file \"([^\"]*)\"$")
	public void I_write_those_values_to_the_target_file(String dest) throws IOException {
		Excel.excelWrite(dest,values);
	}
}
