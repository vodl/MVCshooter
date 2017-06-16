package cz.fit.dpo.mvcshooter.model.entities.states;

import java.util.HashSet;
import java.util.Set;

import cz.fit.dpo.mvcshooter.model.entities.Missile;
import cz.fit.dpo.mvcshooter.model.entities.factories.EntityAbstractFactory;

public abstract class AbstractFireModeState {
	public AbstractFireModeState() {
		super();
		this.shots = new HashSet<Missile>();
	}
	Set<Missile> shots;
	public abstract Set<Missile> fire(EntityAbstractFactory factory, int x, int y, int force, int angle);
}
