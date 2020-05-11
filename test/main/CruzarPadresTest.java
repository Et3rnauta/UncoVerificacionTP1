package main;

import java.util.ArrayList;
import org.junit.Test;
import main.CruzarPadres;
import static org.junit.Assert.*;

/**
 *
 * @author guido
 */
public class CruzarPadresTest {
    @Test
    public void testCruzarPadres1() {
        System.out.println("*Se ejecuta el primer test del metodo cruzarPadres*");
        boolean[] padre = {},
                madre = {};

        ArrayList<boolean[]> hijos = CruzarPadres.cruzarPadres(padre, madre);

        boolean[] hijo1, hijo2;

        assertEquals(2, hijos.size());//Tiene solo 2 hijos

        hijo1 = hijos.get(0);
        hijo2 = hijos.get(1);

        assertEquals(padre.length, hijo1.length);//La longitud del primer hijo es igual al padre
        assertEquals(padre.length, hijo2.length);//La longitud del segundo hijo es igual al padre

        //Tienen cantidad igual o aproximada de cantidad de valores booleanos
        assertTrue(estaBalanceado(hijo1));
        assertTrue(estaBalanceado(hijo2));
    }
    
    @Test
    public void testCruzarPadres2() {
        System.out.println("*Se ejecuta el segundo test del metodo cruzarPadres*");
        int[] padre = {1, 0, 1, 0},
                madre = {0, 1, 0, 1};

        ArrayList<boolean[]> hijos = CruzarPadres.cruzarPadres(transformar(padre), transformar(madre));

        boolean[] hijo1, hijo2;

        assertEquals(2, hijos.size());//Tiene solo 2 hijos

        hijo1 = hijos.get(0);
        hijo2 = hijos.get(1);

        assertEquals(padre.length, hijo1.length);//La longitud del primer hijo es igual al padre
        assertEquals(padre.length, hijo2.length);//La longitud del segundo hijo es igual al padre

        //Tienen cantidad igual o aproximada de cantidad de valores booleanos
        assertTrue(estaBalanceado(hijo1));
        assertTrue(estaBalanceado(hijo2));
    }
    
    @Test
    public void testCruzarPadres3() {
        System.out.println("*Se ejecuta el tercer test del metodo cruzarPadres*");
        int[] padre = {1, 0, 1, 0, 0, 1},
                madre = {1, 1, 0, 1, 0, 0};

        ArrayList<boolean[]> hijos = CruzarPadres.cruzarPadres(transformar(padre), transformar(madre));

        boolean[] hijo1, hijo2;

        assertEquals(2, hijos.size());//Tiene solo 2 hijos

        hijo1 = hijos.get(0);
        hijo2 = hijos.get(1);

        assertEquals(padre.length, hijo1.length);//La longitud del primer hijo es igual al padre
        assertEquals(padre.length, hijo2.length);//La longitud del segundo hijo es igual al padre

        //Tienen cantidad igual o aproximada de cantidad de valores booleanos
        assertTrue(estaBalanceado(hijo1));
        assertTrue(estaBalanceado(hijo2));
    }
    
    @Test
    public void testCruzarPadres4() {
        System.out.println("*Se ejecuta el cuarto test del metodo cruzarPadres*");
        int[] padre = {1, 1, 0, 1, 0, 0, 1, 0, 1},
                madre = {1, 0, 1, 0, 1, 1, 0, 1, 0};

        ArrayList<boolean[]> hijos = CruzarPadres.cruzarPadres(transformar(padre), transformar(madre));

        boolean[] hijo1, hijo2;

        assertEquals(2, hijos.size());//Tiene solo 2 hijos

        hijo1 = hijos.get(0);
        hijo2 = hijos.get(1);

        assertEquals(padre.length, hijo1.length);//La longitud del primer hijo es igual al padre
        assertEquals(padre.length, hijo2.length);//La longitud del segundo hijo es igual al padre

        //Tienen cantidad igual o aproximada de cantidad de valores booleanos
        assertTrue(estaBalanceado(hijo1));
        assertTrue(estaBalanceado(hijo2));
    }
    
    private static boolean[] transformar(int[] array) {
        //Recibe un arreglo con 1 y 0, y lo transforma a booleanos [true = 1, false = 0]
        boolean[] arrayBool = new boolean[array.length];

        for (int contador = 0; contador < arrayBool.length; contador++) {
            arrayBool[contador] = array[contador] > 0;
        }

        return arrayBool;
    }

    private static boolean estaBalanceado(boolean[] arrBoolean) {
        //Busca que el arreglo tenga igual numero de valores booleanos
        //Permite que como máximo sea 1, en los casos donde tiene longitud impar
        int contTrue = 0, contFalse = 0, res;
        for (boolean valBool : arrBoolean) {
            if (valBool) {
                contTrue++;
            } else {
                contFalse++;
            }
        }
        res = Math.abs(contTrue - contFalse);
        return res == 0 || res == 1;
    }
}
