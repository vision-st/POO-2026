# Guía docente · Semana 4 · Manejando colecciones

## Propósito de esta semana

Esta semana está pensada para que el estudiantado comprenda cómo usar las **colecciones provistas por Java** para almacenar, recorrer, buscar y filtrar datos.

El foco no está en construir un sistema grande todavía, sino en entender:
- cuándo usar una colección
- qué problema resuelve cada estructura
- cómo guardar objetos dentro de ellas
- cómo separar la lógica en clases simples

---

## Resultado de aprendizaje que se trabaja

**RA2.** Implementa colecciones de objetos utilizando clases previamente desarrolladas, integrando estructuras provistas por el lenguaje de programación, colecciones personalizadas y aquellas provenientes de librerías propias, con el propósito de estructurar soluciones reutilizables y organizadas.

---

## Indicadores de logro abordados

- utilizar colecciones provistas por el lenguaje
- aplicar inserción, acceso, eliminación, recorrido y búsqueda
- almacenar objetos dentro de colecciones dinámicas
- organizar el código en paquetes según responsabilidad
- separar datos, lógica e interfaz básica

---

## Estructura disponible en el repo

Ruta:

```text
POO/semana4/
├── README.md
├── GUIA-DOCENTE-SEMANA4.md
├── ColeccionesArrayListDemo/
├── ListasYFiltradoDemo/
├── DiccionarioStockDemo/
├── StackHistorialDemo/
└── PuertoGamesColeccionesSemana4/
```

---

## Qué contiene cada proyecto

### 1. `ColeccionesArrayListDemo`
Proyecto de entrada para enseñar el uso básico de `ArrayList`.

**Temas clave:**
- colección dinámica
- `add()`
- `get()`
- `remove()`
- `size()`
- `for-each`

---

### 2. `ListasYFiltradoDemo`
Proyecto para mostrar la interfaz `List`, el uso de `ArrayList` como implementación concreta y una búsqueda simple por coincidencia.

**Temas clave:**
- `List`
- `ArrayList`
- polimorfismo básico
- búsqueda con `contains()`
- recorrido de objetos

---

### 3. `DiccionarioStockDemo`
Proyecto orientado a enseñar el uso de `HashMap` como estructura clave-valor.

**Temas clave:**
- diccionario
- `put()`
- `get()`
- clave y valor
- recorrido con `entrySet()`

---

### 4. `StackHistorialDemo`
Proyecto para enseñar la estructura `Stack` y el comportamiento LIFO.

**Temas clave:**
- `Stack`
- `push()`
- `pop()`
- LIFO
- caso de uso: deshacer acciones

---

### 5. `PuertoGamesColeccionesSemana4`
Proyecto integrador de la semana.

**Temas clave:**
- lectura desde archivo externo
- conversión de texto a objeto
- almacenamiento en `ArrayList`
- búsqueda por título
- filtrado por género
- separación en paquetes `model`, `data` y `ui`

---

# Orden recomendado para la clase

## Bloque 1 · Introducción conceptual breve
**Duración sugerida:** 10 a 15 minutos

### Objetivo
Instalar la idea de colección antes de abrir código.

### Qué explicar
- qué es una colección en Java
- diferencia entre arreglo y colección
- por qué una colección es útil cuando la cantidad de datos cambia
- operaciones comunes:
  - agregar
  - eliminar
  - recorrer
  - buscar
  - filtrar

### Preguntas para activar
- ¿qué pasa si no sabemos cuántos datos vamos a guardar?
- ¿conviene un arreglo fijo o una colección dinámica?
- ¿todas las colecciones sirven para lo mismo?

### Advertencia docente
No alargarse demasiado aquí. Si te quedas veinte minutos en teoría, empiezas a perder atención antes de abrir el primer proyecto.

---

## Bloque 2 · `ColeccionesArrayListDemo`
**Duración sugerida:** 15 minutos

### Objetivo
Enseñar el funcionamiento básico de una colección dinámica.

### Qué mostrar en el código
- `Main.java`
- `CatalogoNombres.java`

### Qué explicar
- creación de la colección
- inserción con `add()`
- acceso por índice con `get()`
- eliminación con `remove()`
- cantidad con `size()`
- recorrido con `for-each`

### Qué decir en clase
- `ArrayList` permite crecer sin definir tamaño fijo
- la colección puede encapsularse dentro de una clase
- no todo debe quedar en `main`

### Preguntas útiles
- ¿qué ventaja tiene `ArrayList` frente a un arreglo?
- ¿qué ocurre si elimino un elemento?
- ¿por qué `CatalogoNombres` guarda la lista y no el `Main`?

### Error típico del estudiante
Pensar que colección = arreglo con otro nombre.

---

## Bloque 3 · `ListasYFiltradoDemo`
**Duración sugerida:** 15 minutos

### Objetivo
Mostrar que una colección puede almacenar objetos y que se puede declarar usando la interfaz `List`.

### Qué mostrar en el código
- `Juego.java`
- `BuscadorJuegos.java`
- `Main.java`

### Qué explicar
- una lista puede contener objetos completos, no solo strings
- `List` es la interfaz
- `ArrayList` es una implementación concreta
- se puede recorrer con `for-each`
- se puede filtrar usando `contains()`

### Qué decir en clase
- programar contra la interfaz da más flexibilidad
- `List<Juego>` expresa intención más limpia que depender siempre de `ArrayList<Juego>`
- aquí ya no guardamos texto suelto: guardamos objetos del dominio

