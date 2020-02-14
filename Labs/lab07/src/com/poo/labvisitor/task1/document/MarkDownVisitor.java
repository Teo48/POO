package com.poo.labvisitor.task1.document;

public class MarkDownVisitor implements DocumentVisitor {
    private static StringBuilder stringBuilder = new StringBuilder("");

    @Override
    public void visit(ItalicTextSegment italicTextSegment) {
        StringBuilder textToModify = new StringBuilder(italicTextSegment.getContent());
        textToModify.insert(0, "_");
        textToModify.append("_");
        stringBuilder.append(textToModify.toString());
    }

    @Override
    public void visit(BoldTextSegment boldTextSegment) {
        StringBuilder textToModify = new StringBuilder(boldTextSegment.getContent());
        textToModify.insert(0, "__");
        textToModify.append("__");
        stringBuilder.append(textToModify.toString());
    }

    @Override
    public void visit(UrlSegment urlSegment) {
        StringBuilder textToModify = new StringBuilder(urlSegment.getDescription());
        textToModify.insert(0, "[");
        textToModify.append("](");
        textToModify.append(urlSegment.getUrl());
        textToModify.append(")");
        stringBuilder.append(textToModify.toString());
    }

    @Override
    public void visit(PlainTextSegment plainTextSegment) {
        stringBuilder.append(plainTextSegment.getContent());
    }

    @Override
    public StringBuilder getDocument() {
        return stringBuilder;
    }
}
