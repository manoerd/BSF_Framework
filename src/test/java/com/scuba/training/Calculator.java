package com.scuba.training;

import java.lang.Math;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * The Calculator class provides static methods for
 *  arithmetic operations on two integers.
 */
public class Calculator {
	
	@DataProvider(name="data")
	public Object[][] getData() {
		return new Object[][] {
			{4,2},
			{6,3}
		};
	}
	
	@DataProvider(name="data1")
	public Object[][] getData1() {
		return new Object[][] {
			{4},
			{6}
		};
	}

	
	@Test(dataProvider="data",groups = {"arithmetic"})
   public void add(int number1, int number2) {	  
      System.out.println("Addition of "+number1+" & "+number2+" = "+ (number1 + number2));
   }
 
	@Test(dataProvider="data",groups = {"arithmetic"})
   public void sub(int number1, int number2) {
		System.out.println("Substraction of "+number1+" & "+number2+" = "+ (number1 - number2));
   }
 
	@Test(dataProvider="data")
   public void mul(int number1, int number2) {
		System.out.println("Multiplication of "+number1+" & "+number2+" = "+ (number1 * number2));
      
   }
 
   // Integer divide. Return a truncated int.
	@Test(dataProvider="data")
   public void divInt(int number1, int number2) {
      if (number2 == 0) {
         throw new IllegalArgumentException("Cannot divide by 0!");
      }
      else
      {
    	  System.out.println("Division of "+number1+" & "+number2+" = "+ (number1 / number2));
      }
   }
 
   // Real number divide. Return a double.
	@Test(dataProvider="data")
   public void divReal(int number1, int number2) {
      if (number2 == 0) {
         throw new IllegalArgumentException("Cannot divide by 0!");
      }
      else
      {
    	  System.out.println("Division of Real number "+number1+" & "+number2+" = "+ (double) (number1 / number2));
      }
   }
   
   
   // Exponent
	@Test(dataProvider="data")
   public void exp(double number1, double number2) {
      if (number2 == 0) {
         throw new IllegalArgumentException("Cannot divide by 0!!");
      }
      else
      {
    	  System.out.println("Exponent of "+number1+" & "+number2+" = "+ Math.pow(number1, number2));
      }
   }
   
   
   // Modulus
	@Test(dataProvider="data")
   public void mod(int number1, int number2) {
      if (number2 == 0) {
    	 
         throw new IllegalArgumentException("Cannot divide by 0!!");
      }
      else
      {
    	  System.out.println("Modulus of "+number1+" & "+number2+" = "+ (number1%number2));
      }
   }
       
     
   // Inverse
	@Test(dataProvider="data1",groups = {"mathematical"})
   public void inverse(int number1) {
      if (number1 == 0) {
         throw new IllegalArgumentException("Cannot divide by 0!");
      }
      else
      {
    	  System.out.println("Inverse of "+number1+" = "+ ((double) 1 / number1));
      }
   }
         
   
   // Negate
   @SuppressWarnings("deprecation")
   @Test(groups = {"mathematical"})
   @Parameters({"number3"})
public void negate(int number3) {
      if (number3 == 0) {
    	  Assert.assertEquals(0, number3);
    	  Assert.assertNotSame(1, number3);
    	  Assert.assertTrue(number3==0);
    	  Assert.assertFalse(number3!=0);
         throw new IllegalArgumentException("Cannot divide by 0!!");
      }
      else
      {
    	  Reporter.log("Negate of "+number3+" = "+ ((-1) * number3));
    	  System.out.println("Negate of "+number3+" = "+ ((-1) * number3));
      }
   }   
   
}