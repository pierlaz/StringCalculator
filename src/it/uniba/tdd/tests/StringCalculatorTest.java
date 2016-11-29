package it.uniba.tdd.tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import it.uniba.tdd.StringCalculator;
import it.uniba.tdd.StringCalculatorException;

public class StringCalculatorTest {

	@Test
	public void emptyStringReturns0() throws StringCalculatorException {
		int ris = StringCalculator.add("");

		assertEquals(ris, 0);
	}

	@Test
	public void oneNumberStringReturnsTheNumber() throws StringCalculatorException {
		int ris = StringCalculator.add("3");

		assertEquals(ris, 3);
	}

	@Test
	public void twoNumbersStringReturnsTheirSum() throws StringCalculatorException {
		int ris = StringCalculator.add("3,91");

		assertEquals(ris, 94);
	}

	@Test
	public void fiveNumbersStringReturnsTheirSum() throws StringCalculatorException {
		int ris = StringCalculator.add("3,9,12,6");

		assertEquals(ris, 30);
	}
	
	@Test
	public void numbersStringWithNewLineSeparatorWorks() throws StringCalculatorException{
		int ris = StringCalculator.add("3,9,12\n6");

		assertEquals(ris, 30);
	}
	
	@Test
	public void numbersStringWithNewDelimiterAtTheBeginningWorks() throws StringCalculatorException{
		int ris = StringCalculator.add("//-\n1-2-7");
		
		assertEquals(ris, 10);
	}
	
	@Test
	public void numbersStringWithOneThousandDoesNotSum() throws StringCalculatorException{
		int ris = StringCalculator.add("1,2,5,3,1001");
		
		assertEquals(ris,11);
	}
	
	@Test(expected = StringCalculatorException.class)
	public void negativeNumbersThrowsException() throws StringCalculatorException{
		StringCalculator.add("1,2,5,-3");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void numbersStringWithMinusAsDelimiterAndNegativeNumber() throws StringCalculatorException{
		StringCalculator.add("//-\n1-2--7");
	}
	
	@Test
	public void numbersStringWithDelimiterWithTwoChars() throws StringCalculatorException{
		int ris = StringCalculator.add("//[__]\n1__2__7");
		
		assertEquals(ris,10);
	}
	
	@Test
	public void numbersStringWithDelimitersWithTwoChars() throws StringCalculatorException{
		int ris = StringCalculator.add("//[__][oP][,,]\n1__1002oP7,,90,,1");
		
		assertEquals(ris,99);
	}

}
