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

*Bani*
------
	Idea
	------
	- Pentru setul de instructiuni de tip 1:
		- Consideram fiecare tip de bancnota ca fiind radacina unui arbore.
		  Copii sai vor fi tipurile de banconte care urmeaza. Numarul de moduri in care pot aranja n bancnote incepand cu bancnota X va fi chiar numarul de frunze din arbore, care este 2^(n - 1), considerand ca radacina se afla pe nivelul 1 (adica am o singura bancnota de aranjat).

		  Spre exemplu: Fie bancnota de 10 lei radacina. Dupa ea urmeaza mereu una de 50 lei sau 100 de lei. La randul lor, dupa una de 50 lei urmeaza una 10 lei sau 200 lei, respectiv 10 lei sau 100 lei pentru cea de 100 si asa mai departe.
		  					10			-> n = 1
		  				 /      \	
		  				50       100	-> n = 2
		  			   /  \     /  \	
		  			 10   200  10   100	-> n = 3
		  		  ..........................

		 Aplicand acelasi rationament si pentru celelalte bancnote se obtine forumla nr_moduri_de_asezare = 5 * 2^(n - 1).
