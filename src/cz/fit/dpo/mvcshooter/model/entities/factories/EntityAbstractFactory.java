package cz.fit.dpo.mvcshooter.model.entities.factories;

import cz.fit.dpo.mvcshooter.model.entities.Enemy;
import cz.fit.dpo.mvcshooter.model.entities.Missile;

public interface EntityAbstractFactory {

	public Enemy createEnemy();
	public Missile createMissile(int x, int y, int velocity, int angle);
	
}
