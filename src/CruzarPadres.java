
import java.util.ArrayList;

// @author guido
public class CruzarPadres {

    public static void main(String[] args) {
        int[] padre, madre;

        //Primer caso de test
        padre = new int[]{};
        madre = new int[]{};
        testAlgoritmo(padre, madre);
        
        //Segundo caso de test
        padre = new int[]{1, 1, 1, 0, 0, 0};
        madre = new int[]{1, 1, 1, 0, 0, 0};
        testAlgoritmo(padre, madre);
        
        
        //Tercer caso de test
        padre = new int[]{1, 0, 1, 0, 1, 0};
        madre = new int[]{0, 1, 0, 1, 0, 1};
        testAlgoritmo(padre, madre);
    }

    private static void testAlgoritmo(int[] padre, int[] madre) {
        boolean[] padreBool = transformar(padre),
                madreBool = transformar(madre);
        System.out.print("padre");
        printArray(padreBool);
        System.out.print("madre");
        printArray(madreBool);

        ArrayList<boolean[]> resultado = cruzarPadres(padreBool, madreBool);

        System.out.print("hijo1");
        printArray(resultado.get(0));
        System.out.print("hijo2");
        printArray(resultado.get(1));
    }

    private static ArrayList<boolean[]> cruzarPadres(boolean[] padre, boolean[] madre) {
        boolean[] hijo1 = new boolean[padre.length], hijo2 = new boolean[padre.length];
        int contador;

        contador = 0;        
        while (contador < padre.length) {
            hijo1[contador] = padre[contador];
            hijo2[contador] = padre[contador];
            contador++;
        }

        boolean alternador = true;
        int balance = 0;

        contador = 0;
        while (contador < padre.length) {
            if (padre[contador] != madre[contador]) {
                /* Si el valor es distinto, le asigna al primer hijo el mismo valor que el padre y el opuesto al 
                segundo. Luego, en la proxima diferencia, asigna los valores opuestos para balancear el arreglo
                y cambia el alternador, para que (si existe algun otra diferencia) realice el mismo proceso pero 
                esta vez, mirando al segundo hijo*/
                if (alternador) {
                    if (balance == 0) {
                        hijo2[contador] = !padre[contador];
                        if (padre[contador]) {
                            balance++;
                        } else {
                            balance--;
                        }
                    } else {
                        if (balance > 0) {
                            hijo1[contador] = false;
                            hijo2[contador] = true;
                            balance--;
                        } else {
                            hijo1[contador] = true;
                            hijo2[contador] = false;
                            balance++;
                        }
                        alternador = !alternador;
                    }
                } else if (balance == 0) {
                    hijo1[contador] = !padre[contador];
                    if (padre[contador]) {
                        balance++;
                    } else {
                        balance--;
                    }
                } else {
                    if (balance > 0) {
                        hijo2[contador] = false;
                        hijo1[contador] = true;
                        balance--;
                    } else {
                        hijo2[contador] = true;
                        hijo1[contador] = false;
                        balance++;
                    }
                    alternador = !alternador;
                }
            }
            contador++;
        }

        ArrayList<boolean[]> lista = new ArrayList<>();
        lista.add(hijo1);
        lista.add(hijo2);
        return lista;
    }

    public static void printArray(boolean[] array) {
        System.out.print("{ ");
        for (int contador = 0; contador < array.length; contador++) {
            if (array[contador]) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
        System.out.println(" }");
    }

    private static boolean[] transformar(int[] array) {
        boolean[] arrayBool = new boolean[array.length];

        for (int contador = 0; contador < arrayBool.length; contador++) {
            arrayBool[contador] = array[contador] > 0;
        }

        return arrayBool;
    }
}
