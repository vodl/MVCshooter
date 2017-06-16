package cz.fit.dpo.mvcshooter.model.entities;

public interface VisitableByEntitiesVisitor {
	public void acceptVisitor(EntitiesVisitor visitor);
}
