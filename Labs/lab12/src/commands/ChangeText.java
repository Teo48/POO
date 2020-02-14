package commands;

import diagram.DiagramCanvas;

public class ChangeText implements DrawCommand{
    private DiagramCanvas diagramCanvas;
    private int diagramID;
    private String diagramText;

    private String oldDiagramText;

    public ChangeText(DiagramCanvas d, int id, String text) {
        diagramCanvas = d;
        diagramID = id;
        diagramText = text;

        oldDiagramText = d.getComponent(id).getText();
    }
    public void execute() {
        diagramCanvas.getComponent(diagramID).setText(diagramText);
    }
    public void undo() {
        diagramCanvas.getComponent(diagramID).setText(oldDiagramText);
    }
}
