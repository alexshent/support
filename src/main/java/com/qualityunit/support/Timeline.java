package com.qualityunit.support;

public class Timeline {
    private String serviceId;
    private String variationId;
    private String questionTypeId;
    private String categoryId;
    private String subcategoryId;
    private char responseType;
    private String date;
    private int time;
    
    public Timeline() {
        serviceId = "";
        variationId = "";
        questionTypeId = "";
        categoryId = "";
        subcategoryId = "";
        responseType = '?';
        date = "";
        time = 0;
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
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("TIMELINE%n", ""));
        sb.append(String.format("serviceId = %s%n", serviceId));
        sb.append(String.format("variationId = %s%n", variationId));
        sb.append(String.format("questionTypeId = %s%n", questionTypeId));
        sb.append(String.format("categoryId = %s%n", categoryId));
        sb.append(String.format("subcategoryId = %s%n", subcategoryId));
        sb.append(String.format("responseType = %c%n", responseType));
        sb.append(String.format("date = %s%n", date));
        sb.append(String.format("time = %d%n", time));
        return sb.toString();
    }
}
