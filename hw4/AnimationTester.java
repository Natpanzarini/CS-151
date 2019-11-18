import java.util.concurrent.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   This program implements an animation that moves
   a car shape.
*/
public class AnimationTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      CarShape car1 = new CarShape(10,50,CAR_WIDTH);
      CarShape car2 = new CarShape(10,50,CAR_WIDTH);
      CarShape car3 = new CarShape(10,50,CAR_WIDTH);

      ShapeIcon icon = new ShapeIcon(car1, ICON_WIDTH, ICON_HEIGHT);
      ShapeIcon icon2 = new ShapeIcon(car2, ICON_WIDTH, ICON_HEIGHT);
      ShapeIcon icon3 = new ShapeIcon(car3, ICON_WIDTH, ICON_HEIGHT);

      final JLabel label = new JLabel(icon);
      final JLabel label2 = new JLabel(icon2);
      final JLabel label3 = new JLabel(icon3);

      frame.add(label);
      frame.add(label2);
      frame.add(label3);

      frame.setLayout(new FlowLayout());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      ExecutorService service = Executors.newCachedThreadPool();

      Runnable r1 = threadTimer(label,car1,20);
      Runnable r2 = threadTimer(label2,car2,80);
      Runnable r3 = threadTimer(label3,car3,240);

      service.execute(r1);
      service.execute(r2);
      service.execute(r3);
      service.shutdown();
   }

   public static Runnable threadTimer(JLabel label, CarShape car, int delay)
   {
     return () ->
     {
         Timer t = new Timer(delay, event ->
            {
               car.move();
               label.repaint();
            });
         t.start();
     };
   }

   private static final int ICON_WIDTH = 400;
   private static final int ICON_HEIGHT = 100;
   private static final int CAR_WIDTH = 100;
}
