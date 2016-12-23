package Arbol;

import java.util.ArrayList;

public class ArbolBB {
    private NodoBB raiz;
    
    public ArbolBB(){
        raiz=null;
    }
    
    public boolean insertar(int dato){
        int in_x=180;
        int in_y=10;
        if(this.estaelArbolVacio()){
            raiz=new NodoBB(dato);
            raiz.setPosition(in_x, in_y);
            if(raiz==null)
                return false;
            return true;
        }
        if(datoEncontrado(dato)){
           return false;
        }
        
        NodoBB t=new NodoBB(dato);
        if(t==null){
            return false;
        }
        
        return recorrerInsertar(raiz,t,1);
    }
    public boolean recorrerInsertar(NodoBB padre,NodoBB hijo,int v){
        if(hijo.valor<padre.valor){
            if(padre.estaIzquierdoVacio()){
                padre.setHijo_izq(hijo);
                padre.getHijo_izq().setPosition(padre.x-30, padre.y+30);
                return true;
            }
            return recorrerInsertar(padre.getHijo_izq(),hijo,++v);
        }else{
            if(padre.estaDerechoVacio()){
                padre.setHijo_der(hijo);
                padre.getHijo_der().setPosition(padre.x+30, padre.y+30);
                return true;
            }
            return recorrerInsertar(padre.getHijo_der(),hijo,++v);
        }
    }
    public boolean eliminar(int valor){
        if(raiz==null)return false;
        if(raiz.valor==valor){
            if(raiz.esHoja()){
                raiz=null;
                return true;
            }
            return false;
        }
       if(!datoEncontrado(valor)){
           return false;
       }
       return buscarNodoEliminar(raiz,valor);
    }
    
    private boolean datoEncontrado(int valor){
        //Codigo para buscar el dato
        ArrayList<NodoBB> nodos=this.getPreordenNodos();
        for(NodoBB nodo:nodos){
            if(nodo.valor==valor){
                return true;
            }
        }
        return false;
    }
    
    private boolean buscarNodoEliminar(NodoBB padre,int valor){
        
        if(!padre.estaDerechoVacio()){
            if(padre.getHijo_der().getValor()==valor){
                if(padre.getHijo_der().esHoja()){
                    padre.setHijo_der(null);
                    return true;
                }
                return false;
            }
        }
        if(!padre.estaIzquierdoVacio()){
            if(padre.getHijo_izq().getValor()==valor){
                if(padre.getHijo_izq().esHoja()){
                    padre.setHijo_izq(null);
                    return true;
                }
                return false;
            }
        }
        return (valor<padre.valor)? buscarNodoEliminar(padre.getHijo_izq(),valor):buscarNodoEliminar(padre.getHijo_der(),valor);
        
    }
    
    private String darFormato(String ruta){
        while(ruta.contains(",,")){
            ruta=ruta.replace(",,", ",");
        }
        if(ruta.substring(0,1).equals(",")){
            ruta=ruta.substring(3, ruta.length());
        }
        return ruta;
    }
    
    public ArrayList<NodoBB> getPreordenNodos(){
        return getPreordenN_(raiz,new ArrayList<NodoBB>());
    }
    private ArrayList<NodoBB> getPreordenN_(NodoBB padre,ArrayList<NodoBB> ar){
        if(padre==null)
            return null;
        ar.add(padre);
        if(!padre.estaIzquierdoVacio())
            getPreordenN_(padre.getHijo_izq(),ar);
        if(!padre.estaDerechoVacio())
            getPreordenN_(padre.getHijo_der(),ar);
        return ar;
    }
   
    public boolean estaelArbolVacio(){
        return raiz==null;
    }
    
    public void vaciarArbol(){
        if(raiz==null)
            return;
        raiz.setHijo_der(null);
        raiz.setHijo_izq(null);
        raiz=null;
    }
    
    
    
}
