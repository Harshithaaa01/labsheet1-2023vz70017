
package com.bits.mvn;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void testGreetWithValidName() {
        App app = new App();
        assertEquals("hello BITS!", app.greet("BITS"));
    }
}
