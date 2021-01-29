package Yatzee;

public class CalculateResults {
	
	public enum listField { 
		Aces (0), Twos(0) , Threes(0) , 
		Fours (0), Fives(0) , Sixes (0), ThreeOfAKind (0), FourOfaKind(0) , 
		FullHouse (25), SmallStraight (30), LargeStraight(40) ,
		Kniffel (50), Chance(0) ; 

		private Integer score;

		listField( int score ){
			this.score = score;
		}

		public Integer getScore () {
			return this.score;
			}

	};
	
	public CalculateResults() {};
		
	public Integer getResultScore ( Integer[] dicesEyes , listField lF) throws IllegalArgumentException{

		switch(lF) {

		case Aces :

			return sumPoints( dicesEyes, 1 );

		case Twos	:	

			return sumPoints( dicesEyes, 2 );

		case Threes :

			return sumPoints( dicesEyes, 3 );


		case Fours :

			return sumPoints( dicesEyes, 4);

		case Fives :

			return sumPoints( dicesEyes, 5 );

		case Sixes :

			return sumPoints( dicesEyes, 6 );

		case ThreeOfAKind :

			return ofAKindResult ( dicesEyes , 3 );

		case FourOfaKind :
			
			return ofAKindResult ( dicesEyes , 4 );

		case FullHouse , LargeStraight, SmallStraight, Kniffel :

			return lF.getScore();

		case Chance :
			
			return sumDicesScore( dicesEyes , lF);
			
		default:
			
			throw new IllegalArgumentException("The result field hasn't been found.");

		}
	}
	
	private Integer sumPoints( Integer[] dicesEyes, Integer eye) {
		Integer score = 0;
		for ( int i = 0 ; i < 5 ; i++) {
			
			if ( dicesEyes[i] == eye ) {
				score = score + dicesEyes[i];
			}
			
		}
		return score;
	}

	public boolean isValidResult ( Integer[] dicesEyes , listField lF ) throws IllegalArgumentException {
		
		switch(lF) {
		
		case Aces, Twos, Threes, Fours, Fives, Sixes, Chance :
			
			return true;
			
		case FullHouse:
			
			return isValidFullHouse ( dicesEyes );
			
		case Kniffel:
			
			return isValidKniffel ( dicesEyes );
						
		case SmallStraight :
			
			return isAValidStraight( dicesEyes , 4 );
					
		case LargeStraight :
			
			return isAValidStraight( dicesEyes , 5 );
			
		case FourOfaKind :
			
			return isValidOfAKind( dicesEyes , 4 );
			
		case ThreeOfAKind :
			
			return isValidOfAKind( dicesEyes, 3 );
			
		default :
			
			throw new IllegalArgumentException("The result field hasn't been found.");

		}
	}

	private boolean isValidOfAKind( Integer[] dicesEyes, Integer timesOfAKind) {

		Integer ofAKindEye = 0;
		Integer countOfAKind = 0;
		
		for ( int diceScore = 1 ; diceScore < 7; diceScore++) {
			ofAKindEye = diceScore ;
			for ( int i = 0 ; i < 5 ; i++) {
				
				if ( dicesEyes[i] == ofAKindEye) {
					countOfAKind = countOfAKind + 1; 
					}
				if ( countOfAKind == timesOfAKind ) {return true;}
			}
			
			countOfAKind = 0;
		}
			
		return false;
		
	}

	private boolean isValidKniffel( Integer[] dicesEyes) {
		Integer fiveScores = 5;
		Integer scoreCount = 0;
		int scoreValue1 = dicesEyes[0];
		for ( int i = 0 ; i < 5 ; i++) {
			
			
			if (scoreValue1 == dicesEyes[i]) {
				scoreCount = scoreCount + 1 ; 
			}else{
				return false;
			};
			
			if ( scoreCount == fiveScores ) { return true; }
		
		}
		return false;
	}

