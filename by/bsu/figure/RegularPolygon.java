package by.bsu.figure;

import by.bsu.figure.Polygon;

import java.awt.*;
import java.util.ArrayList;

public class RegularPolygon extends Polygon {

    private int amountCount;
    private Point point;


    public RegularPolygon(ArrayList<Point> list, Color c, Color fill, int amountCount) {
        super(list, c, fill);
        this.amountCount = amountCount;
        this.point = list.get(0);
    }

    public static ArrayList<Point> getRegularList(Point center, Point start, int n) {
        ArrayList<Point> list = new ArrayList<>();

        double radius = Math.sqrt((start.getX() - center.getX()) * (start.getX() - center.getX()) +
                (start.getY() - center.getY()) * (start.getY() - center.getY()));

        for (int i = 0; i < n; i++) {
            double x = start.getX() + radius * Math.cos(2.0 * Math.PI * i / n);
            double y = center.getY() + radius * Math.sin(2.0 * Math.PI * i / n);
            list.add(new Point((int) x, (int) y));
        }

        return list;
    }

}