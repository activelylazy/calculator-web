/**
   Copyright 2010 David Green

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.example.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests calculator functionality.
 * 
 * @author GreenD
 *
 */
public class CalculatorTest {
	
	@Test
	public void appendingDigitAppearInDisplay() {
		Calculator calculator = new Calculator();
		
		calculator.digit(1);
		calculator.digit(2);
		calculator.digit(3);
		
		assertEquals("123",calculator.getDisplayAmount());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void appendingNonDigitsCausesError() {
		Calculator calculator = new Calculator();
		
		calculator.digit(10);
	}
	
	@Test
	public void displayIsZeroInitially() {
		Calculator calculator = new Calculator();
		
		assertEquals("0",calculator.getDisplayAmount());
	}
	
	@Test
	public void appendingLeadingZerosIgnored() {
		Calculator calculator = new Calculator();
		
		calculator.digit(0);
		calculator.digit(0);
		calculator.digit(1);
		
		assertEquals("1",calculator.getDisplayAmount());
	}
	
	@Test
	public void appendAfterOperatorDisplaysOnlyNewNumber() {
		Calculator calculator = new Calculator();
		
		calculator.digit(2);
		calculator.add();
		calculator.digit(3);
		
		assertEquals("3",calculator.getDisplayAmount());
	}
	
	@Test
	public void addTwoNumbers() {
		Calculator calculator = new Calculator();
		
		calculator.digit(2);
		calculator.add();
		calculator.digit(3);
		calculator.equals();
		
		assertEquals("5",calculator.getDisplayAmount());
	}
	
	@Test
	public void subtractTwoNumbers() {
		Calculator calculator = new Calculator();
		
		calculator.digit(3);
		calculator.subtract();
		calculator.digit(1);
		calculator.equals();
		
		assertEquals("2",calculator.getDisplayAmount());
	}
	
	@Test
	public void multiplyTwoNumbers() {
		Calculator calculator = new Calculator();
		
		calculator.digit(2);
		calculator.multiply();
		calculator.digit(3);
		calculator.equals();
		
		assertEquals("6",calculator.getDisplayAmount());
	}
	
	@Test
	public void divideTwoNumbers() {
		Calculator calculator = new Calculator();
		
		calculator.digit(6);
		calculator.divide();
		calculator.digit(3);
		calculator.equals();
		
		assertEquals("2",calculator.getDisplayAmount());
	}
	
	@Test
	public void addThreeNumbers() {
		Calculator calculator = new Calculator();
		
		calculator.digit(2);
		calculator.add();
		calculator.digit(3);
		calculator.add();
		calculator.digit(4);
		calculator.equals();
		
		assertEquals("9",calculator.getDisplayAmount());
	}
	
	@Test
	public void clear() {
		Calculator calculator = new Calculator();
		
		calculator.digit(2);
		calculator.add();
		calculator.digit(3);
		calculator.clear();
		
		assertEquals("0",calculator.getDisplayAmount());
	}
	
	@Test
	public void equalsWithNoOperatorDoesNothing() {
		Calculator calculator = new Calculator();
		
		calculator.digit(2);
		calculator.equals();
		
		assertEquals("2",calculator.getDisplayAmount());
	}
	
	@Test
	public void displayShowsFirstNumberAfterOperator() {
		Calculator calculator = new Calculator();
		
		calculator.digit(2);
		calculator.add();
		
		assertEquals("2",calculator.getDisplayAmount());
	}
	
	@Test
	public void enterNumberWithoutOperatorClearsPrevious() {
		Calculator calculator = new Calculator();
		
		calculator.digit(2);
		calculator.add();
		calculator.digit(5);
		calculator.equals();
		
		assertEquals("7",calculator.getDisplayAmount());
		
		calculator.digit(3);
		
		assertEquals("3",calculator.getDisplayAmount());
	}
	
	@Test
	public void enterNumberWithoutOperatorClearsOperator() {
		Calculator calculator = new Calculator();
		
		calculator.digit(2);
		calculator.add();
		calculator.digit(5);
		calculator.equals();
		
		assertEquals("7",calculator.getDisplayAmount());
		
		calculator.digit(3);
		calculator.equals();	// Ensure no operator, otherwise we won't get 3 when we apply
		
		assertEquals("3",calculator.getDisplayAmount());
	}
	
	@Test
	public void enterAfterEqualsClears() {
		Calculator calculator = new Calculator();
		
		calculator.digit(2);
		calculator.equals();
		
		assertEquals("2",calculator.getDisplayAmount());
		
		calculator.digit(3);
		
		assertEquals("3",calculator.getDisplayAmount());
	}
	
	@Test
	public void operationAfterEquals() {
		Calculator calculator = new Calculator();
		
		calculator.digit(6);
		calculator.subtract();
		calculator.digit(3);
		calculator.equals();
		calculator.subtract();
		calculator.digit(2);
		calculator.equals();
		
		assertEquals("1",calculator.getDisplayAmount());
	}
	
	@Test
	public void startWithOperator() {
		Calculator calculator = new Calculator();
		
		calculator.add();
		calculator.digit(3);
		calculator.equals();
		
		assertEquals("3",calculator.getDisplayAmount());
	}
	
	@Test
	public void multipleEquals() {
		Calculator calculator = new Calculator();
		
		calculator.digit(3);
		calculator.equals();
		calculator.equals();
		
		assertEquals("3",calculator.getDisplayAmount());
	}
	
	@Test
	public void equalsAfterOperator() {
		Calculator calculator = new Calculator();
		
		calculator.digit(2);
		calculator.add();
		calculator.equals();
		
		assertEquals("4",calculator.getDisplayAmount());
	}
}
