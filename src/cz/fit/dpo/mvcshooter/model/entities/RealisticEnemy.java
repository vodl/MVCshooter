package cz.fit.dpo.mvcshooter.model.entities;

import java.util.Random;

public class RealisticEnemy extends Enemy{

	@Override
	public void move() {
	        //double time = (new Long(System.currentTimeMillis() - beginTime)).doubleValue();
	       // time /= 100;
	        x = (int) (x + random.nextInt(2) - random.nextGaussian());// + random.nextGaussian()); //- random.nextInt(1)*(-1);
	        y = (int) (y +random.nextInt(2) - random.nextGaussian()); //- random.nextInt(1)*(-1);
	              //+ (0.5 * Math.pow(time,2)));		
		
			
		
	}
	

}
