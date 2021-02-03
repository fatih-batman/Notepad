
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
public class MetinMemento {
    private String metinAdi;
    private LinkedList<String> sozcukler;
    
    public MetinMemento(String metinAdi,String metin){
        this.metinAdi=metinAdi;
        sozcukler=metinParcala(metin);
    }
    public MetinMemento(){}; 
    
    public MetinMemento(String metinAdi,LinkedList<String> sozcukler){
        this.metinAdi=metinAdi;
        this.sozcukler=sozcukler;
    }
    
    
    public LinkedList<String> metinParcala(String metin){
        String[] parts = metin.split("(?!^)\\b");
        LinkedList<String> liste = new LinkedList<String>();
        for(String kelime:parts) liste.add(kelime);
        return liste;
    }

    /**
     * @return the metinAdi
     */
    public String getMetinAdi() {
        return metinAdi;
    }

    /**
     * @param metinAdi the metinAdi to set
     */
    public void setMetinAdi(String metinAdi) {
        this.metinAdi = metinAdi;
    }

    /**
     * @return the sozcukler
     */
    public LinkedList<String> getSozcukler() {
        return sozcukler;
    }

    /**
     * @param sozcukler the sozcukler to set
     */
    public void setSozcukler(LinkedList<String> sozcukler) {
        this.sozcukler = sozcukler;
    }
    
}
