package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.controller.Controller;
import cz.fit.dpo.mvcshooter.model.Model;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ondrej Stuchlik
 */
public class MainWindow extends JFrame {


    public MainWindow(Model model, final Controller controller) {
        try {
            controller.setView(this);
            Canvas view = new Canvas(
                  0, 0, model.getPlaygroundWidth(), model.getPlaygroundHeight(), model);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("MyShooter");
            this.setResizable(false);

            Dimension obrazovka = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(
                  (int) (obrazovka.getWidth() / 2 - 250),
                  (int) (obrazovka.getHeight() / 2 - 250));

            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent evt) {
                    controller.keyPressed(evt);
                }
            });

            this.add(view);
            this.pack();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
    
    public void showHelp() {
        JOptionPane.showMessageDialog(this, 
              "Controls: \n"
              + "arrows up/down     cannon vertical movement\n"
              + "arrows left/right     cannon force\n"
              + "page up/down        cannon angle\n"
              + "space                       shoot\n"
              + "home/end                gravity up/down");
    }
}
