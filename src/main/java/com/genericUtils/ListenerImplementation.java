package com.genericUtils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation  implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
	 test = report.createTest(MethodName);
	 Reporter.log(MethodName+"Execution started",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"Passed");
		Reporter.log(MethodName+"Executed successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriverUtils com=new WebDriverUtils();
		String MethodName = result.getMethod().getMethodName();
		
			try {
				com.getScreenShot(BaseClass.sdriver,result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		test.log(Status.FAIL, MethodName+"Failed");
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(MethodName+"-->Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP,MethodName+"Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"TestSkipped");
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\extentReport\\report.html");
		htmlreport.config().setDocumentTitle("SDET-53");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("HMS");
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base paltform", "OS");
		report.setSystemInfo("Base browser", "chrome");
		report.setSystemInfo("Base URL", "http://rmgtestingserver/domain/Hospital_Management_System/");
		report.setSystemInfo("ReporterName", "Prathibha");
		
	
		
	}

	@Override
	public void onFinish(ITestContext context) {
report.flush();	
	}

}
