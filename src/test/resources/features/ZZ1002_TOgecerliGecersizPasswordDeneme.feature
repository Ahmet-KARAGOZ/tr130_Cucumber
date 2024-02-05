Feature: Kullanıcı gecerli email gecersiz password - gecersiz email geçerli password - geçersiz email geçersiz password

  Scenario: TC01 kullanıcı gecerli email gecersiz password ile giris yapamadıgını test edin.
    Given kullanici Testotomasyon sayfasina gider
    Then account linkine tıklar
    And email kutusuna gecerli email girer
    And password kutusuna gecersiz password girer
    Then sign in butonuna basarak login olun
    And basarili giris yapilamadigini test eder
    Then sayfayi kapatir

  Scenario: TC02 kullanıcı gecersiz email gecerli sifre ile giris yapamadigini test edin
    Given kullanici Testotomasyon sayfasina gider
    Then account linkine tıklar
    And email kutusuna gecersiz email girer
    And password kutusuna gecerli password girer
    Then sign in butonuna basarak login olun
    And basarili giris yapilamadigini test eder
    Then sayfayi kapatir

  Scenario: TC03  gecersiz email gecersiz password ile giris yapamadigini test edin
    Given kullanici Testotomasyon sayfasina gider
    Then account linkine tıklar
    And email kutusuna gecersiz email girer
    And password kutusuna gecersiz password girer
    Then sign in butonuna basarak login olun
    And basarili giris yapilamadigini test eder
    Then sayfayi kapatir
