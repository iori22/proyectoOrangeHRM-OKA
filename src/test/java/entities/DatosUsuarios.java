package entities;

public class DatosUsuarios {
	public String UserRole;
	public String Employee_name;
	public String Status;
	public String UserName;
	public String Password;
	public String Confirm_Password;

	public DatosUsuarios() {

	}

	public String getUserRole() {
		return UserRole;
	}

	public void setUserRole(String userRole) {
		UserRole = userRole;
	}

	public String getEmployee_name() {
		return Employee_name;
	}

	public void setEmployee_name(String employee_name) {
		Employee_name = employee_name;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getConfirm_Password() {
		return Confirm_Password;
	}

	public void setConfirm_Password(String confirm_Password) {
		Confirm_Password = confirm_Password;
	}

	public DatosUsuarios(String userRole, String employee_name, String status, String userName, String password, String confirm_Password) {
		UserRole = userRole;
		Employee_name = employee_name;
		Status = status;
		UserName = userName;
		Password = password;
		Confirm_Password = confirm_Password;
	}
}
