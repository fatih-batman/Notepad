
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author batma
 */
public class hafizaMemento {
    private LinkedList<MetinMemento> listeMetinMemento;
    private MetinMemento[] sonCikarilanListeMetinMemento;
     
    public hafizaMemento(){
        listeMetinMemento= new LinkedList<MetinMemento>();
        sonCikarilanListeMetinMemento= new MetinMemento[1];
    }
    
    public void hafizaMementoTemizle(){
        listeMetinMemento= new LinkedList<MetinMemento>();
        sonCikarilanListeMetinMemento= new MetinMemento[1];
    }
    
    public MetinMemento getSonCikarilanListeMetinMemento(){
        return sonCikarilanListeMetinMemento[0];
    }
    
    // En fazla 50 geri dön kullanılabilir.
    public void hafizaMementoEkle(MetinMemento memento){
        listeMetinMemento.add(memento); 
        if (listeMetinMemento.size() > 50) listeMetinMemento.removeFirst();
    }
    
    public LinkedList<MetinMemento> getListeMetinMemento(){
        return listeMetinMemento;
    }
    //     AHMET
    public MetinMemento sonVersiyonuGetir(){
        if(!listeMetinMemento.isEmpty()){
            MetinMemento sonEleman = 
       listeMetinMemento.get(listeMetinMemento.size()-1);
            listeMetinMemento.remove(sonEleman);
            sonCikarilanListeMetinMemento[0]=sonEleman;
            return sonEleman;
        } else{
            throw new ArrayIndexOutOfBoundsException("Geri al kullanılamaz.");
        }
    }
    
}
