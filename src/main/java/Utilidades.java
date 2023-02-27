public interface Utilidades {

    static double doblar(double numero){    //J1.8
        return numero*2;
    }


    static double triplar(double numero){    //J1.8
        return numero*3;
    }


    // J1.9 se añade la posibilidad de funciones static private

    // J1.8 se añade la posibilidade de meter código en funciones de instancia dentro de una interfaz

    String dameTexto();

    default String dameOtroTexto(){ // J1.8
        throw new RuntimeException("Not implemented");
    }
}
