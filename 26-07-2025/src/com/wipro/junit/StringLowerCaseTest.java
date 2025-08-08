package com.wipro.junit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringLowerCaseTest {

	public boolean isLowerCase(String input) {
        return input.equals(input.toLowerCase());
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", "java", "world", "testcase", "lowercase"})
    void checkAllStringsAreLowerCase(String str) {
        assertTrue(isLowerCase(str), "String is not in lower case: " + str);
    }
}
