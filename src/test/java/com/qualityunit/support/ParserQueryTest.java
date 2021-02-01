package com.qualityunit.support;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParserQueryTest {

    @Test
    void parse_mustReturn_QueryObject_whenAvailable_ServiceId_VariationId_QuestionTypeId_categoryId_subcategoryId_dateFrom_dateTo() {
        // given
        String line = "D 1.1 8.15.1 N 08.10.2012-20.11.2012";
        
        // when
        Query expected = new Query();
        expected.setServiceId("1");
        expected.setVariationId("1");
        expected.setQuestionTypeId("8");
        expected.setCategoryId("15");
        expected.setSubcategoryId("1");
        expected.setResponseType('N');
        expected.setDateFrom("08.10.2012");
        expected.setDateTo("20.11.2012");
        
        ParserQuery parserQuery = new ParserQuery();
        Query actual = parserQuery.parse(line);
        
        // then
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void parse_mustReturn_QueryObject_whenAvailable_ServiceId_QuestionTypeId_categoryId_subcategoryId_dateFrom_dateTo() {
        // given
        String line = "D 1 8.15.1 N 08.10.2012-20.11.2012";
        
        // when
        Query expected = new Query();
        expected.setServiceId("1");
        expected.setQuestionTypeId("8");
        expected.setCategoryId("15");
        expected.setSubcategoryId("1");
        expected.setResponseType('N');
        expected.setDateFrom("08.10.2012");
        expected.setDateTo("20.11.2012");
        
        ParserQuery parserQuery = new ParserQuery();
        Query actual = parserQuery.parse(line);
        
        // then
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void parse_mustReturn_QueryObject_whenAvailable_ServiceIdVariationIdMatchAll_QuestionTypeId_categoryId_subcategoryId_dateFrom_dateTo() {
        // given
        String line = "D * 8.15.1 N 08.10.2012-20.11.2012";
        
        // when
        Query expected = new Query();
        expected.setServiceId(Query.MATCH_ALL_ID);
        expected.setVariationId(Query.MATCH_ALL_ID);
        expected.setQuestionTypeId("8");
        expected.setCategoryId("15");
        expected.setSubcategoryId("1");
        expected.setResponseType('N');
        expected.setDateFrom("08.10.2012");
        expected.setDateTo("20.11.2012");
        
        ParserQuery parserQuery = new ParserQuery();
        Query actual = parserQuery.parse(line);
        
        // then
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void parse_mustReturn_QueryObject_whenAvailable_ServiceId_VariationId_QuestionTypeIdcategoryIdsubcategoryIdmatchAll_dateFrom_dateTo() {
        // given
        String line = "D 1.1 * N 08.10.2012-20.11.2012";
        
        // when
        Query expected = new Query();
        expected.setServiceId("1");
        expected.setVariationId("1");
        expected.setQuestionTypeId(Query.MATCH_ALL_ID);
        expected.setCategoryId(Query.MATCH_ALL_ID);
        expected.setSubcategoryId(Query.MATCH_ALL_ID);
        expected.setResponseType('N');
        expected.setDateFrom("08.10.2012");
        expected.setDateTo("20.11.2012");
        
        ParserQuery parserQuery = new ParserQuery();
        Query actual = parserQuery.parse(line);
        
        // then
        assertEquals(expected.toString(), actual.toString());
    }
}
