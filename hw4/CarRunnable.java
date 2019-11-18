import java.util.concurrent.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CarRunnable
{
  private static JLabel label;
  private static CarShape car;

  public CarRunnable(JLabel label, CarShape car){
    this.label = label;
    this.car = car;
  }

  public static Runnable threadTimer(int delay)
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
}
