import java.awt.*;
import javax.swing.*;

public class CarFrame{

  public static void main(String[] args) {
    //JOptionPane.showMessageDialog(null, "Hello, World!");
    final int ICON_WIDTH = 400;
    final int ICON_HEIGHT = 100;
    final int width = 100;

    JFrame frame = new JFrame();
    frame.setLayout(new FlowLayout());

    final CarShape shape = new CarShape(50,30,width);

    ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);

    JLabel label = new JLabel(icon);

    JButton zoomIn = new JButton("Zoom In");
    JButton zoomOut = new JButton("Zoom Out");

    frame.add(zoomIn);
    frame.add(zoomOut);
    frame.add(label);

    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    zoomIn.addActionListener(event -> {
      shape.increaseSize();
      label.repaint();
    });
    zoomOut.addActionListener(event -> {
      shape.decreaseSize();
      label.repaint();
    });

  }


}
