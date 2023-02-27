package ruina;

public class Rectangulo2 {

    private double base;
    private double altura;

    public Rectangulo2(double base, double altura){
        setBase(base);
        setAltura(altura);
    }

    public double getAltura(){
        return this.altura;
    }

    public double getBase(){
        return this.base;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }
    public void setBase(double base){
        this.base = base;
    }

}
