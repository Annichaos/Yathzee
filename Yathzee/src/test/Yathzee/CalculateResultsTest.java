package test.Yathzee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Yatzee.CalculateResults;
import Yatzee.CalculateResults.listField;

class CalculateResultsTest {

private CalculateResults resultsList;
	
	public CalculateResultsTest() {
		
		this.resultsList = new CalculateResults();
	};
		
	@Test
	public void testGetResultAces()  {
		
		Integer[] dicesEyes = {1,2,3,5,5};
		Integer score = 0;
		try{
			score = resultsList.getResultScore(dicesEyes, listField.Aces);
		}
		catch(Exception e) {};
		assert score == 1;
		
	}
	
	@Test
	public void testGetResultTwos()  {
		
		Integer[] dicesEyes = {1,2,3,5,5};
		Integer score = 0;
		try{
			score = resultsList.getResultScore(dicesEyes, listField.Twos);
		}
		catch(Exception e) {};
		assert score == 2;
		
	}
	
	@Test
	public void testGetResultThrees()  {
		
		Integer[] dicesEyes = {1,2,3,5,5};
		Integer score = 0;
		try{
			score = resultsList.getResultScore(dicesEyes, listField.Threes);
		}
		catch(Exception e) {};
		assert score == 3;
		
	}
	
	@Test
	public void testGetResultFours()  {
		
		Integer[] dicesEyes = {1,4,3,5,4};
		Integer score = 0;
		try{
			score = resultsList.getResultScore(dicesEyes, listField.Fours);
		}
		catch(Exception e) {};
		assert score == 8;
		
	}
	
	@Test
	public void testGetResultFives()  {
		
		Integer[] dicesEyes = {1,4,3,5,4};
		Integer score = 0;
		try{
			score = resultsList.getResultScore(dicesEyes, listField.Fives);
		}
		catch(Exception e) {};
		assert score == 5;
		
	}
	
	@Test
	public void testGetResultSixes()  {
		
		Integer[] dicesEyes = {6,6,3,6,4};
		Integer score = 0;
		try{
			score = resultsList.getResultScore(dicesEyes, listField.Sixes);
		}
		catch(Exception e) {};
		assert score == 18;
		
	}
	
	@Test
	public void testGetResultFullHouse()  {
		
		Integer[] dicesEyes = {6,6,3,6,3};
		Integer score = 0;
		try{
			score = resultsList.getResultScore(dicesEyes, listField.FullHouse);
		}
		catch(Exception e) {};
		assert score == 25;
		
	}
	
	@Test
	public void testGetResultThreeOfAKind()  {
		
		Integer[] dicesEyes = {6,6,3,6,4};
		Integer score = 0;
		try{
			score = resultsList.getResultScore(dicesEyes, listField.ThreeOfAKind);
		}
		catch(Exception e) {};
		assert score == 18;
		
	}
	
	@Test
	public void testGetResultChance()  {
		
		Integer[] dicesEyes = {6,6,3,6,6};
		Integer score = 0;
		try{
			score = resultsList.getResultScore(dicesEyes, listField.Chance);
		}
		catch(Exception e) {};
		assert score == 27;
		
	}
	
	@Test
	public void testGetResultFourOfAKind()  {
		
		Integer[] dicesEyes = {6,6,3,6,6};
		Integer score = 0;
		try{
			score = resultsList.getResultScore(dicesEyes, listField.FourOfaKind);
		}
		catch(Exception e) {};
		assert score == 24;
		
	}
	
	@Test
	public void testGetResultKniffel()  {
		
		Integer[] dicesEyes = {6,6,6,6,6};
		Integer score = 0;
		try{
			score = resultsList.getResultScore(dicesEyes, listField.Kniffel);
		}
		catch(Exception e) {};
		assert score == 50;
		
	}
	
	@Test
	public void testGetResultLargeStraight()  {
		
		Integer[] dicesEyes = {2,4,3,5,6};
		Integer score = 0;
		try{
			score = resultsList.getResultScore(dicesEyes, listField.LargeStraight);
		}
		catch(Exception e) {};
		assert score == 40;
		
	}
	
