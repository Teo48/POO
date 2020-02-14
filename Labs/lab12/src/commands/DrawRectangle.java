package commands;

import diagram.DiagramCanvas;
import diagram.DiagramComponent;

public class DrawRectangle implements DrawCommand {
    private DiagramCanvas diagramCanvas;
    public DrawRectangle(DiagramCanvas d) {
        diagramCanvas = d;
    }
    public void execute() {
        DiagramComponent diagramComponent = new DiagramComponent();
        diagramCanvas.addComponent(diagramComponent);
    }
    public void undo() {
        diagramCanvas.removeLastComponent();
    }
}
