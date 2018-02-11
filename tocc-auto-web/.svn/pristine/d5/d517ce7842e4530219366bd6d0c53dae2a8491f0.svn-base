/**
 * 
 */
package com.auto.test.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.auto.test.reporter.HTMLReporter;



/**
 * @author jianping.gao
 *
 */
public class TestNGListener extends TestListenerAdapter {
	
	static Logger logger = Logger.getLogger(TestNGListener.class.getName());
	@Override
	public void onStart(ITestContext testContext) {
		Constant.suites.add(testContext.getSuite().getName());
		// System.out.println(testContext.getName() + "\t"
		// + testContext.getStartDate());
	}
	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		logger.info(tr.getName() + " Failure");
		//takeScreenShot(tr);
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		super.onTestSkipped(tr);
		logger.info(tr.getName() + " Skipped");
               // takeScreenShot(tr);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		logger.info(tr.getName() + " Success");
	}

	@Override
	public void onTestStart(ITestResult tr) {
		super.onTestStart(tr);
		logger.info(tr.getName() + " Start");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);

	}

	
}
