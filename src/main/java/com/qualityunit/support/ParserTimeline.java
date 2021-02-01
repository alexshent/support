package com.qualityunit.support;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserTimeline {

    private String regex = "C (\\d+)(\\.\\d+)? (\\d+)(\\.\\d+)?(\\.\\d+)? ([PN]+) (\\d+\\.\\d+\\.\\d+) (\\d+)";
    private static final int SERVICE_ID = 1;
    private static final int VARIATION_ID = 2;
    private static final int QUESTION_TYPE_ID = 3;
    private static final int CATEGORY_ID = 4;
    private static final int SUBCATEGORY_ID = 5;
    private static final int RESPONSE_TYPE = 6;
    private static final int DATE = 7;
    private static final int TIME = 8;
    
    public Timeline parse(String line) {
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        
        Timeline timeline = new Timeline();
        
        // service id
        if (matcher.group(1) != null) {
            timeline.setServiceId(matcher.group(SERVICE_ID));
        }
        
        // variation id
        if (matcher.group(2) != null) {
            timeline.setVariationId(matcher.group(VARIATION_ID).substring(1));
        }
        
        // question type id
        if (matcher.group(3) != null) {
            timeline.setQuestionTypeId(matcher.group(QUESTION_TYPE_ID));
        }
        
        // category id
        if (matcher.group(4) != null) {
            timeline.setCategoryId(matcher.group(CATEGORY_ID).substring(1));
        }
        
        // subcategory id
        if (matcher.group(5) != null) {
            timeline.setSubcategoryId(matcher.group(SUBCATEGORY_ID).substring(1));
        }
        
        // response type
        if (matcher.group(6) != null) {
            timeline.setResponseType(matcher.group(RESPONSE_TYPE).charAt(0));
        }
        
        // date
        if (matcher.group(7) != null) {
            timeline.setDate(matcher.group(DATE));
        }
        
        // time
        if (matcher.group(8) != null) {
            timeline.setTime(Integer.parseInt(matcher.group(TIME)));
        }
        
        return timeline;
    }
}
