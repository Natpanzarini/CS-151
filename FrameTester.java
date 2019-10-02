import java.awt.*;
import javax.swing.*;

public class FrameTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      JButton redButton = new JButton("Repaint Red");
      JButton blueButton = new JButton("Repaint Blue");
      JButton greenButton = new JButton("Repaint Green");
      CircleIcon circle = new CircleIcon(50);
      JLabel label = new JLabel(circle);

      frame.setLayout(new FlowLayout());

      frame.add(redButton);
      frame.add(blueButton);
      frame.add(greenButton);
      frame.add(label);

      redButton.addActionListener(event -> circle.setColor(Color.RED));
      blueButton.addActionListener(event -> circle.setColor(Color.BLUE));
      greenButton.addActionListener(event -> circle.setColor(Color.GREEN));

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
