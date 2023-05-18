# Taller 6 (Laboratorio): 
### Elaboración de ejercicios de Estructuras de datos en Programación Orientada a Objetos: Estructuras estáticas.

---
#### Problemática 1
---
Se requiere administrar hospitales del país. Por cada entidad hospitalaria se necesita algunos atributos tales como: nombre del hospital, ciudad del hospital, número de especialidades, conjunto de médicos, conjunto de enfermeros o enfermeras, total de sueldos a cancelar por mes del personal del hospital, dirección del hospital.

Considerandos:

* La ciudad del hospital deberá se una entidad que tenga como características: nombre de la ciudad, provincia de la ciudad.
* Un médico se lo considera con atributos como: nombre del doctor, especialidad, sueldo mensual.
* Un efermero o enfermera tiene las siguientes características: nombre, tipo (nombramiento, contrato) y sueldo mensual.
* El sueldo total a cancelar es igual a la suma de los sueldos del conjunto de médicos y enfermeros(as) que forman parte de su personal.
* La solución debe tener dos paquetes.
* Las entidades deben tener constructores.
* En una clase llamada Principal, con el método main, se debe generar un objeto del tipo entidad hospitalaria. Se debe agregar sus valores por teclado.
* Al finalizar le proceso de ingreso; se debe imprimir el objeto (usar el método toString. Por ejemplo

```
HOSPITAL ZARUMA
Dirección: Barrio Central
Ciudad: Zaruma 
Provincia: El Oro
Número de especialidades: 7
Listado de médicos
- Richard Obrien - sueldo: 1000 - Pediatría
- Jacob Mcintyre - sueldo: 1100 - General
- Craig Alexander - sueldo: 1200 - Pediatría
- John Hernandez - sueldo: 1000 - Internista

Listado de enfermeros(as)
- William Bradshaw - sueldo: 800 - contrato
- Jennifer Muñoz - sueldo: 700 - contrato
- Jeffrey Bryant - sueldo: 1000 - nombramiento

Total de sueldos a pagar por mes: 13600
```

Se debe generar la solución en lenguaje de programación Java

---
#### Problemática 2
---

Sistema de Calificaciones de Estudiantes de un ciclo

Desarrolla un programa para gestionar las calificaciones de los estudiantes de ***las materias*** de determinado ciclo. El programa debe tener dos clases principales: "Estudiante" y "Materia".

Del Estudiante se registra su: nombre, edad y las materias a cruzar.

Se debe verificar la aprobación dadas tres calificaciones y el nombre de cada materia: ACD (3.5/10), APE (3.5/10) y AA (3/10). Se aprueba si la sumatoria es de al menos 70%, si cumple con este requisito, se considera que ha aprobado, caso contrario informar al estudiante que deberá rendir un examen de recuperación sobre 3.5/10 pts. agregado al 60% acumulado de los componentes ACD, APE y AA.

Ahora, debe implementar los siguientes requisitos en su programa:

- El programa debe permitir al usuario ingresar los datos de un estudiante, incluyendo su nombre y edad.
- El programa debe permitir al usuario ingresar los datos de una materia, incluyendo su nombre y las calificaciones del estudiante en las categorías ACD, APE y AA.
- El programa debe permitir al usuario vincular una materia a un estudiante, es decir, agregar la materia al estudiante.
- El programa debe verificar si un estudiante ha aprobado una materia específica. Para ello, se deben evaluar las calificaciones del estudiante en las tres categorías (ACD, APE y AA).
- En el caso de retrobar una materia (con o sin supletorio), el estudiante tendrá la opción de rendir un examen de convalidación al final del ciclo académico y aprobarla. Si este es el caso, de igual forma se debe registrar la nota del examen de convalidación. 

Cree una clase de prueba/ejecutor (quien contiene el método main()), quien prueba la funcionalidad de este escenario, mostrando un reporte completo del registro del estudiante para un ciclo. 

