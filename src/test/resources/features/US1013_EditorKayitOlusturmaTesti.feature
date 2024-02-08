Feature: Kullanıcılar toplu kayıt olusturabilmeli

 Scenario: TC21 kullanıcı  olusturabilmeli

   When kullanici "editorUrl" anasayfaya gider
   Then new butonuna basar
   And tum bilgileri girer
   And Create tusuna basar
   When kullanici ilk isim ile arama yapar
   Then isim bolumunde isminin oldugunu dogrular
   And sayfayi kapatir