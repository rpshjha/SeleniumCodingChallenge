package com.rpshjha.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.rpshjha.core.CoreFunctions;

import lombok.extern.java.Log;

@Log
public class TestNGListener implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		
		log.info("\r\n" + 
				"   ____          ______ _       _     _     \r\n" + 
				"  / __ \\        |  ____(_)     (_)   | |    \r\n" + 
				" | |  | |_ __   | |__   _ _ __  _ ___| |__  \r\n" + 
				" | |  | | '_ \\  |  __| | | '_ \\| / __| '_ \\ \r\n" + 
				" | |__| | | | | | |    | | | | | \\__ \\ | | |\r\n" + 
				"  \\____/|_| |_| |_|    |_|_| |_|_|___/_| |_|\r\n" + 
				"                                            \r\n" + 
				"                                            \r\n" + 
				"");

	}

	@Override
	public void onStart(ITestContext arg0) {
		log.info("\r\n" + 
				"   ____           _____ _             _   \r\n" + 
				"  / __ \\         / ____| |           | |  \r\n" + 
				" | |  | |_ __   | (___ | |_ __ _ _ __| |_ \r\n" + 
				" | |  | | '_ \\   \\___ \\| __/ _` | '__| __|\r\n" + 
				" | |__| | | | |  ____) | || (_| | |  | |_ \r\n" + 
				"  \\____/|_| |_| |_____/ \\__\\__,_|_|   \\__|\r\n" + 
				"                                          \r\n" + 
				"                                          \r\n" + 
				"");

	}

	@Override
	public void onTestFailure(ITestResult arg0) {

		CoreFunctions.takeFailedScreenshot(arg0.getTestName());

		log.info("\r\n" + 
				"  _______        _     ______    _ _          _ \r\n" + 
				" |__   __|      | |   |  ____|  (_) |        | |\r\n" + 
				"    | | ___  ___| |_  | |__ __ _ _| | ___  __| |\r\n" + 
				"    | |/ _ \\/ __| __| |  __/ _` | | |/ _ \\/ _` |\r\n" + 
				"    | |  __/\\__ \\ |_  | | | (_| | | |  __/ (_| |\r\n" + 
				"    |_|\\___||___/\\__| |_|  \\__,_|_|_|\\___|\\__,_|\r\n" + 
				"                                                \r\n" + 
				"                                                \r\n" + 
				"");
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		
		log.info("\r\n" + 
				"  _______        _      _____ _    _       \r\n" + 
				" |__   __|      | |    / ____| |  (_)      \r\n" + 
				"    | | ___  ___| |_  | (___ | | ___ _ __  \r\n" + 
				"    | |/ _ \\/ __| __|  \\___ \\| |/ / | '_ \\ \r\n" + 
				"    | |  __/\\__ \\ |_   ____) |   <| | |_) |\r\n" + 
				"    |_|\\___||___/\\__| |_____/|_|\\_\\_| .__/ \r\n" + 
				"                                    | |    \r\n" + 
				"                                    |_|    \r\n" + 
				"");

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		

		log.info("\r\n" + 
				"  _______        _      _____ _             _   \r\n" + 
				" |__   __|      | |    / ____| |           | |  \r\n" + 
				"    | | ___  ___| |_  | (___ | |_ __ _ _ __| |_ \r\n" + 
				"    | |/ _ \\/ __| __|  \\___ \\| __/ _` | '__| __|\r\n" + 
				"    | |  __/\\__ \\ |_   ____) | || (_| | |  | |_ \r\n" + 
				"    |_|\\___||___/\\__| |_____/ \\__\\__,_|_|   \\__|\r\n" + 
				"                                                \r\n" + 
				"                                                \r\n" + 
				"");
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		
		log.info("\r\n" + 
				"  _______        _     _____              \r\n" + 
				" |__   __|      | |   |  __ \\             \r\n" + 
				"    | | ___  ___| |_  | |__) |_ _ ___ ___ \r\n" + 
				"    | |/ _ \\/ __| __| |  ___/ _` / __/ __|\r\n" + 
				"    | |  __/\\__ \\ |_  | |  | (_| \\__ \\__ \\\r\n" + 
				"    |_|\\___||___/\\__| |_|   \\__,_|___/___/\r\n" + 
				"                                          \r\n" + 
				"                                          \r\n" + 
				"");
	}
}
