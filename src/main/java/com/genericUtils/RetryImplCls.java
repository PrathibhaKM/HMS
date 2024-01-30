package com.genericUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplCls implements IRetryAnalyzer {
int retry=5;
int count=1;
	@Override
	public boolean retry(ITestResult result) {
		if(count<retry)
		{
			count++;
			return true;
		}
		return false;
	}



}
