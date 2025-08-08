package com.wipro.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringTest2 {

    @Test
    void testUpperCaseOfNullStringThrowsException() {
        String str = null;
        
        assertThrows(NullPointerException.class, () -> {
            str.toUpperCase();
        });
    }
}

