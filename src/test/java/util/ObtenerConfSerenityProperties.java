package util;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class ObtenerConfSerenityProperties {
	
	EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
	
	public String recuperarVariablesSerenity(String STipoVariable) {
		String SValorVariable = EnvironmentSpecificConfiguration.from(variables).getProperty(STipoVariable);		
		return SValorVariable;	
	}}
