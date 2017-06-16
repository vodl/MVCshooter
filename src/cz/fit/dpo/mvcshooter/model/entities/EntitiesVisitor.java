package cz.fit.dpo.mvcshooter.model.entities;

public interface EntitiesVisitor {
	
	public void visit(Cannon cannon);
	public void visit(Enemy enemy);
	public void visit(Collision collision);
	public void visit(Missile missile);

}
