

  Feature: US1003 kuulanici parametre olarak verilen urunu aratabilmeli

Scenario: TC07 parametre ile arama yapilabilmeli

  Given kullanici Testotomasyon sayfasina gider
  And "baby" icin arama yapar
  Then aradigi urunun bulundugunu test eder
  And 1 saniye bekler
  And sayfayi kapatir
@smoke
Scenario: TC08 nutella sonuc bulmamali
  Given kullanici Testotomasyon sayfasina gider
  And "nutella" icin arama yapar
  Then aradigi urunun bulundmadigini test eder
  And sayfayi kapatir
@smoke
Scenario: TC09 parametre ile arama yapilabilmeli
  Given kullanici Testotomasyon sayfasina gider
  And "iphone" icin arama yapar
  Then aradigi urunun bulundugunu test eder
  And sayfayi kapatir