# Principios SOLID

Presentaci�n a los principios **SOLID**. TP n�5 de **Programaci�n Orientada a Objetos II**.


## Objetivos

* Realizar el proceso completo de dise�o prestando atenci�n en los principios **SOLID**.


## Conceptos

**SOLID** es un acr�nimo que representa 5 principios b�sicos de la **programaci�n orientada a objetos** y el **dise�o**. Al aplicarse en su conjunto, es altamente probable que el c�digo resultante es f�cil de mantener y ampliar con el tiempo. Se busca mantener un **alto** nivel de cohesi�n y un **bajo** nivel de acoplamiento:


* **S**ingle Responsability: Una clase s�lo deber�a tener una responsabilidad, es decir, una �nica raz�n de cambio. El principio m�s importante y el m�s f�cil de explicar, pero el m�s dif�cil de seguir en la pr�ctica.

* **O**pen-Closed: Todas las entidades de software (clases, m�dulos, funciones, etc) deber�an estar abiertas para su extensi�n, pero cerradas para su modificaci�n. Se adapta el c�digo inicial para nuevas/futuras necesidades y/o requerimientos.

* **L**iskov Substitution: Una subclase deber�a poder sustitu�rse por su superclase sin interferir en la funcionalidad del programa. Jerarqu�a f�cilmente entendible y c�digo reutilizable -> subclase **es siempre un** superclase.

* **I**nterface Segregation: Es preferible contar con muchas interfaces que definan pocos m�todos, que tener una interface forzada a implementar muchos m�todos a los que no dar� uso. Ninguna clase deber�a depender de m�todos que no usa.

* **D**ependency Inversion: Depender de abstracciones, no de clases concretas. Los m�dulos de alto nivel no deber�an depender de m�dulos de bajo nivel. Ambos deber�an depender de abstracciones. Las abstracciones no deber�an depender de los detalles. Los detalles deber�an depender de las abstracciones. Consiste en reducir las dependencias entre los m�dulos del c�digo, es decir, lograr un bajo acoplamiento entre clases.


## Consignas

Dadas las clases **ClienteEmail**, **Correo**, **ServidorPop** y la interfaz **IServidor**:

1. Diagrama de Clases en UML.

2. Detecte las violaciones a los principios SOLID

3. Indique las soluciones que deben llevarse a cabo.

4. Implemente las soluciones mediante diagrama de clases y c�digo Java.

