Feature: Visualizar las funcionalidades de la aplicacion ORANGE HRM
  Como Asesor de clientes.
  Quiero registrar y validar los campos al ingresar un nuevo usuario
  Para registrarlo en el sistema.

  Background: Iniciar sesion
  Given ingreso a la aplicacion

  @Login
  Scenario Outline: Validar el escenario - Login exitoso
    Given Inicie sesión con el usuario "<Usuario>" "<Password>"
    When  presiono en el boton Login
    Then  me mostrara el dashboard
    Examples:
      | Usuario   | Password |
      | Admin     | admin123 |


  @Login-CamposVacios
  Scenario Outline: Validar el escenario cuando no se ingresa ningun dato
    Given Inicie sesión con el usuario "<Usuario>" "<Password>"
    When  presiono en el boton Login
    Then  me mostrara el mensaje "Required" en los username y password
    Examples:
      | Usuario   | Password |
      |           |          |


  @Login-DatosIncorrectos
  Scenario Outline: Validar el escenario cuando los datos son incorrectos
    Given Inicie sesión con el usuario "<Usuario>" "<Password>"
    When  presiono en el boton Login
    Then  me mostrara el mensaje de error "Invalid credentials"
    Examples:
      | Usuario   | Password |
      | A         | ad       |



  @FiltrarUsuario
  Scenario Outline: Validar el escenario - filtrar por usuarios
    Given Inicie sesión con el usuario "<Usuario>" "<Password>"
    And presiono en el boton Login
    And presiono en el boton del menu "Admin"
    When selecciono el rol "Admin" y le doy en el boton buscar
    Then me mostrara la busqueda de los usuarios
    Examples:
      | Usuario   | Password |
      | Admin     | admin123 |


  @AgregarUsuario
  Scenario Outline: Validar el escenario - Agregar usuario
    Given Inicie sesión con el usuario "<Usuario>" "<Password>"
    And presiono en el boton Login
    And presiono en el boton del menu "Admin"
    And presiono en el boton agregar
    And ingreso los datos respectivos de las personas para registrarlo
      |UserRole | Employee_name|Status  |UserName     |Password       |Confirm_Password|
      | Admin   | Us           |Enabled |HappyTesting |HappyTesting123|HappyTesting123 |
    When presiono en guardar
    Then me mostrara el mensaje "Success" "Succesfully Saved"
    Examples:
      | Usuario   | Password |
      | Admin     | admin123 |