package commands;

import diagram.DiagramCanvas;

public class ChangeColor implements DrawCommand {
    private DiagramCanvas diagramCanvas;
    private int diagramID;
    private String diagamColor;

    private String oldDiagramColor;

    public ChangeColor(DiagramCanvas d, int id, String color) {
        diagramCanvas = d;
        diagramID = id;
        diagamColor = color;

        oldDiagramColor = d.getComponent(id).getColor();
    }

    public void execute() {
        diagramCanvas.getComponent(diagramID).setColor(diagamColor);
    }
    public void undo() {
        diagramCanvas.getComponent(diagramID).setColor(oldDiagramColor);
    }
}
