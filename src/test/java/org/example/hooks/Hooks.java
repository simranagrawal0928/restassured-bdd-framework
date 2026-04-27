package org.example.hooks;

import io.cucumber.java.Before;
import org.example.utils.RestAssuredSetup;

public class Hooks {
    @Before
    public void setUp() {
        RestAssuredSetup.init();
    }
}
