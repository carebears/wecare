package wecare.step;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import wecare.utils.Utils;

public class check {
	ExtentReports Reports;

	
	@Test
	public void verifyReport() throws Exception {
		// TODO Auto-generated method stub

		 Reports=new ExtentReports(System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
		 ExtentTest logger=Reports.startTest("passTest");
		 logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		Reports
        .addSystemInfo("Host Name", "SoftwareTestingMaterial")
        .addSystemInfo("Environment", "Automation Testing")
        .addSystemInfo("User Name", " anku");
		
		Utils u=new Utils();
System.out.println(u.readproperty("dbuser"));;



	}
@AfterTest()
public void ver(){
	Reports.endTest(null);
}
@AfterSuite
public void afterSuite(){
	Reports.flush();
	Reports.close();
}

}
