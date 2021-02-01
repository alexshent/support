package com.qualityunit.support;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Analytics {
    public void evaluate() throws URISyntaxException, IOException {
        String filename = "input.txt";
        ClassLoader classLoader = Demo.class.getClassLoader();
        URL resource = classLoader.getResource(filename);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + filename);
        }
        File file = new File(resource.toURI());
        List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

        ParserTimeline parserTimeline = new ParserTimeline();
        ParserQuery parserQuery = new ParserQuery();
        List<Timeline> timelines = new ArrayList<>();

        for (String line : lines) {
            if (line.charAt(0) == 'C') {
                Timeline timeline = parserTimeline.parse(line);
                timelines.add(timeline);
            } else if (line.charAt(0) == 'D') {
                Query query = parserQuery.parse(line);
                System.out.println("------------------");
                System.out.println(query.toString());
                
                int timeSum = 0;
                int matchedTimelinesCounter = 0;
                for (Timeline tl : timelines) {
                    if (query.isTimelineMatched(tl)) {
                        //System.out.println(tl.toString());
                        timeSum += tl.getTime();
                        matchedTimelinesCounter ++;
                    }
                }
                
                if (matchedTimelinesCounter > 0) {
                    int averageTime = timeSum / matchedTimelinesCounter;
                    System.out.println(String.format("average time = %d%n", averageTime));
                } else {
                    System.out.println("-");
                }
                
            } else {
                System.out.println(line);
            }
        }
    }
}
