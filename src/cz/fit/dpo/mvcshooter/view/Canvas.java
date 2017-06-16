package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.Missile;
import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.ModelInfo;
import cz.fit.dpo.mvcshooter.model.ModelObserver;
import cz.fit.dpo.mvcshooter.model.entities.Collision;
import cz.fit.dpo.mvcshooter.model.entities.Enemy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Canvas extends JPanel implements ModelObserver {
    GraphicsDrawer drawer = new GraphicsDrawer();
    Model model;
    ModelInfo info;

    public Canvas(int x, int y, int width, int height, Model model) {
    	this.info = new ModelInfo();
        this.model = model;
        this.model.registerObservers(this);
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);
    }

    @Override
    public void modelUpdated() {
    	this.info = new ModelInfo(model.getCannon().getForce(), model.getCannon().getAngle(),model.getGravity(), model.getScore());
        repaint();
        //System.out.println("modelUpdated, takze repaintuju");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawer.drawInfo(g, info);
        
        drawer.drawCannon(g, model.getCannon());
        
        for(Missile missile : model.getMissileList()){
        	drawer.drawMissile(g, missile);    	
        }
        
        for(Enemy enemy : model.getEnemyList()){
        	drawer.drawEnemy(g, enemy);
        }
        
        for(Collision col : model.getCollisionList()){
        	drawer.drawCollision(g, col);
        }
        
    }

}
