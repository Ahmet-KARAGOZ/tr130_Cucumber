Feature: Kullanıcı urun ismi ile sepetteki ismin aynı oldugunu test eder
  Scenario: Kullanici phone aratır ilk urune gider urun ismi ile sepetteki urun ismini test eder
    Given kullanici Testotomasyon sayfasina gider
    Then "phone" icin arama yapar
    And listelenen urunlerden ilkine tiklar
    And urunu sepete ekleyin
    Then your cart linkine tiklayin
    And urun sayfasindaki urun ismi ile sepetteki urun isminin ayni oldugunu test edin
    And sayfayi kapatir