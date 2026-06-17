# Explicacion del proyecto PuertoGamesSemana5

## 1. Que dice la guia
La guia de semana 5 propone un proyecto Maven llamado `PuertoGamesSemana5`, con:
- `groupId`: `com.puertogames`
- `artifactId`: `videojuegos`
- uso de **Apache POI** para leer archivos `.xlsx`
- organizacion del proyecto en paquetes:
  - `ui`
  - `data`
  - `model`
- construccion de un `.jar` ejecutable

## 2. Como se tradujo al proyecto
### Paquete `model`
Contiene la clase `Videojuego`, que representa un registro del Excel.

### Paquete `data`
Contiene la clase `GestorVideojuegos`, que tiene dos responsabilidades acotadas:
- leer el archivo Excel con Apache POI
- administrar una coleccion `ArrayList<Videojuego>`

### Paquete `ui`
Contiene la clase `Main`, que coordina la ejecucion, muestra resultados y demuestra el uso del gestor.

## 3. Que demuestra tecnicamente
Este proyecto permite mostrar en clase:
- uso de Maven como gestor de dependencias
- incorporacion de una libreria externa real (`poi-ooxml`)
- lectura de archivos Excel `.xlsx`
- transformacion de filas en objetos Java
- encapsulamiento de la logica en clases separadas
- uso de colecciones (`ArrayList`)
- metodos de busqueda y filtrado
- preparacion de un `.jar` ejecutable

## 4. Flujo del programa
1. `Main` crea un `GestorVideojuegos`.
2. `GestorVideojuegos` abre `videojuegos.xlsx` desde `resources`.
3. Cada fila del Excel se convierte en un objeto `Videojuego`.
4. Los objetos se guardan en un `ArrayList`.
5. Luego se demuestra:
   - listado completo
   - busqueda por codigo
   - filtrado por genero

## 5. Por que esta bien para la semana 5
Porque cruza exactamente lo que busca la guia:
- proyecto modular
- uso de librerias externas
- organizacion en paquetes
- colecciones de objetos
- lectura de datos externos
- distribucion posterior como `.jar`

## 6. Que podrias enseñar en clase con este proyecto
En 2 horas puedes demostrar:
- creacion del proyecto Maven
- estructura de paquetes
- agregado de Apache POI al `pom.xml`
- modelado de `Videojuego`
- carga de Excel en `GestorVideojuegos`
- ejecucion desde `Main`
- empaquetado final con Maven
