package Arbol;

public class NodoBB {
    public int valor;
    private NodoBB hijo_izq,hijo_der;
    public int x,y;

    public NodoBB(int valor) {
        this.valor = valor;
        this.hijo_izq = null;
        this.hijo_der = null;
    }
    
    public void setPosition(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    public boolean esHoja(){
        return hijo_izq==null&& hijo_der==null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public NodoBB getHijo_izq() {
        return hijo_izq;
    }

    public void setHijo_izq(NodoBB hijo_izq) {
        this.hijo_izq = hijo_izq;
    }

    public NodoBB getHijo_der() {
        return hijo_der;
    }

    public void setHijo_der(NodoBB hijo_der) {
        this.hijo_der = hijo_der;
    }
    
    public boolean estaIzquierdoVacio(){
        return this.hijo_izq==null;
    }
    public boolean estaDerechoVacio(){
        return this.hijo_der==null;
    }
    
}
