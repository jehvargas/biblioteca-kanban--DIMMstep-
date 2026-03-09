# Sistema de Gestión de Tienda de Materiales

## Descripción del Proyecto

Este proyecto consiste en un sistema desarrollado en **Java** que permite gestionar una tienda de materiales.
El sistema permite registrar usuarios, registrar materiales, realizar compras, realizar reembolsos y consultar el estado de los materiales.

También incluye un cálculo del **costo final de los materiales aplicando un impuesto del 10%**, utilizando una clase adicional llamada `CalculadoraCosto`.

---

# Conceptos de Programación Orientada a Objetos Aplicados

## 1. Herencia

Se implementa herencia mediante la clase abstracta `Material`, que sirve como clase base para diferentes tipos de materiales.

Ejemplo:

* `Carne`
* `Verdura`
* `Olla`
* `Utensilios`

Todas estas clases **heredan de la clase `Material`**, reutilizando atributos como:

* id
* tipo
* valor
* disponible

Esto permite mantener una estructura organizada y reutilizable.

---

## 2. Interfaces

Se utiliza la interfaz `Comprable` para definir comportamientos que todos los materiales comprables deben implementar.

La interfaz contiene los métodos:

* `comprar()`
* `estaDisponible()`
* `reembolsar()`

Todas las clases de materiales implementan esta interfaz, lo que garantiza que todos los materiales tengan estas funcionalidades.

---

## 3. Encapsulamiento

Las clases utilizan atributos **privados** o **protegidos**, y el acceso a ellos se realiza mediante **métodos públicos (getters)**.

Ejemplo en la clase `Usuario`:

* id
* nombre
* email

Estos atributos se acceden mediante:

* `getId()`
* `getNombre()`
* `getEmail()`

Esto protege la información interna de las clases.

---

## 4. Polimorfismo

Se utiliza polimorfismo cuando los materiales se manejan a través de la interfaz `Comprable`.

Ejemplo en `TiendaService`:

Se verifica si un material es comprable y se usa su comportamiento correspondiente:

```java
if (m instanceof Comprable) {
    Comprable c = (Comprable) m;
}
```

Esto permite tratar diferentes tipos de materiales de forma general.

---

## 5. Uso de Colecciones

Se utilizan **listas (`ArrayList`)** para almacenar información del sistema.

Ejemplos:

* Lista de materiales
* Lista de usuarios
* Lista de compras realizadas

Esto permite almacenar y gestionar múltiples elementos dinámicamente.

---

## 6. Separación de responsabilidades

El proyecto se organiza en varias clases con responsabilidades específicas:

| Clase                               | Responsabilidad                      |
| ----------------------------------- | ------------------------------------ |
| Material                            | Clase base para todos los materiales |
| Carne / Verdura / Olla / Utensilios | Tipos específicos de materiales      |
| Usuario                             | Información de los usuarios          |
| Compra                              | Registro de compras realizadas       |
| TiendaService                       | Lógica principal del sistema         |
| CalculadoraCosto                    | Cálculo del costo final con impuesto |
| Main                                | Ejecución del programa               |

---

# Funcionamiento del Sistema

El sistema permite:

1. Registrar un usuario
2. Registrar materiales
3. Mostrar materiales disponibles
4. Realizar compras
5. Realizar reembolsos (opcional)
6. Consultar materiales disponibles o comprados
7. Calcular el costo final de las compras con impuesto

---

# Casos de Prueba Manuales

## Caso de prueba 1 – Registro de usuario

**Entrada**




<img width="374" height="88" alt="image" src="https://github.com/user-attachments/assets/817d71bd-e5c1-4b14-a831-fb29f3d4bcbc" />



---

## Caso de prueba 2 – Registro de material

**Entrada**



<img width="400" height="251" alt="image" src="https://github.com/user-attachments/assets/312f2842-5f77-4b18-8b38-13265d8b4ec0" />


---

## Caso de prueba 3 – Realizar compra

**Entrada**




<img width="569" height="177" alt="image" src="https://github.com/user-attachments/assets/07cda794-7ec5-448f-a918-5ba53a8b8115" />

---

## Caso de prueba 4 – Reembolso de material

**Entrada**



<img width="517" height="198" alt="image" src="https://github.com/user-attachments/assets/9b995f38-738d-4127-ae88-80b4332c1568" />


---

## Caso de prueba 5 – Cálculo del costo final

**Entrada**



<img width="749" height="154" alt="image" src="https://github.com/user-attachments/assets/cfaeb977-c2d4-4493-aa03-e839e9e12328" />


---

# Conclusión

El sistema implementa correctamente los principales conceptos de **Programación Orientada a Objetos**, incluyendo:

* Herencia
* Interfaces
* Encapsulamiento
* Polimorfismo
* Uso de colecciones

Además, permite simular el funcionamiento básico de una tienda de materiales, incluyendo la gestión de compras, reembolsos y cálculo de costos.

---

