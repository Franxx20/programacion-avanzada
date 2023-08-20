# ACM 138 - Street Numbers

## Problema
Una programadora de computadoras vive en una calle con casas numeradas consecutivamente (desde 1) por un lado de la calle. Cada noche ella sale a pasear a su perro dejando su casa y girando al azar a la izquierda o a la derecha, camina hasta el final de la calle y vuelve.
Una noche suma los números de las casas que pasan (excluyendo la suya). La siguiente vez que camina, comienza por el otro lado repitiendo la suma y encuentra, para su asombro, que las dos sumas son iguales. Aunque esto se determina en parte por su número de casa y en parte por el número de casas en la calle, ella sin embargo siente que esta es una propiedad deseable para su casa y decide que todas sus casas subsecuentes tendrán esa propiedad.  
Escribe un programa para encontrar los pares de números que satisfagan esta condición. Para comenzar su lista los dos primeros pares son: (número de casa, último número):

```
6,8
35,49
204,288
1189,1681
6930, 9800
40391,57121
235416,332928
1372105,1940449
7997214,11309768
46611179,65918161
...
```

## Consignas
### La resolución
Desarrollar una clase con tres (o más) métodos, que resuelvan el mismo problema pero utilizando aproximaciones similares. Al menos uno de ellos debe utilizar un algoritmo cuadrático, uno lineal y otro constante.

**Nota:** Los métodos devolverán el número de casa desde donde ambas sumas resultan iguales, o `-1` si no fuera posible.

```java
class StreetNumbers {
	int cuadratica(int n) { ... }
	int lineal(int n) { ... }
	int constante(int n) { ... }
}
```

### La toma de tiempos
Escribir un `App#main` que permita ejecutar el algoritmo, descubriendo pares que satisfagan la condición en el rango de 1 a 10⁹. Es probable que no todos los algoritmos permitan llegar a dicha cantidad.
Se deberá tomar el tiempo que lleva cada algoritmo en descubrir todos los números.

```java
class App {
	public static void main(String[] args) {
		StreetNumbers sn = new StreetNumbers();
		long inicio = System.nanoTime();
		for (int i = 1; i < 1_000_000_000; i++) {
			int resultado = sn.cuadratica(i);
			if (resultado != -1) {
				System.out.println(resultado + "," + i);
			}
		}
		long tiempo = System.nanoTime() - inicio;
		System.out.println("El tiempo para el algoritmo cuadrático es de " + tiempo/1_000_000_000 + " segundos");
		// ...
	}
}
```

### La comparación
Responder:
1. ¿A qué conclusión llega luego de este experimento?
2. ¿Son todos los valores comparables entre sí? ¿Por qué?
3. ¿Tuvo problemas con los tipos de dato?

Escribir un pequeño informe comparando los resultados hallados y con el contenido de sus respuestas.
