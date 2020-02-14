package com.poo.labvisitor.task1.document;

public class UrlSegment extends TextSegment {
    private String url;
    private String description;

    public UrlSegment(String url, String description) {
        super(url+description);
        this.url = url;
        this.description = description;
    }

    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }

    public String getUrl() {
        return this.url;
    }

    public String getDescription() {
        return this.description;
    }
}
