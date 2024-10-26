package OrangeHRM.pageobject;
import entities.DatosUsuarios;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.util;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
public class LoginOrangeHRM extends PageObject {

	@FindBy(xpath = "//div[@class='orangehrm-login-logo']")
	WebElementFacade clickLogo;
	
	@FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and @name='username']")
	WebElementFacade clickUsuario;

	private static final String txtUsuario = "//input[@class='oxd-input oxd-input--focus' and @name='username']";
	private static final String txtPassword = "//input[@class='oxd-input oxd-input--focus' and @name='password']";
	private static final String btnLogin = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']";
	private static final String panel = "//a[@class='oxd-main-menu-item active']";

	@FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and @name='password']")
	WebElement clickPassword;
	
	@FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'])[1]")
	WebElement msjError_txtUsuario;

	@FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'])[2]")
	WebElement msjError_txtPassword;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	WebElement msjErrorCredenciales;

	private static final String clickMenu_Admin = "//a[@href='/web/index.php/admin/viewAdminModule']";
	
	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
	WebElement clickCombo;

	@FindBy(xpath = "//div[@data-v-957b4417]/input[@class='oxd-input oxd-input--active']")
	WebElement campoTexto;
	
	@FindBy(css = "button[type='submit']")
	WebElement btnSearch;

	@FindBy(css = "div[role='table']")
	WebElement listaUsuarios;

	@FindBy(css = "div.orangehrm-header-container > button[type='button']")
	WebElement btnAgregar;

	@FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[1]")
	WebElement cboUserRole;

	@FindBy(xpath = "//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']")
	WebElement clickEmployee_name;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement txtEmployee_name;

	@FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[2]")
	WebElement cboStatus;

	@FindBy(xpath = "(//input[@data-v-1f99f73c=''])[2]")
	WebElement txtUserName;

	@FindBy(xpath = "(//input[@type='password'])[1]")
	WebElement txtPassword_CreateUser;

	@FindBy(xpath = "(//input[@type='password'])[2]")
	WebElement txtConfirmPassword_CreateUser;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnSave;

	public void Login(String usurioLogin, String passwordLogin) throws InterruptedException {
		util.waitForPageLoad(getDriver());
		clickLogo.click();
		clickUsuario.click();
		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(txtUsuario)));
		elemento.sendKeys(usurioLogin);
		clickPassword.click();
		elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(txtPassword)));
		elemento.sendKeys(passwordLogin);
		Serenity.takeScreenshot();
	}

	public void clickBoton(){
		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		WebElement wbtnLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnLogin)));
		wbtnLogin.click();
		util.waitForPageLoad(getDriver());
	}

	public boolean validarIngreso() throws InterruptedException {
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement elemento = getDriver().findElement(By.xpath(panel));
		Serenity.takeScreenshot();
		return elemento.isDisplayed();
	}

	public HashMap<String, String> obtenerMsjComponentes() throws InterruptedException {
		HashMap<String, String> obtenerErrores = new HashMap<>();
		obtenerErrores.put("txtErrorUsuario", msjError_txtUsuario.getText());
		obtenerErrores.put("txtErrorPassword", msjError_txtPassword.getText());
		Thread.sleep(5000);
		return obtenerErrores;
	}

	public String obtenerMsjDatosIncorrectos() throws InterruptedException {
		System.out.println("mensaje rror: "+msjErrorCredenciales.getText());
		return msjErrorCredenciales.getText();
	}


	public void clickOpcionMenu(String menu) throws InterruptedException {
		switch (menu) {
			case "Admin":
				WebDriverWait wait = new WebDriverWait(getDriver(), 5);
				WebElement wclickMenu_Admin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickMenu_Admin)));
				wclickMenu_Admin.click();
				Thread.sleep(2000);
				Serenity.takeScreenshot();
				break;
			case "PIM":
				break;
			case "Leave":
				break;
			case "Time":
				break;

		}
	}

	public void clickComboRoles(String menu) throws InterruptedException, AWTException {
		Thread.sleep(5000);
		campoTexto.click();

		try {
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_TAB);
			seleccionarCBO(robot);
			btnSearch.click();
			Thread.sleep(2000);
			Serenity.takeScreenshot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public boolean listaUsuarios(){
		return listaUsuarios.isDisplayed();
	}

	public void btnAgregarUsuario() throws InterruptedException {
		btnAgregar.click();
		Thread.sleep(4000);
	}


	public void formularioData(List<DatosUsuarios> datosUsuarios) throws InterruptedException, AWTException {
		util.waitForPageLoad(getDriver());
		Robot robot = new Robot();
		List<DatosUsuarios> listaCopia = new ArrayList<>(datosUsuarios);
		for (int i = 0; i < datosUsuarios.size(); i++) {
				String rol=listaCopia.get(i).getUserRole();
				String status=listaCopia.get(i).getStatus();

			switch (rol) {
				case "Admin":
					cboUserRole.click();
					seleccionarCBO(robot);
					break;
			}
			clickEmployee_name.click();
			Thread.sleep(2000);
			txtEmployee_name.sendKeys(listaCopia.get(i).getEmployee_name());
			seleccionarCBO(robot);

			switch (status) {
				case "Enabled":
					cboStatus.click();
					seleccionarCBO(robot);
					break;
			}
			txtUserName.sendKeys(listaCopia.get(i).getUserName());
			txtPassword_CreateUser.sendKeys(listaCopia.get(i).getPassword());
			txtConfirmPassword_CreateUser.sendKeys(listaCopia.get(i).getConfirm_Password());
			Thread.sleep(5000);
		}
	}

	public void clickBotonGuardarDatos() throws InterruptedException {
		Serenity.takeScreenshot();
		btnSave.click();
		Thread.sleep(5000);
	}

	private static void seleccionarCBO(Robot robot) throws InterruptedException {
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}
}