	@Test
	public void testGetResultSmallStraight()  {
		
		Integer[] dicesEyes = {1,6,3,4,2};
		Integer score = 0;
		try{
			score = resultsList.getResultScore(dicesEyes, listField.SmallStraight);
		}
		catch(Exception e) {};
		assert score == 30;
		
	}
	
	@Test
	public void testIsAValidResultFours()  {
		
		Integer[] dicesEyes = {1,4,3,5,4};
		boolean isValid = false;
		try{
			isValid = resultsList.isValidResult(dicesEyes, listField.Fours);
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
			};
		assert isValid;
		
	}
	
	@Test
	public void testIsAValidResultSmallStraight()  {
		
		boolean isValid = false;
		Integer[] dicesEyes = {5,6,3,4,5};
		
		try{
			isValid = resultsList.isValidResult(dicesEyes, listField.SmallStraight);
		}
		catch(Exception e) {};
		assert isValid;
		
	}
	
	@Test
	public void testIsAvAValidResultLargeStraight()  {
		
		boolean isValid = false;
		Integer[] dicesEyes = {2,6,3,4,5};
		
		try{
			isValid = resultsList.isValidResult(dicesEyes, listField.LargeStraight);
		}
		catch(Exception e) {};
		assert isValid;
		
		isValid = false;
		Integer[] dicesEyeNotStraight = {3,6,3,4,1};
		
		try{
			isValid = resultsList.isValidResult(dicesEyeNotStraight, listField.LargeStraight);
		}
		catch(Exception e) {};
		assert !isValid;
		
	}
	
	@Test
	public void testIsAValidResultFullHouse()  {
		
		Integer[] dicesEyes = {1,4,3,5,4};
		boolean isValid = true;
		try{
			isValid = resultsList.isValidResult(dicesEyes, listField.FullHouse);
		}
		catch(Exception e) {};
		assert !isValid;
		
		Integer[] dicesEyes2 = {1,4,4,1,4};
		isValid = false;
		try{
			isValid = resultsList.isValidResult(dicesEyes2, listField.FullHouse);
		}
		catch(Exception e) {};
		assert isValid;
		
	}
	
	@Test
	public void testIsAValidResultFourOfAKind()  {
		
		Integer[] dicesEyes = {1,4,3,5,4};
		boolean isValid = true;
		try{
			isValid = resultsList.isValidResult(dicesEyes, listField.FourOfaKind);
		}
		catch(Exception e) {};
		assert !isValid;
		
		Integer[] dicesEyes2 = {1,4,4,4,4};
		isValid = false;
		try{
			isValid = resultsList.isValidResult(dicesEyes2, listField.FourOfaKind);
		}
		catch(Exception e) {};
		assert isValid;
		
	}
	
	@Test
	public void testIsAValidResultThreeOfAKind()  {
		
		Integer[] dicesEyes = {1,4,3,5,4};
		boolean isValid = true;
		try{
			isValid = resultsList.isValidResult(dicesEyes, listField.ThreeOfAKind);
		}
		catch(Exception e) {};
		assert !isValid;
		
		Integer[] dicesEyes2 = {1,4,4,1,4};
		isValid = false;
		try{
			isValid = resultsList.isValidResult(dicesEyes2, listField.ThreeOfAKind);
		}
		catch(Exception e) {};
		assert isValid;
		
	}
	
	@Test
	public void testIsAValidFullHouse()  {
		
		Integer[] dicesEyes = {1,4,3,5,4};
		boolean isValid = true;
		try{
			isValid = resultsList.isValidResult(dicesEyes, listField.FullHouse);
		}
		catch(Exception e) {};
		assert !isValid;
		
		Integer[] dicesEyes2 = {1,4,4,1,4};
		isValid = false;
		try{
			isValid = resultsList.isValidResult(dicesEyes2, listField.FullHouse);
		}
		catch(Exception e) {};
		assert isValid;
		
	}

	/**the Message "The result field hasn't been found." is not for test.It should never been thrown.
	 *  There will be a result for every Listfield. 
	 *  That is the reason the JUnitmethod 
	 *  @Test
	 *  public void testIsAValidThrowsException(){
	 *  is not programmed. The test would require a exception like this
	 *  assert exception.getMessage() == "No enum constant Kniffel.ResultsList.listField.full";
	 *  assert exception.getClass() == IllegalArgumentException.class;
	 *  as response. 
	*/
		

}
