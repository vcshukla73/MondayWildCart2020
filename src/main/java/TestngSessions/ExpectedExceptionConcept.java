package TestngSessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	
	
	@Test(expectedExceptions = { ArithmeticException.class} )
	public void getNumberTest(){
		System.out.println("get number test");
		int i = 9/0;
		System.out.println("end of test");
	}
	
	
	
	
	
	

}
