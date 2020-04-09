*LABS*
------
- Lab01: Java Basics
- Lab02: Constructori si referinte
- Lab03: Agregare si mostenire
- Lab04: Static, Final si Singleton
- Lab05: Clase abstracte si interfete
- Lab06: Clase interne
- Lab07: Overriding, Overloading & Visitor
- Lab08: Colectii
- Lab09: Genericitate
- Lab10: Exceptii
- Lab11: Design Patterns-1
- Lab12: Design Patterns-2

*Sheriff-Of-Nottingham*
-----------------------
- Tema 1

*League-Of-OOP*
---------------
- Proiect - Etapele 1 & 2





 _____ _            _                     _ 
|  __ (_)          | |                   | |
| |  \/_  __ _  ___| |     __ _ _ __   __| |
| | __| |/ _` |/ _ \ |    / _` | '_ \ / _` |
| |_\ \ | (_| |  __/ |___| (_| | | | | (_| |
 \____/_|\__, |\___\_____/\__,_|_| |_|\__,_|
          __/ |                             
         |___/                              





 _____ _            _                     _ 
|  __ (_)          | |                   | |
| |  \/_  __ _  ___| |     __ _ _ __   __| |
| | __| |/ _` |/ _ \ |    / _` | '_ \ / _` |
| |_\ \ | (_| |  __/ |___| (_| | | | | (_| |
 \____/_|\__, |\___\_____/\__,_|_| |_|\__,_|
          __/ |                             
         |___/                              

*Bani*
------

- Pentru setul de instructiuni de tip 1:

	Ideea
	------
		- Consideram fiecare tip de bancnota ca fiind radacina unui arbore.
		  Copii sai vor fi tipurile de banconte care urmeaza. Numarul de moduri in care pot aranja n bancnote incepand cu bancnota X va fi chiar numarul de frunze din arbore, care este 2^(n - 1), considerand ca radacina se afla pe nivelul 1 (adica am o singura bancnota de aranjat).

		  Spre exemplu: Fie bancnota de 10 lei radacina. Dupa ea urmeaza mereu una de 50 lei sau 100 de lei. La randul lor, dupa una de 50 lei urmeaza una 10 lei sau 200 lei, respectiv 10 lei sau 100 lei pentru cea de 100 si asa mai departe.
		  					10			-> n = 1
		  				 /      \	
		  				50       100	-> n = 2
		  			   /  \     /  \	
		  			 10   200  10   100	-> n = 3
		  		  ..........................

		 Aplicand acelasi rationament si pentru celelalte bancnote se obtine formula nr_moduri_de_asezare = 5 * 2^(n - 1).

- Pentru setul de instructiuni de tip 2:
	
	Ideea
	------
		- Pornim de la aceeasi idee cu asezarea bancnotelor intr-un arbore. De
		  aceasta data banconta de 200 lei va genera 3 copii, motiv pentru care numarul de frunze de pe nivelul i va depinde de nivelul anterior. -> Programare dinamica xD
		  Fie dp[i][j] -> numarul de moduri in care pot aseza i bancnote avand bancnota j ca radacina.

		  Asociem urmatoarele:

		  	- Pentru j = 1: 10 lei.
		  	- Pentru j = 2: 50 lei.
		  	- Pentru j = 3: 100 lei.
		  	- Pentru j = 4: 200 lei.
		  	- Pentru j = 5: 500 lei.

		  Atunci:
		  	- dp[i][j] va fi suma numarului de moduri in care pot aseza bancnotele de pe nivelul anterior care urmeaza dupa bancnota j.
		  	Spre exemplu, pentru j = 1 avem:
		  		dp[i][1] = dp[i - 1][2] + dp[i - 1][3]. Analog si pentru celelalte tipuri de bancnote.

		  Numarul total de moduri in care putem aseza cele n bancnote va fi dat de suma tutoror elementelor de pe linia n.

		  Observam ca tot timpul ne raportam numai la nivelul anterior, fapt pentru care e suficient sa retinem doar doua linii in matrice, ceea ce ne va ajuta in obtinerea unei complexitati spatiale mai bune.

		  Cazuri de baza:
		  	Dandu-se 2 bancnote (n = 2), in cate moduri putem aseza bancnotele incepand cu fiecare bancnota ca radacina.
	  		dp[0][1] = 2; -> incepem cu bancnota 10;
			dp[0][2] = 2; -> incepem cu bancnota 50;
			dp[0][3] = 2; -> incepem cu bancnota 100;
			dp[0][4] = 3; -> incepem cu bancnota 200;
			dp[0][5] = 2; -> incepem cu bancnota 500;

	*Complexitate*
	--------------
		- Temporala:
			θ(logn) pentru tipul 1, deoarece avem de calculat 2^n - 1 realizand acest lucru cu ridicarea logaritmica la putere.
			θ(n) pentru tipul 2, deoarce parcurgem toate nivelele din asa-zisul arbore.
		- Spatiala:
			θ(1) - retinem o matrice de 2 linii, 6 coloane.


*Gard*
------
-
	Ideea
	------

    	- Sortam intervalele crescator dupa capatul din stanga, iar in caz de
    	  egalitate le sortam crescator dupa capatul din dreapta.

    	  Parcurgem intervalele sortate si le numaram pe cele care nu se suprapun. Numarul de garduri redundante va fi dat de diferenta dintre numarul total de intervale si cele care nu se suprapun.

   	*Complexitate*
	--------------

		- Temporala:
		θ(nlogn) pentru sortare + θ(n) pentru parcurgere => θ(nlogn).
		- Spatiala:
			θ(n) - retinem un array de n perechi de intervale.
