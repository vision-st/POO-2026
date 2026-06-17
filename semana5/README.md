# Semana 5 - POO

Esta carpeta reune distintos proyectos de apoyo para la **semana 5** de Programacion Orientada a Objetos. El foco de la semana esta en:

- organizacion de proyectos Java
- separacion por paquetes (`model`, `data`, `ui`)
- uso de colecciones como `ArrayList`
- lectura de archivos Excel `.xlsx`
- trabajo con Maven y Apache POI
- empaquetado y distribucion
- reutilizacion de clases en consola y en interfaz grafica

## Proyectos incluidos

### 1. `PuertoGamesSemana5`
Version **portable** del proyecto principal.

**Que hace:**
- carga `videojuegos.xlsx`
- convierte filas en objetos `Videojuego`
- guarda los datos en una coleccion
- lista, busca y filtra registros
- compila sin depender de Maven

**Para que sirve:**
Ideal para una clase donde se necesita **llegar y probar** rapidamente.

---

### 2. `PuertoGamesSemana5-maven`
Version del mismo proyecto usando **Maven + Apache POI**.

**Que hace:**
- lee un archivo `.xlsx` con Apache POI
- usa `pom.xml` con dependencia `poi-ooxml`
- permite mostrar una version mas cercana a un proyecto profesional Java

**Para que sirve:**
Ideal para explicar dependencias, `pom.xml`, Maven y lectura de Excel con librerias externas.

---

### 3. `PuertoGamesSemana5-swing`
Version **super sencilla con interfaz grafica Swing**.

**Que hace:**
- reutiliza la logica del proyecto base
- muestra los videojuegos en una tabla
- permite buscar por codigo
- permite mostrar todos los registros y recargar datos

**Para que sirve:**
Ideal para mostrar como la misma logica de negocio puede reutilizarse en otra capa de presentacion.

---

### 4. `poi-desde-resources`
Mini proyecto con Apache POI para leer un Excel desde `src/main/resources`.

**Que demuestra:**
- uso del classpath
- lectura de recursos internos del proyecto
- carga de archivos que viajan con la aplicacion

**Pregunta docente que responde:**
> "¿Que pasa si el Excel viene dentro del proyecto?"

---

### 5. `poi-desde-ruta`
Mini proyecto con Apache POI para leer un Excel desde una carpeta externa (`datos/`).

**Que demuestra:**
- uso de rutas relativas o absolutas
- lectura desde el sistema de archivos
- diferencia entre recurso interno y archivo externo

**Pregunta docente que responde:**
> "¿Puedo colocar el archivo Excel en otro lugar?"

---

### 6. `poi-desde-resource`
Mini proyecto tipo sandbox que junta ejemplos de lectura desde `resources` y desde ruta externa dentro de una misma estructura simple.

**Que hace:**
- incluye una clase para lectura desde `resources`
- incluye una clase para lectura desde ruta
- incluye ambos archivos de ejemplo

**Para que sirve:**
Ideal como carpeta experimental o comparativa si se quiere mostrar ambos enfoques en un solo proyecto.

---

### 7. `GestorVideojuegosSincronica`
Proyecto pequeno pensado para apoyo en clase sincrona.

**Que hace:**
- modela un gestor de videojuegos
- usa Apache POI
- carga datos desde Excel
- sirve como ejemplo intermedio entre teoria y proyecto principal

**Para que sirve:**
Ideal para demostraciones paso a paso durante una clase guiada.

---

## Archivo de apoyo
### `explicacion-rutas-poi.md`
Documento complementario que explica la diferencia entre:
- leer desde `resources`
- leer desde una ruta externa
- usar rutas relativas
- usar rutas absolutas

## Recomendacion de uso docente
Si necesitas una secuencia simple para clase:
1. mostrar `poi-desde-resources`
2. mostrar `poi-desde-ruta`
3. explicar `explicacion-rutas-poi.md`
4. cerrar con `PuertoGamesSemana5` o `PuertoGamesSemana5-swing`

Asi los estudiantes entienden primero **de donde sale el archivo**, luego **como se usa en un proyecto mas completo**.
