
public class Main {
    public static void main(String[] args){
        //    Crear un CentroDeportivo, con capacidad para 15 entrenadores
        CentroDeportivo uaxFC = new CentroDeportivo(15);

        //    Registrar al menos 3 entrenadores.
        Entrenador pingu = new Entrenador(1,"Abel, Martínez Villalba","Máquinas y cardio",5);
        Entrenador sthefy = new Entrenador(26,"Sthefany, Villafranca Del Valle Seijas","Cardio",26);
        Entrenador venus = new Entrenador(3,"Venus Emilio","Yoga y pilates",10);
        Entrenador lamine = new Entrenador(10,"Lamine Yamal","Fútbol",18);
        Entrenador pedri = new Entrenador(8,"Pedri, González Lopez","Magia",22);
        Entrenador fermin = new Entrenador(16,"Fermín López","Cañonazos",20);
        Entrenador raphinhia = new Entrenador(11,"Don Raphael","Jogo Bonito",50);
        Entrenador cubarsi = new Entrenador(5,"Pau Cubarsí","Fuera de juego",3);

        uaxFC.registrarEntrenador(sthefy);
        uaxFC.registrarEntrenador(venus);
        uaxFC.registrarEntrenador(pingu);
        uaxFC.registrarEntrenador(pedri);
        uaxFC.registrarEntrenador(fermin);
        uaxFC.registrarEntrenador(raphinhia);
        uaxFC.registrarEntrenador(cubarsi);

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

        // ordenar por id de mayor a menor
        System.out.println(uaxFC.mostrarEntrenadores());





        uaxFC.ordenarEntrenadores();
        uaxFC.eliminarEntrenador(venus.getId());


        System.out.println(uaxFC.mostrarEntrenadores());

    }

}
