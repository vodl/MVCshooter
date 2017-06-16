package cz.fit.dpo.mvcshooter.model.entities;

public class NormalMissile extends Missile {

	public NormalMissile(int x, int y, int velocity, int angle) {
		super(x, y, velocity, angle);
	}

	@Override
	public Missile move(int gravity) {
        double time = (new Long(System.currentTimeMillis() - beginTime)).doubleValue();
        time /= 100;
        x = (int) (beginX + (beginVelocity * time * Math.cos(beginAngleInRad)));
        y = (int) (beginY - (beginVelocity * time * Math.sin(beginAngleInRad))
              + (0.5 * Math.pow(time,2)));		
        return this;
	}

}
