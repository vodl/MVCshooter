package cz.fit.dpo.mvcshooter.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import cz.fit.dpo.mvcshooter.model.entities.Collision;
import cz.fit.dpo.mvcshooter.model.entities.Enemy;
import cz.fit.dpo.mvcshooter.model.entities.Missile;
import cz.fit.dpo.mvcshooter.model.entities.factories.EntityAbstractFactory;

public class Mover {
	
	public void checkNumbers(List<Enemy> enemyList, EntityAbstractFactory factory){
		
		for(int i = 0; i < ModelConfig.ENEMIES_COUNT - enemyList.size(); i++ ){
			enemyList.add(factory.createEnemy());
		}
		
	}
	
	public void moveMissiles(List<Missile> missileList, int gravity){
		for(Missile missile : missileList){
			missile.move(gravity);
		}
	} 
	
	public void moveEnemies(List<Enemy> enemyList){
		for(Enemy enemy : enemyList){
			enemy.move();
		}
	} 

	private void discardOldMissiles(List<Missile> missileList){
		for (int i=missileList.size()-1; i> -1; i--) {
		    if (missileList.get(i).shouldBeDiscarted() ) {
		        missileList.remove(i);
		    }
		}
	}
	
	private void discardOldCollisions(List<Collision> colissionList){

		for (int i=colissionList.size()-1; i> -1; i--) {
		    if (colissionList.get(i).shouldBeDiscarted() ) {
		        colissionList.remove(i);
		    }
		}
	}
	
	private void discardOldEnemies(List<Enemy> enemyList){
		for (int i=enemyList.size()-1; i> -1; i--) {
		    if (enemyList.get(i).shouldBeDiscarted() ) {
		        enemyList.remove(i);
		    }
		}
	}
	
	public void discardOldObjects(List<Missile> missileList, List<Enemy> enemyList, List<Collision> colissionList){
		
		discardOldMissiles(missileList);
		discardOldCollisions(colissionList);
		discardOldEnemies(enemyList);
	
	}
	
	public int checkColissions(List<Missile> missileList, List<Enemy> enemyList, List<Collision> colissionList, int score){
		
		List<Integer> missileIndex = new Vector<Integer>();
		List<Integer> enemyIndex = new Vector<Integer>();
		
		for(Missile missile : missileList){
			for(Enemy enemy : enemyList){
				if(missile.collidesWith(enemy)){
					colissionList.add(new Collision(enemy.getX(), enemy.getY()));
					enemyIndex.add(enemyList.indexOf(enemy));
					missileIndex.add(missileList.indexOf(missile));
					score++;
				}
			}
		}
		
		for(int i : missileIndex){
			missileList.remove(i);
		}
		
		for (int i : enemyIndex){
			enemyList.remove(i);
		}
		
		return score;
	}

}
