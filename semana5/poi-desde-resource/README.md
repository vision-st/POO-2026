# poi-desde-resource

Proyecto sandbox para comparar dos formas de leer un archivo Excel con Apache POI dentro de una sola carpeta.

## Incluye
- `LectorExcelResources.java`: lectura desde `src/main/resources`
- `LectorExcelRuta.java`: lectura desde una ruta externa en `datos/`

## Objetivo docente
Mostrar rapidamente que el problema no esta en Apache POI, sino en **como obtienes el `InputStream`**.

## Casos mostrados
### 1. Recurso interno
Cuando el archivo forma parte del proyecto.

### 2. Ruta externa
Cuando el archivo vive fuera de `resources` y depende de una ruta del sistema.
