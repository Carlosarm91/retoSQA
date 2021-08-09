package com.carlos.retoSQA.definitions;

import com.carlos.retoSQA.steps.buscarVueloSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class buscarVueloDefinitions {
	
	@Steps
	buscarVueloSteps objStepsBuscarVuelo;
	
	@Given("^Ingreso a pagina web$")
	public void ingreso_a_pagina_web() throws Exception {
		objStepsBuscarVuelo.ingreso_a_Navegador();
	}

	@When("^Ingresar destino fecha y cantidad de personas$")
	public void ingresar_destino_fecha_y_cantidad_de_personas() throws Exception {
		objStepsBuscarVuelo.ingresar_destino_fecha_y_cantidad_de_personas();
	}
	@When("^Seleccionar tiquete y equipaje economico$")
	public void seleccionar_tiquete_y_equipaje_economico() throws Exception {
		objStepsBuscarVuelo.SeleccionarTiqueteEconomico();
	}
	
	@Then("^Validar tiquete comprado$")
	public void validar_tiquete_comprado() throws Exception {
		
	}
}
