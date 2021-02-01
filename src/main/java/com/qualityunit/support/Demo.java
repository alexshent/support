package com.qualityunit.support;

import java.io.IOException;
import java.net.URISyntaxException;

public class Demo {

    public static void main(String[] args) {
        Analytics analytics = new Analytics();

        try {
            analytics.evaluate();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
