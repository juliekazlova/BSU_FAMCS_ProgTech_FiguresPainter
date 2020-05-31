package by.bsu.figure;

import java.awt.*;

public abstract class Figure {

    private Color borderColor;

    public Figure(Color c) {
        borderColor = c;
    }

    public abstract void draw(Graphics2D g);

    public abstract void move(Point newCenter);

    public abstract boolean contains(Point point);

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

}