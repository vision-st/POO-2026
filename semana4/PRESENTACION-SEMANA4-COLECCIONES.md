# Semana 4 · Manejando colecciones en Java
## Programación Orientada a Objetos · PRY2202

- Tema central: uso de colecciones provistas por Java
- Enfoque: ejemplos pequeños + proyecto integrador
- Contexto: almacenamiento, recorrido, búsqueda y filtrado de objetos

---

# Objetivo de la clase

Al finalizar la clase, el estudiantado debería ser capaz de:

- identificar qué es una colección en Java
- diferenciar una colección de un arreglo tradicional
- usar `ArrayList`, `List`, `HashMap` y `Stack`
- recorrer y filtrar datos dentro de una colección
- almacenar objetos dentro de estructuras dinámicas
- reconocer una organización simple en paquetes: `model`, `data`, `ui`

---

# ¿Qué problema resuelven las colecciones?

Cuando trabajamos con múltiples datos, necesitamos estructuras que permitan:

- crecer dinámicamente
- recorrer elementos con facilidad
- buscar información
- eliminar o agregar datos
- organizar objetos del dominio

## Idea clave
Un arreglo sirve, pero una colección suele ser más flexible.

---

# Arreglo vs colección

## Arreglo
- tamaño fijo
- menos flexible
- útil cuando la cantidad ya está definida

## Colección
- tamaño dinámico
- operaciones integradas
- mejor para aplicaciones con datos cambiantes

## Pregunta para el curso
¿Qué usarías si no sabes cuántos elementos tendrás durante la ejecución?

---

# Colecciones trabajadas en esta semana

Vamos a revisar 4 estructuras principales:

1. `ArrayList`
2. `List` + `ArrayList`
3. `HashMap`
4. `Stack`

Y luego cerraremos con un proyecto integrador:

5. `PuertoGamesColeccionesSemana4`

---

# Estructura del repo

```text
POO/
└── semana4/
    ├── README.md
    ├── GUIA-DOCENTE-SEMANA4.md
    ├── ColeccionesArrayListDemo/
    ├── ListasYFiltradoDemo/
    ├── DiccionarioStockDemo/
    ├── StackHistorialDemo/
    └── PuertoGamesColeccionesSemana4/
```

## Idea
Cada proyecto cubre un concepto específico sin mezclar todo innecesariamente.

---

# Proyecto 1 · ColeccionesArrayListDemo

## Objetivo
Introducir `ArrayList` como colección dinámica.

## Conceptos mostrados
- `add()`
- `get()`
- `remove()`
- `size()`
- `for-each`

## Idea pedagógica
Partir simple: primero entender la estructura, luego el contexto.

---

# ¿Qué enseña ArrayList?

`ArrayList` permite guardar elementos en una lista que puede crecer o reducirse.

## Ventajas
- no se define tamaño fijo
- se puede recorrer fácilmente
- permite inserción y eliminación

## Caso del ejemplo
Un catálogo de nombres.

---

# Código conceptual · ArrayList

```java
ArrayList<String> nombres = new ArrayList<>();
nombres.add("Mario");
nombres.add("Luigi");
nombres.add("Peach");

System.out.println(nombres.get(0));
nombres.remove("Luigi");
```

## Pregunta para el curso
¿Qué cambia en la lista después de eliminar un elemento?

---

# Proyecto 2 · ListasYFiltradoDemo

## Objetivo
Mostrar la diferencia entre:
- la interfaz `List`
- la implementación `ArrayList`

## Además
- recorrido con `for-each`
- filtrado con `contains()`
- colección de objetos, no solo strings

---

# List y polimorfismo básico

```java
List<Juego> juegos = new ArrayList<>();
```

## Idea clave
La variable se declara como `List` porque nos importa el contrato general.

## Ventaja
Podemos cambiar la implementación sin reescribir toda la lógica.

---

# Búsqueda y filtrado

En este ejemplo se recorren juegos y se filtran los que contienen una palabra específica.

```java
if (juego.titulo().contains("Mario")) {
    System.out.println(juego);
}
```

## Conceptos reforzados
- recorrido
- condición
- filtrado por coincidencia

---

# Proyecto 3 · DiccionarioStockDemo

## Objetivo
Enseñar `HashMap` como estructura clave-valor.

## Conceptos mostrados
- `put()`
- `get()`
- clave
- valor
- recorrido con `entrySet()`

## Caso del ejemplo
Stock de consolas en una tienda.

---

# ¿Cuándo usar HashMap?

Cuando necesitas acceder a un dato usando una clave.

## Ejemplo
- clave: `"PS5"`
- valor: `10`

```java
stock.put("PS5", 10);
System.out.println(stock.get("PS5"));
```

## Pregunta para el curso
¿Tiene más sentido una lista o un mapa si quiero buscar por nombre exacto?

---

# Proyecto 4 · StackHistorialDemo

## Objetivo
Explicar la estructura `Stack`.

## Conceptos mostrados
- `push()`
- `pop()`
- LIFO

