package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestotomasyonStepdefinitions {

	TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
	String urunSayfasindakiUrunIsmi;
	String satirdakiUrunIsmi;
	//String satirdakiMinUrunSayisiStr;
	int satirdakiMinUrunSayisi;
	int actBulunanUrunSayisi;

	@Given("kullanici Testotomasyon sayfasina gider")
	public void kullanici_testotomasyon_sayfasina_gider() {
		Driver.getDriver().get(ConfigReader.getProperty("toUrl"));


	}

	@Given("phone icin arama yapar")
	public void phone_icin_arama_yapar() {
		testOtomasyonPage.aramaKutusu.sendKeys("phone", Keys.ENTER);

	}

	@Then("aradigi urunun bulundugunu test eder")
	public void aradigi_urunun_bulundugunu_test_eder() {
		Assert.assertTrue(testOtomasyonPage.bulunanUrunElementleriList.size() > 0);

	}

	@And("sayfayi kapatir")
	public void sayfayiKapatir() {
		Driver.quitDriver();
	}

	@And("dress icin arama yapar")
	public void dressIcinAramaYapar() {
		testOtomasyonPage.aramaKutusu.sendKeys("dress", Keys.ENTER);
	}

	@And("java icin arama yapar")
	public void javaIcinAramaYapar() {
		testOtomasyonPage.aramaKutusu.sendKeys("java", Keys.ENTER);
	}

	@Then("aradigi urunun bulundmadigini test eder")
	public void aradigiUrununBulundmadiginiTestEder() {
		String expectedSonucYazisi = ConfigReader.getProperty("toUrunBulunamadiYazisi");
		String actSonucYazisi = testOtomasyonPage.bulunanUrunSayisiYazisiElementi.getText();

		Assert.assertEquals(expectedSonucYazisi, actSonucYazisi);

	}

	@And("{string} icin arama yapar")
	public void icinAramaYapar(String aranacakUrun) {
		testOtomasyonPage.aramaKutusu.sendKeys(aranacakUrun, Keys.ENTER);
	}

	@And("{int} saniye bekler")
	public void saniyeBekler(int beklenecekSure) {
		try {
			Thread.sleep(beklenecekSure * 1000);
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
		Assert.assertEquals(urunSayfasindakiUrunIsmi, sepettekiUrunIsmi);
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
		Assert.assertTrue(testOtomasyonPage.logoutButonu.isDisplayed());
	}

	@When("email olarak listeden {string} girer")
	public void emailOlarakListedenGirer(String siradakiEmail) {
		testOtomasyonPage.emailKutusu.sendKeys(siradakiEmail);
	}

	@And("password olarak listeden {string} girer")
	public void passwordOlarakListedenGirer(String siradakiPassword) {
		testOtomasyonPage.passwordKutusu.sendKeys(siradakiPassword);
	}

	@Then("urun excelindeki {string} daki urunun min. miktarini ve urun ismini kaydeder")
	public void urunExcelindekiDakiUrununMinMiktariniVeUrunIsminiKaydeder(String istenenSatir) throws IOException {
		String dosyaYolu = "src/test/resources/stok.xlsx";
		FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sayfa2 = workbook.getSheet("Sayfa2");
		satirdakiUrunIsmi = sayfa2.getRow(Integer.parseInt(istenenSatir) - 1).getCell(0).toString();
		String satirdakiMinUrunSayisiStr = sayfa2.getRow(Integer.parseInt(istenenSatir) - 1).getCell(1).toString();
		satirdakiMinUrunSayisi = (int) Double.parseDouble(satirdakiMinUrunSayisiStr);

	}

	@And("urun ismini testotomasyonu sayfasinda arar ve sonuc sayisini kaydeder")
	public void urunIsminiTestotomasyonuSayfasindaArarVeSonucSayisiniKaydeder() {
		testOtomasyonPage.aramaKutusu.sendKeys(satirdakiUrunIsmi + Keys.ENTER);
		String aramaSonucYazisi = testOtomasyonPage.bulunanUrunSayisiYazisiElementi.getText();
		aramaSonucYazisi = aramaSonucYazisi.replaceAll("\\D", "");
		actBulunanUrunSayisi = Integer.parseInt(aramaSonucYazisi);
	}

	@And("And bulunan urun sayisinin kaydedilen min. miktardan fazla oldugunu test eder")
	public void andBulunanUrunSayisininKaydedilenMinMiktardanFazlaOldugunuTestEder() {
		Assert.assertTrue(actBulunanUrunSayisi >= satirdakiMinUrunSayisi);
	}

	@Then("urun excelindeki tum urunler icin arama yapip min miktarda urun oldugunu test eder")
	public void urunExcelindekiTumUrunlerIcinAramaYapipMinMiktardaUrunOldugunuTestEder() throws IOException {
		// adimlari takip ederek excel'deki sayfaya ulas
		String dosyaYolu = "src/test/resources/stok.xlsx";
		FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sayfa2 = workbook.getSheet("Sayfa2");

		// exceldeki son satir sayisini bulup
		int sonSatirIndex = sayfa2.getLastRowNum();

		// bir loop ile urunu aratip min sayida urun bulundugunu test et
		boolean stoktaOlmayanVarmi = false;
		for (int i = 1; i <= sonSatirIndex; i++) {
			String satirdakiUrunIsmi = sayfa2.getRow(i).getCell(0).toString();
			String satirdakiMinUrunMiktariSTR = sayfa2.getRow(i).getCell(1).toString();
			double satirdakiMinUrunMiktariDbl = Double.parseDouble(satirdakiMinUrunMiktariSTR);
			int satirdakiMinUrunSayisi = (int) satirdakiMinUrunMiktariDbl;

			Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

			testOtomasyonPage.aramaKutusu.sendKeys(satirdakiUrunIsmi + Keys.ENTER);
			String actualUrunSayisiStr = testOtomasyonPage.bulunanUrunSayisiYazisiElementi.getText();
			actualUrunSayisiStr = actualUrunSayisiStr.replaceAll("\\D", "");
			int actualUrunSayisi = Integer.parseInt(actualUrunSayisiStr);

			try {
				Assert.assertTrue(actualUrunSayisi >= satirdakiMinUrunSayisi);
			} catch (AssertionError e) {
				stoktaOlmayanVarmi = true;
				System.out.println("aranan " + satirdakiUrunIsmi + " min stok sayisi "+ satirdakiMinUrunSayisi+" sağlanamadı " + "bulunan ürün sayısı " + actualUrunSayisi);
			}


		}


		Assert.assertFalse(stoktaOlmayanVarmi);
		Driver.quitDriver();

	}
}
