
public class Main {
    public static void main(String[] args){
        //    Crear un CentroDeportivo, con capacidad para 15 entrenadores
        CentroDeportivo uaxFC = new CentroDeportivo(15);

        //    Registrar al menos 3 entrenadores.
        Entrenador pingu = new Entrenador(1,"Abel, Martínez Villalba","Máquinas y cardio",5);
        Entrenador sthefy = new Entrenador(2,"Sthefany, Villafranca Del Valle Seijas","Cardio",26);
        Entrenador venus = new Entrenador(3,"Venus Emilio","Yoga y pilates",10);
        Entrenador lamine = new Entrenador(4,"Lamine  Yamal","Fútbol",18);


        uaxFC.registrarEntrenador(pingu);
        uaxFC.registrarEntrenador(sthefy);
        uaxFC.registrarEntrenador(venus);

        //    Mostrar entrenadores.
        System.out.println(uaxFC.mostrarEntrenadores());

        //    Mostrar el total almacenado.
        System.out.println("Número de entrenadores: "+uaxFC.contarEntrenadores());

        // eliminar a un entrenador
        uaxFC.registrarEntrenador(lamine);
        uaxFC.eliminarEntrenador(lamine.getId());


        //    Probar una búsqueda existente y otra inexistente.
        System.out.println(uaxFC.buscarEntrenador(pingu.getId()));
        System.out.println(uaxFC.buscarEntrenador(lamine.getId()));

    }

}
