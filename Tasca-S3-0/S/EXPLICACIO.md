### 1. Què estava malament?
***Que contenia aquestes 3 altres responsabilitats dins del metode register:***

- ***Procés de registre d'usuari***
- ***Validació de dades d'usuari(email/password)***
- ***Envio d'email de confirmació validació del mateix***

***Quan només hauría de tindre la responsabilitat de tindre l'estructura de user.***

### 2. Per què incomplia el principi?
***Moltes responsabilitats dins la clase, concretament al métode register.***

### 3. Quina solució has aplicat i per què?
***Separar totes aquestes responsabilitats extra en diferents clases perquè cadascuna d'aquestes clases només tingui una responsabilitat.***

- ***EmailService***
- ***UserRegistrationService***
- ***UserValidator***