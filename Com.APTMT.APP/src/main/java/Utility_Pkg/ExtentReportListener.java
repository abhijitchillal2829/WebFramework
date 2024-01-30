package Utility_Pkg;

import java.text.SimpleDateFormat;
import org.apache.poi.hpsf.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportListener{
	
	static ExtentReports extent; 

	public static ExtentReports getReportObject() {
		
//		String Timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//		String Name = "ExtentReport - "+Timestamp;
//		String path = System.getProperty("user.dir")+"/Reports/"+Name+" "+".html";
		String path="/home/apmosys/eclipse-workspace/Com.APTMT.APP/Reports/ExtentReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("APTMT Report");
		reporter.config().setDocumentTitle("APTMT Report");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Automation Engg.", "Abhijit Chillal");
		extent.setSystemInfo("Suite name", "Sanity");
		return extent;
	}
	

}
