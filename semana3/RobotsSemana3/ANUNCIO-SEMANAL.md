# Anuncio semanal - Semana 3

Estimadas y estimados:

Esta semana seguiremos avanzando con nuestro proyecto de **Robots de Combate**, pero ahora el desafío sube un poco de nivel. Tranquilidad: no es magia negra, sigue siendo Programación Orientada a Objetos... solo que ya no basta con crear clases bonitas y fingir que todo funciona perfecto.

En la **semana 3** aprenderemos a fortalecer nuestro sistema incorporando tres ideas clave:

- **validación de atributos**
- **manejo de excepciones personalizadas**
- **relaciones entre clases**

## ¿Qué veremos concretamente?

Tomaremos la base que ya construimos con `Robot`, `Motor` y `Armamento`, y la haremos evolucionar.
Ahora el sistema no solo tendrá robots: también incorporará nuevas entidades como:

- `Piloto`
- `Rut`
- `Direccion`
- `RutInvalidoException`

Con esto trabajaremos una idea muy importante en POO: un sistema crece bien cuando **agrega responsabilidades de forma ordenada**, no cuando mete todo en una sola clase y después nadie entiende por qué explotó.

## ¿Qué aprenderán?

Durante esta semana aprenderán a:

- validar datos al momento de crear objetos
- detectar cuándo una clase necesita apoyo de otra clase
- modelar relaciones del tipo **has-a**
- separar responsabilidades para evitar duplicación de lógica
- usar excepciones personalizadas para representar errores del dominio

En otras palabras: comenzaremos a pasar de un proyecto “que compila” a un proyecto que además **tiene sentido**.

## ¿Por qué esto es importante?

Porque en sistemas reales no basta con guardar datos y cruzar los dedos.
Si un dato viene mal, el sistema debe detectarlo.
Si una entidad depende de otra, esa relación debe modelarse correctamente.
Y si todo lo dejamos mezclado en una sola clase, después mantener el código se vuelve una experiencia espiritual, pero de las malas.

## Conexión con la guía oficial

Aunque nuestro ejemplo sigue usando la temática de **robots de combate**, los conceptos que veremos son exactamente los mismos que luego podrán aplicar en contextos más tradicionales, como clientes, direcciones, validaciones y otras estructuras del mundo “formal”.
Es decir: cambia la historia, pero no cambia la lógica.

## Recomendación para la clase

Lleguen con la base de la semana anterior revisada, especialmente:

- clases y objetos
- encapsulamiento
- composición
- organización por paquetes

Eso nos permitirá concentrarnos en el nuevo desafío sin tener que pelear otra vez con conceptos que ya deberían estar bajo control. Idealmente.

Nos vemos en clase.

**Jorge Carmona**
