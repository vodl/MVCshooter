package cz.fit.dpo.mvcshooter.model.entities;

import java.util.Set;

import cz.fit.dpo.mvcshooter.model.ModelConfig;
import cz.fit.dpo.mvcshooter.model.entities.factories.EntityAbstractFactory;
import cz.fit.dpo.mvcshooter.model.entities.factories.NormalWorldFactory;
import cz.fit.dpo.mvcshooter.model.entities.states.AbstractFireModeState;
import cz.fit.dpo.mvcshooter.model.entities.states.DoubleFireState;
import cz.fit.dpo.mvcshooter.model.entities.states.SingleFireState;
import cz.fit.dpo.mvcshooter.model.entities.strategies.Shootable;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Cannon extends GameObject {
    
    private int angle = ModelConfig.CANNON_DEFAULT_ANGLE;
    private int force = ModelConfig.CANNON_DEFAULT_FORCE;
    private AbstractFireModeState fireMode;
    private EntityAbstractFactory world;

    public Cannon() {
        super(ModelConfig.CANNON_X, ModelConfig.CANNON_DEFAULT_Y);
        world = new NormalWorldFactory();
        fireMode = new SingleFireState(); 
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    public void setFireMode(int mode){
    	if (mode == 1){
    		this.fireMode = new SingleFireState();
    	}
    	else {
    		this.fireMode = new DoubleFireState();
    	}
    }
   

    public int getForce() {
        return force;
    }

    public int getAngle() {
        return angle;
    }
    
    public void moveUp() {
        if (y >= ModelConfig.CANNON_TOP_MARGIN) {
            y -= ModelConfig.CANNON_MOVE_STEP;
        }
    }
    
    public void moveDown() {
        if (y <= ModelConfig.PLAYGROUND_HEIGHT - ModelConfig.CANNON_BOTTOM_MARGIN) {
            y +=  ModelConfig.CANNON_MOVE_STEP;
        }
    }
    
    public void aimUp() {
        if (angle < ModelConfig.CANNON_MAX_UP_ANGLE) {
            angle += ModelConfig.CANNON_AIM_STEP;
        }
    }
    
    public void aimDown() {
        if (angle > ModelConfig.CANNON_MAX_DOWN_ANGLE) {
            angle -= ModelConfig.CANNON_AIM_STEP;
        }
    }
    
    public void forceUp() {
        if (force < ModelConfig.CANNON_MAX_FORCE) {
            force += ModelConfig.CANNON_FORCE_STEP;
        }
    }
    
    public void forceDown() {
        if (force > ModelConfig.CANNON_MIN_FORCE) {
            force -= ModelConfig.CANNON_FORCE_STEP;
        }
    }

	@Override
	public void acceptVisitor(EntitiesVisitor visitor) {
		visitor.visit(this);		
	}
    
    /* cv 5 missile shoot*/
    public Set<Missile> shoot(EntityAbstractFactory creator){
    	return fireMode.fire(creator, x,y, force,angle);
    }
    
}
