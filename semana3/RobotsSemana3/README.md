# RobotsSemana3

Proyecto Java correspondiente a la **semana 3** de la asignatura Programación Orientada a Objetos.

## Descripción de la actividad

Este proyecto deja preparada la **base estructural** para la semana 3 de Programación Orientada a Objetos, reutilizando como espejo la organización desarrollada en la semana 2 con la temática de **robots de combate**. Se mantiene la estructura del proyecto, la separación por paquetes y las clases principales sobre las que se ampliará el trabajo en clases.

## Contenido teórico trabajado

### 1. Clases y objetos
Se aplican clases para representar entidades del dominio, por ejemplo:
- `Robot`
- `Motor`
- `Armamento`

Cada clase modela características y comportamientos específicos del problema.

### 2. Encapsulamiento
Los atributos se declaran como privados y se controlan mediante métodos de acceso y modificación (`get` y `set`). Esto permite proteger el estado interno de los objetos y mantener un diseño más ordenado.

### 3. Constructores
Las clases principales utilizan constructores para inicializar los objetos con sus datos base al momento de crearlos.

### 4. Composición
La clase `Robot` está compuesta por otras clases del modelo:
- un `Armamento`
- un `Motor`

Esto permite representar que un robot se construye a partir de componentes con responsabilidades distintas.

### 5. Responsabilidad de métodos
La lógica del combate se distribuye en métodos como:
- `atacar()`
- `recibirDaño()`
- `estaDestruido()`

Con esto se trabaja la idea de que cada clase debe concentrar comportamientos coherentes con su responsabilidad.

### 6. Organización por paquetes
El proyecto separa el código en paquetes según su propósito:
- `app`
- `model.armamentobelico`
- `model.mecanismo`
- `model.robots`
- `model.robots.acciones`

Esto ayuda a mantener una estructura más clara y escalable.

## Estructura del proyecto

```text
RobotsSemana3/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/duoc/fabricarobots/
                ├── app/
                └── model/
```

## Aprendizajes esperados

- Reconocer la estructura base del proyecto que se ampliará en la semana 3.
- Reutilizar una solución previa como punto de partida para nuevas relaciones entre clases.
- Mantener organización por paquetes y responsabilidades claras.
- Preparar el proyecto para incorporar validación, excepciones y nuevas entidades en clases posteriores.

## Observación técnica

Este repositorio excluye archivos generados por el IDE y por la compilación para mantener un historial limpio y portable.