	private boolean isValidFullHouse( Integer[] dicesEyes) {
		Integer twoScores = 2;
		Integer threeScores = 3;
		Integer scoreValue2 = 0;
		Integer scoreValue = dicesEyes[0];
		Integer scoreCount = 0;
		//find as many dices with the same score as you can and count how many they are.
		for ( int i = 0 ; i < 5 ; i++) {
			
		
			if (scoreValue == dicesEyes[i]) {
				scoreCount = scoreCount + 1 ; 
			}else{
				scoreValue2 = dicesEyes[i];
			};
			
		
		}
		
		if ( scoreValue2 == 0 ) { return false; }
		/** to find dices with a different result,
		 *  there should be only one since we have dive dices and we need one result two times and one result threetimes,
		 *   the dices are searched for a different result than the first time. 
		 */
		if ( scoreCount == threeScores ) {
			scoreCount = 0;
			for ( int i = 0 ; i < 5 ; i++) {
				
				if (scoreValue2 == dicesEyes[i]) { scoreCount = scoreCount + 1 ; };
			}
			if ( scoreCount == twoScores ) {
				return true;
			}
		}else if( scoreCount == twoScores){
			scoreCount = 0;
			for ( int i = 0 ; i < 5 ; i++) {
				if (scoreValue2 == dicesEyes[i]) { scoreCount = scoreCount + 1 ; };
			}
			if ( scoreCount == threeScores ) {
				return true;
			}
			/**if the result of the first dice haven't been found two ore free times,
			*the dices aren't valid to be a full house. 
			*/
		}else{
			return false;
		};
		return false;
	}

	private boolean isAValidStraight( Integer[] dicesEyes, Integer straightLength)
	{

		boolean straightStartNotFound = true;
		

		// find a dice score with a value less or equal 2 to get the starting of the straight.

		int straightIterrator = 0;
		Integer straightEye = 1; //dices eyes start with value 1

		while (straightStartNotFound) {
			// the Startvalue that is found has to be the smallest and less or equal than the maximum of a dicescore
			// minus the length of the streat plus one, because the dices eyes do not start with zero;
			while ( straightIterrator < 5 ) {
				
				if ( straightEye != null && straightEye <= dicesEyes[straightIterrator] ) {
					// the start value of the straight.
					straightIterrator = straightIterrator + 1;
					straightStartNotFound = false;
				}

			}
			
			straightEye = straightEye + 1;
			
		}


		boolean straightResultFound;
		
		// this Loop counts up straightEye straightlengths times  
		for (int j = 0; j < straightLength; j ++ ) {
			straightResultFound = false;
			/**
			 * in this Loop it is checked if the eyes of the current dice are equal the straighteye,
			 *  which is counted up after this Loop.
			 */
			for ( int i = 0 ; i < 5 ; i++) {
				if ( dicesEyes[i] == straightEye ) {
					straightResultFound = true;
				}
			}
			if (straightResultFound) {
				straightEye = straightEye + 1;
			}else {
				return false;
			}
		}

		return true;
	}

	private Integer ofAKindResult ( Integer[] dicesEyes , Integer ofAKind) {
		
		Integer score;
		Integer ofAKindEye = 0;
		Integer countOfAKind = 0;
		
		for ( int diceScore = 1 ; diceScore < 7; diceScore++) {
			ofAKindEye = diceScore ;
			for ( int i = 0 ; i < 5 ; i++) {
				
				if ( dicesEyes[i] == ofAKindEye) {
					countOfAKind = countOfAKind + 1; 
					}
				if ( countOfAKind == ofAKind ) {break;}
			}
			
			countOfAKind = 0;
		}
		
		score = ofAKind * ofAKindEye;	
		return score;
		
	}
	
	private Integer sumDicesScore(Integer[] dicesEyes , listField lF) {
		
		Integer score = 0;
			
		for ( int i = 0 ; i < 5 ; i++) {
			
			score = score + dicesEyes[i];			
		}
		
		return score;
		
	}
	
	
	  
	//look up .getField

}
