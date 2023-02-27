package ruina;

public class App {

    public static void main(String[] args){
        // Dia 2 al 100
        Rectangulo r1 = new Rectangulo(4,5);
        System.out.println("Base: "+ r1.base);
        r1.altura=10;
        System.out.println("Altura: "+ r1.altura);
        ///

        Rectangulo2 r2 = new Rectangulo2(4,5);
        System.out.println("Base: "+ r2.getBase());
        r2.setAltura(10);
        System.out.println("Altura: "+ r2.getAltura());

    }

}

