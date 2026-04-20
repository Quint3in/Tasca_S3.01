### 1. Què estava malament?
***Cada clase gestionava el takeDamage diferent i no seguien el principi***

### 2. Per què incomplia el principi?
***Perquè una subclasse no es podia substituir per la superclasse***

### 3. Quina solució has aplicat i per què?
***He creat la interface PhysicalDamage amb clases que implementant. 
I es gestiona amb un atribut PhysicalDamage perquè cadascun
tinguin el seu comportament sense modificar el métode.

