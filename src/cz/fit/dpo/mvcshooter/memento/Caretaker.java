package cz.fit.dpo.mvcshooter.memento;

import java.util.ArrayList;

public class Caretaker {
	ArrayList<Memento> savedModels= new ArrayList<Memento>();
	
	public void addMemento(Memento m){ savedModels.add(m); }
	public Memento getMemento(int index) { return savedModels.get(index); }

}
