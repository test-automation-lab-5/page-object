package com.epam.objectpattern.driverfactory;

public class DriverManagerFactory {
	private static DriverManagerFactory driverManagerFactory=null;
	private DriverManagerFactory() {}
	
	public static DriverManagerFactory getInstance() {
		if (driverManagerFactory==null) {
			driverManagerFactory =new DriverManagerFactory();
		}
		return driverManagerFactory;
		
	}
	public DriverManager getManager(DriverType type) {

		DriverManager driverManager = null;
		if (type.equals(DriverType.CHROME)) {
			driverManager = new ChromeDriverManager();
		} else if (type.equals(DriverType.FIREFOX)) {
			driverManager = new FirefoxDriverManager();
		}
		return driverManager;
	}
}


