# Proyecto Semana 8 - Biblioteca Hibrida

## Contexto del negocio
Este proyecto modela una **biblioteca hibrida** que administra materiales fisicos y digitales.
A diferencia de PuertoGames, aqui el dominio es distinto: prestamos, descargas y reproduccion de muestras.

## Objetivo academico
Integrar en un solo proyecto:

- herencia
- polimorfismo
- interfaces
- colecciones genericas
- validacion de tipos en tiempo de ejecucion con `instanceof`
- organizacion por paquetes (`model`, `data`, `ui`, `util`)

## Estructura

```text
src/
├── model/
│   ├── MaterialBiblioteca.java
│   ├── Prestable.java
│   ├── Descargable.java
│   ├── Reproducible.java
│   ├── LibroFisico.java
│   ├── RevistaFisica.java
│   ├── Ebook.java
│   └── Audiolibro.java
├── data/
│   ├── Catalogo.java
│   └── GestorBiblioteca.java
├── util/
│   └── Separador.java
└── ui/
    ├── Main.java
    ├── MainGrafico.java
    └── BibliotecaFrame.java
```

## Dónde está cada concepto

### 1. Herencia
La clase abstracta `MaterialBiblioteca` actua como superclase.
Las clases `LibroFisico`, `RevistaFisica`, `Ebook` y `Audiolibro` heredan de ella.

### 2. Polimorfismo
El `GestorBiblioteca` trabaja con una coleccion de `MaterialBiblioteca`.
Eso permite recorrer materiales distintos usando una referencia comun.

### 3. Interfaces
- `Prestable`: para materiales que se pueden prestar.
- `Descargable`: para materiales que se pueden descargar.
- `Reproducible`: para materiales que pueden mostrar o reproducir una muestra.

### 4. Colecciones genericas
`Catalogo<T>` es una clase generica que encapsula una lista flexible.
En este caso se usa como `Catalogo<MaterialBiblioteca>`.

### 5. instanceof
Se usa en `GestorBiblioteca` para:
- identificar materiales prestables,
- identificar descargables,
- y mostrar el tipo real del objeto en tiempo de ejecucion.

## Cómo ejecutar
Desde la carpeta del proyecto:

### Version consola
```bash
mkdir -p out
javac -d out src/model/*.java src/data/*.java src/util/*.java src/ui/*.java
java -cp out ui.Main
```

### Version grafica
```bash
mkdir -p out
javac -d out src/model/*.java src/data/*.java src/util/*.java src/ui/*.java
java -cp out ui.MainGrafico
```

## Ganancia conceptual
Este proyecto muestra por que una interfaz no es adorno teorico:
permite que distintas clases compartan comportamientos sin obligarlas a pertenecer a una sola jerarquia funcional rigida.

Ademas, la evolucion con Swing muestra otra ventaja real: cuando el modelo y la logica estan razonablemente desacoplados, se puede agregar una nueva interfaz de usuario sin reescribir todo el proyecto.

---
Preparado por Balto para Jorge.