### Preguntas útiles
- ¿por qué declaramos `List<Juego>` y no `ArrayList<Juego>`?
- ¿qué ganamos al modelar `Juego` como clase o record?
- ¿cómo encontramos juegos que contienen la palabra “Mario”?

### Error típico del estudiante
Meter toda la lógica de búsqueda directamente en `main`.

---

## Bloque 4 · `DiccionarioStockDemo`
**Duración sugerida:** 10 minutos

### Objetivo
Presentar una estructura distinta a la lista: el diccionario.

### Qué mostrar en el código
- `StockConsolas.java`
- `Main.java`

### Qué explicar
- diferencia entre lista y mapa
- clave y valor
- inserción con `put()`
- consulta con `get()`
- recorrido con `entrySet()`

### Qué decir en clase
- si necesitas buscar por una clave exacta, un mapa suele tener más sentido que una lista
- aquí la clave es el nombre de la consola
- el valor es la cantidad en stock

### Preguntas útiles
- si quiero saber rápidamente el stock de “PS5”, ¿lista o mapa?
- ¿qué representa la clave?
- ¿qué representa el valor?

### Error típico del estudiante
Usar una lista para todo por costumbre, incluso cuando el problema pide clave-valor.

---

## Bloque 5 · `StackHistorialDemo`
**Duración sugerida:** 10 minutos

### Objetivo
Enseñar una estructura con una lógica distinta: LIFO.

### Qué mostrar en el código
- `HistorialAcciones.java`
- `Main.java`

### Qué explicar
- qué significa LIFO
- `push()` agrega una acción
- `pop()` elimina la última acción registrada
- caso de uso natural: deshacer

### Qué decir en clase
- esta estructura no reemplaza a una lista ni a un mapa
- resuelve otro tipo de problema
- aquí importa el orden de entrada y salida

### Preguntas útiles
- si quiero deshacer la última acción, ¿qué estructura tiene más sentido?
- ¿por qué no usar simplemente una lista cualquiera?
- ¿qué significa que el último en entrar es el primero en salir?

### Error típico del estudiante
Confundir “último elemento” con “último índice” sin comprender la idea de pila.

---

## Bloque 6 · `PuertoGamesColeccionesSemana4`
**Duración sugerida:** 25 a 30 minutos

### Objetivo
Cerrar la clase con un caso más completo y cercano a una aplicación real.

### Qué mostrar en el código
- `model/Videojuego.java`
- `data/GestorVideojuegos.java`
- `ui/Main.java`
- `resources/videojuegos.txt`

### Qué explicar
- el archivo externo contiene datos crudos
- cada línea del archivo se convierte en un objeto `Videojuego`
- esos objetos se guardan en un `ArrayList`
- luego la colección se recorre, se busca y se filtra
- la lógica no está mezclada toda en una sola clase

### Qué decir en clase
- este proyecto une POO y colecciones de forma más realista
- aparece una separación de responsabilidades:
  - `model` representa datos
  - `data` concentra la lógica de gestión
  - `ui` ejecuta el flujo principal
- una colección no es solo una lista de textos: puede contener objetos completos con significado

### Preguntas útiles
- ¿por qué conviene convertir la línea de texto a objeto?
- ¿por qué el archivo no se procesa completo en `main`?
- ¿qué ventaja tiene separar `model`, `data` y `ui`?
- ¿dónde ocurre la búsqueda?
- ¿dónde ocurre el filtrado?

### Error típico del estudiante
- leer el archivo y dejar todo como `String`
- no separar responsabilidades
- hacer parsing, búsqueda e impresión todo en `main`

---

# Qué puedes remarcar como ideas transversales

## 1. No todas las colecciones sirven para lo mismo
- `ArrayList` → colección ordenada y flexible
- `HashMap` → acceso por clave
- `Stack` → deshacer / LIFO

## 2. Las colecciones también guardan objetos
No solo strings o enteros. En programación orientada a objetos, lo valioso es guardar entidades del dominio.

## 3. Separar responsabilidades mejora el diseño
Incluso en ejemplos simples, es bueno mostrar que:
- `main` coordina
- el modelo representa datos
- otra clase puede gestionar la colección

## 4. Programar por capas pequeñas mejora la comprensión
No se necesita una arquitectura gigante, pero sí un orden mínimo.

---

# Sugerencia metodológica de cierre

## Cierre conceptual sugerido
Al terminar la clase, puedes cerrar con algo como:

> Hoy vimos que una colección no es solo una forma de guardar datos, sino una herramienta que cambia según el problema que queremos resolver.
> Si necesitamos una lista dinámica, usamos `ArrayList`.
> Si necesitamos buscar por clave, usamos `HashMap`.
> Si necesitamos deshacer acciones, usamos `Stack`.
> Y cuando trabajamos con objetos, las colecciones nos permiten construir sistemas más cercanos a casos reales.

---

# Qué no cubre esta semana todavía
Para evitar mezclar contenidos, esta semana no entra fuerte en:
- Maven con dependencias externas
- Apache POI
- lectura de Excel
- empaquetado `.jar`
- estructuras personalizadas complejas
- librerías propias

Eso conversa más con la semana siguiente.

---

# Recomendación final para ti

Si el tiempo es corto, el orden mínimo que yo sí haría es:

1. `ColeccionesArrayListDemo`
2. `ListasYFiltradoDemo`
3. `DiccionarioStockDemo`
4. `StackHistorialDemo`
5. `PuertoGamesColeccionesSemana4`

Si estás muy justo de tiempo, puedes resumir los tres primeros y dejar el proyecto `PuertoGamesColeccionesSemana4` como cierre principal.

Ese proyecto es el que mejor aterriza la guía en algo con cara de sistema real.
