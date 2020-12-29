package frontEnd;

import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

public class Scaler {
    public static Rectangle2D screenBounds = Screen.getPrimary().getBounds();
    public static double x = screenBounds.getWidth();
    public static double y = screenBounds.getHeight();
    public static double ratioX = (x / 1366);
    public static double ratioY = (y / 768);

    public static void scale(Node node, boolean isFullScreen) {
        javafx.scene.transform.Scale scale;
        scale = new javafx.scene.transform.Scale(ratioX, ratioY, 0, 0);
        if (!isFullScreen) {
            double ratio;
            if (ratioX > ratioY) ratio = ratioY;
            else ratio = ratioX;
            scale = new javafx.scene.transform.Scale(ratio, ratio, 0, 0);
            if (node instanceof Pane) {
                Pane p = (Pane) node;
                p.setPrefSize(p.getPrefWidth() * ratioX, p.getPrefHeight() * ratioY);
            }
        }
        if (!(node instanceof Pane)) {
            node.setLayoutX(node.getLayoutX() * ratioX);
            node.setLayoutY(node.getLayoutY() * ratioY);
        }
        node.getTransforms().add(scale);
    }
}
