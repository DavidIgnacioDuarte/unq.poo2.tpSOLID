# Principios SOLID

Presentación a los principios **SOLID**. TP n°5 de **Programación Orientada a Objetos II**.


## Objetivos

* Realizar el proceso completo de diseño prestando atención en los principios **SOLID**.


## Conceptos

**SOLID** es un acrónimo que representa 5 principios básicos de la **programación orientada a objetos** y el **diseño**. Al aplicarse en su conjunto, es altamente probable que el código resultante es fácil de mantener y ampliar con el tiempo. Se busca mantener un **alto** nivel de cohesión y un **bajo** nivel de acoplamiento:


* **S**ingle Responsability: Una clase sólo debería tener una responsabilidad, es decir, una única razón de cambio. El principio más importante y el más fácil de explicar, pero el más difícil de seguir en la práctica.

* **O**pen-Closed: Todas las entidades de software (clases, módulos, funciones, etc) deberían estar abiertas para su extensión, pero cerradas para su modificación. Se adapta el código inicial para nuevas/futuras necesidades y/o requerimientos.

* **L**iskov Substitution: Una subclase debería poder sustituírse por su superclase sin interferir en la funcionalidad del programa. Jerarquía fácilmente entendible y código reutilizable -> subclase **es siempre un** superclase.

* **I**nterface Segregation: Es preferible contar con muchas interfaces que definan pocos métodos, que tener una interface forzada a implementar muchos métodos a los que no dará uso. Ninguna clase debería depender de métodos que no usa.

* **D**ependency Inversion: Depender de abstracciones, no de clases concretas. Los módulos de alto nivel no deberían depender de módulos de bajo nivel. Ambos deberían depender de abstracciones. Las abstracciones no deberían depender de los detalles. Los detalles deberían depender de las abstracciones. Consiste en reducir las dependencias entre los módulos del código, es decir, lograr un bajo acoplamiento entre clases.


## Consignas

Dadas las clases **ClienteEmail**, **Correo**, **ServidorPop** y la interfaz **IServidor**:

1. Diagrama de Clases en UML.

2. Detecte las violaciones a los principios SOLID

3. Indique las soluciones que deben llevarse a cabo.

4. Implemente las soluciones mediante diagrama de clases y código Java.

