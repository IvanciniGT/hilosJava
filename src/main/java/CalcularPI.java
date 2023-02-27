import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CalcularPI {

    private static double estimarPI(int numeroDeDardos){
        int dardosDentroCirculo = 0;
        for (int dardo = 0 ; dardo < numeroDeDardos; dardo++){
            double x = Math.random();
            double y = Math.random();
            double d = Math.sqrt( x*x + y*y);
            if(d<=1)
                dardosDentroCirculo ++;
        }
        return 4.*dardosDentroCirculo/numeroDeDardos;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int numeroTotalDeDardos= 1000000;

        // Sin hilos
        System.out.println(estimarPI(numeroTotalDeDardos));

        int numeroDeHilos = 4;
        int dardosPorHilo = numeroTotalDeDardos/numeroDeHilos;

        // Con hilos en 2002. Me ofrece todo el control.... pero me obliga a :
        // 1º saber mucho más de como funcionan los hilos
        // 2º A tener más cuidado con la sicronización entre hilos (join)
        List<HiloCalculadorDePi> hilos= new ArrayList<>();
        for( int hilo = 0; hilo <numeroDeHilos ; hilo++) {
            HiloCalculadorDePi nuevoHilo = new HiloCalculadorDePi(dardosPorHilo);
            nuevoHilo.start();
            hilos.add(nuevoHilo);
        }
        for( int hilo = 0; hilo <numeroDeHilos ; hilo++) {
            hilos.get(hilo).join();   // Espera a cada hilo a que acabe su metodo RUN
        }
        // Hago la media de las 4 estimaciones
        double total=0;
        for( int hilo = 0; hilo <numeroDeHilos ; hilo++) {
            total+=hilos.get(hilo).getEstimacion();
        }
        System.out.println(total/numeroDeHilos);



        // Desde JAVA 1.8, con streams paralelo. Esta guay cuando queremos hacer calculos paralelos en un momento dado
        List<Integer> hilosCalculadoresDeDardos= Arrays.asList(1,2,3,4);
        double estimacion = hilosCalculadoresDeDardos.parallelStream().map( numeroHilo -> estimarPI(dardosPorHilo)) // Tengo un stream con las estimaciones de PI
                                          .reduce(0.,Double::sum)/numeroDeHilos;                             // Su media
        System.out.println(estimacion);

         // Pools de ejecutores. Cuando queremos montar un servicio que trabaje a largo plazo, al que le vamos encargando tareas
        List<Future<Double>> resultadosFuturos = new ArrayList<>();
        ExecutorService ejecutores = Executors.newFixedThreadPool(numeroDeHilos); // Abre 4 hilos y los deja listos para ir ejecutando trabajos
                                                                                  // segun lleguen
        for( int hilo = 0; hilo <numeroDeHilos ; hilo++) {
            resultadosFuturos.add(ejecutores.submit(() -> estimarPI(dardosPorHilo)));
        }
        int hilosPendientes = numeroDeHilos;
        while(hilosPendientes >0) {
            for (Future<Double> resultado : resultadosFuturos) {
                if (resultado.isDone()) {
                    //System.out.println(resultado.get());
                    hilosPendientes--;
                }
            }
        }
        ejecutores.shutdown();
        total=0;
        for (Future<Double> resultado : resultadosFuturos) {
            total+=resultado.get();
        }
        System.out.println(total/numeroDeHilos);
    }
    // Quiero usar 4 cores para trabajar = 4 hilos
// 8 cores. 1 core al 100% y el resto de baretas !

    private static class HiloCalculadorDePi extends Thread{
        private int dardos;
        private double estimacion;
        public HiloCalculadorDePi(int dardos){
            this.dardos = dardos;
        }
        public void run(){
            estimacion = estimarPI(dardos);
        }
        public double getEstimacion(){
            return this.estimacion;
        }

    }


}
