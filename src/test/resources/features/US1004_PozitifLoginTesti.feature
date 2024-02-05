Feature: US1004 Kullanıcı gecerli bilgilerle sisteme giris yapabilmeli

  Scenario: TC10 gecerli username ve password ile sisteme giris yapabilmeli
    Given kullanici "toUrl" anasayfaya gider
    Then account linkine tıklar
    And email olarak "toGecerliEmail" girer
    And password olarak "toGecerliPassword" girer
    Then sign in butonuna basarak login olun
    And basarili giris yapilabildigini test eder
    And 1 saniye bekler
    And sayfayi kapatir
