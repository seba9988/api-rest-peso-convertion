package org.Sebastian.quarkus.test.model;

public class Issue {
    private String severity;
    private String code;
    private Details details;

    public Issue(String code, Details details) {
        this.setSeverity("error");
        this.setCode(code);
        this.setDetails(details);
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
