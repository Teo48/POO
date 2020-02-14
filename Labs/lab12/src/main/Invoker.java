package main;

import commands.*;
import diagram.DiagramCanvas;
import diagram.DiagramComponent;

import java.util.Deque;
import java.util.LinkedList;

/**
 * The layer between the client and the commands that need to be executed on the receivers (DiagramCanvas and DiagramComponent).
 * <br>
 * It is independent of the subtypes of commands, it just receives a command, runs it and implements a redo/undo mechanism.
 */
public class Invoker {

    Deque<DrawCommand> undoDeque = new LinkedList<>();
    Deque<DrawCommand> redoDeque = new LinkedList<>();
    /**
     * Clear up all the used resources, start fresh :D
     */
    public void restart() {
      // TODO
        undoDeque.clear();
        redoDeque.clear();
    }

    /**
     * Executes a given command
     * @param command
     */
    public void execute(DrawCommand command) {
        undoDeque.push(command);
        redoDeque.clear();
        command.execute();
    }

    /**
     * Undo the latest command
     */
    public void undo() {
        // TODO
        // Hint: use data structures to keep track of commands
        // Do not use the java.util.Stack, its implementation is based on vector which is inefficient and deprecated.
        // Use a class that implements the Deque interface, e.g. LinkedList https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Deque.html

        undoDeque.peekFirst().undo();
        redoDeque.push(undoDeque.peekFirst());
        undoDeque.pop();
    }

    /**
     * Redo command previously undone. Cannot perform a redo after an execute, only after at least one undo.
     */
    public void redo() {
        // TODO
        redoDeque.peekFirst().execute();
        redoDeque.pop();
    }
}
