# Explicacion breve - PuertoGamesSemana5 Swing

## Idea general
Esta version toma el mismo modelo de datos de PuertoGames y le agrega una interfaz grafica **super sencilla** con Swing.

## Que conserva del proyecto base
- `model/Videojuego`
- `data/LectorXlsxSimple`
- `data/GestorVideojuegos`
- archivo `videojuegos.xlsx`

## Que cambia
En vez de mostrar todo en consola, ahora el programa abre una ventana con:
- una tabla
- un campo para buscar por codigo
- un boton para buscar
- un boton para mostrar todos
- un boton para recargar datos
- una etiqueta de estado

## Que enseña
- como separar logica y interfaz
- como reutilizar clases ya creadas
- como mostrar datos en una `JTable`
- como conectar botones con acciones simples
- como mantener una UI basica sin complicar el proyecto

## Flujo
1. `Main` abre la ventana `PuertoGamesFrame`.
2. La ventana crea un `GestorVideojuegos`.
3. Se carga `videojuegos.xlsx`.
4. Los registros se muestran en una tabla.
5. El usuario puede buscar por codigo o volver a ver todos los registros.

## Por que esta version sirve para clase
Porque permite mostrar una interfaz grafica real sin meter demasiada complejidad. Es suficiente para que los estudiantes entiendan que el mismo backend de clases y listas puede reutilizarse en otra capa de presentacion.
