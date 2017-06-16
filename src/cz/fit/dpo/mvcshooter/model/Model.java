package cz.fit.dpo.mvcshooter.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.Collision;
import cz.fit.dpo.mvcshooter.model.entities.Enemy;
import cz.fit.dpo.mvcshooter.model.entities.GameObject;
import cz.fit.dpo.mvcshooter.model.entities.Missile;
import cz.fit.dpo.mvcshooter.model.entities.factories.EntityAbstractFactory;
import cz.fit.dpo.mvcshooter.model.entities.factories.NormalWorldFactory;
import cz.fit.dpo.mvcshooter.model.entities.factories.RealisticWorldFactory;
import cz.fit.dpo.mvcshooter.model.entities.states.AbstractFireModeState;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Model implements Subject {
    
    private Timer timer;
    private Cannon cannon;
    private List<ModelObserver> observerList;
    
    private List<Missile> missileList;
    private List<Enemy> enemyList;
    private List<Collision> colissionList;
    
    private EntityAbstractFactory world;
    private Mover mover;
    
	private int  gravity;
    private int  score;
    
    public Cannon getCannon() {
		return cannon;
	}
	
    public Model(int gravity, int score){
    	this(new RealisticWorldFactory());
    	this.gravity = gravity;
    	this.score = score;
    	
    }
	public Model(Cannon cannon, List<ModelObserver> observerList,
			List<Missile> missileList, List<Enemy> enemyList,
			List<Collision> colissionList, EntityAbstractFactory world,
			int gravity, int score) {
		this(world);
		mover = new Mover();
		this.cannon = cannon;
		this.world = world;
		
		this.observerList = observerList;
		this.missileList = missileList;
		this.enemyList = enemyList;
		this.colissionList = colissionList;
				
		this.gravity = gravity;
		this.score = score;
		
		initTimer();
	}


	public List<ModelObserver> getObserverList() {
		return observerList;
	}

	public List<Collision> getColissionList() {
		return colissionList;
	}

	public EntityAbstractFactory getWorld() {
		return world;
	}

	public Mover getMover() {
		return mover;
	}


	public int getGravity(){
		return gravity;
	}
	
	public int getScore(){
		return score;
	}
    private Random generator = new Random();
      

    public Model(EntityAbstractFactory world) {
    	this.world = world;
    	mover = new Mover();
        
        cannon = new Cannon();//jen zkousim
        observerList = new ArrayList<ModelObserver>();
        missileList = new ArrayList<Missile>();
        colissionList = new ArrayList<Collision>();
        enemyList = new ArrayList<Enemy>();
        
        gravity = ModelConfig.DEFAULT_GRAVITY;
        score = 0;
        
        for (int i = 0; i < ModelConfig.ENEMIES_COUNT; i++)
        	enemyList.add(world.createEnemy());
        
        initTimer();

    }
    
    public int getPlaygroundWidth() {
        return ModelConfig.PLAYGROUND_WIDTH;
    }

    public List<Missile> getMissileList() {
		return missileList;
	}
    
    public List<Enemy> getEnemyList() {
		return enemyList;
	}
    
    public List<Collision> getCollisionList(){
    	return colissionList;
    }

	public int getPlaygroundHeight() {
        return ModelConfig.PLAYGROUND_HEIGHT;
    }
    

    // ############################### private initialization ###############################
    private void initTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
 
            @Override
            public void run() {
            	moveObjects();
            }
        }
        , 0, ModelConfig.TICK_TIME);
    }
    
    public void setFireMode(int mode){
    	cannon.setFireMode(mode);
    }

	public void moveCannonDown() {
		cannon.moveDown();
		this.notifyObservers();		
	}
	
	public void moveObjects(){
		mover.moveMissiles(missileList, gravity);
		mover.moveEnemies(enemyList);
		score = mover.checkColissions(missileList, enemyList, colissionList, score);
		mover.discardOldObjects(missileList, enemyList, colissionList);
		mover.checkNumbers(enemyList, world);
		this.notifyObservers();
	}
	

	public void moveCannonUp() {
		cannon.moveUp();
		this.notifyObservers();
	}

	public void forceOfCannonDown() {
		cannon.forceDown();
		this.notifyObservers();
	}

	public void forceOfCannonUp() {
		cannon.forceUp();
		this.notifyObservers();
	}

	public void aimCannonUp() {
		cannon.aimUp();
		this.notifyObservers();
	}

	public void aimCannonDown() {
		cannon.aimDown();
		this.notifyObservers();
	}

	public void shootCannon() {
		missileList.addAll(cannon.shoot(world));
		this.notifyObservers();
	}

	public void increaseGravity() {
		gravity++;
		this.notifyObservers();				
	}

	public void decreaseGravity() {
		gravity--;
		this.notifyObservers();		
	}

	@Override
	public void registerObservers(ModelObserver observer) {
		observerList.add(observer);		
	}

	@Override
	public void removeObservers(ModelObserver observer) {
		observerList.remove(observer);
		
	}

	@Override
	public void notifyObservers() {
		for(ModelObserver observer : observerList){
			observer.modelUpdated();
		}
		
	}

    

    // ################################## private logic ##################################
    


}
