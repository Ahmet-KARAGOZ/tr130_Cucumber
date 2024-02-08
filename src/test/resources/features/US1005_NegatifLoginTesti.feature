
Feature: US1005 gecersiz bilgilerle sisteme giris yapilamamali


  Scenario: TC11 gecerli email , gecersiz password
    Given kullanici "toUrl" anasayfaya gider
    Then account linkine tıklar
    And email olarak "toGecerliEmail" girer
    And password olarak "toGecersizPassword" girer
    Then sign in butonuna basarak login olun
    And basarili giris yapilamadigini test eder
    And 1 saniye bekler
    And sayfayi kapatir

  Scenario: TC12 Gecersiz email, gecerli password ile sisteme giris yapilamaz

    Given kullanici "toUrl" anasayfaya gider
    Then account linkine tıklar
    And email olarak "toGecersizEmail" girer
    And password olarak "toGecerliPassword" girer
    Then sign in butonuna basarak login olun
    And basarili giris yapilamadigini test eder
    And 3 saniye bekler
    And sayfayi kapatir

  Scenario: TC12 Gecersiz email, gecerli password ile sisteme giris yapilamaz

    Given kullanici "toUrl" anasayfaya gider
    Then account linkine tıklar
    And email olarak "toGecersizEmail" girer
    And password olarak "toGecersizPassword" girer
    Then sign in butonuna basarak login olun
    And basarili giris yapilamadigini test eder
    And 3 saniye bekler
    And sayfayi kapatir
