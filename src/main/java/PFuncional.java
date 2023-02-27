import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class PFuncional {

    public static void main(String[] args){
        System.out.println(Utilidades.doblar(10));
        PFuncional.imprimirResultado(Utilidades::doblar, 10);
        Function<Double, Double> operacion = Utilidades::triplar;
        PFuncional.imprimirResultado(operacion, 25);
        // Expresión lambda! Es una expresión que devuelve una Función anónima creada en linea.
       Function<Double,Double> nuevaOperacion = (Double numero)->{    //J1.8
           return numero/2;
       };
        PFuncional.imprimirResultado(nuevaOperacion, 25);
        PFuncional.imprimirResultado((Double numero)->{    //J1.8
            return numero/2;
        }, 25);
        PFuncional.imprimirResultado(numero -> numero/5, 25);

        // Stream. Toda colleccion se puede convertir en un Stream
        // Stream: Objeto nuevo del API de java que representa una secuencia de datos(objetos) a
        // los que les podemos aplicar programación funcional
        List<String> miLista = Arrays.asList("Texto1", "TEXTO2", "texto3");
        //List<String> miLista = List.toList("Texto1", "TEXTO2", "texto3"); J9
        // Quiero iterarlo
        // Pre JAVA 1.5
        for (int indice =0; indice<miLista.size(); indice++){
            System.out.println(miLista.get(indice));
        }
        // Pre Java 1.8
        for(String texto : miLista){
            System.out.println(texto);
        }
        // Desde JAVA 1.8:
        miLista.stream().forEach(System.out::println); // Más eficiente, más conveniente

        // Los streams poseen funciones de tipo MAP:
        // Estas funciones me permiten aplicar una función sobre cada elemento del stream,
        // dando lugar a otro Stream: MAP, FLATMAP, SORTED, FILTERED
        // Los streams poseen funciones de tipo REDUCE:
        // Estas funciones no devuelven un Stream: forEach, reduce, collect
        miLista.stream()                                // Para cada texto
                //.map( texto -> texto.toUpperCase() )
                .filter( texto -> texto.endsWith("2"))   // Lo mantengo si acaba en 2
                .map( String::toUpperCase )             // Lo pongo en mayusculas
                .forEach(System.out::println);          // Lo imprimo
    }

    public static void imprimirResultado(Function<Double, Double> operacion, double numero){
        System.out.println( operacion.apply(numero) );
    }


}
