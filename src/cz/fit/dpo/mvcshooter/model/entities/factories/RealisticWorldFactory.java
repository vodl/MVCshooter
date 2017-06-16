package cz.fit.dpo.mvcshooter.model.entities.factories;

import cz.fit.dpo.mvcshooter.model.entities.Enemy;
import cz.fit.dpo.mvcshooter.model.entities.Missile;
import cz.fit.dpo.mvcshooter.model.entities.RealisticEnemy;
import cz.fit.dpo.mvcshooter.model.entities.RealisticMissile;

public class RealisticWorldFactory implements EntityAbstractFactory{

	@Override
	public Enemy createEnemy() {
		// TODO Auto-generated method stub
		return new RealisticEnemy();
	}


	@Override
	public Missile createMissile(int x, int y, int velocity, int angle) {
		return new RealisticMissile(x, y, velocity, angle);
	}

}
