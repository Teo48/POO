package com.poo.labvisitor.task2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 * Counter for java files of a given directory using java.nio API
 */
public class JavaFilesVisitor extends SimpleFileVisitor<Path> {

    private static ArrayList<Path> javaFiles = new ArrayList<>();

    public final ArrayList<Path> getJavaFiles() {
        return javaFiles;
    }

    // TODO - override the visitFile(Path file, BasicFileAttributes attr) method of the SimpleFileVisitor
    // add to javaFiles all the Java related files: the ones with .java and .class extensions

    public static class Finder extends SimpleFileVisitor<Path> {
        private final PathMatcher matcher;

        Finder() {
            matcher = FileSystems.getDefault().getPathMatcher("glob:*.{java,class}");
        }

        void find(Path file) {
            Path name = file.getFileName();
            if (name != null && matcher.matches(name)) {
                javaFiles.add(file);
            }
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            find(file);
            return FileVisitResult.CONTINUE;
        }

    }

    public static void main(String[] args) throws IOException {

        Path startingDir = Paths.get(".");
        JavaFilesVisitor filesVisitor = new JavaFilesVisitor();
//        // TODO
//        // use Files.walkFileTree
//        // obtain the list of files and print some info about them (e.g. size and path)

        Finder finder = new Finder();
        Files.walkFileTree(startingDir, finder);

        ArrayList<Path> filesJava = filesVisitor.getJavaFiles();

        for (int i = 0 ; i < filesJava.size() ; ++i) {
            BasicFileAttributes attrs = Files.readAttributes(filesJava.get(i), BasicFileAttributes.class);
            System.out.println(filesJava.get(i) + " ---> " + attrs.size() + " bytes." );
        }
    }
}
