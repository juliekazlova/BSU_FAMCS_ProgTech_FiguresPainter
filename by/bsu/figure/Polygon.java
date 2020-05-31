package by.bsu.figure;

import by.bsu.figure.TwoDimentionalFigure;

import java.awt.*;
import java.util.ArrayList;

public class Polygon extends TwoDimentionalFigure {

    private ArrayList<Point> listOfPoints;
    private int[] arrayX;
    private int[] arrayY;
    private java.awt.Polygon polygon;
    private Point check = null;

    public Polygon(ArrayList<Point> list, Color c, Color fill) {
        super(c, fill);
        listOfPoints = new ArrayList<>(list);
        int size = list.size();
        arrayX = new int[size];
        arrayY = new int[size];

        for (int i = 0; i < size; i++) {
            arrayX[i] = (int) list.get(i).getX();
            arrayY[i] = (int) list.get(i).getY();
        }

        polygon = new java.awt.Polygon(arrayX, arrayY, size);

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(getFillColor());
        g.fill(polygon);
        g.setColor(getBorderColor());
        g.draw(polygon);
    }

    public ArrayList<Point> getListOfPoints() {
        return null;
    }

    public void move(Point newCenter) {
        if (check == null) {
            check = new Point(listOfPoints.get(0));
        }

        double newCenterX = newCenter.getX();
        double newCenterY = newCenter.getY();

        double oldCenterX = check.getX();
        double oldCenterY = check.getY();


        int dx = (int) ((newCenterX - oldCenterX));
        int dy = (int) ((newCenterY - oldCenterY));

        check.setLocation(newCenter);
        polygon.translate(dx, dy);


    }

    @Override
    public boolean contains(Point point) {
        return polygon.contains(point);

    }

    public void setListOfPoints(ArrayList<Point> listOfPoints) {
        this.listOfPoints = listOfPoints;
    }

    public int[] getArrayX() {
        return arrayX;
    }

    public void setArrayX(int[] arrayX) {
        this.arrayX = arrayX;
    }

    public int[] getArrayY() {
        return arrayY;
    }

    public void setArrayY(int[] arrayY) {
        this.arrayY = arrayY;
    }

    public java.awt.Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(java.awt.Polygon polygon) {
        this.polygon = polygon;
    }

    public Point getCheck() {
        return check;
    }

    public void setCheck(Point check) {
        this.check = check;
    }
}