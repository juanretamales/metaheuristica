# metaheuristica

Optimización de asignación cuadrática con distintas tecnicas

Como ejecutar el proyecto:

ejecutar desde la línea de comandos de la siguiente forma (JAR adjunto en carpeta "jar"):

java -jar ayudantia1metaheuristicas.jar -path [Ruta] [matriz funciones] [matriz distancias] [swaps] [ejercicio]

[Ruta] es la ruta donde están los txt de datos. Por ejemplo: "C:/Universidad/USACH/2018-1/Optimización en Ingeniería/Ayudantía/Metaheurísticas/Ayudantía 1/Datos/"

[matriz funciones] es el nombre del txt con la matriz de funciones, por ejemplo: F64.txt

[matriz distancias] es el nombre del txt con la matriz de distancias, por ejemplo: D64.txt

[swaps] numero de swaps, por ejemplo (no he probado con más): 2

[ejercicio] es uno de los 3 ejercicios que aparecen en el pdf de asignación cuadrática de la ayudantía, por ejemplo:
ejercicio1
ejercicio2
ejercicio3

También pueden ejecutarlo desde eclipse agregando estos argumentos en el "Run configuration", ejemplo:

-path "C:/Universidad/USACH/2018-1/Optimización en Ingeniería/Ayudantía/Metaheurísticas/Ayudantía 1/Datos/" F128.txt D128.txt 2 ejercicio3

Adjunto datos en carpeta "datos"

Tipos de ejercicio:

ejercicio1: buscar 1 solución mejor que la inicial generada aleatoriamente, o hasta alcanzar el 50% de la vecindad

ejecicio2: generar el 30% de la vecindad y luego buscar el mejor resultado, a partir de una solución inicial generada aleatoriamente

ejercico3: generar el 100% de la vecindad y luego buscar el mejor resultado, a partir de una solución inicial generada aleatoriamente

SA: generar óptimos en base al algoritmo de simulated annealing (Parámetros dentro del método Main y de la clase SimulatedAnnealing)

Argumentos de ejemplo para ejecutar simulated annealing:

-path "C:/Universidad/USACH/2018-1/Optimización en Ingeniería/Ayudantía/Metaheurísticas/Ayudantía 1/Datos/" F64.txt D64.txt 10 SA

Ultimo ejemplo linea de comando
-path "C:/gitWorkspace/swapoperator/swapOperator/datos/" chr22F.txt chr22D.txt 22 SA 1 350 0.99 1

Argumentos Simmulated Annealing instancia 64:
```
-path "C:/Users/SebaFuTzu/git/swapOperatorLocal/swapOperator/datos/" F64.txt D64.txt 2 SA 1 1000 0.95 1 0.3 2
```
##Dataset de pruebas
para hacer de forma mas automatica la toma de muestras se habilito el uso de un archivo que llamamos dataset de pruebas, que guarda los argumentos de las pruebas, por ello en un archivo csv se guardaran los argumentos separados por una letra de preferencia coma (,) y cada experimento separado por un salto de linea como se ve en el siguiente ejemplo que explica los datos en la columa 2
### Para Simulated Annealing
| Dato| ejemplo| Explicacion |
| ----- | ---- | ---- |
| tipo | SimulatedAnnealing | Tipo de metaheuristica a usar |
| dataset | 64.txt | dataset usada, debe estar dentro de la carpeta datos y separada anteponiendo F o D | 
| funcion | swap | funcion que se utilizara para tratar a los vecinos, puede ser "swap", "insercion"*, "switch"* |
| cantidad | 2 | cantidad de vencidad |
| tempMax | 350 |  |
| tempMin | 1 |  |
| funcion de enfriamiento | Geométrico |  |
| aceptacion | Aleatoria |  |
| Factor de decrecimiento | 1 |  |
| nombre del grafico | grafico | nombre del titulo del grafico |

Este ejemplo seria en el archivo dataset.csv
```
-path "C:/Users/SebaFuTzu/git/swapOperatorLocal/swapOperator/datos/" F64.txt D64.txt 2 SA 1 1000 0.95 1 0.3 2
```


