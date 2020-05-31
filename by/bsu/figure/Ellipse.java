package by.bsu.figure;

import by.bsu.figure.TwoDimentionalFigure;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse extends TwoDimentionalFigure {

    private Point endPoint;
    private Point startPoint;
    Ellipse2D.Double ellipse;

    public Ellipse(Point start, Point end, Color c, Color fill) {
        super(c, fill);
        endPoint = end;
        startPoint = start;
        double width = Math.abs(end.getX() - start.getX());
        double height = Math.abs(end.getY() - start.getY());

        ellipse = new Ellipse2D.Double(startPoint.getX(), startPoint.getY(), width, height);
    }

    public void draw(Graphics2D g2) {
        g2.setColor(getFillColor());
        g2.fill(ellipse);
        g2.setColor(super.getBorderColor());
        g2.draw(ellipse);
    }

    public void move(Point newCenter) {
        double x = newCenter.getX();
        double y = newCenter.getY();
        ellipse.setFrame(x, y, ellipse.getWidth(), ellipse.getHeight());
    }

    public boolean contains(Point point) {
        return ellipse.contains(point);
    }

}
