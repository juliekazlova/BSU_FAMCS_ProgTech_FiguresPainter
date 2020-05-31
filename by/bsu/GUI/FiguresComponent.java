package by.bsu.GUI;

import by.bsu.figure.*;
import by.bsu.figure.Circle;
import by.bsu.figure.Ellipse;
import by.bsu.figure.Polygon;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class FiguresComponent extends JComponent {

    private int countPoints = 0;
    private Point startPoint;
    private Point endPoint;

    private int polygonPointsCount = 0;
    private ArrayList<Point> polygonPointsList;

    private static ArrayList<Figure> figures;
    private Figure currentShape;




    FiguresPanel buttonPanel;

    public FiguresComponent(JFrame frame) {
        figures = new ArrayList<>();
        currentShape = null;
        polygonPointsList = new ArrayList<>();
        buttonPanel = new FiguresPanel();

        JButton buttonDel = new JButton("Clear field");
        buttonDel.addActionListener(e -> {
            figures.clear();
            repaint();
        });


        JPanel panel = new JPanel();
        panel.add(buttonPanel);
        panel.add(buttonDel);

        Border etched = BorderFactory.createEtchedBorder();
        panel.setBorder(etched);

        frame.add(panel, BorderLayout.SOUTH);


        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;


        for (Figure e : figures)
            e.draw(g2);


    }


    public Figure findShape(Point p) {
        for (Figure e : figures) {
            if (e.contains(p)) return e;
        }
        return null;
    }

    public void add(Point startPoint, Point endPoint) {

        switch (buttonPanel.getSelectedShape()) {
            case "Ellipse":
                currentShape = new Ellipse(startPoint, endPoint, buttonPanel.getBorderColor(), buttonPanel.getFillColor());
                break;
            case "Circle":
                currentShape = new Circle(startPoint, endPoint, buttonPanel.getBorderColor(), buttonPanel.getFillColor());
                break;
            case "Segment":
                currentShape = new Section(startPoint, endPoint, buttonPanel.getBorderColor());
                break;
            case "Ray":
                currentShape = new Ray(startPoint, Ray.getNewEndPoint(startPoint, endPoint), buttonPanel.getBorderColor());
                break;
            case "Line":
                currentShape = new Line(Line.getNewStartPoint(startPoint, endPoint), Line.getNewEndPoint(startPoint, endPoint), buttonPanel.getBorderColor());
                break;
            case "Regular Polygon":
                currentShape = new RegularPolygon(RegularPolygon.getRegularList(startPoint, endPoint, FiguresPanel.countSides), buttonPanel.getBorderColor(), buttonPanel.getFillColor(), FiguresPanel.countSides);
                break;
            case "Square":
                currentShape = new Square(RegularPolygon.getRegularList(startPoint, endPoint, 4), buttonPanel.getBorderColor(), buttonPanel.getFillColor());
                break;

        }


        figures.add(currentShape);
        repaint();
    }

    public void addPolygons(ArrayList<Point> list) {
        switch ((buttonPanel.getSelectedShape())) {
            case "Polygon":
                currentShape = new Polygon(polygonPointsList, buttonPanel.getBorderColor(), buttonPanel.getFillColor());
                break;
        }

        figures.add(currentShape);
        repaint();
    }


    private class MouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent event) {

            currentShape = findShape(event.getPoint());

            if (currentShape == null && !buttonPanel.getSelectedShape().equals("Polygon")) {
                if (countPoints == 0) {
                    startPoint = event.getPoint();
                    countPoints++;
                } else if (countPoints == 1) {
                    endPoint = event.getPoint();
                    add(startPoint, endPoint);
                    countPoints = 0;
                }
            } else if (currentShape == null && buttonPanel.getSelectedShape().equals("Polygon")) {


                if (polygonPointsCount < FiguresPanel.countSides - 1) {
                    polygonPointsList.add(new Point(event.getPoint()));
                    polygonPointsCount++;
                } else if (polygonPointsCount == FiguresPanel.countSides - 1) {
                    polygonPointsList.add(event.getPoint());
                    addPolygons(polygonPointsList);
                    polygonPointsCount = 0;
                    polygonPointsList.clear();
                }
            }


        }

        public void mouseClicked(MouseEvent event) {

        }
    }

    private class MouseMotionHandler implements MouseMotionListener {
        public void mouseMoved(MouseEvent event) {

        }

        public void mouseDragged(MouseEvent event) {

            if (currentShape != null) {
                currentShape.move(event.getPoint());
                repaint();
            }


        }
    }



}