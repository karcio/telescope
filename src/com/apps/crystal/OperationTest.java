package com.apps.crystal;

import junit.framework.Assert;

import org.junit.Test;

public class OperationTest {

	@Test
	public void testCalculate() {
		Operation oper = new Operation();
		oper.calculate(650, 130);
		Assert.assertEquals(5, oper.getBrightness());
		Assert.assertEquals(21, oper.getMinimalMagnification());
		Assert.assertEquals(260, oper.getMaximalMagnification());

	}

}
