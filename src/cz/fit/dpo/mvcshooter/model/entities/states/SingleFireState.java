package cz.fit.dpo.mvcshooter.model.entities.states;

import java.util.HashSet;
import java.util.Set;

import cz.fit.dpo.mvcshooter.model.entities.Missile;
import cz.fit.dpo.mvcshooter.model.entities.factories.EntityAbstractFactory;

public class SingleFireState extends AbstractFireModeState{

	@Override
	public Set<Missile> fire(EntityAbstractFactory factory, int x, int y,
			int force, int angle) {
		shots.add(factory.createMissile(x, y, force, angle));
		return shots;
	}

}
