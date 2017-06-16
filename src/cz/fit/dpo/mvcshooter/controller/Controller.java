package cz.fit.dpo.mvcshooter.controller;

import cz.fit.dpo.mvcshooter.memento.Caretaker;
import cz.fit.dpo.mvcshooter.memento.Originator;
import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.view.MainWindow;

import java.awt.event.KeyEvent;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Controller {

    private Model model;
    private MainWindow view;
    private Originator originator;
    private Caretaker caretaker;
    private int saves;

    public Controller(Model model) {
        this.model = model;
        this.originator = new Originator();
        this.caretaker = new Caretaker();
        this.saves = 0;
    }

    public void keyPressed(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                model.moveCannonDown();
                break;
            case KeyEvent.VK_UP:
                model.moveCannonUp();
                break;
            case KeyEvent.VK_LEFT:
                model.forceOfCannonDown();
                break;
            case KeyEvent.VK_RIGHT:
                model.forceOfCannonUp();
                break;
            case KeyEvent.VK_PAGE_UP:
                model.aimCannonUp();
                break;
            case KeyEvent.VK_PAGE_DOWN:
                model.aimCannonDown();
                break;
            case KeyEvent.VK_SPACE:
                model.shootCannon();
                break;
                
            case KeyEvent.VK_M:
            	model.setFireMode(1);
            	break;
            	
            case KeyEvent.VK_N:
            	model.setFireMode(2);
            	break;

            case KeyEvent.VK_HOME:
                model.increaseGravity();
                break;
            case KeyEvent.VK_END:
                model.decreaseGravity();
                break;

            case KeyEvent.VK_F:
                view.showHelp();
                break;
                
            case KeyEvent.VK_S:
                originator.set(model);
                caretaker.addMemento(originator.storeInMemento());
                saves++;
                System.out.println("Memento ulozen " + saves);
                break;
                
            case KeyEvent.VK_X:
            	if(saves > 0)
            	    this.model = originator.restoreFromMemento(caretaker.getMemento(saves - 1));
            	    System.out.println("Vybiram memento ");
            	
            	break;
        }
    }

    public void setView(MainWindow view) {
        this.view = view;
    }
}
