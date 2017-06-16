package cz.fit.dpo.mvcshooter.model.entities.states;

import java.util.Set;

import cz.fit.dpo.mvcshooter.model.entities.Missile;
import cz.fit.dpo.mvcshooter.model.entities.factories.EntityAbstractFactory;

public class DoubleFireState extends AbstractFireModeState{

	@Override
	public Set<Missile> fire(EntityAbstractFactory factory, int x, int y,
			int force, int angle) {
		
		Missile myMissile = factory.createMissile(x - 40, y, force, angle);
		/*
		for(int i = 0; i < 50; i++){
			myMissile.move(1);
		}*/
		shots.add(myMissile);
		shots.add(factory.createMissile(x, y, force, angle));
		return shots;
	}

}
