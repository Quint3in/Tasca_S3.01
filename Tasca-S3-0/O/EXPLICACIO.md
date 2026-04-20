### 1. Què estava malament?

***Tot el codi es trobava amb if else en una clase i això incumpleix la norma només afegir sense modificar, ja que és impossible
amb el canvi de fer diverses clases amb polimorfisme cada vegada que necesitem nous instruments diferents(if elses) només hem de crear una nova clase.***

### 2. Per què incomplia el principi?

***El codi estava tot en una clase InstrumentPlayer, ara Instrument Player no es modifica perquè li arriba la informació de les clases amb polimorfisme.

### 3. Quina solució has aplicat i per què?

***Crear una interface Instrument i clases de cada instrument que tinguin un mètode que retorni els missatges d'abans.***