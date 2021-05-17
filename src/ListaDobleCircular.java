/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kjbs1
 */
public class ListaDobleCircular extends ListaDoble{
    public ListaDobleCircular(){
        super();
    }
    
    @Override
    public boolean insertar(char dato, int nivel){
        boolean respuesta = super.insertar(dato, nivel);
        if(!respuesta) return false;
        ini.setAnt(fin);
        fin.setSig(ini);
        return true; 
    }
    
    @Override
    public boolean eliminar(){
        if(!hayListaDobleVacia()){
            ini.setAnt(null);
            fin.setSig(null);
            return true;
        }
        boolean respuesta = super.eliminar();
        if(!respuesta) return false;
        if(!hayListaDobleVacia()){
            ini.setAnt(fin);
            fin.setSig(ini);
        }
        return true;
    }
}
