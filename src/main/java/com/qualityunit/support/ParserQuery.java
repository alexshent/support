package com.qualityunit.support;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserQuery {

    private String regex = "D (\\d+|\\*)(\\.\\d+)? (\\d+|\\*)(\\.\\d+)?(\\.\\d+)? ([PN]+) (\\d+\\.\\d+\\.\\d+)(\\-\\d+\\.\\d+\\.\\d+)?";
    private static final int SERVICE_ID = 1;
    private static final int VARIATION_ID = 2;
    private static final int QUESTION_TYPE_ID = 3;
    private static final int CATEGORY_ID = 4;
    private static final int SUBCATEGORY_ID = 5;
    private static final int RESPONSE_TYPE = 6;
    private static final int DATE_FROM = 7;
    private static final int DATE_TO = 8;
    
    public Query parse(String line) {
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        
        Query query = new Query();
        
        // service id
        if (matcher.group(SERVICE_ID) != null) {
            if (matcher.group(SERVICE_ID).equals(Query.MATCH_ALL_ID)) {
                // match all
                query.setServiceId(Query.MATCH_ALL_ID);
            } else {
                // parse service id
                query.setServiceId(matcher.group(SERVICE_ID));
                // parse variation id
                if (matcher.group(VARIATION_ID) != null) {
                    query.setVariationId(matcher.group(VARIATION_ID).substring(1));
                }
            }
        }
        
        // question type id
        if (matcher.group(QUESTION_TYPE_ID) != null) {
            if (matcher.group(QUESTION_TYPE_ID).equals(Query.MATCH_ALL_ID)) {
                // match all
                query.setQuestionTypeId(Query.MATCH_ALL_ID);
            } else {
                // match question type id
                query.setQuestionTypeId(matcher.group(QUESTION_TYPE_ID));
                // category id
                if (matcher.group(CATEGORY_ID) != null) {
                    query.setCategoryId(matcher.group(CATEGORY_ID).substring(1));
                }
                // subcategory id
                if (matcher.group(SUBCATEGORY_ID) != null) {
                    query.setSubcategoryId(matcher.group(SUBCATEGORY_ID).substring(1));
                }
            }
        }
        
        // response type
        if (matcher.group(RESPONSE_TYPE) != null) {
            query.setResponseType(matcher.group(RESPONSE_TYPE).charAt(0));
        }
        
        // date from
        if (matcher.group(DATE_FROM) != null) {
            query.setDateFrom(matcher.group(DATE_FROM));
        }
        
        // date to
        if (matcher.group(DATE_TO) != null) {
            query.setDateTo(matcher.group(DATE_TO).substring(1));
        }
        
        return query;
    }
}
