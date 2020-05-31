package by.bsu.GUI;

import javax.swing.*;
import java.awt.*;

public class FiguresFrame extends JFrame {

    public FiguresFrame() {
        setTitle("Figure painter");
        Toolkit kit = Toolkit.getDefaultToolkit();
        setSize(1500, 1000);
        FiguresComponent mtest = new FiguresComponent(this);
        add(mtest);
    }

}
