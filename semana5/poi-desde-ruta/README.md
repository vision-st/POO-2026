# poi-desde-ruta

Ejemplo minimo para demostrar como cargar un archivo Excel `.xlsx` desde una **ruta externa** usando Apache POI.

## Idea clave
El archivo se lee desde el sistema de archivos usando una ruta.

## Codigo clave
```java
Path path = Path.of("datos/productos.xlsx");
InputStream inputStream = Files.newInputStream(path);
```

## Cuando usarlo
- cuando el archivo no viene dentro del proyecto
- cuando el usuario puede cambiarlo o reemplazarlo
- cuando necesitas leer archivos desde otra carpeta del equipo
