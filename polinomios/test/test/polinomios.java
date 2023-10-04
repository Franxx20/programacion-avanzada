package test;

import polinomio.PolinomioHorner;
import polinomio.PolinomioMultiplicacionSucesivas;
import polinomio.PolinomioPD;
import polinomio.PolinomioPDMejorado;
import polinomio.PolinomioParImparIterativo;
import polinomio.PolinomioParImparRecursivo;
import polinomio.PolinomioPow;
import polinomio.PolinomioRecursivo;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class polinomios {

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void arrayVacios() {
		double[] arrayVacio = {};

		PolinomioMultiplicacionSucesivas pms = new PolinomioMultiplicacionSucesivas(arrayVacio);
		PolinomioRecursivo pr = new PolinomioRecursivo(arrayVacio);
		PolinomioParImparRecursivo ppir = new PolinomioParImparRecursivo(arrayVacio);
		PolinomioParImparIterativo ppii = new PolinomioParImparIterativo(arrayVacio);
		PolinomioPD ppd = new PolinomioPD(arrayVacio);
		PolinomioPDMejorado ppdm = new PolinomioPDMejorado(arrayVacio);
		PolinomioHorner ph = new PolinomioHorner(arrayVacio);
		PolinomioPow pp = new PolinomioPow(arrayVacio);
	}

	@Test
	public void polinomioDeGrado10EvaluadoEn2() {
		double[] array1A10 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		double expected = 18434;

		PolinomioMultiplicacionSucesivas pms = new PolinomioMultiplicacionSucesivas(array1A10);
		PolinomioRecursivo pr = new PolinomioRecursivo(array1A10);
		PolinomioParImparRecursivo ppir = new PolinomioParImparRecursivo(array1A10);
		PolinomioParImparIterativo ppii = new PolinomioParImparIterativo(array1A10);
		PolinomioPD ppd = new PolinomioPD(array1A10);
		PolinomioPDMejorado ppdm = new PolinomioPDMejorado(array1A10);
		PolinomioHorner ph = new PolinomioHorner(array1A10);
		PolinomioPow pp = new PolinomioPow(array1A10);

		assertEquals(expected, pms.evaluar(2), 0.00001);
		assertEquals(expected, pr.evaluar(2), 0.00001);
		assertEquals(expected, ppir.evaluar(2), 0.00001);
		assertEquals(expected, ppii.evaluar(2), 0.00001);
		assertEquals(expected, ppd.evaluar(2), 0.00001);
		assertEquals(expected, ppdm.evaluar(2), 0.00001);
		assertEquals(expected, ph.evaluar(2), 0.00001);
		assertEquals(expected, pp.evaluar(2), 0.00001);
	}

	@Test
	public void polinomioDeGrado0() {
		double[] array = { 5 };
		double expected = 5;

		PolinomioMultiplicacionSucesivas pms = new PolinomioMultiplicacionSucesivas(array);
		PolinomioRecursivo pr = new PolinomioRecursivo(array);
		PolinomioParImparRecursivo ppir = new PolinomioParImparRecursivo(array);
		PolinomioParImparIterativo ppii = new PolinomioParImparIterativo(array);
		PolinomioPD ppd = new PolinomioPD(array);
		PolinomioPDMejorado ppdm = new PolinomioPDMejorado(array);
		PolinomioHorner ph = new PolinomioHorner(array);
		PolinomioPow pp = new PolinomioPow(array);

		assertEquals(expected, pms.evaluar(2), 0.00001);
		assertEquals(expected, pr.evaluar(2), 0.00001);
		assertEquals(expected, ppir.evaluar(2), 0.00001);
		assertEquals(expected, ppii.evaluar(2), 0.00001);
		assertEquals(expected, ppd.evaluar(2), 0.00001);
		assertEquals(expected, ppdm.evaluar(2), 0.00001);
		assertEquals(expected, ph.evaluar(2), 0.00001);
		assertEquals(expected, pp.evaluar(2), 0.00001);
	}

	@Test
	public void resultadoInfinito() {
		double[] array = new double[100];
		Arrays.setAll(array, i -> i + 1);
		
		double expected = Double.POSITIVE_INFINITY;


		PolinomioMultiplicacionSucesivas pms = new PolinomioMultiplicacionSucesivas(array);
		PolinomioRecursivo pr = new PolinomioRecursivo(array);
		PolinomioParImparRecursivo ppir = new PolinomioParImparRecursivo(array);
		PolinomioParImparIterativo ppii = new PolinomioParImparIterativo(array);
		PolinomioPD ppd = new PolinomioPD(array);
		PolinomioPDMejorado ppdm = new PolinomioPDMejorado(array);
		PolinomioHorner ph = new PolinomioHorner(array);
		PolinomioPow pp = new PolinomioPow(array);

		assertEquals(expected, pms.evaluar(10000), 0.00001);
		assertEquals(expected, pr.evaluar(10000), 0.00001);
		assertEquals(expected, ppir.evaluar(10000), 0.00001);
		assertEquals(expected, ppii.evaluar(10000), 0.00001);
		assertEquals(expected, ppd.evaluar(10000), 0.00001);
		assertEquals(expected, ppdm.evaluar(10000), 0.00001);
		assertEquals(expected, ph.evaluar(10000), 0.00001);
		assertEquals(expected, pp.evaluar(10000), 0.00001);
	}

	@Test(expected = StackOverflowError.class)
	public void stackOverflowHorner() {
		double[] array = new double[9000];

		PolinomioHorner ph = new PolinomioHorner(array);

		ph.evaluar(2);
	}

	@Test(expected = StackOverflowError.class)
	public void stackOverflowPolinomioRecursivo() {
		double[] array = new double[45000];

		PolinomioRecursivo pr = new PolinomioRecursivo(array);

		pr.evaluar(2);
	}

	/*@Test(expected = StackOverflowError.class)
	public void stackOverflowParImparRecursivo() {
		double[] array = new double[200000];

		PolinomioParImparRecursivo ppir = new PolinomioParImparRecursivo(array);
		ppir.evaluar(2);
	}*/

}
