package commands;

import diagram.DiagramCanvas;

import java.util.List;

public class Connect implements DrawCommand {
    private DiagramCanvas diagramCanvas;
    private int diagramID;
    private String diagamConnect;

    private List<String> oldDiagramConnect;

    public Connect(DiagramCanvas d, int id, String connect) {
        diagramCanvas = d;
        diagramID = id;
        diagamConnect = connect;

        oldDiagramConnect = d.getComponent(id).getConnect();
    }
    public void execute() {
        diagramCanvas.getComponent(diagramID).connectTo(diagamConnect);
    }
    public void undo() {
        diagramCanvas.getComponent(diagramID).connectToAll(oldDiagramConnect);
    }
}
