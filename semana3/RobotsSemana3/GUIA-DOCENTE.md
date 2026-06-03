# Guía docente - RobotsSemana3

## Objetivo de uso en clase

Utilizar un ejemplo temático de **robots de combate** para enseñar los contenidos de la semana 3 sin abandonar la alineación con la guía institucional.

## Idea pedagógica central

Primero se enseña el **concepto** en un dominio llamativo.
Después se hace la **traducción** al dominio formal del material institucional.

## Traducción sugerida al contexto oficial

| Proyecto temático | Contexto guía oficial |
|---|---|
| Piloto | Cliente |
| Rut | Rut |
| Direccion | Direccion |
| Robot | Entidad principal del sistema |
| RutInvalidoException | Excepción personalizada de validación |

## Secuencia sugerida para la clase

### Inicio
- Recordar semana 2: clases, atributos, composición y paquetes.
- Mostrar que el proyecto ahora crece sin romper la estructura anterior.

### Desarrollo
1. Revisar `Rut` como clase especializada.
2. Explicar por qué validar dentro de `Piloto` sería mala idea.
3. Presentar `RutInvalidoException` como error de negocio.
4. Revisar la relación `Piloto has-a Rut`.
5. Revisar la relación `Piloto has-a Direccion`.
6. Revisar la relación `Robot has-a Piloto`.
7. Ejecutar el `Main` mostrando caso válido y caso inválido.

### Cierre
- Pedir al estudiante que traduzca el ejemplo a `Cliente`, `Rut` y `Direccion`.
- Preguntar qué parte del diseño se puede reutilizar en otro dominio.

## Preguntas guía para estudiantes

- ¿Por qué `Rut` debería ser una clase y no solo un `String` dentro de `Piloto`?
- ¿Qué ventaja tiene lanzar una excepción personalizada?
- ¿Qué relación existe entre `Piloto` y `Direccion`?
- ¿Qué relación existe entre `Robot` y `Piloto`?
- ¿Qué partes del proyecto se reutilizan si cambiamos el dominio?

## Evidencias de aprendizaje visibles

- uso de composición y asociación
- encapsulamiento
- validación desde constructor y setter
- reutilización de lógica
- manejo de errores con `try-catch`

## Sugerencia de actividad posterior

Pedir a los estudiantes que creen una variante del proyecto usando contexto de negocio tradicional:
- `Cliente`
- `Rut`
- `Direccion`
- `Pedido` o `Cuenta`

Así comprueban que comprendieron el **modelo**, no solo la historia de los robots.
