package com.poo.labvisitor.task1.document;

public class PlainTextSegment extends TextSegment{

    public PlainTextSegment(String content) {
        super(content);
    }

    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
}
