# Notepad
Notepad app that have gui with some design patterns
Notepad
Tıpki bilgisayarlarımızda olan metin belgesi düzenleyici veya Microsoft word programı gibi metin düzenlemeye yarayan bir program. Görsel bir arayüzü bulunmakta.
Uygulama aşağıdaki özellikleri gerçekleştirebilir.

* Dosya oluşturma, açma, kapatma, kaydetme
* Verilen bir kelimeyi bulmak ve değiştirmek
* Yazılan harfleri geri almak (harf harf (tek tek) geri alınabilir)
* Yazım Hatası Kontrolü ve düzeltilmesi:

Memento tasarım deseni: Memento anı-hatıra demek. Genel olarak silinen ve yerine yenisi getirilen nesnelerin veya varlıkların eskisi bir yerde olası geri dönüşler için kullanılması gerektiğinde bu tasarım deseni kullanılır. Programımızda bir harfi geri almak istediğimizde geri al butonunu kullanırız. İşte geri getirilen aslında bir harfi eksik olan önceki yazılmış kelimedir. Bu kelimeler sınıf yaratılmıştır ve farklı bir noktada tutulur. Geri al butonundan sonra eski hatıra nesne getirilir ve geri almadan önceki kelime hatıra olarak gönderilir.

Observer tasarım deseni: Kelime anlamı gözlemcidir. Notepad uygulaması kendi içerisinde bir çok kelimenin doğru yazılmış halini saklamakta. Eğer kullanıcı bir kelime girerse uygulama yazılmış kelimeleri kendi deposundaki yüzlerce kelime ile eşleştirmeye başlar. Bu eşleştirmeler içerisinde eğer kelime yanlış yazılmış ise kullanıcıya bunu gösterecektir. 

Command, iterator, observer ve memento tasarım kalıpları bu projede kullanılmıştır.


