#Author: Carlos Sarmiento
#Feature para la busqueda de vuelos en Despegar.
@tag
Feature: Busqueda de vuelo en Avianca

  @CP001
  Scenario: Busqueda de vuelo Avianca
    Given Ingreso a pagina web
    When Ingresar destino fecha y cantidad de personas
    And Seleccionar tiquete y equipaje economico
    Then Validar tiquete comprado