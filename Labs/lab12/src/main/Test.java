package main;

public class Test {
    public static void main(String[] args) {
        Client client = new Client();

        // Execute various tests

//        testDraw(client);
//        System.out.println(new String(new char[80]).replace("\0", "-"));
//
        testTextAndColor(client);
//        System.out.println(new String(new char[80]).replace("\0", "-"));
//
//        testResize(client);
//        System.out.println(new String(new char[80]).replace("\0", "-"));
//
//        testConnect(client);
//        System.out.println(new String(new char[80]).replace("\0", "-"));
//
//        testAllCommands(client);
//        System.out.println(new String(new char[80]).replace("\0", "-"));
//
//        testSimpleUndoRedo(client);
//        System.out.println(new String(new char[80]).replace("\0", "-"));

//        testComplexUndoRedo(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));
    }

    private static void testDraw(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");

        client.showDiagram();
    }

    private static void testTextAndColor(Client client) {
        testDraw(client);
        client.executeAction("change color", "0", "RED");
        client.executeAction("change color", "1", "BLUE");
        client.executeAction("draw rectangle");
        client.executeAction("change text", "0", "MyClass1");
        client.executeAction("change text", "5", "MyClass2");
        client.showDiagram();
    }

    private static void testConnect(Client client) {
        // TODO
        testDraw(client);
        client.executeAction("connect", "0", "1");
        client.executeAction("connect", "0", "2");
        client.executeAction("draw rectangle");
        client.executeAction("connect", "0", "5");
        client.executeAction("connect", "1", "3");
        client.showDiagram();
    }

    private static void testResize(Client client) {
        // TODO
        testDraw(client);
        client.executeAction("resize", "0", "200", "200");
        client.executeAction("resize", "1", "50", "60");
        client.executeAction("draw rectangle");
        client.executeAction("resize", "3", "90", "40");
        client.executeAction("resize", "5", "120", "45");
        client.showDiagram();
    }

    private static void testAllCommands(Client client) {
        // TODO
        testDraw(client);
        client.executeAction("change color", "0", "RED");
        client.executeAction("change color", "1", "BLUE");
        client.executeAction("draw rectangle");
        client.executeAction("change text", "0", "MyClass1");
        client.executeAction("change text", "5", "MyClass2");

        client.executeAction("connect", "0", "1");
        client.executeAction("connect", "0", "2");
        client.executeAction("connect", "0", "5");
        client.executeAction("connect", "1", "3");

        client.executeAction("resize", "0", "200", "200");
        client.executeAction("resize", "1", "50", "60");
        client.executeAction("resize", "3", "90", "40");
        client.executeAction("resize", "5", "120", "45");

        client.showDiagram();

    }

    private static void testSimpleUndoRedo(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("change color", "0", "ORANGE");
        client.showDiagram();

        client.executeAction("draw rectangle");
        client.showDiagram();

        client.undo();
        client.showDiagram();

        client.redo();
        client.showDiagram();
    }

    private static void testComplexUndoRedo(Client client) {
        // TODO
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("change color", "0", "ORANGE");
        client.showDiagram();

        client.executeAction("draw rectangle");
        client.showDiagram();

        client.undo();
        client.showDiagram();

        client.undo();
        client.showDiagram();

        client.redo();
        client.showDiagram();

        client.redo();
        client.showDiagram();
    }
}
