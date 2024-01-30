package TestClass_Pkg;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass_Pkg.BaseClass_Pkg;
import POMClass_Pkg.MyFirst_Test;

public class MyFirstTestCase extends MyFirst_Test{
	
	@Test
	public void T() throws IOException {
		
		MyFirst_Test mt = new MyFirst_Test();
		
		mt.User("aefsdfsd");
		mt.ScreenShot("Screenshot_1");
		mt.Pass1("sjnsjxnksanx");
	}
	
	
}
