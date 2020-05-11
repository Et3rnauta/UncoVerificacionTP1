package main;

import java.util.ArrayList;

// @author guido
public class CruzarPadres {

    public static ArrayList<boolean[]> cruzarPadres(boolean[] padre, boolean[] madre) {
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
}
