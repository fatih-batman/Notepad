/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author batma
 */

public class Text extends Observable{
    private String metin;
    
    public Text(String m){
        metin=m;
    }

    /**
     * @return the metin
     */
    public String getMetin() {
        return metin;
    }

    /**
     * @param metin the metin to set
     */
    public void setMetin(String metin) {
        this.metin = metin;
    }

    /**
     * @return the kayitliOlanMetin
     */
   
    public boolean kaydedildiMiKontrolEt(String butunSatirlar){  // Nesnede bulunan değişiklikler
        if(!metin.equals(butunSatirlar)  ){ // dosya olarak kaydedildimi sorgular.
            haberVer();
            return false; 
                                                             }
        else return true;
        
    }
    
    
    
}
