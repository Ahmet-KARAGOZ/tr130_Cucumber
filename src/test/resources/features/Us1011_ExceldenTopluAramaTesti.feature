Feature: US1011 excel olarak verilen listedeki ürünleri aratır

  Scenario Outline: TC19 excelden seçeceğimiz satırdaki ürünlerin min ürün sayısı test edilir.

    Given kullanici "toUrl" anasayfaya gider
    Then urun excelindeki "<istenenSatir>" daki urunun min. miktarini ve urun ismini kaydeder
    And urun ismini testotomasyonu sayfasinda arar ve sonuc sayisini kaydeder
    And And bulunan urun sayisinin kaydedilen min. miktardan fazla oldugunu test eder
    And sayfayi kapatir

    Examples:
    |istenenSatir|
    |2           |
    |3           |
    |4           |
    |5           |
    |8           |
    |9           |
    |10          |