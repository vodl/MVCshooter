package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.ModelConfig;

import java.util.Random;

/**
 *
 * @author Ondrej Stuchlik
 */
public abstract class Enemy extends TimedGameObject {
    protected static final Random random = new Random();
    
    private int type;

    public Enemy(int x, int y) {
        super(x, y);
        type = random.nextInt(2);
    }
    
    public Enemy(){
    	super(random.nextInt(ModelConfig.PLAYGROUND_WIDTH), random.nextInt(ModelConfig.PLAYGROUND_HEIGHT));
    	type = random.nextInt(2);
    }
    
    public boolean shouldBeDiscarted() {
        return super.shouldBeDiscarted(ModelConfig.ENEMY_LIVE_TIME);
    }

    public int getType() {
        return type;
    }

	public void acceptVisitor(EntitiesVisitor visitor) {
		visitor.visit(this);
	}
	
	public abstract void move();
    
}
