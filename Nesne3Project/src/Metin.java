/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class Metin extends Observable {
    private String metinAdi;
    private LinkedList<String> sozcukler;
//----------------------------------------------------------------------------------------------
    // İki çizgi arasındakilerin sınıf ile alakası yoktur. 
    private boolean Mod; // GUI'de bazen setText getText gibi metotları
    // addDocumentListener kullanmasın istiyoruz. Bu yüzden Mod var.
    private int geriAlSayisi;  // sayiyi takip ediyoruz. 0 ise işlem yapılıyor.
    private boolean geriAlaBasilmaSonrasiEklenirse; // sonCikarilanListeMetinMemento geri yükler
    // Eğer geri al sonrası bir ekleme yapılırsa, tekrar geri al kullanıldığında yanlış çalışmaktaydı.
    // bu değişken ile bunu takip edip düzelttik.
//-----------------------------------------------------------------------------------------------
    
    public Metin(String metinAdi,String metin){
        this.metinAdi=metinAdi;
        sozcukler=metinParcala(metin);
        geriAlaBasilmaSonrasiEklenirse=false;
        Mod=true;
        geriAlSayisi=0;
        geriAlaBasilmaSonrasiEklenirse=false;
    }
    
    public Metin(String metinAdi,LinkedList<String> sozcukler){
        this.metinAdi=metinAdi;
        this.sozcukler=sozcukler;
        Mod=true;
        geriAlSayisi=0;
        geriAlaBasilmaSonrasiEklenirse=false;
    }
    
    
    public Metin(){
    Mod=true;
    geriAlSayisi=0;
    geriAlaBasilmaSonrasiEklenirse=false;
    }; 

    /**
     * @return the metinAdi
     */
    
    
    
    public boolean getMod(){
        return Mod;
    }
    
    public void setMod(boolean mod){
        Mod=mod;
    }
    
    public boolean getGeriAlaBasilmaSonrasiEklenirse(){
        return geriAlaBasilmaSonrasiEklenirse;
    }
    
    public void setGeriAlaBasilmaSonrasiEklenirse(boolean geriAlaBasilmaSonrasiEklenirse){
        this.geriAlaBasilmaSonrasiEklenirse=geriAlaBasilmaSonrasiEklenirse;
    }
    
    public int getGeriAlSayisi(){
        return geriAlSayisi;
    }
    
    public void setGeriAlSayisi(int geriAlSayisi){
        this.geriAlSayisi=geriAlSayisi;
    }
    
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
    
    public Iterator getIteratorSozcukler(){
        return sozcukler.iterator();
    }
    

    /**
     * @param sozcukler the sozcukler to set
     */
    public void setSozcukler(LinkedList<String> sozcukler) {
        this.sozcukler = sozcukler;
    }
    
    public LinkedList<String> metinParcala(String metin){
        String[] parts = metin.split("(?!^)\\b");
        LinkedList<String> liste = new LinkedList<String>();
        for(String kelime:parts) liste.add(kelime);
        return liste;
    }
    
    public String metinBirlestir(LinkedList<String> sozcukler){
        String metin="";
        for(String string:sozcukler) metin=metin+string;
        return metin;
    }
    
    public ArrayList<Integer> kelimeBul(String arananKelime){  //LinkedList'de kelimenin indexleri 
    ArrayList<Integer> bulunanKelimeIndexListesi = new ArrayList<Integer>();//ArrayListde döndürür.
    int i = 0;
    for (Iterator iter = sozcukler.iterator(); iter.hasNext(); i++)  //ArrayList boş ise
        if(arananKelime.equalsIgnoreCase((String) iter.next() ))       //null döndürür.
            bulunanKelimeIndexListesi.add(i);                       // Iterator Design Pattern
    if (bulunanKelimeIndexListesi.isEmpty()) return null;       //burada kullanılmıştır.
        else return bulunanKelimeIndexListesi;
                                                            }
    
    public void kelimeDegistir (String yeniKelime, 
            ArrayList<Integer> bulunanKelimeIndexListesi) {
        for(int i:bulunanKelimeIndexListesi) sozcukler.set(i,yeniKelime);
                                                          }
    
    public Boolean kelimeHataliMi(String kelime,
           ArrayList<String> kelimeler) { //kelimeler word.txt dekiler.
        boolean sahipMi=kelimeler.contains(kelime); // sahipse hatalı değildir.
    return !sahipMi;
    }
    
    public String singleTransposition(String kelime,
           ArrayList<String> kelimeler){
        char[] charArray = new char[kelime.length()]; //sonuc olarak bulunmamışsa,                            
        for(int i=0;i<kelime.length()-1;i++){   // gelen kelimenin kendisini döndürür.
            charArray=kelime.toCharArray();
            char x = charArray[i];
            charArray[i]=charArray[i+1];
            charArray[i+1]=x;
            String yeniKelime=String.valueOf(charArray);
            boolean hataliMi = kelimeHataliMi(yeniKelime, kelimeler);
            if(!hataliMi) return yeniKelime; 
                                            }
        return kelime;
    }
    
    
    public MetinMemento kaydetMemento(){
        return new MetinMemento(metinAdi,sozcukler);
    }
    
    public void geriDonMemento(MetinMemento memento){
        sozcukler = memento.getSozcukler();
        metinAdi= memento.getMetinAdi();
    }




}

