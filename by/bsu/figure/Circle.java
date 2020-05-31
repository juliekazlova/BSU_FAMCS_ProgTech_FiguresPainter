package by.bsu.figure;

import by.bsu.figure.Ellipse;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Ellipse {

    public Circle(Point start, Point end, Color c, Color fill) {
        super(start, end, c, fill);

        double width = Math.abs(end.getX() - start.getX());
        double height = Math.abs(end.getY() - start.getY());
        double maxValue = Math.max(width, height);
        ellipse = new Ellipse2D.Double(start.getX(), start.getY(), maxValue, maxValue);
    }

}