# PuertoGamesSemana5 Maven

Version del proyecto pensada para trabajar con **Maven + Apache POI**.

## Objetivo
Demostrar:
- proyecto Maven en IntelliJ IDEA
- uso de Apache POI para leer archivos `.xlsx`
- organizacion del codigo en paquetes `model`, `data` y `ui`
- uso de `ArrayList` para gestionar una coleccion de objetos `Videojuego`
- generacion de `.jar` ejecutable con dependencias

## Dependencia principal
El `pom.xml` incluye:
- `org.apache.poi:poi-ooxml:5.2.5`

## Estructura
- `model/Videojuego`: representa el dato
- `data/GestorVideojuegos`: carga el Excel y administra la coleccion usando Apache POI
- `ui/Main`: punto de entrada y demostracion del sistema

## Ejecutar con Maven
```bash
mvn package
java -jar target/videojuegos-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Recurso usado
El archivo `videojuegos.xlsx` se encuentra en `src/main/resources/` para que el programa lo cargue desde el classpath.

## Nota
Esta version requiere Maven instalado. Si quieres una version que funcione sin Maven, usa la carpeta `PuertoGamesSemana5` sin sufijo.
