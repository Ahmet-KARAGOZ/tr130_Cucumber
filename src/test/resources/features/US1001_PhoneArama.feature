
 #user story ile aynı seviyede kullanılır. birden fazla test case içerebilir.
Feature: US1001 Kullanici phone icin arama yapabilmeli
  #Test case karşılık gelir.

  @smoke
  Scenario:TC01 phone icin aram yapar
    Given kullanici Testotomasyon sayfasina gider
    And phone icin arama yapar
    Then aradigi urunun bulundugunu test eder
    And sayfayi kapatir

  Scenario: TC02 dress icin aram yapar
    Given kullanici Testotomasyon sayfasina gider
    And dress icin arama yapar
    Then aradigi urunun bulundugunu test eder
    And sayfayi kapatir

  Scenario: TC03 java sonuc bulmamali
    Given kullanici Testotomasyon sayfasina gider
    And java icin arama yapar
    Then aradigi urunun bulundmadigini test eder
    And sayfayi kapatir
