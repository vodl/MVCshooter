package cz.fit.dpo.mvcshooter.memento;

import java.util.ArrayList;
import java.util.List;

import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.Collision;
import cz.fit.dpo.mvcshooter.model.entities.Enemy;
import cz.fit.dpo.mvcshooter.model.entities.Missile;

public class Memento {
	
	private Cannon cannon;
	private Model model;
	
	private List<Missile> missileList;
    private List<Enemy> enemyList;
    private List<Collision> colissionList;
    
	private int  gravity;
    private int  score;
    
	public Memento(Cannon cannon, List<Missile> missileList,
			List<Enemy> enemyList, List<Collision> colissionList, int gravity,
			int score) {
		super();
		
		this.cannon = cannon;
		this.missileList = missileList;
		this.enemyList = enemyList;
		this.colissionList = colissionList;
		
		this.gravity = gravity;
		this.score = score;
	}
	
	public Memento(Model model) {
		super();
		
		this.cannon = model.getCannon();
		this.missileList =  new ArrayList<Missile>(model.getMissileList());
		this.enemyList =  new ArrayList<Enemy>(model.getEnemyList());
		this.colissionList = new ArrayList<Collision>(model.getCollisionList());
		
		this.gravity = model.getGravity();
		this.score = model.getGravity();
	}
	
	public Model getSavedModel(){
		return new Model(this.gravity, this.score);
	   //new Model(this.cannon, model.getObserverList(), this.missileList, this.enemyList, this.colissionList, model.getWorld(), this.gravity, this.score);
	}

}
