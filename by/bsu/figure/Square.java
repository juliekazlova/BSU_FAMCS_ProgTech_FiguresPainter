package by.bsu.figure;

import java.awt.*;
import java.util.ArrayList;

public class Square extends Polygon{
    private int amountCount=4;
    private Point point;


    public Square(ArrayList<Point> list, Color c, Color fill) {
        super(list, c, fill);
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
