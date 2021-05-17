/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kjbs1
 */
public class ListaDobleCircularPrioridad  extends ListaDobleCircular{
    
    public ListaDobleCircularPrioridad() {
        super();
    }
    
    @Override
    public boolean insertar(char dato, int nivel) {
        boolean respuesta = super.insertar(dato, nivel);
        if(!respuesta) return false;
        
        if (fin.getNivel() == fin.getAnt().getNivel()) return true;
        if (fin.getNivel() > ini.getNivel()) {
            fin = fin.getAnt();
            ini = ini.getAnt();
            return true;
        }
        NodoDoble t = fin.getAnt();
        while (fin.getNivel() > t.getNivel()) {
            t = t.getAnt();
        }

        fin.setSig(t.getSig());
        ini.setAnt(fin.getAnt());
        fin.getAnt().setSig(ini);
        fin.setAnt(t);
        t.getSig().setAnt(fin);
        t.setSig(fin);
        fin = ini.getAnt();
        return true;
    }
    
    public boolean eliminar(char dato, int nivel){
        
        if(hayListaDobleVacia()) return false;
        
        if(ini.getDato() == dato && ini.getNivel() == nivel){
            return eliminar();
        }
        for(NodoDoble ant = ini, temp = ini.getSig(); temp != fin.getSig(); ant = temp, temp = temp.getSig()){
            if(temp.getDato() == dato && temp.getNivel() == nivel){
                if(temp == fin){
                    fin.setSig(null);
                    fin = ant;
                    ant.setSig(ini);
                    temp = null;
                }else{
                    ant.setSig(temp.getSig());
                    temp.setSig(null);
                    temp = null;
                }
                return true;
            }
        }
        return false;
    }
    
}
