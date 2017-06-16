package cz.fit.dpo.mvcshooter;

import cz.fit.dpo.mvcshooter.controller.Controller;
import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.entities.factories.RealisticWorldFactory;
import cz.fit.dpo.mvcshooter.view.MainWindow;

import javax.swing.SwingUtilities;

/**
 *
 * @author stue
 */
public class Shooter {
    
    public static void main(String[] args) {

    	//tady se vybira Strategy
        final Model model = new Model(new RealisticWorldFactory());
        final Controller controller = new Controller(model);
        
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
               new MainWindow(model, controller).setVisible(true);
            }
        });
    }
}
