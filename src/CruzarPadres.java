
import java.util.ArrayList;

// @author guido
public class CruzarPadres {

    public static void main(String[] args) {

    }

    private static void cruzarPadres(boolean[] padre, boolean[] madre) {
        boolean[] geno1 = new boolean[N], geno2 = new boolean[N];
        for (int i = 0; i < N; i++) {
            geno1[i] = padre.genotipo[i];
            geno2[i] = padre.genotipo[i];
        }
        Ind hijo1 = new Ind(geno1),
                hijo2 = new Ind(geno2);

        boolean alternador = true;
        int balance = 0;
        for (int i = 0; i < N; i++) {
            if (padre.genotipo[i] != madre.genotipo[i]) {
                /* Si el valor es distinto, le asigna al primer hijo el mismo valor que el padre y el opuesto al 
                segundo. Luego, en la proxima diferencia, asigna los valores opuestos para balancear el arreglo
                y cambia el alternador, para que (si existe algun otra diferencia) realice el mismo proceso pero 
                esta vez, mirando al segundo hijo*/
                if (alternador) {
                    if (balance == 0) {
                        hijo2.genotipo[i] = !padre.genotipo[i];
                        if (padre.genotipo[i]) {
                            balance++;
                        } else {
                            balance--;
                        }
                    } else {
                        if (balance > 0) {
                            hijo1.genotipo[i] = false;
                            hijo2.genotipo[i] = true;
                            balance--;
                        } else {
                            hijo1.genotipo[i] = true;
                            hijo2.genotipo[i] = false;
                            balance++;
                        }
                        alternador = !alternador;
                    }
                } else if (balance == 0) {
                    hijo1.genotipo[i] = !padre.genotipo[i];
                    if (padre.genotipo[i]) {
                        balance++;
                    } else {
                        balance--;
                    }
                } else {
                    if (balance > 0) {
                        hijo2.genotipo[i] = false;
                        hijo1.genotipo[i] = true;
                        balance--;
                    } else {
                        hijo2.genotipo[i] = true;
                        hijo1.genotipo[i] = false;
                        balance++;
                    }
                    alternador = !alternador;
                }
            }
        }
        hijosN.add(hijo1);
        hijosN.add(hijo2);
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
}
