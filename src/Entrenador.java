public class Entrenador {

    private int id;
    private String nombre;
    private String especialidad;
    private int aniosExperiencia;

    /**
     * Metodo constructor de la clase Entrenador
     * @param id identificador del entrenador
     * @param nombre nombre del entrenador
     * @param especialidad área de especialidad del entrenador
     * @param aniosExperiencia años de experiencia del Entrenador
     */
    public Entrenador(int id, String nombre, String especialidad, int aniosExperiencia) {
        this.id = validarid(id);
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
    }

    /**
     *
     * @return devuelve el identificador del entrenador
     */

    public int getId() {
        return id;
    }
    /**
     *
     * @return devuelve el nombre del entrenador
     */
    public String getNombre() {
        return nombre;
    }
    /**
     *
     * @return devuelve la especialidad del entrenador
     */
    public String getEspecialidad() {
        return especialidad;
    }
    /**
     *
     * @return devuelve el numero de años de experiencia del entrenador
     */
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    /**
     * validador del id introducido como parámetro en el constructor del Entrenador
     * @param id id que se etsá introduciendo en el constructor
     * @return el id introducido, en caso de ser positivo, si no, 100
     */

    private int validarid(int id){
        int idEntrenador;
        if (id >= 0 ){
            idEntrenador = id;
        } else {
            idEntrenador = 100;
        }
        return idEntrenador;
    }

    /**
     * toString de la clase Entrenador
     * @return la informacion del entrenador en el formato:
     * [[id]]  -  [nombre] - Especialidad: [especialidad]  -  Años de experiencia: [numeroDeAñosDeExperiencia]
     */

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[%d] - ",id));
        sb.append(String.format("%s - ",nombre));
        sb.append(String.format("Especialidad: %s - ",especialidad));
        sb.append(String.format("Años de experiencia: %d", aniosExperiencia));
        sb.append("\n");
        return sb.toString();
    }

}
