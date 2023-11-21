/* Decompiler 18ms, total 178ms, lines 69 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Клас TitlesPanel є панеллю для відображення анімованих фігур.
 */
public class TitlesPanel extends JPanel implements ActionListener {
   private Graphics2D g2d;
   private Timer animation;
   private boolean is_done = true;
   private int start_angle = 0;
   private int shape;

   public TitlesPanel(int _shape) {
      this.shape = _shape;
      this.animation = new Timer(50, this);
      this.animation.setInitialDelay(50);
      this.animation.start();
   }

   	/**
     * Метод, що викликається при події таймера. Викликає перефарбовування панелі.
     *
     * @param arg0 подія ActionEvent
     */
   public void actionPerformed(ActionEvent arg0) {
      if (this.is_done) {
         this.repaint();
      }

   }

   	/**
     * Метод, який виконує малювання фігур на панелі.
     *
     * @param g графічний контекст для малювання
     */
   private void doDrawing(Graphics g) {
      this.is_done = false;
      this.g2d = (Graphics2D)g;
      this.g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      Dimension size = this.getSize();
      Insets insets = this.getInsets();
      int w = size.width - insets.left - insets.right;
      int h = size.height - insets.top - insets.bottom;
      ShapeFactory shape = new ShapeFactory(this.shape);
      this.g2d.setStroke(shape.stroke);
      this.g2d.setPaint(shape.paint);
      double angle = (double)(this.start_angle++);
      if (this.start_angle > 360) {
         this.start_angle = 0;
      }

      double dr = 90.0D / ((double)w / ((double)shape.width * 1.5D));

      for(int j = shape.height; j < h; j = (int)((double)j + (double)shape.height * 1.5D)) {
         for(int i = shape.width; i < w; i = (int)((double)i + (double)shape.width * 1.5D)) {
            angle = angle > 360.0D ? 0.0D : angle + dr;
            AffineTransform transform = new AffineTransform();
            transform.translate((double)i, (double)j);
            transform.rotate(Math.toRadians(angle));
            this.g2d.draw(transform.createTransformedShape(shape.shape));
         }
      }

      this.is_done = true;
   }

   	/**
     * Перевизначений метод для малювання компоненту.
     *
     * @param g графічний контекст для малювання
     */
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      this.doDrawing(g);
   }
}
