package com.qualityunit.support;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParserTimelineTest {

    @Test
    void parse_mustReturnTimelineObject_whenAvailable_ServiceId_VariationId_QuestionTypeId_categoryId_subcategoryId() {
        // given
        String line = "C 1.1 8.15.1 P 15.10.2012 83";
        
        Timeline expected = new Timeline();
        expected.setServiceId("1");
        expected.setVariationId("1");
        expected.setQuestionTypeId("8");
        expected.setCategoryId("15");
        expected.setSubcategoryId("1");
        expected.setResponseType('P');
        expected.setDate("15.10.2012");
        expected.setTime(83);
        
        // when
        ParserTimeline parserTimeline = new ParserTimeline();
        Timeline actual = parserTimeline.parse(line);
        
        // then
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void parse_mustReturnTimelineObject_whenAvailable_ServiceId_QuestionTypeId_categoryId_subcategoryId() {
        // given
        String line = "C 1 8.15.1 P 15.10.2012 83";
        
        Timeline expected = new Timeline();
        expected.setServiceId("1");
        expected.setQuestionTypeId("8");
        expected.setCategoryId("15");
        expected.setSubcategoryId("1");
        expected.setResponseType('P');
        expected.setDate("15.10.2012");
        expected.setTime(83);
        
        // when
        ParserTimeline parserTimeline = new ParserTimeline();
        Timeline actual = parserTimeline.parse(line);
        
        // then
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void parse_mustReturnTimelineObject_whenAvailable_ServiceId_QuestionTypeId_categoryId() {
        // given
        String line = "C 1 8.15 P 15.10.2012 83";
        
        Timeline expected = new Timeline();
        expected.setServiceId("1");
        expected.setQuestionTypeId("8");
        expected.setCategoryId("15");
        expected.setResponseType('P');
        expected.setDate("15.10.2012");
        expected.setTime(83);
        
        // when
        ParserTimeline parserTimeline = new ParserTimeline();
        Timeline actual = parserTimeline.parse(line);
        
        // then
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void parse_mustReturnTimelineObject_whenAvailable_ServiceId_QuestionTypeId() {
        // given
        String line = "C 1 8 P 15.10.2012 83";
        
        Timeline expected = new Timeline();
        expected.setServiceId("1");
        expected.setQuestionTypeId("8");
        expected.setResponseType('P');
        expected.setDate("15.10.2012");
        expected.setTime(83);
        
        // when
        ParserTimeline parserTimeline = new ParserTimeline();
        Timeline actual = parserTimeline.parse(line);
        
        // then
        assertEquals(expected.toString(), actual.toString());
    }
}
