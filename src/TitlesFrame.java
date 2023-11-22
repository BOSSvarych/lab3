/* Decompiler 8ms, total 168ms, lines 27 */
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * The class TitlesFrame is a subclass of JFrame and represents the program window with curved shapes.
 */
public class TitlesFrame extends JFrame {
   public TitlesFrame() {
      this.initUI();
   }
/**
* The method that initializes the graphical interface of the window
*/
   private void initUI() {
      this.setTitle("Криві фігури");
      this.setDefaultCloseOperation(3);
      this.add(new TitlesPanel(78));
      this.setSize(350, 350);
      this.setLocationRelativeTo((Component)null);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            TitlesFrame ps = new TitlesFrame();
            ps.setVisible(true);
         }
      });
   }
}
