package cz.fit.dpo.mvcshooter.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.entities.factories.EntityAbstractFactory;

public class TestGravity {
	@Test
	public void test_gravity() {
		EntityAbstractFactory mock = mock(EntityAbstractFactory.class);
		Model model = new Model(mock);
		
		model.increaseGravity();
		//Model model = new Model(null);
		
         
         assertEquals(model.getGravity(), 6);
	}


}
