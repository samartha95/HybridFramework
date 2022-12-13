package com.testsripts.demoblaze;

import org.testng.Reporter;

import com.genericlib.demoblaze.Base;

public class Test extends Base {
	@org.testng.annotations.Test
	public void test(){
		Reporter.log("Test", true);
	}

}
