Feature: US1009 Kullanıcı verilen listedeki tum ürünleri aratır.

  Scenario Outline:  TC17 listedeki tüm ürünlerin var oldugunu test eder
      #phone java dress baby iphone samsung --> Aranacak ürünler

    Given kullanici "toUrl" anasayfaya gider
    Then "<aranacakKelime>" icin arama yapar
    And aradigi urunun bulundugunu test eder
    And 1 saniye bekler
    Then sayfayi kapatir

    Examples:
    |aranacakKelime|
    |phone         |
    |java          |
    |dress         |
    |baby          |
    |iphone        |
    |samsung       |