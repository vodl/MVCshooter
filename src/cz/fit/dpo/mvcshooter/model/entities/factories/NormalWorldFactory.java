package cz.fit.dpo.mvcshooter.model.entities.factories;

import cz.fit.dpo.mvcshooter.model.entities.Enemy;
import cz.fit.dpo.mvcshooter.model.entities.Missile;
import cz.fit.dpo.mvcshooter.model.entities.NormalEnemy;
import cz.fit.dpo.mvcshooter.model.entities.NormalMissile;

public class NormalWorldFactory implements EntityAbstractFactory {

	@Override
	public Enemy createEnemy() {
		return new NormalEnemy();
	}

	@Override
	public Missile createMissile(int x, int y, int velocity, int angle) {
		return new NormalMissile(x,y,velocity,angle);
	}

}
