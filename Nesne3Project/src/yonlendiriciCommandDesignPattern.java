/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author batma
 */
public class yonlendiriciCommandDesignPattern {
    
    public static String yonlendir(Islem islem, String kelime){
        String sonHarfSilinen = islem.geriAlSonHarf(kelime);
        return sonHarfSilinen;
    }
}
