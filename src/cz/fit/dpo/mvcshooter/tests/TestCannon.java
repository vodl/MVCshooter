package cz.fit.dpo.mvcshooter.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.factories.EntityAbstractFactory;

public class TestCannon {
	@Test
	public void test_cannon() {
		Cannon cannon = new Cannon();		
		EntityAbstractFactory mock = mock(EntityAbstractFactory.class);				
        assertEquals(cannon.shoot(mock).size(), 1);
	}
	
	@Test
	public void test_cannon2() {
		Cannon cannon = new Cannon();	
		cannon.setFireMode(0);
		EntityAbstractFactory mock = mock(EntityAbstractFactory.class);				
        assertEquals(cannon.shoot(mock).size(), 1);
	}
	
	@Test
	public void test_cannon3() {
		Cannon cannon = new Cannon();	
		cannon.setFireMode(1);
		EntityAbstractFactory mock = mock(EntityAbstractFactory.class);				
        assertEquals(cannon.shoot(mock).size(), 1);
	}
	
	@Test
	public void test_cannon4() {
		Cannon cannon = new Cannon();	
		cannon.setFireMode(2);
		EntityAbstractFactory mock = mock(EntityAbstractFactory.class);				
        assertEquals(cannon.shoot(mock).size(), 2);
	}

}
