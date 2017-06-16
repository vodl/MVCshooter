package cz.fit.dpo.mvcshooter.model;

public interface Subject {

	public void registerObservers(ModelObserver observer);
	public void removeObservers(ModelObserver observer);
	public void notifyObservers();
}
