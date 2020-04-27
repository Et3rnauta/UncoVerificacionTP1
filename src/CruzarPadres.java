
import java.util.ArrayList;

// @author guido
public class CruzarPadres {

    public static void main(String[] args) {

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
        for (int i = 0; i < padre.length; i++) {
            hijo1[i] = padre[i];
            hijo2[i] = padre[i];
        }

        boolean alternador = true;
        int balance = 0;
        for (int i = 0; i < padre.length; i++) {
            if (padre[i] != madre[i]) {
                /* Si el valor es distinto, le asigna al primer hijo el mismo valor que el padre y el opuesto al 
                segundo. Luego, en la proxima diferencia, asigna los valores opuestos para balancear el arreglo
                y cambia el alternador, para que (si existe algun otra diferencia) realice el mismo proceso pero 
                esta vez, mirando al segundo hijo*/
                if (alternador) {
                    if (balance == 0) {
                        hijo2[i] = !padre[i];
                        if (padre[i]) {
                            balance++;
                        } else {
                            balance--;
                        }
                    } else {
                        if (balance > 0) {
                            hijo1[i] = false;
                            hijo2[i] = true;
                            balance--;
                        } else {
                            hijo1[i] = true;
                            hijo2[i] = false;
                            balance++;
                        }
                        alternador = !alternador;
                    }
                } else if (balance == 0) {
                    hijo1[i] = !padre[i];
                    if (padre[i]) {
                        balance++;
                    } else {
                        balance--;
                    }
                } else {
                    if (balance > 0) {
                        hijo2[i] = false;
                        hijo1[i] = true;
                        balance--;
                    } else {
                        hijo2[i] = true;
                        hijo1[i] = false;
                        balance++;
                    }
                    alternador = !alternador;
                }
            }
        }

        ArrayList<boolean[]> lista = new ArrayList<>();
        lista.add(hijo1);
        lista.add(hijo2);
        return lista;
    }

    public static void printArray(boolean[] array) {
        System.out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
        System.out.println(" }");
    }

    private static boolean[] transformar(int[] array) {
        boolean[] arrayBool = new boolean[array.length];

        for (int i = 0; i < arrayBool.length; i++) {
            arrayBool[i] = array[i] > 0;
        }

        return arrayBool;
    }
}
