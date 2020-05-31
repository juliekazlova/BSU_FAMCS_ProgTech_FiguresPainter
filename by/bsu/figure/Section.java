package by.bsu.figure;

import by.bsu.figure.Figure;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Section extends OneDimentionalFigure {

    private Point startPoint;
    private Point endPoint;
    private Line2D.Double line;

    public Section(Point start, Point end, Color c) {
        super(c);
        startPoint = start;
        endPoint = end;
        line = new Line2D.Double(start, end);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(getBorderColor());
        g.draw(line);
    }

    public void move(Point newCenter) {
        double x = newCenter.getX();
        double y = newCenter.getY();

        Rectangle2D rectangle = line.getBounds2D();
        rectangle.setFrame(x, y, rectangle.getWidth(), rectangle.getHeight());
        line.setLine(getLineOrientation(x, y, rectangle.getWidth(), rectangle.getHeight()));
    }

    @Override
    public boolean contains(Point point) {
        Rectangle2D rectangle2D = new Rectangle2D.Double(point.getX() - 5, point.getY() - 5, 10, 10);
        return line.intersects(rectangle2D);
    }

    private Line2D.Double getLineOrientation(double x, double y, double width, double height) {
        if ((startPoint.getX() >= endPoint.getX() && startPoint.getY() < endPoint.getY()) ||
                (startPoint.getX() < endPoint.getX() && startPoint.getY() >= endPoint.getY()))
            return new Line2D.Double(x, y + height, x + width, y);
        else return new Line2D.Double(x, y, x + width, y + height);
    }

}