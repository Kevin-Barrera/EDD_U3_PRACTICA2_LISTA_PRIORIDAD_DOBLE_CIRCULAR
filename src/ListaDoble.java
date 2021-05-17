/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kjbs1
 */
public class ListaDoble {
    protected NodoDoble ini;
    protected NodoDoble fin;
    
    public ListaDoble(){
        ini=fin = null;
    }
    
    public boolean insertar(char dato, int nivel){
        NodoDoble nuevo = new NodoDoble(dato, nivel);
        if(nuevo==null) return false;
        if(hayListaDobleVacia()){
            ini = fin = nuevo;
            return true;
        }
        fin.setSig(nuevo);
        nuevo.setAnt(fin);
        fin = nuevo;
        return true; 
    }
    
    public boolean hayListaDobleVacia(){
        return ini==null && fin==null; 
    }
    
    public boolean eliminar(){
        if(hayListaDobleVacia())return false;
        if(hayUnSoloNodo()){
            ini = fin = null;
            return true;
        }
        NodoDoble temp = ini;
        ini = temp.getSig();
        ini.setAnt(null);
        temp.setSig(null);
        temp = null;
        return true;
    }
    
    public boolean hayUnSoloNodo(){
        return ini==fin;
    }
    
    public NodoDoble getIni(){
        return ini;
    }
    
    public NodoDoble getFin(){
        return fin;
    }
}
