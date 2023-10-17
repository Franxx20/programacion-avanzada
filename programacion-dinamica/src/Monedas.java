
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Monedas {
	int[] monedas;
	int dinero;
	Map<Integer, Integer> usos;

	public Monedas(int dinero, int[] monedas) {
		// TODO Auto-generated constructor stub
		this.dinero = dinero;
		this.monedas = monedas;
		this.usos= new HashMap<>();
		for (int i = 0; i < monedas.length; i++) {
			usos.put(monedas[i], 0);
		}
	}

	public void buscar(int monedas[], int dinero) {
		int menor = Integer.MAX_VALUE;

		for (int i = 0; i < monedas.length; i++) {
			int resultado = buscarRecursivo(monedas, dinero, monedas[i]);
			if (resultado < menor)
				menor = resultado;
		}
		System.out.println("menor: " + menor);
		System.out.println(usos);
	}

	public int buscarRecursivo(int monedas[], int dineroViejo, int moneda) {
		int dinero = dineroViejo - moneda;
		if (dinero == 0)
		{
			usos.replace(moneda, usos.get(moneda) + 1);
			return 1;
		}
			

	
		if (dinero < 0)
			return Integer.MAX_VALUE - 1;

		int menor = Integer.MAX_VALUE - 1;
		for (int i = 0; i < monedas.length; i++) {
			int resultado = 1 + buscarRecursivo(monedas, dinero, monedas[i]);

			if (resultado < menor)
			{
				menor = resultado;
				
			}
			
		}
	
		return menor;
	}
}
