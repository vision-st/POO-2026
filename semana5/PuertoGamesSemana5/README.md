# PuertoGamesSemana5

Proyecto de ejemplo alineado con la semana 5 del documento de aprendizaje.

## Objetivo
Demostrar:
- organizacion del codigo en paquetes `model`, `data` y `ui`
- uso de `ArrayList` para gestionar una coleccion de objetos `Videojuego`
- lectura de archivos `.xlsx`
- generacion de un `.jar` ejecutable
- una version portable que funcione sin instalar Maven

## Estructura
- `model/Videojuego`: representa el dato
- `data/LectorXlsxSimple`: lector simple de Excel `.xlsx` usando Java estandar
- `data/GestorVideojuegos`: carga el Excel y administra la coleccion
- `ui/Main`: punto de entrada y demostracion del sistema

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

## Maven
Se conserva `pom.xml` para abrir el proyecto de forma comoda en IntelliJ, pero la version oficial de esta carpeta no depende de Maven para compilar ni ejecutar.

## Recurso usado
El archivo `videojuegos.xlsx` se encuentra en `src/main/resources/` para que el programa lo cargue desde el classpath.
