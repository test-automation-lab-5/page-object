package com.epam.objectpattern.driverfactory;

import static com.epam.objectpattern.constant.Constant.CHROME_DRIVER_PATH;
import static com.epam.objectpattern.constant.Constant.CHROME_DRIVER_TYPE;
import static com.epam.objectpattern.constant.Constant.GLOBAL_WAIT_TIME;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

	
	@Override
	protected void createDriver() {
		System.setProperty(CHROME_DRIVER_TYPE, CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(GLOBAL_WAIT_TIME, TimeUnit.SECONDS);

	}

}
