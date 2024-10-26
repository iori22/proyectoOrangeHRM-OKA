package OrangeHRM.steps;

import OrangeHRM.pageobject.LoginOrangeHRM;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entities.DatosUsuarios;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class LoginStepDefinition {
    LoginOrangeHRM loginOrangeHRM;

    @Given("^ingreso a la aplicacion$")
    public void ingresoalaaplicacion() {
        loginOrangeHRM.open();
    }

    @Given("^Inicie sesión con el usuario \"([^\"]*)\" \"([^\"]*)\"$")
    public void inicieSesiónConElUsuario(String usuario, String password) throws InterruptedException {
        loginOrangeHRM.Login(usuario,password);
    }

    @When("^presiono en el boton Login$")
    public void presionoEnElBotonLogin() {
        loginOrangeHRM.clickBoton();
    }

    @Then("^me mostrara el dashboard$")
    public void meMostraraElDashboard() throws InterruptedException {
        assertTrue("Exitoso - Se visualiza el dashboard", loginOrangeHRM.validarIngreso());
    }

    @Then("^me mostrara el mensaje \"([^\"]*)\" en los username y password$")
    public void meMostraraElMensajeEnLosUsernameYPassword(String mensajeError) throws Throwable {
        HashMap<String, String> obtenerErrores = new HashMap<>();
        obtenerErrores = loginOrangeHRM.obtenerMsjComponentes();
        assertEquals("Exitoso - El mensaje de error del campo Usuario se visualiza",mensajeError,obtenerErrores.get("txtErrorUsuario"));
        assertEquals("Exitoso - El mensaje de error del campo Password se visualiza",mensajeError,obtenerErrores.get("txtErrorPassword"));
    }

    @Then("^me mostrara el mensaje de error \"([^\"]*)\"$")
    public void meMostraraElMensajeDeError(String mensajeDatosErrornes) throws Throwable {
        assertEquals("Exitoso - El mensaje de error del campo Password se visualiza",mensajeDatosErrornes, loginOrangeHRM.obtenerMsjDatosIncorrectos());
    }

    @And("^presiono en el boton del menu \"([^\"]*)\"$")
    public void presionoEnElBotonAdmin(String opcionMenu) throws InterruptedException {
        loginOrangeHRM.clickOpcionMenu(opcionMenu);
    }

    @And("^selecciono el rol \"([^\"]*)\" y le doy en el boton buscar$")
    public void seleccionoElRol(String rolUsuario) throws Throwable {
        loginOrangeHRM.clickComboRoles(rolUsuario);
    }

    @Then("^me mostrara la busqueda de los usuarios$")
    public void meMostraraLaBusquedaDeLosUsuarios() {
        assertTrue("Exitoso - Se visualiza la lista filtrada", loginOrangeHRM.listaUsuarios());
    }

    @And("^presiono en el boton agregar$")
    public void presionoEnElBotonAgregar() throws InterruptedException {
        loginOrangeHRM.btnAgregarUsuario();
    }

    @When("^ingreso los datos respectivos de las personas para registrarlo$")
    public void ingresoLosDatosRespectivosDeLasPersonasParaRegistrarlo(DataTable dataTable) throws InterruptedException, AWTException {
        List<DatosUsuarios> listaUsuarios = new ArrayList<DatosUsuarios>();

        for (Map<String, String> data : dataTable.asMaps(String.class, String.class)) {
            DatosUsuarios objDatosUsuario=new DatosUsuarios();
            objDatosUsuario.setUserRole(data.get("UserRole").toString());
            objDatosUsuario.setEmployee_name(data.get("Employee_name").toString());
            objDatosUsuario.setStatus(data.get("Status").toString());
            objDatosUsuario.setUserName(data.get("UserName").toString());
            objDatosUsuario.setPassword(data.get("Password").toString());
            objDatosUsuario.setConfirm_Password(data.get("Confirm_Password").toString());
            listaUsuarios.add(objDatosUsuario);
        }
        loginOrangeHRM.formularioData(listaUsuarios);
    }

    @When("^presiono en guardar$")
    public void presionoEnGuardar() throws InterruptedException {
        loginOrangeHRM.clickBotonGuardarDatos();
    }

    @Then("^me mostrara el mensaje \"([^\"]*)\" \"([^\"]*)\"$")
    public void meMostraraElMensaje(String mensajeTitulo, String mensajeSubTitulo) throws Throwable {

    }
}
