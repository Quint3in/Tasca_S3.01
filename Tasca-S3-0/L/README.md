# 🧬 L - Principi de Substitució de Liskov (LSP)

## 🧠 Què és?

El **Principi de Substitució de Liskov (LSP)** diu que:

> **Les subclasses han de poder substituir les seves superclasses sense alterar el comportament del programa.**

Això significa que qualsevol classe filla hauria de **comportar-se com la seva classe pare**. Si una subclasse **trenca contractes o comportaments** definits a la classe base, llavors viola aquest principi.

En altres paraules, si un programa està dissenyat per treballar amb un objecte d’una classe base, hauria de funcionar correctament si aquest objecte se substitueix per qualsevol objecte d’una classe derivada.

## 🚨 Per què és important?
Quan fem servir **herència**, esperem que una subclasse **ampliï el comportament de la superclasse, no que el trenqui**. Si no es respecta LSP, podem tenir errors difícils de detectar i sistemes difícils de mantenir o estendre.

### 👩‍🏫 **Exemple:**

Suposem que estàs dissenyant una aplicació que treballa amb diverses **criptomonedes** i ofereixes una **API** com aquesta:

```java
public class Wallet {
    private String nomCripto;
    private String codiCancelacio;

    public Wallet(String nomCripto, String codiCancelacio) {
        this.nomCripto = nomCripto;
        this.codiCancelacio = codiCancelacio;
    }

    public void enviarDiner(String desti, double quantitat) {
        System.out.println("S’està enviant diners per la blockchain de " + nomCripto);
    }

    public void cancelarTransaccio(String idTransaccio) {
        if (AuthorizationCancel.cancel(codiCancelacio, idTransaccio))
            System.out.println("S’anul·la la transacció" + id + "amb el codi" + codiCancelacio);
        else throw new TransactionCancelException("No s’ha pogut cancel·lar la transacció");
    }
}
```
**La teva API treballa amb:**

- `Tezos`
- `Ethereum`
- `Monero`

```java
public class TezosWallet extends Wallet{
    public TezosWallet(){
        super("Tezos", "TEZ_0974_BLCH");
    }
}

public class EthereumWallet extends Wallet{
    public EthereumWallet(){
        super("Ethereum", "ETH_7637_BLCH");
    }
}

public class MoneroWallet extends Wallet{
    public MoneroWallet(){
        super("Monero", null); //Monero no permet la cancel·lació de transaccions
    }
}

```
🔴 Problema: MoneroWallet hereta de Wallet, però quan algú crida `cancelarTransaccio()` amb una instància de `MoneroWallet`, el **programa va a trencar sempre** perquè Monero no permet cancel·lacions.

⚠️ Per tant, no es pot utilitzar `MoneroWallet` en contextos que esperen que `Wallet.cancelarTransaccio()` funcioni correctament → això **trenca LSP.**

✅ Solució: aplicar LSP amb una **jerarquia clara**: 
> La clau és **separar les responsabilitats**: no totes les criptomonedes permeten cancel·lacions, així que no totes les wallets haurien de tenir aquest mètode.

- **1️⃣ Crear la interfície per a la cancel·lació:**

```java
public interface EstrategiaCancelacio {
    void cancellar(String id);
}
```
- **2️⃣ Implementar l’estratègia real i la null:**

```java
public class EstrategiaCancelacioPermitida implements EstrategiaCancelacio {
    private String codiCancelacio;

    public EstrategiaCancelacioPermitida(String codiCancelacio) {
        this.codiCancelacio = codiCancelacio;
    }

    @Override
    public void cancellar(String id) {
        System.out.println("S’anul·la la transacció " + id + " amb el codi " + codiCancelacio);
    }
}

public class EstrategiaCancelacioNoPermitida implements EstrategiaCancelacio {
    @Override
    public void cancellar(String id) {
        // No fa res, simplement ignora la cancel·lació.
        System.out.println("Cancel·lació no suportada per aquesta wallet, s’ignora la transacció: " + id);
    }
}

```
- **3️⃣ Modificar la classe Wallet per usar l’estratègia de cancel·lació:**

```java
public class Wallet {
    private String nomCripto;
    private EstrategiaCancelacio estrategiaCancelacio;

    public Wallet(String nomCripto, EstrategiaCancelacio estrategiaCancelacio) {
        this.nomCripto = nomCripto;
        this.estrategiaCancelacio = estrategiaCancelacio;
    }

    public void enviarDiners(String desti, double quantitat) {
        System.out.println("S’està enviant diners per la blockchain de " + nomCripto);
    }

    public void cancelarTransaccio(String id) {
        estrategiaCancelacio.cancellar(id);
    }
}
```
- **4️⃣ Crear les wallets amb l’estratègia adequada:**

```java
public class TezosWallet extends Wallet {
    public TezosWallet() {
        super("Tezos", new EstrategiaCancelacioPermitida("TEZ_0974_BLCH"));
    }
}

public class EthereumWallet extends Wallet {
    public EthereumWallet() {
        super("Ethereum", new EstrategiaCancelacioPermitida("ETH_7637_BLCH"));
    }
}

public class MoneroWallet extends Wallet {
    public MoneroWallet() {
        super("Monero", new EstrategiaCancelacioNoPermitida());
    }
}
```

---

## 🎯 Objectiu de l’exercici

Trobaràs una classe Java que utilitza **malament l'herència** i, com a conseqüència, **viola el principi de Liskov**.

🔧 El teu repte és:

1. Identificar la jerarquia que **trenca el comportament** esperat.
2. Refactoritzar el codi per garantir que les **subclasses siguin substituïbles sense trencar** la lògica.
3. Aplicar **abstraccions i polimorfisme** per fer el codi més flexible i robust.

---

## 📌 Consells per aplicar LSP

✅ **Assegura’t que totes les subclasses compleixin el contracte de la superclasse.**

✅ **No utilitzis herència només per reutilitzar codi.**

✅ **Considera patrons com Composició`*` sobre Herència quan no hi ha una relació clara de tipus.**

`*`**“Composició”** és un concepte de **POO** que significa construir una classe utilitzant altres objectes (d’altres classes) com a parts internes, en lloc de crear una jerarquia d’herència (subclasses).

---


## 💬 Reflexió

Quan apliques correctament **el principi de Liskov**:
- Evites comportaments inesperats en l’execució.
- El teu codi és més previsible, segur i reutilitzable.
- Pots fer servir polimorfisme sense sorpreses.

🔁 **Heretar** comportament vol dir **respectar-lo**, **no trencar-lo**.

---

🚀 Endavant! Revisa el codi, identifica l’error i refactoritza la jerarquia perquè compleixi el **LSP**.

❓ **Pot una subclasse ser usada en lloc de la seva superclasse sense problemes?**

***Si ara apliquen el mateix comportament que la superclase.***
 


