# RobotsSemana2

Proyecto Java correspondiente a la **semana 2** de la asignatura Programación Orientada a Objetos.

## Descripción de la actividad

La actividad modela un pequeño sistema de **robots de combate** utilizando clases y relaciones entre objetos. El proyecto permite crear robots con atributos propios, asignarles un motor y un armamento, y ejecutar una simulación básica de ataque entre instancias.

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
RobotsSemana2/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/duoc/fabricarobots/
                ├── app/
                └── model/
```

## Aprendizajes esperados

- Modelar entidades del mundo del problema usando clases Java.
- Aplicar encapsulamiento y composición.
- Organizar código por paquetes.
- Comprender cómo interactúan objetos mediante métodos.

## Observación técnica

Este repositorio excluye archivos generados por el IDE y por la compilación para mantener un historial limpio y portable.
