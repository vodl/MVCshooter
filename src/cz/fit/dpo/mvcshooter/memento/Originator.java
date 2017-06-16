package cz.fit.dpo.mvcshooter.memento;

import cz.fit.dpo.mvcshooter.model.Model;

public class Originator {
     Model model;
     
     public void set(Model model){
    	 this.model = model;
     }
     
     public Memento storeInMemento(){
    	 return new Memento(model);
     }
     
     public Model restoreFromMemento(Memento memento){
    	 return memento.getSavedModel();
     }
}
