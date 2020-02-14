package commands;

import diagram.DiagramCanvas;

public class Resize implements DrawCommand {
    private DiagramCanvas diagramCanvas;
    private int diagramID;
    private int diagramHeight;
    private int diagramWidth;

    private int oldDiagramHeight;
    private int oldDiagramWidth;

    public Resize(DiagramCanvas d, int id, int h, int w) {
        diagramCanvas = d;
        diagramID = id;
        diagramHeight = h;
        diagramWidth = w;

        oldDiagramHeight = d.getComponent(id).getHeight();
        oldDiagramWidth = d.getComponent(id).getWeight();
    }
    public void execute() {
        diagramCanvas.getComponent(diagramID).setHeight(diagramHeight);
        diagramCanvas.getComponent(diagramID).setWeight(diagramWidth);
    }
    public void undo() {
        diagramCanvas.getComponent(diagramID).setHeight(oldDiagramHeight);
        diagramCanvas.getComponent(diagramID).setWeight(oldDiagramWidth);
    }
}
