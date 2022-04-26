public class Primos {
    /**
     * @param max_num_p El número máximo que el usuario dice para generar los numeros primos
     * @return Hace el return del metodo que realiza el relleno de los numeros pirmos
     */
// Generar números primos de 1 a max_num_p
    public static int[] generadorPrimos(int max_num_p) {
        Primos primo = new Primos();
        int i, j;
        if (max_num_p >= 2) {
            // Declaraciones
            int size = max_num_p + 1; // size del array
            boolean[] esPrimo = new boolean[size];
            //Inicializar el array
            esPrimo = primo.startArray(size, esPrimo);

            // Eliminar el 0 y el 1, que no son primos
            esPrimo[0] = esPrimo[1] = false;

            // Criba
            esPrimo = primo.criba(esPrimo, size);

            // ¿Cuántos primos hay?
            int counting = primo.countingPrimos(size, esPrimo);

            //Rellenar el vector de números primos
            return primo.rellenarVPrimos(counting, size, esPrimo);
        } else { // max_num_p < 2
            return new int[0];
            // Vector vacío

        }
    }

    /**
     * @param size    Determina el size
     * @param esPrimo Boolean que comprueba si el numero es primo o no
     * @return Devuelve cuentos numeros primos hay
     */
    // ¿Cuántos primos hay?
    public int countingPrimos(int size, boolean[] esPrimo) {
        int counting = 0;
        for (int i = 0; i < size; i++) {
            if (esPrimo[i]) {
                counting++;
            }
        }
        return counting;
    }


    /**
     * @param counting Numero de cuantos numeros primos hay
     * @param size     El tamaño del array
     * @param esPrimo  Si es primo o no
     * @return Hace el return del metodo que realiza el relleno de los numeros pirmos
     */
    // Rellenar el vector de números primos
    public int[] rellenarVPrimos(int counting, int size, boolean[] esPrimo) {
        int[] primos = new int[counting];
        int i, j;
        for (i = 0, j = 0; i < size; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }
        return primos;
    }

    /**
     * @param esPrimo Determina si es primo o no
     * @param size    Determina el size del array
     * @return Devuelve si es primo o no mediante un boolean
     */

    //Criba
    public boolean[] criba(boolean[] esPrimo, int size) {
        for (int i = 2; i < Math.sqrt(size) + 1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (int j = 2 * i; j < size; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
        return esPrimo;
    }

    /**
     * @param size    Determina el size del array
     * @param esPrimo Determina si es primo o no
     * @return Iniciar el array
     */
    public boolean[] startArray(int size, boolean[] esPrimo) {
        //Inicializar el array
        for (int i = 0; i < size; i++) {
            esPrimo[i] = true;
        }


        return esPrimo;
    }
}
