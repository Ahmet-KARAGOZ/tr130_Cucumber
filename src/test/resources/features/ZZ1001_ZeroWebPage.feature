Feature: ZZ1001 Kullanıcı zero Bank sitesine giriş yaparak döviz cevirimi yapar
  Scenario: TC01 Kullanici username password ile giris yapabilmeli
    Given Kullanici Zero WebAppSecurtiy sayfasina gider
    Then ana sayfaya gittigini kontrol eder
    And sign in butonuna basar
    Then login kutusuna username yazar
    Then password kutusuna password yazar
    And sign in tusuna basar
    Then back tusuna basar
    And giris yapilabildigini dogrular
    Then online banking menusune tiklar
    And paybills sayfasina gider
    Then Purchase Foreign Currency tusuna basar
    And Currency dropdown menusunun erisilebilir oldugunu dogrulayin
    Then  Currency dropdown menusunden Eurozone secin
    And Eurozone euro secildigini dogrulayin
    Then Dropdown menude 16 option bulundugunu dogrulayin.
    And Dropdown menude Canada dollar bulunduğunu dogrulayin
    And sayfayi kapatir