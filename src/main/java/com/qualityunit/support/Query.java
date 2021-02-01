package com.qualityunit.support;

import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Query {
    private String serviceId;
    private String variationId;
    private String questionTypeId;
    private String categoryId;
    private String subcategoryId;
    private char responseType;
    private String dateFrom;
    private String dateTo;

    public static final String MATCH_ALL_ID = "*";

    public Query() {
        serviceId = "";
        variationId = "";
        questionTypeId = "";
        categoryId = "";
        subcategoryId = "";
        responseType = '?';
        dateFrom = "";
        dateTo = "";
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getVariationId() {
        return variationId;
    }

    public void setVariationId(String variationId) {
        this.variationId = variationId;
    }

    public String getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(String questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public char getResponseType() {
        return responseType;
    }

    public void setResponseType(char responseType) {
        this.responseType = responseType;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("QUERY%n", ""));
        sb.append(String.format("serviceId = %s%n", serviceId));
        sb.append(String.format("variationId = %s%n", variationId));
        sb.append(String.format("questionTypeId = %s%n", questionTypeId));
        sb.append(String.format("categoryId = %s%n", categoryId));
        sb.append(String.format("subcategoryId = %s%n", subcategoryId));
        sb.append(String.format("responseType = %c%n", responseType));
        sb.append(String.format("dateFrom = %s%n", dateFrom));
        sb.append(String.format("dateTo = %s%n", dateTo));
        return sb.toString();
    }

    public boolean isTimelineMatched(Timeline timeline) {

        if (timeline == null) {
            throw new InvalidParameterException("timeline parameter is null!");
        }
        
        // check response type
        if (timeline.getResponseType() != responseType) {
            return false;
        }
        
        // check ids
        
        if (!serviceId.equals(MATCH_ALL_ID) && !serviceId.equals(timeline.getServiceId())) {
            return false;
        }
        
        if (!variationId.isEmpty() && !variationId.equals(timeline.getVariationId())) {
            return false;
        }
        
        if (!questionTypeId.equals(MATCH_ALL_ID) && !questionTypeId.equals(timeline.getQuestionTypeId())) {
            return false;
        }
        
        if (!categoryId.isEmpty() && !categoryId.equals(timeline.getCategoryId())) {
            return false;
        }
        
        if (!subcategoryId.isEmpty() && !subcategoryId.equals(timeline.getSubcategoryId())) {
            return false;
        }
        
        // check dates

        String timelineDateString = timeline.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date timelineDate = null;
        Date queryDateFrom = null;
        Date queryDateTo = null;

        try {
            if (timelineDateString != null) {
                timelineDate = sdf.parse(timelineDateString);
            }

            if (dateFrom != null && !dateFrom.isEmpty()) {
                queryDateFrom = sdf.parse(dateFrom);
            }

            if (dateTo != null && !dateTo.isEmpty()) {
                queryDateTo = sdf.parse(dateTo);
            }

        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        
        if (timelineDate == null) {
            throw new InvalidParameterException("timelineDate is null!");
        }

        if (queryDateFrom != null && !timelineDate.after(queryDateFrom)) {
            return false;
        }

        if (queryDateTo != null && !timelineDate.before(queryDateTo)) {
            return false;
        } 
        
        return true;
    }
}
