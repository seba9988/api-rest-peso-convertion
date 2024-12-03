package org.Sebastian.quarkus.test.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.core.Response.Status;

public class ErrorResponse {
    private String resourceType;
    private int id;
    private List<Issue> issue;

    public ErrorResponse() {
    }

    public ErrorResponse(Integer id, String code, String text) {
        this.setResourceType("OperationOutcome");
        this.setId(id);
        Details details = new Details(text);
        List<Issue> issues = new ArrayList<>();
        issues.add(new Issue(code, details));
        this.setIssue(issues);
    }

    public ErrorResponse(int i, String string) {
        //TODO Auto-generated constructor stub
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Issue> getIssue() {
        return issue;
    }

    public void setIssue(List<Issue> issue) {
        this.issue = issue;
    }
}
