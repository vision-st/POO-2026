# PuertoGamesSemana5 Swing

Version super sencilla de PuertoGames con interfaz grafica usando Swing.

## Objetivo
Demostrar:
- organizacion del codigo en paquetes `model`, `data` y `ui`
- lectura de un archivo `.xlsx`
- uso de `ArrayList` para manejar objetos `Videojuego`
- una interfaz grafica basica con Swing

## Que hace la interfaz
- carga los videojuegos desde `videojuegos.xlsx`
- muestra los datos en una tabla
- permite buscar por codigo
- permite volver a mostrar todos los registros
- permite recargar datos

## Llegar y probar
Desde la carpeta del proyecto:

```bash
chmod +x build.sh run.sh
./run.sh
```

## Compilar y generar JAR
```bash
./build.sh
java -jar out/PuertoGamesSemana5.jar
```

## Recurso usado
El archivo `videojuegos.xlsx` se encuentra en `src/main/resources/` para que el programa lo cargue desde el classpath.
