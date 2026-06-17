# Explicacion docente - Rutas con Apache POI

## Pregunta tipica del estudiante
**¿Puedo colocar el archivo Excel en otro lugar?**

Respuesta corta: **si**, pero depende de **como** lo cargues.

## Caso 1: archivo dentro del proyecto (`resources`)
Aqui el archivo se considera parte de la aplicacion.

Se carga con algo como:
```java
getClass().getClassLoader().getResourceAsStream("productos.xlsx")
```

### Caracteristicas
- no necesitas escribir una ruta del disco
- funciona bien si el archivo viaja con el proyecto
- sirve para demos, datos base y ejemplos pequeños
- al empaquetar la aplicacion, el archivo puede quedar dentro del `.jar`

## Caso 2: archivo en una ruta externa
Aqui el archivo esta fuera del proyecto o en otra carpeta.

Se carga con algo como:
```java
Path path = Path.of("datos/productos.xlsx");
Files.newInputStream(path)
```

### Caracteristicas
- el programa depende de la ruta
- puede ser relativa o absoluta
- el archivo puede cambiar sin recompilar el proyecto
- sirve cuando el usuario debe entregar o reemplazar archivos

## Diferencia pedagogica importante
- `resources` = archivo interno al proyecto
- `Path/Files` = archivo externo en el sistema

## Tipos de ruta que puedes explicar
### Ruta relativa
```java
Path.of("datos/productos.xlsx")
```
Depende de desde donde se ejecuta el proyecto.

### Ruta absoluta
```java
Path.of("/Users/jorgecarmona/archivo.xlsx")
```
Apunta a una ubicacion exacta del sistema.

## Recomendacion docente
Para ensenar, conviene mostrar ambos casos:
1. uno simple desde `resources`
2. otro desde carpeta externa `datos/`

Asi los estudiantes entienden que el problema no es Apache POI en si, sino **desde donde obtengo el `InputStream`**.
