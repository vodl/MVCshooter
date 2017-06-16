package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.ModelConfig;

/**
 *
 * @author Ondrej Stuchlik
 */
public abstract class Missile extends GameObject {
    protected static double DEGREE_TO_RAD_MULTIPLIER = (2 * Math.PI) / 360;
    protected int beginVelocity;
    protected double beginAngleInRad;
    protected int beginX;
    protected int beginY;
    protected long beginTime;

    public Missile(int x, int y, int velocity, int angle) {
        super(x, y);
        this.beginVelocity = velocity;
        this.beginAngleInRad = angle * DEGREE_TO_RAD_MULTIPLIER;
        this.beginX = x;
        this.beginY = y;
        this.beginTime = System.currentTimeMillis();
    }

    public boolean shouldBeDiscarted() {
        // don't discard based on y coord, it can still fall down
        return x > ModelConfig.PLAYGROUND_WIDTH;
    }

    public abstract Missile move(int gravity) ;

	public void acceptVisitor(EntitiesVisitor visitor) {
		visitor.visit(this);
	}

}
