package CSC.CodeForces_input_test.Codeforce.Contest_1;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestInfixToPostfix{
	InfixToPostfix infixToPostfix = new InfixToPostfix("8 9+1 7-*");
	
	@Test
	public void iterator_test( ){
		assertEquals("ABC+D* +", infixToPostfix.run().out);
	}
}
