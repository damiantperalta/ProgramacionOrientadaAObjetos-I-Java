# 📚 Proyectos en Java

Este repositorio reúne distintos programas desarrollados en **Java** para practicar conceptos de **Programación Orientada a Objetos, colecciones, excepciones, archivos y UML**.  

Algunos proyectos incluyen **diagramas UML**, aunque no todos los códigos cuentan con diagrama.  

---

## 📌 Lista de Proyectos

### 1. 🎬 Videoclub (Películas, Series y Videojuegos)  
- Implementa la interfaz **`Entregable`**.  
- Se gestionan **Películas, Series y Videojuegos** con atributos como título, género, director/compañía.  
- Uso de **herencia, interfaces, colecciones (`ArrayList`)** y **`Comparable`** para ordenar.  
- Funcionalidades:  
  - Registrar títulos.  
  - Entregar/devolver.  
  - Contar entregados.  
  - Identificar la película más antigua, la serie con más temporadas y el videojuego con más horas.  
- ✅ **Diagrama UML incluido**.  

---

### 2. 🏦 Sistema Bancario  
- Modelo de un banco con distintos tipos de cuentas:  
  - **CuentaAhorros** (tasa de interés).  
  - **CuentaCorriente** (límite de descubierto).  
- Usa **herencia, clases abstractas y excepciones personalizadas** (`SaldoInsuficienteException`).  
- Funcionalidades:  
  - Depósitos y retiros.  
  - Calcular promedio de saldos.  
  - Ordenar cuentas por saldo.  
  - Buscar cuentas.  


---

### 3. 🛩️ Estacionamiento de Avionetas  
- Simula la gestión de un estacionamiento con **capacidad limitada (12 lugares)**.  
- Usa **colas (`Queue`)** para organizar llegadas y salidas.  
- Funcionalidades:  
  - Registrar llegada (`E matrícula`).  
  - Registrar salida (`S matrícula`).  
  - Mostrar estado actual del estacionamiento.  
 

---

### 4. 🤖 Torneo de Robots  
- Crea distintos tipos de **robots**: Luchador, Tirador y Volador.  
- Todos heredan de la clase base **Robot** (energía, resistencia, fuerza).  
- Funcionalidades:  
  - Simular combates.  
  - Calcular energía promedio.  
  - Determinar el ganador.  
- ✅ **Diagrama UML incluido**.  

---

### 5. 🏥 Sistema de Hospital  
- Modelo de un hospital con **Pacientes y Doctores**.  
- Incluye:  
  - **Clases abstractas, interfaces, herencia y polimorfismo**.  
  - Excepción personalizada (**`SaludInvalidaException`**).  
  - Ordenación con **`Comparator`**.   

---

### 6. 👨‍💼 Registro de Empleados  
- Permite **agregar, modificar, eliminar y listar empleados**.  
- Uso de **`ArrayList`, `Iterator` y colecciones**.  
- Ejemplo práctico de **menús en consola y operaciones CRUD**.  

---

### 7. 📂 Procesamiento de Nombres  
- Lee un archivo de texto con nombres y los procesa.  
- Usa **`BufferedReader`, `BufferedWriter`, `HashMap`** para contar ocurrencias.  
- Ordena y guarda resultados en un archivo de salida.  
- Ejemplo de **manejo de archivos y colecciones**.  

---

### 8. 📑 Proyecto Final – Gestión de Personas  
- Manejo de objetos `Persona` y operaciones sobre ellos.  
- Funcionalidades:  
  - Guardar objetos en **archivo binario**.  
  - Eliminar registros.  
  - Generar y leer **CSV**.  
  - Buscar por DNI.  
- Incluye **`Serializable`**, excepciones personalizadas (`DniParException`) y colecciones.  
- Tiene menú general (`TestMenu`) para navegar opciones.  
- ⚠️ **UML parcial (no coincide al 100% con el código)**.  

---
