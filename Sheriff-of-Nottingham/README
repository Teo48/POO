Copyright Teodor Matei - 323 CA
				 _____ _               _  __  __ 
				/  ___| |             (_)/ _|/ _|
				\ `--.| |__   ___ _ __ _| |_| |_ 
				 `--. | '_ \ / _ | '__| |  _|  _|
				/\__/ | | | |  __| |  | | | | |  
				\____/|_| |_|\___|_|  |_|_| |_| 
						          __ 
						         / _|
						    ___ | |_ 
						   / _ \|  _|
						  | (_) | |  
						   \___/|_|  
	 _   _       _   _   _             _                     
	| \ | |     | | | | (_)           | |                    
	|  \| | ___ | |_| |_ _ _ __   __ _| |__   __ _ _ __ ___  
	| . ` |/ _ \| __| __| | '_ \ / _` | '_ \ / _` | '_ ` _ \ 
	| |\  | (_) | |_| |_| | | | | (_| | | | | (_| | | | | | |
	\_| \_/\___/ \__|\__|_|_| |_|\__, |_| |_|\__,_|_| |_| |_|
	                              __/ |                      
	                             |___/                       

! Tab size: 4 is required for a better experience xD
           
The homework consisted in implementing a minimalistic version of the Sheriff
of Nottingham boardgame.

============================================================================

The project structure is the following:
com
   |_goods
	     |_ Goods, GoodsFactory, GoodsType, IllegalGoods, LegalGoods
   |_main
   		 |_ GameInput, GameInputLoader, Main, SheriffOfNottingham
   |_Players
   			|_ Basic, Bribed, Greedy, PlayersFactory
   |_utils
   		  |_ Constants, Deck, GoodsComparator, Pair, Reader

*main package*
--------------
 - GameInputLoader
 	I changed a little bit the load() method using the Reader class for
 	faster parsing of the input.
 - SheriffofNottingham
 	Class that implements the game logic. Here we read the data from the
 	gameinput, we create an instantce of the deck(using singleton pattern)
 	and then we add cards to it and collect the info about the players
 	(Their IDs and which type they are).
 	The method that actually executes the game is implemented here alongside
 	the ones used for computing the final score plus the bonuses and printing
 	the final leaderboard.

*Players package*
-----------------
- PlayersFactory
   Implementation of factory pattern for the players.

				  UML chart

			 ___________________
			|       BASIC       |
			|___________________|
 					  ^
 					  |
 			__________|__________		  
 		   |					 |
 ___________________		___________________
|       Greedy      | 	   |       Bribed      | 
|___________________|	   |___________________|

- Basic
	Class that implements the Basic player from which the other two are going
	to be extended(Greedy and Bribed). I didn't see a reason to implement
	something like a Player class from which the Basic is going to be extended
	since the other type of players are extdend from Basic.
- Greedy
	Class that implements the Greedy player. It overrides the playSheriff() and
	playMerchant() methods from Basic to follow the strategy a Greedy player has.
	This class is final since there is no reason for it to be extended.
- Bribed
	Class that implements the Bribe player. It overrides the playSheriff() and
	playMerchant() methods from Basic to follow the strategy a Bribe player has.
	This class is final since there is no reason for it to be extended.

*utils package*
---------------
- Constants
	Utility class for needed constants.
- Deck
	Class the implements the deck of cards required for the game using singleton
	pattern.
- GoodsComparator
	Class that implements a Comparator for Goods.
- Pair
	A generic implementation of a simple container with two elements.
	The first element is referenced as ‘first’ and the second element
	as ‘second’ and the order is fixed (first, second).
- Reader
	Class that implements methods for fast input parsing.
	It only implements parsing methods for Integers and Strings.