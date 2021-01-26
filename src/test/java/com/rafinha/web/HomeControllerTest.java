package com.rafinha.web;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeControllerTest {
    @Test
    public void homePageTest() throws Exception {
        HomeController homeController = new HomeController();
        assertEquals("index", homeController.home());
    }
}
