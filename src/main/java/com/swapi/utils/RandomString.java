package com.swapi.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomString {

    public static String getAlphabeticString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String getAlphanumericString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

}