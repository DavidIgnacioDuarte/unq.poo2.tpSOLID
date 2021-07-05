# Principios SOLID

Presentación a los principios **SOLID**. TP n°5 de **Programación Orientada a Objetos II**.


## Objetivos

* Realizar el proceso completo de diseño prestando atención en los principios **SOLID**.


## Conceptos

**SOLID** es un acrónimo que representa 5 principios básicos de la **programación orientada a objetos** y el **diseño**. Al aplicarse en su conjunto, es altamente probable que el código resultante es fácil de mantener y ampliar con el tiempo. Se busca mantener un **alto** nivel de cohesión y un **bajo** nivel de acoplamiento:


* **S**ingle Responsability: Una clase sólo debería tener una responsabilidad, es decir, una única razón de cambio. El principio más importante y el más fácil de explicar, pero el más difícil de seguir en la práctica.

* **O**pen-Closed: Todas las entidades de software (clases, módulos, funciones, etc) deberían estar abiertas para su extensión, pero cerradas para su modificación. Se adapta el código inicial para nuevas/futuras necesidades y/o requerimientos. Todas las variables de instancia deben ser privadas. 

* **L**iskov Substitution: Una subclase debería poder sustituírse por su superclase sin interferir en la funcionalidad del programa. Jerarquía fácilmente entendible y código reutilizable -> subclase **es siempre un** superclase.

* **I**nterface Segregation: Es preferible contar con muchas interfaces que definan pocos métodos, que tener una interface forzada a implementar muchos métodos a los que no dará uso. Ninguna clase debería depender de métodos que no usa.

* **D**ependency Inversion: Depender de abstracciones, no de clases concretas. Los módulos de alto nivel no deberían depender de módulos de bajo nivel. Ambos deberían depender de abstracciones. Las abstracciones no deberían depender de los detalles. Los detalles deberían depender de las abstracciones. Consiste en reducir las dependencias entre los módulos del código, es decir, lograr un bajo acoplamiento entre clases.


## Consignas

Dadas las clases **ClienteEmail**, **Correo**, **ServidorPop** y la interfaz **IServidor**:

1. Diagrama de Clases en UML.

2. Detecte las violaciones a los principios SOLID

3. Indique las soluciones que deben llevarse a cabo.

4. Implemente las soluciones mediante diagrama de clases y código Java.


### Respuestas

Violaciones a los principios SOLID detectadas:

* **ClienteEmail** sólo tiene privado como atributo a los mensajes borrados. Tanto su servidor como su userName, pass e inbox son accesibles desde cualquier módulo del paquete, violando así el **Open-Closed Principle**. Esto se soluciona modificando dichos niveles de visibilidad a  _private_ .

* **IServidor** es muy genérica y en este caso, a **ServidorPop** que la implementa, no le corresponde definir 3 métodos referidos al mantenimiento del servidor. Esto viola el **Interface Segregation Principle**, y la vez del **Single Responsibility Principle** ya que involucra 2 capas de la arquitectura: persistencia y lógica del negocio. Esto podría solucionarse planteando interfaces más pequeñas; por un lado, una que defina un protocolo para el funcionamiento de la conectividad del usuario y el envío y recibo de mails, y por el otro, para su mantenimiento.

* **ClienteEmail** depende concretamente de **ServidorPop** y no se produce una abstracción con respecto a su comportamiento. Esto viola el **Dependency Inversion Principle**, y podría solucionarse, con el anterior ítem -> esperando recibir una interfaz del tipo **IServidorPop** a la que le corresponda la conectividad del usuario y el manejo de mails.

* **ClienteEmail** también viola por sí mismo el **Dependency Inversion Principle** debido a que en conjunto, su estado y comportamiento deberían implementar un protocolo en común para cada cliente de email; pudiendo solucionarse con una interfaz **IClienteEmail**.

* A **ClienteEmail** le corresponden la responsabilidad de enviar y recibir mails, y de manejar el estado de estos borrándolos y/o contando cuántos hay. Esto viola el **Single Responsibility Principle**, y podría solucionarse planteando una clase que se encargue de lo primero, y otra que se encargue de lo segundo.



##Sistema Informático Bancario

* Justifique por qué su modelo no viola los principios SOLID y marque cuáles desiciones tomó para que asi sea:


Creo que mi modelo **no** viola los principios **SOLID**, cumpliendo con cada uno de la siguiente manera:


1. **SRP:** Cada clase por sí misma tiene una única responsabilidad y razón de cambio. Por un lado, a **Banco** le corresponde simplemente la gestión del agregado de clientes, la solicitud de créditos de estos últimos, y el cálculo de su monto en base a las solicitudes aceptadas. Abarca sólo la lógica de negocio.Cada **Solicitud** cuenta con su respectivos datos de instancia, sabe responder a su monto y si la misma es aceptable en base al cliente. **PropiedadInmobiliaria** funciona como la garantía que es, teniendo una breve descripción y datos propios de la propiedad. Finalmente, a **Cliente** es a quien le corresponde saber su sueldo y cada uno de sus datos propios como persona física, fundamentales para ser usados en cada solicitud y para su información en el banco.

2. **OCP:** Es posible extender el dominio en cuanto a las solicitudes de crédito debido a que **Banco** recibe una solicitud, esta última siendo una clase abstracta como base a seguir por nuevas a agregar.

3. **LSP:** Cada clase que hereda de **SolicitudCredito** respeta el protocolo de esta última. **No** se cuenta con métodos inútiles en su extensión.

4. Por último, este dominio no implementa interfaces de ningún tipo.

