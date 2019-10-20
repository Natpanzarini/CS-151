import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class question1{
  public static void main(String[] args) {
    LabeledRectangle temp = new LabeledRectangle(50,50,200,100,"Label");

    JFrame frame = new JFrame("Problem 1");

    LabeledRectangleComponent component = new LabeledRectangleComponent(temp);


    frame.add(component);

    frame.pack();
    frame.setSize(300,300);
    frame.getContentPane().setSize(300,300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }



}
