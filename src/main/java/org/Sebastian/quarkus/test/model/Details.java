package org.Sebastian.quarkus.test.model;

public class Details {
    public String text;

    public Details() {
    }

    public Details(String text) {
        this.setText(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
