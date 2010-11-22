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

import java.math.BigInteger;

/**
 * The calculator.
 * 
 * @author GreenD
 *
 */
public class Calculator {

	private static final BigInteger TEN = new BigInteger("10");
	
	private static final BigInteger ZERO = new BigInteger("0");
	
	// The last number, before operator
	private BigInteger lastNumber = ZERO;
	
	// The operation we'll apply
	private Operation operation = null;
	
	// The current number being entered
	private BigInteger currNumber = null;

	/**
	 * Appends a digit - what happens when a user presses a number key.
	 * 
	 * @param digit
	 * @throws IllegalArgumentException
	 */
	public void digit( int digit ) {
		if( (digit < 0) || (digit > 9) ) {
			throw new IllegalArgumentException("Invalid digit: "+digit);
		}
		if( currNumber != null ) {
			currNumber = currNumber.multiply(TEN).add(BigInteger.valueOf(digit));
		} else {
			currNumber = BigInteger.valueOf(digit);
		}
	}

	public void add() {
		setOperation( new AddOperation() );
	}

	public void subtract() {
		setOperation( new SubtractOperation() );
	}

	public void multiply() {
		setOperation( new MultiplyOperation() );
	}
	
	public void divide() {
		setOperation( new DivideOperation() );
	}

	/**
	 * Sets the operation we're working on.
	 * If there is already an operation and a previous number (e.g. we have 2 + 2 _)
	 * then calculate the first operation first and stash the result.
	 * <p>
	 * Because operations are calculated left first operator precedence is not honoured.
	 * E.g. 2 + 3 * 2
	 * Returns 10 not 8
	 * 
	 * I.e. process as (2+3)*2 not 2+(3*2)
	 * 
	 * @param operation
	 */
	private void setOperation( Operation operation ) {
		// If we have an operation (e.g. 1+2) calculate it first
		equals();
		
		this.operation = operation;
	}
			
	/**
	 * Calculates the current operation - what happens when the user presses =
	 */
	public void equals() {
		if( operation != null ) {
			// Calculate operation
			lastNumber = operation.apply(lastNumber, (currNumber != null?currNumber:lastNumber) );
		} else if( currNumber != null ) {
			// Stash the currently edited number, so it's no longer editable
			lastNumber = currNumber;
		} else {
			// Do nothing, leave last number alone
		}
		currNumber = null;
		operation = null;
	}
	
	/**
	 * Reset the calculator
	 */
	public void clear() {
		currNumber = null;
		lastNumber = ZERO;
		operation = null;
	}
	
	/**
	 * @return The amount to display on the calculator screen
	 */
	public String getDisplayAmount() {
		if( currNumber == null ) {
			return lastNumber.toString();
		}
		return currNumber.toString();
	}
}
