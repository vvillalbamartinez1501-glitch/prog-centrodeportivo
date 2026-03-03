public class test {
    public static void main(String[] args){
        int[] numeritos = new int[20];
        numeritos[0] = 6;
        numeritos[1] = 2;
        numeritos[2] = 5;
        numeritos[3] = 8;
        numeritos[4] = 1;
        numeritos[6] = 34;
        numeritos[7] = 7;
        numeritos[8] = 3;
        numeritos[9] = 0;

        ordenarNumeritos(numeritos);

        System.out.println(comprobarSucesionMayorAMenor(numeritos));
        mostrarNumeritos(numeritos);
    }

    public static void ordenarNumeritos(int[] numeritos){
        int posicionRuptura = 0;
        int siguientePosicion;
        while(posicionRuptura != -1 || posicionRuptura >= (numeritos.length-1)){
            posicionRuptura = comprobarSucesionMayorAMenor(numeritos);
            if (posicionRuptura != -1){
                siguientePosicion = posicionRuptura +1;
                cambiarPosicionNumeritos(numeritos,siguientePosicion,posicionRuptura);
            }
        }
    }

    public static int comprobarSucesionMayorAMenor(int[] numeritos){
        int posicionRuptura = -1;
        int posicionACambiar;
        int proximaPosicion;
        for (int i = 0 ; posicionRuptura == -1 && i < numeritos.length -1; i++){
            posicionACambiar = i;
            proximaPosicion = posicionACambiar +1;
            if (numeritos[posicionACambiar] <  numeritos[proximaPosicion]){
                posicionRuptura = i;
            }
        }
        return posicionRuptura;
    }

    public static void cambiarPosicionNumeritos(int[] numeritos, int posicion1, int posicion2){
        int numeritoTemporal = numeritos[posicion1];
        numeritos[posicion1] = numeritos[posicion2];
        numeritos[posicion2] = numeritoTemporal;
    }

    public static void mostrarNumeritos(int[] numeritos){
        String resultado = "Numeritos: ";
        for (int i = 0 ; i < numeritos.length ; i++){
            resultado += numeritos[i];
            resultado += ", ";
        }
        System.out.println(resultado);
    }

}
