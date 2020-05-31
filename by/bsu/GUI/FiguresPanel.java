package by.bsu.GUI;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FiguresPanel extends JPanel {

    private String selectedShape = "Ellipse";
    private Color borderColor=Color.black;
    private Color fillColor=Color.BLUE;
    public static int countSides = 3;

    public FiguresPanel() {

        JMenuBar menuBar = new JMenuBar();
        JMenu figureMenu = new JMenu("Figure type");
        JMenu colorMenu = new JMenu("Color");

        JMenuItem lineItem = new JMenuItem("line");
        JMenuItem rayItem = new JMenuItem("ray");
        JMenuItem sectionItem = new JMenuItem("section");
        JMenuItem ellipseItem = new JMenuItem("ellipse");
        JMenuItem circleItem = new JMenuItem("circle");
        JMenuItem squareItem = new JMenuItem("square");
        JMenuItem regularPolygonItem = new JMenuItem("regular polygon");


        figureMenu.add(lineItem);
        figureMenu.add(rayItem);
        figureMenu.add(sectionItem);
        figureMenu.add(ellipseItem);
        figureMenu.add(circleItem);
        figureMenu.add(sectionItem);
        figureMenu.add(squareItem);
        figureMenu.add(regularPolygonItem);


        JMenuItem borderColorItem = new JMenuItem("borders");
        JMenuItem fillColorItem = new JMenuItem("fill");

        colorMenu.add(borderColorItem);
        colorMenu.add(fillColorItem);

        menuBar.add(figureMenu);
        menuBar.add(colorMenu);
        add(menuBar);

        lineItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedShape="Line";
            }
        });

        rayItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedShape="Ray";
            }
        });

        sectionItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedShape="Segment";
            }
        });


        squareItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedShape="Square";
            }
        });

        regularPolygonItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedShape="Regular Polygon";
                countSides=Integer.parseInt(JOptionPane.showInputDialog("Type in sides number"));

            }
        });

        ellipseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedShape="Ellipse";
            }
        });

        circleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedShape="Circle";
            }
        });

        borderColorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borderColor = JColorChooser.showDialog(null,
                        "Border Color", Color.black);
            }
        });

        fillColorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillColor = JColorChooser.showDialog(null,
                        "Border Color", Color.black);
            }
        });
    }



    public String getSelectedShape() {
        return selectedShape;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public Color getFillColor() {
        return fillColor;
    }
}
