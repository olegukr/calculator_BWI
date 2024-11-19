
Resultado: 


| IMC         | Resultado              | IMC        | Resultado              |
|-------------|------------------------|------------|------------------------|
| < 16        | Delgadez severa        | [25-30)    | Sobrepeso             |
| [16-17)     | Delgadez moderada      | [30-35)    | Obesidad leve         |
| [17-18.5)   | Delgadez leve          | [35-40)    | Obesidad moderada     |
| [18.5-25)   | Peso normal            | >= 40      | Obesidad mórbida      |



Result table:

| BMI (IMC)   | Result                | BMI (IMC)   | Result                |
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
    classify --> saveResult[Save Result to History]
    saveResult --> decision{Show All Results?}
    decision -- Yes --> showResults[Display All Records]
    decision -- No --> en([End])
    showResults --> en
