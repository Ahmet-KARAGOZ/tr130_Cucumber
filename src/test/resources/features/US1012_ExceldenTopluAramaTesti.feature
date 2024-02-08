Feature: US1012 exceldeki tüm ürünlerin stoklarını test eder.
  Scenario: TC20 Exceldeki tüm ürünlerin min miktarda bulundugunu test eder.
    Given kullanici "toUrl" anasayfaya gider
    Then urun excelindeki tum urunler icin arama yapip min miktarda urun oldugunu test eder
    And 1 saniye bekler
    And sayfayi kapatir