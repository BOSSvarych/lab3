/* Decompiler 8ms, total 168ms, lines 27 */
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Клас TitlesFrame є підкласом JFrame і представляє вікно програми з кривими фігурами.
 */
public class TitlesFrame extends JFrame {
   public TitlesFrame() {
      this.initUI();
   }
/**
* Метод, який ініціалізує графічний інтерфейс вікна.
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
