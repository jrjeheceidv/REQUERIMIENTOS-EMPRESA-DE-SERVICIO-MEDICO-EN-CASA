# REQUERIMIENTOS-EMPRESA-DE-SERVICIO-MEDICO-EN-CASA
repositorrio para empresa de servicio medico. que incluye los requerimientos funcionales, no funcionales y de dominio
# Empresa de Servicio Médico en Casa - UNIAJC

## Descripción del Proyecto
Este proyecto consiste en el desarrollo de un algoritmo continuo en Java que permite gestionar el proceso de registro, selección de plan preventivo, cálculo de costos mensuales con descuentos clínicos, visualización de información y respaldo en archivo de texto (`.TXT`) para una empresa de servicios médicos en casa.

---

## Levantamiento de Requerimientos

### Requerimientos Funcionales (RF)
* **RF-01 Menú de opciones:** El sistema debe presentar un menú interactivo en consola para permitir la navegación por todas las funciones de la aplicación.
* **RF-02 Registro de cliente:** El sistema debe capturar el nombre, cédula, síntomas y dirección de residencia del paciente.
* **RF-03 Selección de tipo de plan:** El sistema debe permitir elegir entre el Plan Básico (PB: $275.325 COP) y el Plan Premium (PP: $325.650 COP).
* **RF-04 Cantidad de otros usuarios:** El sistema debe solicitar el número entero de personas adicionales cubiertas en el plan.
* **RF-05 Cálculo del valor mensual:** El sistema debe calcular el valor mensual multiplicando la tarifa del plan por la cantidad de personas registradas.
* **RF-06 Aplicación de descuento:** El sistema debe aplicar un 12.5% de descuento sobre el valor en ambos planes si el síntoma reportado es "gripa" o "alergia".
* **RF-07 Visualizar información:** El sistema debe permitir consultar en pantalla el resumen de todos los datos ingresados y los totales calculados.
* **RF-08 Salir y ciclo continuo:** El sistema opera continuamente mediante un ciclo `while`, permitiendo interrumpir la factura si el médico escribe la palabra "medicamento" o elige la opción de salir.

### Requerimientos No Funcionales (RNF)
* **RNF-01 Respaldo en archivo TXT:** La información del servicio debe respaldarse en un archivo local de formato `.TXT` empleando las clases `FileWriter` y `BufferedWriter` dentro de un bloque `try-catch`.
* **RNF-02 Formato monetario:** Los valores calculados deben presentarse en formato de moneda colombiana (`COP`) haciendo uso de la clase `NumberFormat`.
* **RNF-03 Lenguaje de programación:** La solución debe ser desarrollada e implementada completamente en Java.

### Requerimientos de Dominio (RD)
* **RD-01 Tarifas institucionales:** Las tarifas fijas aplicadas corresponden al Plan Básico ($275.325 COP) y Plan Premium ($325.650 COP).
* **RD-02 Descuentos clínicos:** Las rebajas comerciales del 12.5% aplican única y exclusivamente ante diagnósticos sintomáticos de "gripa" o "alergia".
* **RD-03 Ley de Protección de Datos:** El tratamiento de los datos personales (nombre, cédula y dirección) se rige bajo la Ley Estatutaria 1581 de 2012 de Colombia.

---

## Product Backlog (Inventario de Trabajo Pendiente)

| Identificador | Título de la Historia de Usuario | Tipo de Requisito | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **HU-01** | Registro de Cliente | Funcional | Alta | Finalizado |
| **HU-02** | Selección de Tipo de Plan | Funcional | Alta | Finalizado |
| **HU-03** | Registro de Otros Usuarios | Funcional | Media | Finalizado |
| **HU-04** | Cálculo de Valor Mensual | Funcional | Alta | Finalizado |
| **HU-05** | Respaldo en Archivo TXT | No Funcional | Media | Finalizado |
| **HU-06** | Aplicación de Descuento | Funcional | Media | Finalizado |
| **HU-07** | Visualización de Información | Funcional | Alta | Finalizado |
| **HU-08** | Control de Salida y Ciclo Continuo | Funcional | Alta | Finalizado |
| **HU-09** | Protección de Datos Personales | Dominio | Alta | Finalizado |

---

## Historias de Usuario (HU)

### HU-01: Registro de Cliente
* **Como** médico o asesor del servicio médico en casa,
* **Quiero** registrar el nombre, cédula, síntomas y dirección de residencia del cliente,
* **Para** identificar al paciente y conocer su ubicación y condición clínica inicial.
* **Criterios de Aceptación:**
  - Permite ingresar datos de texto mediante el teclado (`Scanner`).
  - Si en el nombre se escribe la palabra "medicamento", se interrumpe y finaliza la factura actual por orden médica.

### HU-02: Selección de Tipo de Plan
* **Como** cliente o usuario del servicio médico,
* **Quiero** seleccionar el plan ingresando las siglas **PB** (Plan Básico) o **PP** (Plan Premium),
* **Para** asociar la tarifa base del servicio contratado.
* **Criterios de Aceptación:**
  - Asigna $275.325 COP si se ingresa "PB".
  - Asigna $325.650 COP si se ingresa "PP".

### HU-03: Registro de Otros Usuarios
* **Como** titular del plan médico,
* **Quiero** ingresar la cantidad de personas adicionales cubiertas como un número entero,
* **Para** extender la cobertura preventiva a mi grupo familiar.
* **Criterios de Aceptación:**
  - El sistema captura de manera correcta un número de tipo entero.

### HU-04: Cálculo de Valor Mensual
* **Como** operador del sistema,
* **Quiero** que el sistema calcule automáticamente el valor mensual (costo del plan × personas cubiertas),
* **Para** obtener el total del presupuesto de forma inmediata.
* **Criterios de Aceptación:**
  - La operación matemática se ejecuta automáticamente y el resultado se presenta formateado en moneda colombiana (`COP`).

### HU-05: Respaldo en Archivo TXT
* **Como** administrador del sistema,
* **Quiero** que los datos del registro y la factura se almacenen en un archivo de texto (`.TXT`),
* **Para** mantener persistencia y soporte auditable de las transacciones.
* **Criterios de Aceptación:**
  - Se genera el archivo local mediante `FileWriter` y `BufferedWriter`.
  - Contiene una estructura limpia con fecha, hora y detalle de cobro.

### HU-06: Aplicación de Descuento
* **Como** paciente con síntoma de gripa o alergia,
* **Quiero** que se aplique un 12.5% de descuento sobre el valor mensual,
* **Para** acceder al beneficio económico instituido por la empresa.
* **Criterios de Aceptación:**
  - Evalúa la condición clínica ingresada y aplica el descuento en caso de coincidencia.

### HU-07: Visualización de Información
* **Como** usuario del sistema,
* **Quiero** visualizar en pantalla el resumen completo de la transacción,
* **Para** verificar la exactitud de los datos antes de finalizar.
* **Criterios de Aceptación:**
  - Despliega en consola el detalle completo del registro y cobro.

