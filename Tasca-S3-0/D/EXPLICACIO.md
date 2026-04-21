### 1. Què estava malament?
***La classe de servei depenia d'una classe concreta 
com `MySql`.***

### 2. Per què incomplia el principi?
***Perquè `ServicePerson` havia de dependre d'una
abstracció i no d'una implementació concreta. Això 
també dificultava l'extensió del codi.***

### 3. Quina solució has aplicat i per què?
***He creat la interface `DataBase` i l'he injectat
a `ServicePerson`. Així es poden afegir noves bases
de dades sense modificar el servei.***