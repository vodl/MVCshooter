package cz.fit.dpo.mvcshooter.model.entities;

public class RealisticMissile extends Missile{

	public RealisticMissile(int x, int y, int velocity, int angle) {
		super(x, y, velocity, angle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Missile move(int gravity) {
        double time = (new Long(System.currentTimeMillis() - beginTime)).doubleValue();
        time /= 100;
        x = (int) (beginX + (beginVelocity * time * Math.cos(beginAngleInRad)));
        y = (int) (beginY - (beginVelocity * time * Math.sin(beginAngleInRad))
              + (0.5 * gravity * Math.pow(time,2)));
        
        return this;
	}
	
	

}
