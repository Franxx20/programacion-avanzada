# Algoritmos de Ordenamiento Elementales (cuadráticos)

## Objetivo
El propósito de este trabajo es analizar y comparar los tiempos de ejecución de cuatro algoritmos de ordenamiento: Selección, Burbujeo, Inserción y uno adicional. Se llevará a cabo una evaluación exhaustiva de estos algoritmos en tres casos distintos de entrada: ordenado, invertido y aleatorio.
Además, se estudiará el comportamiento de los algoritmos para diferentes tamaños de entrada, específicamente para conjuntos de datos conteniendo 1,000; 100,000; 500,000; y 1,000,000 de elementos.

## Instrucciones

1. **Implementación de Algoritmos:** Implementar los algoritmos de ordenamiento de Selección, Burbujeo e Inserción en Java, según las descripciones vistas en clase.
Adicionalmente, se agregará un algoritmo dependiendo del número de grupo asignado, de la siguiente manera:
	1. GnomeSort
	2. DoubleSelectionSort
	3. Odd/EvenSort
1. **Generación de Conjuntos de Datos:** Crear conjuntos de datos para cada uno de los tamaños especificados (1K, 100K, 500K, 1M) en tres configuraciones diferentes: ordenado, invertido y aleatorio. En total serán 12 conjuntos de datos, a ejecutar en cada uno de los cuatro algoritmos (los tres vistos y el adicional asignado).
   Se deberá programar un generador de casos de entrada para este fin, configurable por parámetros.
2. **Medición de Tiempos:** Realizar un proceso de medición de tiempos de ejecución para cada algoritmo en cada uno de los conjuntos de datos generados. Considerar un método confiable para medir el tiempo transcurrido durante la ejecución de cada algoritmo, evitando realizar otras tareas al mismo tiempo para no ocupar el procesador intencionalmente.
   Sugerimos realizar entre 3 y 5 mediciones y promediarlas para mitigar los efectos transitorios de uso del procesador. Esto llevará a una cantidad de ejecuciones alta, pero puede automatizarse y todo debería correr en forma desatendida.
3. **Análisis de Resultados:** Una vez que hayas obtenido los tiempos de ejecución para los algoritmos en los diferentes casos y tamaños de entrada, realiza un análisis comparativo. Identifica patrones, tendencias y diferencias significativas en los tiempos de ejecución entre los algoritmos y los casos de entrada.
4. **Documentación:** Prepara un breve informe (6 páginas máximo) que incluya una introducción al problema, la descripción de los algoritmos implementados, análisis de complejidad computacional en cada caso, los detalles sobre la generación de conjuntos de datos, los resultados de las mediciones de tiempos y el análisis de los mismos. Incluir gráficos y tablas que respalden tus conclusiones en secciones anexas.
5. **Conclusiones:** Sobre la base de los resultados obtenidos, realizar una conclusión respecto de la eficiencia relativa de los algoritmos de ordenamiento en los diferentes casos y tamaños de entrada. Ofrece una discusión informada sobre qué algoritmo es más adecuado en qué situaciones y por qué.

**Entrega:** Entregar el informe en formato PDF, junto con el código fuente de tus implementaciones, en un archivo comprimido, durante la próxima clase presencial.

Recordar que este trabajo no solo busca analizar los algoritmos de ordenamiento, sino también evaluar la capacidad para medir y analizar el rendimiento de los algoritmos en situaciones diversas. ¡Buena suerte!
