package com.poo.labvisitor.task1.document;

public class BoldTextSegment extends TextSegment {

    public BoldTextSegment(String content) {
        super(content);
    }

    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
}
