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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

/**
 * @author GreenD
 *
 */
public class CalculateController extends ParameterizableViewController {

	// The calculator
	private Calculator calculator;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		char button = request.getParameter("button").charAt(0);
		if( (button >= '0') && (button <= '9') ) {
			calculator.digit(Integer.parseInt(""+button));
		} else {
			switch(button) {
			case '+':
				calculator.add();
				break;
			case '-':
				calculator.subtract();
				break;
			case '*':
				calculator.multiply();
				break;
			case '/':
				calculator.divide();
				break;
			case '=':
				calculator.equals();
				break;
			case 'C':
				calculator.clear();
				break;
			}
		}
		
		ModelAndView mav = super.handleRequestInternal(request, response);
		mav.addObject("displayAmount",calculator.getDisplayAmount());
		return mav;
	}

	@Required
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	
}
