Feature: US1008 kullanıcı add ve remove butonlarını test eder

  Scenario:TC16 Kullanıcı add ve remove butonlarını kullanabilmeli

    Given kullanici "heroUrl" anasayfaya gider
    When kullanici Add Element butonuna basar
    And 2 saniye bekler
    And Delete butonu’nun gorunur oldugunu test eder
    Then Delete tusuna basar
    And Add Remove Elements yazisinin gorunur oldugunu test eder
    And 2 saniye bekler
    And Delete butonunun gorunmedigini test eder
    And sayfayi kapatir