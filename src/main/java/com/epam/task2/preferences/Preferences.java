package com.epam.task2.preferences;

import java.io.IOException;

import org.apache.log4j.Logger;

public class Preferences {
	private static final Logger log = Logger.getLogger(Preferences.class);
	public static final PreferencesTestGmail preferencesTestGmail = new PreferencesTestGmail();

	private Preferences() {
	}

	public static void loadPreferences(String preferencesFileURL) throws IOException, PreferencesLoadException {
		log.info("Load TestGmail preferences");
		preferencesTestGmail.loadPreferences(preferencesFileURL);
		log.info("TestGmail preferences loaded");
	}
}