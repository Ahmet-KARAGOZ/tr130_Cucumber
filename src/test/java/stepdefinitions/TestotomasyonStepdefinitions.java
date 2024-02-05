package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TestotomasyonStepdefinitions {

	TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
	String urunSayfasindakiUrunIsmi;

	@Given("kullanici Testotomasyon sayfasina gider")
	public void kullanici_testotomasyon_sayfasina_gider() {
		Driver.getDriver().get(ConfigReader.getProperty("toUrl"));


	}
	@Given("phone icin arama yapar")
	public void phone_icin_arama_yapar() {
		testOtomasyonPage.aramaKutusu.sendKeys("phone" , Keys.ENTER);

	}
	@Then("aradigi urunun bulundugunu test eder")
	public void aradigi_urunun_bulundugunu_test_eder() {
		Assert.assertTrue(testOtomasyonPage.bulunanUrunElementleriList.size()>0);

	}

	@And("sayfayi kapatir")
	public void sayfayiKapatir() {
		Driver.quitDriver();
	}

	@And("dress icin arama yapar")
	public void dressIcinAramaYapar() {
		testOtomasyonPage.aramaKutusu.sendKeys("dress" , Keys.ENTER);
	}

	@And("java icin arama yapar")
	public void javaIcinAramaYapar() {
		testOtomasyonPage.aramaKutusu.sendKeys("java" , Keys.ENTER);
	}

	@Then("aradigi urunun bulundmadigini test eder")
	public void aradigiUrununBulundmadiginiTestEder() {
		String expectedSonucYazisi = ConfigReader.getProperty("toUrunBulunamadiYazisi");
		String actSonucYazisi = testOtomasyonPage.bulunanUrunSayisiYazisiElementi.getText();

		Assert.assertEquals(expectedSonucYazisi,actSonucYazisi);

	}

	@And("{string} icin arama yapar")
	public void icinAramaYapar(String aranacakUrun) {
		testOtomasyonPage.aramaKutusu.sendKeys(aranacakUrun , Keys.ENTER);
	}

	@And("{int} saniye bekler")
	public void saniyeBekler(int beklenecekSure) {
		try {
			Thread.sleep(beklenecekSure*1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}


	@Then("account linkine tıklar")
	public void accountLinkineTıklar() {
		testOtomasyonPage.accountLinki.click();
	}


	@And("email kutusuna gecerli email girer")
	public void emailKutusunaGecerliEmailGirer() {
		testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));

	}

	@And("password kutusuna gecersiz password girer")
	public void passwordKutusunaGecersizPasswordGirer() {
		testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
	}

	@Then("sign in butonuna basarak login olun")
	public void signInButonunaBasarakLoginOlun() {
		testOtomasyonPage.loginButonu.click();
	}

	@And("basarili giris yapilamadigini test eder")
	public void basariliGirisYapilamadiginiTestEder() {
		Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());
	}

	@And("email kutusuna gecersiz email girer")
	public void emailKutusunaGecersizEmailGirer() {
		testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
	}

	@And("password kutusuna gecerli password girer")
	public void passwordKutusunaGecerliPasswordGirer() {
		testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
	}

	@And("listelenen urunlerden ilkine tiklar")
	public void listelenenUrunlerdenIlkineTiklar() {
		testOtomasyonPage.bulunanUrunElementleriList.get(0).click();
	}

	@And("urunu sepete ekleyin")
	public void urunuSepeteEkleyin() {
		urunSayfasindakiUrunIsmi = testOtomasyonPage.urunSayfasindaUrunIsimElementi.getText();
		testOtomasyonPage.urunSayfasiAddToCartButonu.click();
	}

	@Then("your cart linkine tiklayin")
	public void yourCartLinkineTiklayin() {
		testOtomasyonPage.yourCardButonu.click();
	}

	@And("urun sayfasindaki urun ismi ile sepetteki urun isminin ayni oldugunu test edin")
	public void urunSayfasindakiUrunIsmiIleSepettekiUrunIsmininAyniOldugunuTestEdin() {
		String sepettekiUrunIsmi = testOtomasyonPage.sepettekiUrunIsimElementi.getText();
		Assert.assertEquals(urunSayfasindakiUrunIsmi , sepettekiUrunIsmi);
	}

	@Given("kullanici {string} anasayfaya gider")
	public void kullaniciAnasayfayaGider(String configdenIstenenUrl) {
		Driver.getDriver().get(ConfigReader.getProperty(configdenIstenenUrl));
	}

	@And("email olarak {string} girer")
	public void emailOlarakGirer(String configtenIstenenEmail) {
		testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty(configtenIstenenEmail));
	}

	@And("password olarak {string} girer")
	public void passwordOlarakGirer(String configtenIstenenPAssword) {
		testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty(configtenIstenenPAssword));
	}

	@And("basarili giris yapilabildigini test eder")
	public void basariliGirisYapilabildiginiTestEder() {
		Assert.assertTrue(testOtomasyonPage.logoutButonu.isDisplayed());	}
}
