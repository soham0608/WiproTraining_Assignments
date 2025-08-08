package com.wipro.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringMainTest {
	
	@Test
    public void testIsUpperCase_WithUppercaseString() {
        assertTrue(StringTest.isUpperCase("HELLO"));
    }

    @Test
    public void testIsUpperCase_WithLowercaseString() {
        assertFalse(StringTest.isUpperCase("hello"));
    }

    @Test
    public void testIsUpperCase_WithMixedCaseString() {
        assertFalse(StringTest.isUpperCase("HeLLo"));
    }

    @Test
    public void testIsUpperCase_WithEmptyString() {
        assertFalse(StringTest.isUpperCase(""));
    }

    @Test
    public void testIsUpperCase_WithNullString() {
        assertFalse(StringTest.isUpperCase(null));
    }

    @Test
    public void testIsUpperCase_WithNumbersAndSymbols() {
        assertTrue(StringTest.isUpperCase("123!@#"));
    }
    
}
