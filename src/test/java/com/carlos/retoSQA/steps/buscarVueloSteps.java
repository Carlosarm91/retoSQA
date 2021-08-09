package com.carlos.retoSQA.steps;

import com.carlos.retoSQA.pageObjects.buscarVueloPageObject;

import net.thucydides.core.annotations.Step;

public class buscarVueloSteps {
	
	buscarVueloPageObject objPageObjectBuscarVuelo;

	@Step
	public void ingreso_a_Navegador() throws Exception {
		objPageObjectBuscarVuelo.open();
	}
	
	@Step
	public void ingresar_destino_fecha_y_cantidad_de_personas() {
		objPageObjectBuscarVuelo.ingresar_destino_fecha_y_cantidad_de_personas();
	}
	
	@Step
	public void SeleccionarTiqueteEconomico() {
		objPageObjectBuscarVuelo.seleccionarTiqueteEconomico();
	}
	
}
