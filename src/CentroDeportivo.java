public class CentroDeportivo {
    private Entrenador[] entrenadores;
    private final int MAX_ENTRENADORES;
    private int numeroEntrenadores;

    /**
     * metodo constructor de la clase CentroDeportivo
     * @param max_entrenadores capacidad maxima que podra tener el array de entrenadores
     */
    public CentroDeportivo(int max_entrenadores) {
        MAX_ENTRENADORES = validadorMaxEntrenadores(max_entrenadores);
        this.entrenadores = new Entrenador[MAX_ENTRENADORES];
    }

    /**
     * Validador de que el numero maximo de entrenadores introducido en el constructor sea valido
     * @param maxEntrenadores numero maximo de entrenadores introducido en el metodo constructor
     * @return el numero de entrenadores dado como parámetro en caso d eser válido (entre 1 y 15), de no serlo, asigna 15 por defecto
     */

    private int validadorMaxEntrenadores(int maxEntrenadores){
        int maxEntrenadoresFinal;
        if (maxEntrenadores > 0 && maxEntrenadores <= 15){
            maxEntrenadoresFinal = maxEntrenadores;
        } else {
            maxEntrenadoresFinal = 15;
        }
        return maxEntrenadoresFinal;
    }

    /**
     * metodo que recorre el array de entrenadores en busca de uno cuyo id coincida con el dado como parámetro
     * @param id el id que va a ser comparado con el resto de ids del array de entrenadores
     * @return el primer entrenador cuyo id coincida con el dado como parametro o nulo en caso de no haberlo
     */
    public Entrenador buscarEntrenador(int id){
        Entrenador entrenadorBuscado = null;
        for (int i = 0 ; entrenadorBuscado == null && i < MAX_ENTRENADORES ; i++){
            if (entrenadores[i] != null && entrenadores[i].getId() == id ){
                entrenadorBuscado = entrenadores[i];
            }
        }
        return entrenadorBuscado;
    }

    /**
     * metodo que recorre el array de entrenadores en busca de un hueco (donde el valor sea nulo)
     * @return el indice del hueco libre o -1 is no lo encunetra
     */

    private int buscarPrimerHuecoLibre(){
        int primerHuecoLibre = -1;
        for (int i = 0 ; primerHuecoLibre == -1 && i < MAX_ENTRENADORES ; i++){
            if (entrenadores[i] == null){
                primerHuecoLibre = i;
            }
        }
        return primerHuecoLibre;
    }

    /**
     * metodo que registra a un entrenador en el centro deportivo guardandolo en el array de entrenadores con las condiciones 1. que haya hueco libre 2. que no haya un entrenador con el mismo id
     * @param entrenador el entrenador que quiere registrarse en el centro deportivo
     * @return true si se registró false si no
     */

    public boolean registrarEntrenador(Entrenador entrenador){
        boolean entrenadorRegistradoCorrectamente = false;
        Entrenador entrenadorEnELArray;
        int huecoLibre;

        huecoLibre = buscarPrimerHuecoLibre();
        if (huecoLibre != -1){
            entrenadorEnELArray = buscarEntrenador(entrenador.getId());
            if (entrenadorEnELArray == null){
                entrenadores[huecoLibre] =  entrenador;
                numeroEntrenadores++;
                entrenadorRegistradoCorrectamente = true;
            }
        }

        return entrenadorRegistradoCorrectamente;
    }

    /**
     * metodo que lista los entrenadores del centro deportivo con su correspondiente toString
     * @return el listado de entrenadores, en caso de no haber entrenadores, lo dice
     */

    public String mostrarEntrenadores(){
        StringBuilder sb = new StringBuilder("Listado de entrenadores del gimnasio:");
        sb.append("\n");

        if (numeroEntrenadores < 1){
            sb.append("Todavía no hay entrenadores ne este centro deportivo");
        } else {
            for (int i = 0 ; i < MAX_ENTRENADORES ; i++){
                if (entrenadores[i] != null){
                    sb.append(entrenadores[i].toString());
                }
            }
        }
        return sb.toString();
    }

    /**
     * metodo que recorre el array de entrenadores y que por cada hueco libre, suma 1 al contador de entrenadores
     * @return el contador de entrenadores, el numero de entrenadores en el array
     */

    public int contarEntrenadores(){
        int contadorEntrenadores = 0;
        for (int i = 0 ; i < MAX_ENTRENADORES ; i++){
            if (entrenadores[i]!= null){
                contadorEntrenadores++;
            }
        }
        return contadorEntrenadores;
    }

    /**
     * metodo que elimina a un entrenador del array de entrenadores
     * @param id id del entrenador a eliminar
     * @return el entrenador eliminado o false si no lo eliminó
     */
    public Entrenador eliminarEntrenador(int id){
        Entrenador entrenadorEliminado = null;
        int posicionEntrenador;

        posicionEntrenador = buscarIndiceEntrenador(id);
        if (posicionEntrenador != -1){
            entrenadorEliminado = entrenadores[posicionEntrenador];
            entrenadores[posicionEntrenador] = null;
            numeroEntrenadores--;
        }
        return entrenadorEliminado;
    }

    /**
     * metodo que elimina a un entrenador del array de entrenadores
     * @param entrenador entrenador a eliminar
     * @return el entrenador eliminado o false si no lo eliminó
     */
    public Entrenador deleteEntrenador(Entrenador entrenador){
        Entrenador entrenadorEliminado;
        int posicionEntrenador;

        entrenadorEliminado = buscarEntrenador(entrenador.getId());
        if (entrenadorEliminado != null){
            posicionEntrenador = buscarIndiceEntrenador(entrenador.getId());
            entrenadorEliminado = entrenador;
            entrenadores[posicionEntrenador] = null;
            numeroEntrenadores--;
        }
        return entrenadorEliminado;
    }

    /**
     * metodo que ordena el array de entrenadores en base a su id (de mayor a menor)
     */

    public void ordenarEntrenadores(){
        Entrenador entrenadorTemporal;

        for (int i = 0 ; i < MAX_ENTRENADORES ; i++){
            for (int j = i +1; j < MAX_ENTRENADORES; j++){
                if (entrenadores[i] == null){
                    entrenadores [i] = entrenadores[j];
                    entrenadores[j] = null;
                } else if (entrenadores[j] != null && entrenadores[i].getId() < entrenadores[j].getId()) {
                    entrenadorTemporal = entrenadores[i];
                    entrenadores[i] = entrenadores[j];
                    entrenadores[j] = entrenadorTemporal;
                }
            }
        }
    }

    /**
     * metodo que ordena el array de entrenadores en base a su id (de mayor a menor)
     */

    public void ordenarEntrenadores_vis(){
        for (int i = 0 ; i < MAX_ENTRENADORES ; i++){
            for (int j = i +1; j < MAX_ENTRENADORES; j++){
                if (entrenadores[i] == null){
                    entrenadores [i] = entrenadores[j];
                    entrenadores[j] = null;
                } else if (entrenadores[j] != null && entrenadores[i].getId() < entrenadores[j].getId()) {
                    cambiarEntrenadoresDePosicion(i,j);
                }
            }
        }
    }

    /**
     * metodo temporal para imprimir el array de entrenadores, el id del entrenador en cada posición
     *

    public void imprimirArray(){
        for (int i = 0; i < MAX_ENTRENADORES; i++) {
            if (entrenadores[i] != null){
                System.out.print("[");
                System.out.print(entrenadores[i].getId());
                System.out.print("]");
            } else if (entrenadores[i] == null){
                System.out.print("[");
                System.out.print("nulo");
                System.out.print("]");
            }
            System.out.print(" ");
        }
    }
     */

    /**
     * metodo para efectuar un cambio simple entre elementos del array entrenadores
     * @param posicion1 indice de un elemento del array a intercambiar
     * @param posicion2 indice del otro elemento del array a intercambiar
     */
    public void cambiarEntrenadoresDePosicion(int posicion1, int posicion2){
        Entrenador entrenadorTemporal;
        entrenadorTemporal = entrenadores[posicion1];
        entrenadores[posicion1] = entrenadores[posicion2];
        entrenadores[posicion2] = entrenadorTemporal;
    }

    /**
     * recorre el array de entrenadorees en busca del primer indice cuyo entrenador tenga el id dado como parámetro
     * @param id el id que comparará con el resto de entrenadores en el array
     * @return la el indice en el array del entrenador con id conicidente, -1 si no lo encontró
     */

    private int buscarIndiceEntrenador(int id){
        int indiceEntrenador = -1;
        for (int i = 0 ; indiceEntrenador == -1 && i < MAX_ENTRENADORES ; i++){
            if (entrenadores[i] != null && entrenadores[i].getId() == id ){
                indiceEntrenador = i;
            }
        }
        return indiceEntrenador;
    }
}
