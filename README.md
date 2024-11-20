Task

Se desea desarrollar un programa de consola que calcule el índice de masa corporal de una persona. La aplicación solicitara el peso de la persona (en kilogramos) y su estatura (en metros). El índice de masa corporal (IMC) se calcula utilizando la siguiente fórmula:

IMC = peso / estatura2

Luego, a partir del IMC obtenido se pueden calcular si una persona tiene un peso normal, inferior o superior al normal u obesidad. Para generar estos resultados el IMC calculado debe estar en los rangos de la tabla (Ver documento adjunto)

Requisitos:
Obligatorio realizar los pruebas unitarias (coverage mínimo 70%)
Entregables:
Repositorio de GitHub (enlace)
Diagrama de actividad
Captura de pantalla de la sección "Testing" de visual studio code donde se aprecia el coverage de los tests
NOTA: Queda prohibida la publicación del contenido adjunto.


A console program is to be developed that calculates a person's body mass index. The application will request the person's weight (in kilograms) and height (in meters). The body weight index (BWI) is calculated using the following formula:

BWI = weight / height2

Then, from the BWI obtained, it is possible to calculate whether a person has a normal weight, underweight, overweight, or obesity. To generate these results, the calculated BWI must be within the ranges in the table (See attached document)

Requirements:
It is mandatory to perform unit tests (minimum coverage 70%)
Deliverables:
GitHub repository (link)
Activity diagram
Screenshot of the "Testing" section of Visual Studio Code where the coverage of the tests can be seen
NOTE: The publication of the attached content is prohibited.

Resultado: 


| IMC         | Resultado              | IMC        | Resultado             |
|-------------|------------------------|------------|-----------------------|
| < 16        | Delgadez severa        | [25-30)    | Sobrepeso             |
| [16-17)     | Delgadez moderada      | [30-35)    | Obesidad leve         |
| [17-18.5)   | Delgadez leve          | [35-40)    | Obesidad moderada     |
| [18.5-25)   | Peso normal            | >= 40      | Obesidad mórbida      |



Result table:

| BWI (IMC,BM)| Result                | BWI(IMC,BMI)| Result                |
|-------------|-----------------------|-------------|-----------------------|
| < 16        | Severe thinness       | [25-30)     | Overweight            |
| [16-17)     | Moderate thinness     | [30-35)     | Mild obesity          |
| [17-18.5)   | Mild thinness         | [35-40)     | Moderate obesity      |
| [18.5-25)   | Normal weight         | >= 40       | Morbid obesity        |

```mermaid
flowchart TD
start([Start]) --> init[Initialize Application]
init --> inputData[Input Person Data and BWI Values]
inputData --> calcBWI[Calculate BWI]
calcBWI --> classify[Classify BWI]
classify --> showResult[Show Result]
showResult --> saveResult[Save Result to History]
saveResult --> continueDecision{Continue?}
continueDecision -- Yes --> inputData
continueDecision -- No --> decision{Show All Results?}
decision -- Yes --> showResults[Display All Records]
decision -- No --> en([End])
showResults --> en


