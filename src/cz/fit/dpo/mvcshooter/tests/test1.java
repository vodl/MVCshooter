package cz.fit.dpo.mvcshooter.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import cz.fit.dpo.mvcshooter.memento.Caretaker;
import cz.fit.dpo.mvcshooter.memento.Memento;
import cz.fit.dpo.mvcshooter.memento.Originator;
import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.factories.EntityAbstractFactory;

public class test1 {

	@Test
	public void test_memento_1() {
		Originator originator = new Originator();
		Caretaker caretaker = new Caretaker();
		Model mock=mock(Model.class);
		
		//Model model = new Model(null);
		
		 originator.set(mock);
		 Memento memento = originator.storeInMemento();
         caretaker.addMemento(memento);
         assertEquals(caretaker.getMemento(0), memento);
	}
	
	@Test
	public void test_memento_2() {
		Originator originator = new Originator();
		Caretaker caretaker = new Caretaker();
		
		Model mock=mock(Model.class);
		when(mock.getScore()).thenReturn(1);
		
		 originator.set(mock);
		 Memento memento = originator.storeInMemento();
         caretaker.addMemento(memento);
         
         assertEquals(originator.restoreFromMemento(memento).getScore(), mock.getScore());
	}
	
	
	
}
