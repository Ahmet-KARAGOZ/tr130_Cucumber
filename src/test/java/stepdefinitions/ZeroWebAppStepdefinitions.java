package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.ZeroWebPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class ZeroWebAppStepdefinitions {
	ZeroWebPage zeroWebPage = new ZeroWebPage();
	Select select;

	@Given("Kullanici Zero WebAppSecurtiy sayfasina gider")
	public void kullanici_zero_web_app_securtiy_sayfasina_gider() {
		Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));

	}
	@Then("ana sayfaya gittigini kontrol eder")
	public void ana_sayfaya_gittigini_kontrol_eder() {
		String expURL = ConfigReader.getProperty("zeroUrl");
		String actURL = Driver.getDriver().getCurrentUrl();

		Assert.assertEquals(expURL , actURL);
	}
	@Then("sign in butonuna basar")
	public void sign_in_butonuna_basar() {
		zeroWebPage.signInLinki.click();

	}
	@Then("login kutusuna username yazar")
	public void login_kutusuna_username_yazar() {
		zeroWebPage.userNameKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliUserName"));

	}
	@Then("password kutusuna password yazar")
	public void password_kutusuna_password_yazar() {
		zeroWebPage.passwordKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliPassword"));

	}
	@Then("sign in tusuna basar")
	public void sign_in_tusuna_basar() {
		zeroWebPage.signInButonu.click();

	}

	@Then("back tusuna basar")
	public void backTusunaBasar() {
		Driver.getDriver().navigate().back();
	}

	@And("giris yapilabildigini dogrular")
	public void girisYapilabildiginiDogrular() {
		Assert.assertTrue(zeroWebPage.loginDogrulama.isDisplayed());
	}

	@Then("online banking menusune tiklar")
	public void onlineBankingMenusuneTiklar() {
		zeroWebPage.onlineBankingLinki.click();
	}

	@And("paybills sayfasina gider")
	public void paybillsSayfasinaGider() {
		zeroWebPage.payBillsLinki.click();
	}

	@Then("Purchase Foreign Currency tusuna basar")
	public void purchaseForeignCurrencyTusunaBasar() {
		zeroWebPage.purchaseForeignCurrencyTab.click();
	}

	@And("Currency dropdown menusunun erisilebilir oldugunu dogrulayin")
	public void currencyDropdownMenusununErisilebilirOldugunuDogrulayin() {
		Assert.assertTrue(zeroWebPage.pcCurrencyDropdown.isEnabled());
	}


	@Then("Currency dropdown menusunden Eurozone secin")
	public void currencyDropdownMenusundenEurozoneUSecin() {
		select = new Select(zeroWebPage.pcCurrencyDropdown);
		select.selectByValue("EUR");
	}

	@And("Eurozone euro secildigini dogrulayin")
	public void eurozoneEuroSecildiginiDogrulayin() {
		String expectedSecilenOption = "Eurozone (euro)";
		String actualSecilenOption = select.getFirstSelectedOption().getText();

		Assert.assertEquals(expectedSecilenOption , actualSecilenOption);
	}

	@Then("Dropdown menude {int} option bulundugunu dogrulayin.")
	public void dropdownMenudeOptionBulundugunuDogrulayin(int gelenOptionSayisi) {
		int expOptionSayisi = gelenOptionSayisi;
		int actOptionSayisi = select.getOptions().size();

		Assert.assertEquals(expOptionSayisi , actOptionSayisi);

	}

	@And("Dropdown menude Canada dollar bulunduğunu dogrulayin")
	public void dropdownMenudeCanadaDollarBulunduğunuDogrulayin() {
		List<WebElement> dropdownOptionElementleriList = select.getOptions();
		List<String> dropDownOptionsString = ReusableMethods.stringListeCevir(dropdownOptionElementleriList);

		String expIcerik = "Canada (dollar)";
		Assert.assertTrue(dropDownOptionsString.contains(expIcerik));
	}

}
