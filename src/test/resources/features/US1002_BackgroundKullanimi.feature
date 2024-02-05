Feature: US1002 Kullanici background özelligini kullanir

  Background: anasayfaya gitme
    Given  kullanici Testotomasyon sayfasina gider

  Scenario:TC04 phone icin aram yapar

    And phone icin arama yapar
    Then aradigi urunun bulundugunu test eder
    And sayfayi kapatir

  Scenario: TC05 dress icin aram yapar

    And dress icin arama yapar
    Then aradigi urunun bulundugunu test eder
    And sayfayi kapatir

  Scenario: TC06 java sonuc bulmamali

    And java icin arama yapar
    Then aradigi urunun bulundmadigini test eder
    And sayfayi kapatir