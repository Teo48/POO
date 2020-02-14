package com.poo.labvisitor.task1.document;

public class ItalicTextSegment extends TextSegment {

    public ItalicTextSegment(String content) {
        super(content);
    }

    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
}