## Caso del ejemplo
Historial de acciones de un videojuego para deshacer la última acción.

---

# LIFO: Last In, First Out

La última acción en entrar es la primera en salir.

```java
acciones.push("Mover adelante");
acciones.push("Saltar");
acciones.push("Disparar");

String ultima = acciones.pop();
```

## Idea visual
Como una pila de platos.

---

# Comparando estructuras

| Estructura | Útil para | Ejemplo |
|---|---|---|
| `ArrayList` | lista dinámica | nombres, productos, libros |
| `List` | programar contra interfaz | colecciones flexibles |
| `HashMap` | clave-valor | stock, configuración |
| `Stack` | historial LIFO | deshacer acciones |

## Idea clave
No todas las colecciones sirven para el mismo problema.

---

# Proyecto integrador · PuertoGamesColeccionesSemana4

## Objetivo
Aplicar colecciones en un caso más realista.

## Qué hace
- lee datos desde archivo externo
- convierte texto a objetos `Videojuego`
- guarda esos objetos en una colección
- permite buscar y filtrar
- organiza el código en paquetes

---

# Estructura del proyecto integrador

```text
PuertoGamesColeccionesSemana4/
├── src/main/java/com/puertogames/
│   ├── model/Videojuego.java
│   ├── data/GestorVideojuegos.java
│   └── ui/Main.java
└── src/main/resources/videojuegos.txt
```

## Paquetes
- `model`: representa datos
- `data`: gestiona colección y carga
- `ui`: ejecuta el flujo principal

---

# Archivo externo

El proyecto usa un archivo de texto con este formato:

```text
Mario Kart;Carreras;45990
Minecraft;Sandbox;26990
Super Mario Odyssey;Aventura;49990
```

## Idea clave
El programa no depende de datos escritos a mano dentro del `main`.

---

# Conversión de texto a objeto

Cada línea del archivo se transforma en un objeto `Videojuego`.

## Pasos
1. leer línea
2. separar por `;`
3. obtener título, género y precio
4. construir objeto
5. agregar a la colección

## Aprendizaje importante
Una colección puede guardar objetos del dominio, no solo texto.

---

# Qué hace GestorVideojuegos

La clase `GestorVideojuegos` concentra la lógica principal:

- cargar datos desde archivo
- guardar objetos en `ArrayList`
- mostrar todos los videojuegos
- buscar por título
- filtrar por género

## Idea de diseño
Separar responsabilidades evita hacer todo en `main`.

---

# Búsqueda y filtrado en el integrador

## Ejemplos
- buscar títulos que contienen `Mario`
- filtrar videojuegos del género `Aventura`

## Conceptos integrados
- colección de objetos
- recorrido
- condición
- encapsulamiento de lógica

---

# Ideas de POO que aparecen en esta semana

Aunque el foco son colecciones, también aparecen principios de diseño:

- encapsulamiento
- separación de responsabilidades
- organización en paquetes
- modelado de objetos

## Ojo
No es solo “aprender métodos”, sino usarlos con intención.

---

# Errores comunes del estudiante

- pensar que colección = arreglo con otro nombre
- meter toda la lógica dentro de `main`
- usar una lista para cualquier problema
- no distinguir entre clave-valor y lista secuencial
- dejar los datos como `String` en vez de convertirlos a objetos

---

# Preguntas para la clase

- ¿Qué ventaja tiene una colección frente a un arreglo?
- ¿Cuándo usarías `HashMap` en vez de `ArrayList`?
- ¿Por qué `Stack` sirve para deshacer acciones?
- ¿Por qué es útil guardar objetos dentro de una colección?
- ¿Qué ganamos al separar `model`, `data` y `ui`?

---

# Cierre conceptual

## Lo aprendido
Hoy vimos que Java ofrece distintas colecciones para distintos problemas:

- `ArrayList` para listas dinámicas
- `List` para trabajar con interfaces
- `HashMap` para clave-valor
- `Stack` para orden LIFO

Y además vimos cómo estas estructuras pueden integrarse en un mini sistema real.

---

# Conclusión

Las colecciones no son un tema aislado.

Son una base para:
- almacenar objetos
- organizar información
- recorrer datos
- construir soluciones más cercanas a aplicaciones reales

## Próximo paso natural
Pasar de colecciones provistas por Java a estructuras más organizadas o reutilizables.

---

# Material disponible en el repo

- mini proyectos por tema
- guía docente
- proyecto integrador
- código comentado con Javadocs

## Recomendación
Usar los proyectos en este orden:
1. `ColeccionesArrayListDemo`
2. `ListasYFiltradoDemo`
3. `DiccionarioStockDemo`
4. `StackHistorialDemo`
5. `PuertoGamesColeccionesSemana4`

---

# Fin
## Semana 4 · Manejando colecciones en Java

Si quieres, el siguiente paso es convertir esta presentación en:
- versión para Gamma
- versión para Canva
- versión para PowerPoint
- o una versión más breve para clase sincrónica.
