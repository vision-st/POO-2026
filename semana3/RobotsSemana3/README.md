# RobotsSemana3

Proyecto Java correspondiente a la **semana 3** de la asignatura **Programación Orientada a Objetos**.

## Propósito del proyecto

Este proyecto continúa el trabajo realizado en `RobotsSemana2`, manteniendo la temática de **robots de combate** para enseñar los contenidos centrales de la semana 3 desde un contexto más atractivo para el estudiante.

La solución incorpora:
- **validación de atributos**
- **manejo de excepciones personalizadas**
- **relaciones entre múltiples clases**
- **reutilización de código**
- **continuidad estructural respecto de la semana 2**

## Alineación con la guía oficial

Aunque la guía institucional utiliza ejemplos como `Cliente`, `Rut` y `Direccion`, este proyecto traslada esos mismos conceptos al dominio de robots sin alterar el objetivo pedagógico.

### Equivalencias conceptuales
- `Piloto` → equivalente pedagógico de `Cliente`
- `Rut` → mismo concepto de identificación validable
- `Direccion` → misma relación de composición o asociación
- `Robot` → entidad principal del dominio que integra otras clases

## Resultado de aprendizaje trabajado

**RA1.** Desarrolla soluciones aplicando los principios fundamentales de la programación orientada a objetos, integrando la composición de clases y buenas prácticas de programación.

## Indicadores de logro abordados

- Modela entidades relevantes del problema mediante clases.
- Aplica encapsulamiento y separación de responsabilidades.
- Integra relaciones entre clases usando composición y asociación.
- Implementa validación de datos desde clases especializadas.
- Maneja errores del dominio con excepciones personalizadas.

## Contenidos de semana 3 evidenciados

### 1. Validación de atributos
La clase `Rut` valida el formato del dato recibido mediante una expresión regular.

Formato esperado:
- `XXXXXXXX-Y`

Ejemplo válido:
- `12345678-K`

Ejemplo inválido:
- `12.345.678-K`

### 2. Excepciones personalizadas
La clase `RutInvalidoException` permite reportar un error específico del dominio cuando el RUT no cumple el formato esperado.

### 3. Relaciones entre clases
El proyecto evidencia relaciones del tipo **has-a**:
- `Robot` has-a `Armamento`
- `Robot` has-a `Motor`
- `Robot` has-a `Piloto`
- `Piloto` has-a `Rut`
- `Piloto` has-a `Direccion`

### 4. Reutilización y modularidad
La lógica de validación no está duplicada dentro de `Piloto` ni de `Robot`. Se encapsula en `Rut`, respetando una responsabilidad clara por clase.

## Estructura del proyecto

```text
RobotsSemana3/
├── pom.xml
├── README.md
├── GUIA-DOCENTE.md
└── src/
    └── main/
        └── java/
            └── com/duoc/fabricarobots/
                ├── app/
                │   └── Main.java
                ├── model/
                │   ├── armamentobelico/
                │   │   └── Armamento.java
                │   ├── identidad/
                │   │   └── Rut.java
                │   ├── mecanismo/
                │   │   └── Motor.java
                │   ├── personas/
                │   │   └── Piloto.java
                │   ├── robots/
                │   │   ├── Robot.java
                │   │   └── acciones/
                │   │       └── Atacar.java
                │   └── ubicacion/
                │       └── Direccion.java
                └── util/
                    └── RutInvalidoException.java
```

## Flujo de demostración en `Main`

1. Se crean direcciones para los pilotos.
2. Se construyen RUT válidos.
3. Se crean pilotos con sus datos personales.
4. Se crean robots con motor, armamento y piloto.
5. Se ejecuta una simulación de combate.
6. Se prueba un caso inválido de RUT.
7. Se captura la excepción personalizada y se muestra el mensaje correspondiente.

## Aprendizajes esperados para estudiantes

Al revisar y ejecutar este proyecto, el estudiante debería ser capaz de:
- comprender por qué conviene separar la validación en una clase propia
- identificar relaciones entre objetos dentro de un modelo orientado a objetos
- distinguir entre error genérico y excepción de negocio
- reconocer cómo una misma lógica puede trasladarse a distintos dominios

## Ejecución

Si se desea compilar manualmente:

```bash
find src/main/java -name '*.java' | sort > sources.txt
javac @sources.txt
java -cp src/main/java com.duoc.fabricarobots.app.Main
```

## Observación pedagógica

Este proyecto fue diseñado como **ejemplo temático alternativo** al material institucional. Su valor didáctico está en facilitar la comprensión inicial mediante un contexto motivador, para luego traducir esos mismos conceptos al caso formal solicitado por la guía.
