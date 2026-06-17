# Explicacion del proyecto PuertoGamesSemana5

## 1. Que dice la guia
La guia de semana 5 propone un proyecto Maven llamado `PuertoGamesSemana5`, con:
- `groupId`: `com.puertogames`
- `artifactId`: `videojuegos`
- uso de una libreria como **Apache POI** para leer archivos `.xlsx`
- organizacion del proyecto en paquetes:
  - `ui`
  - `data`
  - `model`
- construccion de un `.jar` ejecutable

## 1.1 Que se ajusto en esta version oficial
En esta carpeta de `semana5` se priorizo una version **portable y lista para probar**. Como en este entorno no hay Maven disponible, la lectura del archivo `.xlsx` se implemento con Java estandar mediante un lector simple basado en ZIP + XML.

Eso significa:
- se mantiene el objetivo pedagogico de leer Excel y organizar el proyecto
- se evita depender de instalaciones externas para poder probarlo
- el proyecto compila con `javac` y se ejecuta con `java` directamente

## 2. Como se tradujo al proyecto
### Paquete `model`
Contiene la clase `Videojuego`, que representa un registro del Excel.

### Paquete `data`
Contiene dos clases:
- `LectorXlsxSimple`, que lee el archivo Excel `.xlsx` usando Java estandar
- `GestorVideojuegos`, que transforma las filas leidas en objetos y administra una coleccion `ArrayList<Videojuego>`

### Paquete `ui`
Contiene la clase `Main`, que coordina la ejecucion, muestra resultados y demuestra el uso del gestor.

## 3. Que demuestra tecnicamente
Este proyecto permite mostrar en clase:
- organizacion de un proyecto modular en Java
- lectura de archivos Excel `.xlsx`
- transformacion de filas en objetos Java
- encapsulamiento de la logica en clases separadas
- uso de colecciones (`ArrayList`)
- metodos de busqueda y filtrado
- compilacion y empaquetado de un `.jar` ejecutable
- diferencia entre una solucion con dependencias externas y una portable

## 4. Flujo del programa
1. `Main` crea un `GestorVideojuegos`.
2. `LectorXlsxSimple` abre `videojuegos.xlsx` desde `resources` y extrae sus filas.
3. `GestorVideojuegos` convierte cada fila del Excel en un objeto `Videojuego`.
4. Los objetos se guardan en un `ArrayList`.
5. Luego se demuestra:
   - listado completo
   - busqueda por codigo
   - filtrado por genero

## 5. Por que esta bien para la semana 5
Porque cruza exactamente lo que busca la guia:
- proyecto modular
- organizacion en paquetes
- colecciones de objetos
- lectura de datos externos
- distribucion posterior como `.jar`
- una implementacion que se puede probar inmediatamente en clase o en laboratorio

## 6. Que podrias enseñar en clase con este proyecto
En 2 horas puedes demostrar:
- estructura de paquetes
- modelado de `Videojuego`
- lectura de Excel en `LectorXlsxSimple`
- carga de objetos en `GestorVideojuegos`
- ejecucion desde `Main`
- empaquetado final con `build.sh`
