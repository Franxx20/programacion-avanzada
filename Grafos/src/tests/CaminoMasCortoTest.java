package tests;

import grafos.*;
import grafos.algoritmos.caminomascorto.BellmanFord;
import grafos.algoritmos.caminomascorto.Dijkstra;
import org.junit.Assert;
import org.junit.Test;


import java.util.Arrays;
import java.util.zip.InflaterInputStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class CaminoMasCortoTest {
    private static final double INFY = Double.POSITIVE_INFINITY;

    @Test
    public void test01() {
        Double[][] g = {
                {0.0, 5.0, 4.0, 2.0},
                {5.0, 0.0, 4.0, 1.0},
                {4.0, 4.0, 0.0, 1.0},
                {2.0, 1.0, 1.0, 0.0}
        };

        int root = 0;

        Grafo grafo = new MatrizAdyacente(g);
        Dijkstra d = new Dijkstra();
        double[] distancias = d.dijkstra(grafo, root);

        assertEquals(3, distancias[2], 0);
        assertEquals(2, distancias[3], 0);
    }

    @Test
    public void dijkstraMatrizDirigida() {
        Double[][] matrizAdyacencia = {
                {INFY, 7.0, 3.0, INFY},
                {INFY, INFY, INFY, 2.0},
                {INFY, 2.0, INFY, 8.0},
                {0.0, 0.0, 0.0, 0.0},
        };

        int raiz = 0;
        Grafo grafo = new MatrizAdyacente(matrizAdyacencia);
        Dijkstra camino = new Dijkstra();
        double[] distancias = camino.dijkstra(grafo, raiz);

        assertEquals(5, (int) distancias[1]);
        assertEquals(3, (int) distancias[2]);
        assertEquals(7, (int) distancias[3]);


    }

    @Test
    public void DijkstraMatrizNoDirigida() {
        Double[][] matrizAdyacencia = {
                // a   b     c     d     e     f     g     h   i
                {0.0, 4.0, INFY, INFY, INFY, INFY, INFY, 8.0, INFY},// a 0
                {4.0, 0.0, 8.0, INFY, INFY, INFY, INFY, 11.0, INFY}, // b 1
                {INFY, 8.0, 0.0, 7.0, INFY, 4.0, INFY, INFY, 2.0}, // c 2
                {INFY, INFY, 7.0, 0.0, 9.0, 14.0, INFY, INFY, INFY}, // d 3
                {INFY, INFY, INFY, 9.0, 0.0, 10.0, INFY, INFY, INFY}, // e 4
                {INFY, INFY, 4.0, 14.0, 10.0, 0.0, 2.0, INFY, INFY}, // f 5
                {INFY, INFY, INFY, INFY, INFY, 2.0, 0.0, 1.0, 6.0}, // g 6
                {8.0, 11.0, INFY, INFY, INFY, INFY, 1.0, 0.0, 7.0}, // h 7
                {INFY, INFY, 2.0, INFY, INFY, INFY, 6.0, 7.0, 0.0}, // i 8
        };

        int raiz = 0;
        Grafo grafo = new MatrizAdyacenteNoDirigida(matrizAdyacencia);
        Dijkstra dijkstra = new Dijkstra();
        double[] distancias = dijkstra.dijkstra(grafo, raiz);
        BellmanFord bellmanFord = new BellmanFord();
        double[] distancias2 = bellmanFord.bellmanFord(grafo, raiz);


        System.out.println(Arrays.toString(distancias));
        Assert.assertArrayEquals(new double[]{0, 4, 12, 19, 21, 11, 9, 8, 14}, distancias, 0.01);
        System.out.println(Arrays.toString(dijkstra.getAntecesores()));
        Assert.assertArrayEquals(new double[]{0, 4, 12, 19, 21, 11, 9, 8, 14}, distancias2, 0.01);
        System.out.println(Arrays.toString(bellmanFord.getAntecesores()));
        assertEquals(14, grafo.cantVertices());
    }

    @Test
    public void bellmanFordMatrizDirigidaCicloNegativo() {
        Double[][] matrizAdyacencia = {
                // a   b     c     d     e     s
                {0.0, INFY, 2.0, INFY, INFY, INFY},// a 0
                {1.0, 0.0, INFY, INFY, INFY, INFY}, // b 1
                {INFY, -2.0, 0.0, INFY, INFY, INFY}, // c 2
                {-4.0, INFY, -1.0, 0.0, INFY, INFY}, // d 3
                {INFY, INFY, INFY, 1.0, 0.0, INFY}, // e 4
                {10.0, INFY, INFY, INFY, 8.0, 0.0}, // s 5

        };
        Grafo grafo = new MatrizAdyacente(matrizAdyacencia);
//        Dijkstra dijkstra = new Dijkstra();
//        double[] distancias = dijkstra.dijkstra(grafo, raiz);
        BellmanFord bellmanFord = new BellmanFord();
        int raiz = 5;
        double[] distancias2 = bellmanFord.bellmanFord(grafo, raiz);


        assertArrayEquals(new double[]{5, 5, 7, 9, 8, 0}, distancias2, 0.01);

    }

    public void bellmanFordMatrizDirigidaCicloNegativoExceptsError() {
//        Double[][] matrizAdyacencia = {
//                // a   b     s
//                {0.0, INFY, INFY},// a 0
//                {-2.0, 0.0, INFY}, // b 1
//                {3.0, 4.0, 0.0}, // s 2
//
//        };
        Double[][] matrizAdyacencia = {
                // a   b     c     d     e     f
                {0.0, 5.0, INFY, INFY, INFY, INFY},// a 0
                {INFY, 0.0, 1.0, 2.0, INFY, INFY}, // b 1
                {INFY, INFY, 0.0, INFY, 1.0, INFY}, // c 2
                {INFY, INFY, INFY, 0.0, INFY, 2.0}, // d 3
                {INFY, INFY, INFY, -1.0, 0.0, INFY}, // e 4
                {INFY, INFY, INFY, INFY, -3.0, 0.0}, // f 5

        };
        Grafo grafo = new MatrizAdyacente(matrizAdyacencia);

        BellmanFord bellmanFord = new BellmanFord();
        double[] distancias2;
        for (int i = 0; i < grafo.cantNodos(); i++) {
            distancias2 = bellmanFord.bellmanFord(grafo, i);
            System.out.println(Arrays.toString(distancias2));
        }


//        assertArrayEquals(new double[]{5, 5, 7, 9, 8, 0}, distancias2, 0.01);

    }

    @Test
    public void bellmanFord(){


        Grafo grafo = new ListaAbyacente(10);
        grafo.setArista(0,1,1);
        grafo.setArista(1,2,1);
        grafo.setArista(2,4,1);
        grafo.setArista(4,3,-3);
        grafo.setArista(3,2,1);
        grafo.setArista(1,5,4);
        grafo.setArista(1,6,4);
        grafo.setArista(5,6,5);
        grafo.setArista(6,7,4);
        grafo.setArista(5,7,3);

        BellmanFord bellmanFord = new BellmanFord();
        double[] distanciasBF;

        distanciasBF = bellmanFord.bellmanFord(grafo,0);

        System.out.println(Arrays.toString(distanciasBF));
        System.out.println(Arrays.toString(bellmanFord.getAntecesores()));

        double resultados[] = new double[]{0.0,1.0,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,5.0,5.0,8.0,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY};
        assertArrayEquals(resultados,distanciasBF,0.01);

    }
    @Test
    public void bellmanFordDesde0(){


        Grafo grafo = new ListaAbyacente(10);

       grafo.setArista(0,1,5);
       grafo.setArista(1,2,20);
       grafo.setArista(1,5,30);
       grafo.setArista(1,6,60);
       grafo.setArista(2,3,10);
       grafo.setArista(2,4,75);
       grafo.setArista(3,2,-15);
       grafo.setArista(4,9,100);
       grafo.setArista (5,4,25);
       grafo.setArista(5,6,5);
       grafo.setArista(5,8,50);
       grafo.setArista(6,7,-50);
       grafo.setArista(7,8,-10);

        BellmanFord bellmanFord = new BellmanFord();
        double[] distanciasBF;

        distanciasBF = bellmanFord.bellmanFord(grafo,0);

        System.out.println(Arrays.toString(distanciasBF));
        System.out.println(Arrays.toString(bellmanFord.getAntecesores()));


    }
    @Test
    public void bellmanFordConFuenteAlcanzablePorCiCloNegativo(){


        Grafo grafo = new ListaAbyacente(10);

        grafo.setArista(0,1,5);
        grafo.setArista(1,2,20);
        grafo.setArista(1,5,30);
        grafo.setArista(1,6,60);
        grafo.setArista(2,3,10);
        grafo.setArista(2,4,75);
        grafo.setArista(3,2,-15);
        grafo.setArista(4,9,100);
        grafo.setArista (5,4,25);
        grafo.setArista(5,6,5);
        grafo.setArista(5,8,50);
        grafo.setArista(6,7,-50);
        grafo.setArista(7,8,-10);

        BellmanFord bellmanFord = new BellmanFord();
        double[] distanciasBF;

        distanciasBF = bellmanFord.bellmanFord(grafo,9);

        System.out.println(Arrays.toString(distanciasBF));
        System.out.println(Arrays.toString(bellmanFord.getAntecesores()));


    }
    @Test
    public void dijkstraEnCicloNegativo(){


        Grafo grafo = new ListaAbyacente(10);

        grafo.setArista(0,1,5);
        grafo.setArista(1,2,20);
        grafo.setArista(1,5,30);
        grafo.setArista(1,6,60);
        grafo.setArista(2,3,10);
        grafo.setArista(2,4,75);
        grafo.setArista(3,2,-15);
        grafo.setArista(4,9,100);
        grafo.setArista (5,4,25);
        grafo.setArista(5,6,5);
        grafo.setArista(5,8,50);
        grafo.setArista(6,7,-50);
        grafo.setArista(7,8,-10);

        Dijkstra dijkstra = new Dijkstra();
        double[] distanciasBF;

        distanciasBF = dijkstra.dijkstra(grafo,0);

        System.out.println("Distancias a " + 0);
        System.out.println(Arrays.toString(distanciasBF));
        System.out.println("Antecesores" );
        System.out.println(Arrays.toString(dijkstra.getAntecesores()));


    }
    @Test
    public void dijkstraVsBellmanFord(){


        Grafo grafo = new ListaAbyacente(10);

        grafo.setArista(0,1,5);
        grafo.setArista(1,2,20);
        grafo.setArista(1,5,30);
        grafo.setArista(1,6,60);
        grafo.setArista(2,3,10);
        grafo.setArista(2,4,75);
        grafo.setArista(3,2,-15);
        grafo.setArista(4,9,100);
        grafo.setArista (5,4,25);
        grafo.setArista(5,6,5);
        grafo.setArista(5,8,50);
        grafo.setArista(6,7,-50);
        grafo.setArista(7,8,-10);

        Dijkstra dijkstra = new Dijkstra();
        BellmanFord bellmanFord = new BellmanFord();

        assertArrayEquals(bellmanFord.bellmanFord(grafo,0),dijkstra.dijkstra(grafo,0),0.001);

    }

    @Test
    public void dijkstraVsBellmanFordNoNegativo(){


        Grafo grafo = new ListaAbyacente(10);

        grafo.setArista(0,1,5);
        grafo.setArista(1,2,20);
        grafo.setArista(1,5,30);
        grafo.setArista(1,6,60);
        grafo.setArista(2,3,10);
        grafo.setArista(2,4,75);
        grafo.setArista(3,2,15);
        grafo.setArista(4,9,100);
        grafo.setArista (5,4,25);
        grafo.setArista(5,6,5);
        grafo.setArista(5,8,50);
        grafo.setArista(6,7,50);
        grafo.setArista(7,8,10);

        Dijkstra dijkstra = new Dijkstra();
        BellmanFord bellmanFord = new BellmanFord();

        assertArrayEquals(bellmanFord.bellmanFord(grafo,0),dijkstra.dijkstra(grafo,0),0.001);

    }
}