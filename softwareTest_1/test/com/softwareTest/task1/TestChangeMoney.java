package com.softwareTest.task1;


import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;



@RunWith(Parameterized.class)
public class TestChangeMoney {
	int num;
	boolean expected ;
	ChangeMoney cm = null;
	
	
	public TestChangeMoney(int num , boolean b) {
		this.num = num;
		this.expected = b;
	}
	
	@Before
	public void setUp(){
		cm = new ChangeMoney();
	}
	
	@Parameters
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][]{
			{1,true},
			{2,true},
			{3,true},
			{100,false}
			});
	}
	
	
	@Test
	public void testChangeMoney() {
		assertEquals(this.expected,cm.judge(this.num));
	}
	
	
	
}
