Feature: US1014 tablo olarak verilen degerler ilekayıt olusturur.


  Scenario Outline: TC22 tablo olarak verilen datalar ile kayıt olusturabilmeli


    When kullanici "editorUrl" anasayfaya gider
    Then new butonuna basar
    And "<firstname>" "<lastname>" "<position>" "<office>" "<extention>""<startdate>" ve "<salary>" girer
    And Create tusuna basar
    When kullanici "<firstname>" ile arama yapar
    Then listede ilk ismin "<firstname>" icerdigini test eder
    And sayfayi kapatir


    Examples:
    |firstname|lastname|position|office|extention|startdate|salary|
    |Ahmet |KARAGOZ|QA|Izmir  |junior|2024-06-23|35000|
    |Orkong|BULUT  |QA|Newyork|senior|2024-07-21|95000|
