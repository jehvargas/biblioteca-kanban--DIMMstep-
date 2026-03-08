# Mini-Proyecto POO – Consulta de Materiales

## Funcionalidad desarrollada

Esta parte del proyecto implementa la funcionalidad **Consultar materiales disponibles y materiales comprados** dentro del sistema de gestión de la tienda.

El objetivo es permitir al usuario visualizar qué materiales se encuentran disponibles para comprar y cuáles ya han sido comprados.

La implementación se realizó dentro de la clase **TiendaService**, agregando los métodos:

* `consultarMaterialesDisponibles()`
* `consultarMaterialesComprados()`

Estos métodos recorren la lista de materiales registrados en el sistema y verifican su disponibilidad utilizando la interfaz `Comprable`.

---

# Cumplimiento de los conceptos de Programación Orientada a Objetos

## 1. Relaciones entre clases

En esta funcionalidad se utiliza una **relación de asociación** entre la clase `TiendaService` y la clase `Material`.

`TiendaService` mantiene una lista de materiales:

```
List<Material> materiales
```

Esto permite almacenar diferentes tipos de materiales como:

* Carne
* Verdura
* Olla
* Utensilios

---

## 2. Encapsulamiento y control de acceso

Los atributos de las clases se encuentran encapsulados y se accede a ellos mediante métodos públicos como:

* `getInfo()`
* `estaDisponible()`

Esto evita modificar directamente los atributos internos de los objetos.

---

## 3. Herencia

La clase abstracta `Material` funciona como clase base del sistema.

Las clases que heredan de ella son:

* `Carne`
* `Verdura`
* `Olla`
* `Utensilios`

Estas clases reutilizan atributos comunes como:

* id
* tipo
* valor
* disponible

---

## 4. Polimorfismo

Se utiliza polimorfismo al almacenar diferentes tipos de materiales dentro de una lista de tipo:

```
List<Material>
```

Esto permite que objetos de distintas clases puedan tratarse de manera uniforme al momento de consultarlos.

---

## 5. Uso de Interfaces

Las clases que representan materiales implementan la interfaz:

```
Comprable
```

Esta interfaz define los métodos:

* `comprar()`
* `estaDisponible()`

La consulta de materiales utiliza el método `estaDisponible()` para determinar si un material está disponible o no.

---

## 6. Uso de static

La clase `Material` utiliza una variable `static` llamada `contador` que permite generar automáticamente identificadores únicos para cada material registrado.

Esto garantiza que cada material tenga un ID diferente dentro del sistema.

---

# Casos de prueba manuales

A continuación se presentan algunos escenarios utilizados para verificar el correcto funcionamiento de la funcionalidad implementada.

---

## Caso de prueba 1: Registro de material

Entrada del usuario:

Nombre: Juan
Email: [juan@email.com](mailto:juan@email.com)
ID: 1

Material seleccionado: Carne
Nombre: Res
Fecha de vencimiento: 10/06/2026
Precio: 15000

Resultado esperado:

El material se registra correctamente en el sistema y aparece en la lista de materiales.

---

## Caso de prueba 2: Consultar materiales disponibles

Acción realizada:

Seleccionar la opción **1 – Ver disponibles**

Resultado esperado:

El sistema muestra todos los materiales que tienen el atributo `disponible = true`.

Ejemplo de salida:

```
Materiales disponibles:
ID: 1 Tipo: Carne Valor: 15000
```

---

## Caso de prueba 3: Consultar materiales comprados

Acción realizada:

Seleccionar la opción **2 – Ver comprados**

Resultado esperado:

El sistema muestra todos los materiales cuyo atributo `disponible = false`.

---

## Caso de prueba 4: Registro de múltiples materiales

Materiales registrados:

* Carne
* Verdura
* Olla

Acción realizada:

Consultar materiales disponibles.

Resultado esperado:

El sistema muestra los tres materiales registrados.

---

## Caso de prueba 5: Material comprado

Acción realizada:

Comprar un material utilizando el método `comprar()`.

Luego consultar materiales comprados.

Resultado esperado:

El sistema muestra el material comprado dentro de la lista de materiales no disponibles.

Ejemplo de salida:

```
Materiales comprados:
ID: 3 Tipo: Olla Valor: 80000
```

---

# Conclusión

La funcionalidad implementada permite consultar el estado de los materiales registrados en el sistema, diferenciando entre materiales disponibles y materiales ya comprados.

Esta implementación demuestra el uso de conceptos fundamentales de Programación Orientada a Objetos como herencia, polimorfismo, encapsulamiento e interfaces, cumpliendo con los requisitos establecidos en la guía del mini-proyecto.
