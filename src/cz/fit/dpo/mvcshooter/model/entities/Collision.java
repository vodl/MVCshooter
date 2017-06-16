package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.ModelConfig;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Collision extends TimedGameObject {

    public Collision(int x, int y) {
        super(x, y);
    }
    
    public boolean shouldBeDiscarted() {
        return super.shouldBeDiscarted(ModelConfig.COLLISION_LIVE_TIME);
    }


	public void acceptVisitor(EntitiesVisitor visitor) {
		visitor.visit(this);
	}
    
}
