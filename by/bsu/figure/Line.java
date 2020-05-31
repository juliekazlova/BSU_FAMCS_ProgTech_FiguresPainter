package by.bsu.figure;

import java.awt.*;

public class Line extends Ray {

    public Line(Point start, Point end, Color c) {
        super(start, end, c);
    }

    public static Point getNewStartPoint(Point start, Point end) {
        double newStartX = start.getX();
        double newStartY = start.getY();
        double dx = 0;
        double dy = 0;
        while (Math.sqrt(dx * dx + dy * dy) < 1000) {
            newStartX -= dx;
            newStartY -= dy;
            dx = end.getX() - newStartX;
            dy = end.getY() - newStartY;
        }
        return new Point((int) newStartX, (int) newStartY);
    }
}