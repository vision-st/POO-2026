# poi-desde-resources

Ejemplo minimo para demostrar como cargar un archivo Excel `.xlsx` desde `src/main/resources` usando Apache POI.

## Idea clave
El archivo se lee desde el **classpath**, no desde una ruta escrita a mano en el disco.

## Codigo clave
```java
InputStream inputStream = getClass().getClassLoader().getResourceAsStream("productos.xlsx");
```

## Cuando usarlo
- cuando el archivo forma parte del proyecto
- cuando quieres empaquetarlo dentro de la aplicacion
- cuando no quieres depender de una ruta externa del computador
