package com.epam.task2.preferences;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public abstract class PreferencesLoader {
    Properties prop = null;

    abstract void loadPreferences(String preferencesFileURL) throws IOException, PreferencesLoadException;

    protected String loadProperty(String propertyName) throws PreferencesLoadException {
        String property;
        if (Objects.isNull(property = prop.getProperty(propertyName)))
            throw new PreferencesLoadException(String.format("%s not found", propertyName));
        return property;
    }
}