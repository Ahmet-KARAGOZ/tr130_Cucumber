Feature: US1010 yanlış bilgilerle giriş yapamaz

  Scenario Outline: TC18 yanlış bilgilerle giriş yapılamadıgını test eder
    Given kullanici "toUrl" anasayfaya gider
    Then account linkine tıklar
    When email olarak listeden "<siradakiEmail>" girer
    And password olarak listeden "<siradakiPassword>" girer
    Then sign in butonuna basarak login olun
    And basarili giris yapilamadigini test eder
    And 1 saniye bekler
    Then sayfayi kapatir

    Examples:
    |siradakiEmail|siradakiPassword|
    |banu@gmail.com     |   898989|
    | sedat@yahoo.com   |   989887|
    | orkong@tmail.com  | 122334|
    |fatih@hotmail.com  |  454545|
    | arzu@senmail.com  |  676767|
    |mehmet@mynet.com   | 878987|