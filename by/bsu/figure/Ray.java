package by.bsu.figure;

import java.awt.*;

public class Ray extends Section {

    public Ray(Point start, Point end, Color c) {
        super(start, end, c);
    }

    public static Point getNewEndPoint(Point start, Point end) {
        double newEndX = end.getX();
        double newEndY = end.getY();
        double dx = 0;
        double dy = 0;
        while (Math.sqrt(dx * dx + dy * dy) < 1000) {
            newEndX += dx;
            newEndY += dy;
            dx = newEndX - start.getX();
            dy = newEndY - start.getY();
        }
        return new Point((int) newEndX, (int) newEndY);
    }

}