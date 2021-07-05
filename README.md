# Principios SOLID

Presentaci�n a los principios **SOLID**. TP n�5 de **Programaci�n Orientada a Objetos II**.


## Objetivos

* Realizar el proceso completo de dise�o prestando atenci�n en los principios **SOLID**.


## Conceptos

**SOLID** es un acr�nimo que representa 5 principios b�sicos de la **programaci�n orientada a objetos** y el **dise�o**. Al aplicarse en su conjunto, es altamente probable que el c�digo resultante es f�cil de mantener y ampliar con el tiempo. Se busca mantener un **alto** nivel de cohesi�n y un **bajo** nivel de acoplamiento:


* **S**ingle Responsability: Una clase s�lo deber�a tener una responsabilidad, es decir, una �nica raz�n de cambio. El principio m�s importante y el m�s f�cil de explicar, pero el m�s dif�cil de seguir en la pr�ctica.

* **O**pen-Closed: Todas las entidades de software (clases, m�dulos, funciones, etc) deber�an estar abiertas para su extensi�n, pero cerradas para su modificaci�n. Se adapta el c�digo inicial para nuevas/futuras necesidades y/o requerimientos. Todas las variables de instancia deben ser privadas. 

* **L**iskov Substitution: Una subclase deber�a poder sustitu�rse por su superclase sin interferir en la funcionalidad del programa. Jerarqu�a f�cilmente entendible y c�digo reutilizable -> subclase **es siempre un** superclase.

* **I**nterface Segregation: Es preferible contar con muchas interfaces que definan pocos m�todos, que tener una interface forzada a implementar muchos m�todos a los que no dar� uso. Ninguna clase deber�a depender de m�todos que no usa.

* **D**ependency Inversion: Depender de abstracciones, no de clases concretas. Los m�dulos de alto nivel no deber�an depender de m�dulos de bajo nivel. Ambos deber�an depender de abstracciones. Las abstracciones no deber�an depender de los detalles. Los detalles deber�an depender de las abstracciones. Consiste en reducir las dependencias entre los m�dulos del c�digo, es decir, lograr un bajo acoplamiento entre clases.


## Consignas

Dadas las clases **ClienteEmail**, **Correo**, **ServidorPop** y la interfaz **IServidor**:

1. Diagrama de Clases en UML.

2. Detecte las violaciones a los principios SOLID

3. Indique las soluciones que deben llevarse a cabo.

4. Implemente las soluciones mediante diagrama de clases y c�digo Java.


### Respuestas

Violaciones a los principios SOLID detectadas:

* **ClienteEmail** s�lo tiene privado como atributo a los mensajes borrados. Tanto su servidor como su userName, pass e inbox son accesibles desde cualquier m�dulo del paquete, violando as� el **Open-Closed Principle**. Esto se soluciona modificando dichos niveles de visibilidad a  _private_ .

* **IServidor** es muy gen�rica y en este caso, a **ServidorPop** que la implementa, no le corresponde definir 3 m�todos referidos al mantenimiento del servidor. Esto viola el **Interface Segregation Principle**, y la vez del **Single Responsibility Principle** ya que involucra 2 capas de la arquitectura: persistencia y l�gica del negocio. Esto podr�a solucionarse planteando interfaces m�s peque�as; por un lado, una que defina un protocolo para el funcionamiento de la conectividad del usuario y el env�o y recibo de mails, y por el otro, para su mantenimiento.

* **ClienteEmail** depende concretamente de **ServidorPop** y no se produce una abstracci�n con respecto a su comportamiento. Esto viola el **Dependency Inversion Principle**, y podr�a solucionarse, con el anterior �tem -> esperando recibir una interfaz del tipo **IServidorPop** a la que le corresponda la conectividad del usuario y el manejo de mails.

* **ClienteEmail** tambi�n viola por s� mismo el **Dependency Inversion Principle** debido a que en conjunto, su estado y comportamiento deber�an implementar un protocolo en com�n para cada cliente de email; pudiendo solucionarse con una interfaz **IClienteEmail**.

* A **ClienteEmail** le corresponden la responsabilidad de enviar y recibir mails, y de manejar el estado de estos borr�ndolos y/o contando cu�ntos hay. Esto viola el **Single Responsibility Principle**, y podr�a solucionarse planteando una clase que se encargue de lo primero, y otra que se encargue de lo segundo.



##Sistema Inform�tico Bancario

* Justifique por qu� su modelo no viola los principios SOLID y marque cu�les desiciones tom� para que asi sea:


Creo que mi modelo **no** viola los principios **SOLID**, cumpliendo con cada uno de la siguiente manera:


1. **SRP:** Cada clase por s� misma tiene una �nica responsabilidad y raz�n de cambio. Por un lado, a **Banco** le corresponde simplemente la gesti�n del agregado de clientes, la solicitud de cr�ditos de estos �ltimos, y el c�lculo de su monto en base a las solicitudes aceptadas. Abarca s�lo la l�gica de negocio.Cada **Solicitud** cuenta con su respectivos datos de instancia, sabe responder a su monto y si la misma es aceptable en base al cliente. **PropiedadInmobiliaria** funciona como la garant�a que es, teniendo una breve descripci�n y datos propios de la propiedad. Finalmente, a **Cliente** es a quien le corresponde saber su sueldo y cada uno de sus datos propios como persona f�sica, fundamentales para ser usados en cada solicitud y para su informaci�n en el banco.

2. **OCP:** Es posible extender el dominio en cuanto a las solicitudes de cr�dito debido a que **Banco** recibe una solicitud, esta �ltima siendo una clase abstracta como base a seguir por nuevas a agregar.

3. **LSP:** Cada clase que hereda de **SolicitudCredito** respeta el protocolo de esta �ltima. **No** se cuenta con m�todos in�tiles en su extensi�n.

4. Por �ltimo, este dominio no implementa interfaces de ning�n tipo.

