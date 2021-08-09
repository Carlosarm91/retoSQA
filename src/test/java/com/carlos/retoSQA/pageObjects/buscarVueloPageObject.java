package com.carlos.retoSQA.pageObjects;

import javax.swing.JOptionPane;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.carlos.retoSQA.Utilidades.Leer_Excel;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.avianca.com")
public class buscarVueloPageObject extends PageObject {
	WebDriver driver;
	static int diferenciaMeses;
	String xpath_Desde = "//input[@class='form-control airport pbOrigen airport_ida airport_mvvn valid']";
	String xpath_Boton_IdaVuelta = "//a[contains(text(),'Ida y vuelta')]";
	String xpath_DesdeVacio = "//input[@class='form-control airport pbOrigen airport_ida airport_mvvn error']";
	String xpath_Desde_Clickeado = "//input[@class='form-control airport pbOrigen airport_ida airport_mvvn error focus-visible']";
	String xpath_SelectDesde = "//li[@class='item itemKeySelected']";
	String xpath_Hacia = "//input[@class='name_airport x-mvvm']";
	String xpath_Hacia_Clickeado =  "/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div[2]/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[1]/fieldset/div/div[2]/div[2]/div[1]/label/div/input[1]";
	String xpath_SelectHacia = "/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div[2]/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[1]/fieldset/div/div[2]/div[2]/div[2]/ul/li[1]";
	String xpath_FechasViaje = "/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div[2]/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[2]/fieldset/div/div/div[1]/label/div/div/input[1]";				
	String xpath_MesCalendario = "/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div[2]/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[2]/fieldset/div/div/div[2]/div/div[1]/div[";
	String xpath_BotonAvanzarCalendario = "/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div[2]/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[2]/fieldset/div/div/div[2]/div/div[1]/div[2]";
	String xpath_DiaCalendario = "/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div[2]/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[2]/fieldset/div/div/div[2]/div/div[1]/div[";
	String xpath_Pasajeros = "/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div[2]/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[3]/fieldset/div/div[1]/div[1]/label/div/input";
	String xpath_BotonPlus = "/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div[2]/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[3]/fieldset/div/div[1]/div[2]/div[";
	String xpath_BotonContinuarPasajeros = "/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div[2]/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[3]/fieldset/div/div[1]/div[2]/button[1]";
	String xpath_BotonBuscarVuelos = "/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div[2]/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[3]/fieldset/div/div[4]/button";
	String xpath_BotonSeleccionar = "/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/ul/li[1]/div[1]/div[1]/div/div/div/div[2]/div/div[2]/a";
	String xpath_RadioButtonEconomy = "/html/body/div[3]/div[2]/div[2]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/button[1]/div/label/span[1]";
	String xpath_BotonEquipajeL = "/html/body/div[3]/div[2]/div[2]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/button[3]";
	
	String dataExcel[] =  Leer_Excel.leerExcel();
	String ciudadOrigen = dataExcel[0];
	String ciudadDestino = dataExcel[1];
	String fechaVueloIda = dataExcel[2];
	String fechaVueloVuelta = dataExcel[3];
	String cantidadAdultos = dataExcel[4];
	String cantidadNinos = dataExcel[5];
	String cantidadBebes = dataExcel[6];
	
	public void ingresar_destino_fecha_y_cantidad_de_personas() {
		ingresarLugarOrigen(ciudadOrigen);
		ingresarLugarDestino(ciudadDestino);
		seleccionarFechaViaje(fechaVueloIda, fechaVueloVuelta);
		seleccionarCantidadPasajeros(cantidadAdultos, cantidadNinos, cantidadBebes);
	}
	
	public void ingresarLugarOrigen(String ciudadOrigen) {
		aceptarEmergente();
		find(By.xpath(xpath_Desde)).clear();
		find(By.xpath(xpath_Boton_IdaVuelta)).click();
		find(By.xpath(xpath_DesdeVacio)).sendKeys(ciudadOrigen);
		find(By.xpath(xpath_SelectDesde)).click();
	}
	
	public void ingresarLugarDestino(String ciudadDestino) {
		find(By.xpath(xpath_Hacia_Clickeado)).click();
		find(By.xpath(xpath_Hacia_Clickeado)).sendKeys(ciudadDestino);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		find(By.xpath(xpath_SelectHacia)).click();
	}
	
	public void seleccionarFechaViaje(String fechaVueloIda, String fechaVueloVuelta) {
		seleccionarFechaIda(fechaVueloIda);
		seleccionarFechaVuelta(fechaVueloVuelta);
	}
	
	public void seleccionarFechaIda(String fechaVueloVuelta) {
		String[] arrayFecha = fechaVueloVuelta.split("-"); //Obtengo el mes de la fecha en el feature
		find(By.xpath(xpath_FechasViaje)).click();
		String xpath_MesActual = xpath_MesCalendario + "3]";
		String strAtributoMes = find(By.xpath(xpath_MesActual)).getAttribute("data-month"); 
		String[] arrOfStr = strAtributoMes.split("\\."); //obtengo el mes de la fecha en pantalla
		diferenciaMeses = Integer.parseInt(arrayFecha[1]) - Integer.parseInt(arrOfStr[1]);
		avanzarCalendario(diferenciaMeses);
		boolean flag=true;
		int cont =0;
		while(flag) {
			cont++;
			String diaPantalla = find(By.xpath(xpath_DiaCalendario+(3+diferenciaMeses)+"]/div[3]/div["+cont+"]")).getAttribute("aria-label");
			if(diaPantalla!=null && Integer.parseInt(diaPantalla)==Integer.parseInt(arrayFecha[2])) {
				find(By.xpath(xpath_DiaCalendario+(3+diferenciaMeses)+"]/div[3]/div["+cont+"]")).click();
				flag=false;
			}
		}
	}
	
	public void seleccionarFechaVuelta(String fechaVueloVuelta) {
		String[] arrayFecha = fechaVueloVuelta.split("-"); //Obtengo el mes de la fecha en el feature
		find(By.xpath(xpath_FechasViaje)).click();
		String xpath_MesIda=xpath_MesCalendario + (3+diferenciaMeses) + "]";
		String strAtributoMes = find(By.xpath(xpath_MesIda)).getAttribute("data-month"); 
		String[] arrOfStr = strAtributoMes.split("\\."); //obtengo el mes de la fecha en pantalla
		int acumuladoDiferencias = diferenciaMeses;
		diferenciaMeses = Integer.parseInt(arrayFecha[1]) - Integer.parseInt(arrOfStr[1]);
		acumuladoDiferencias+=diferenciaMeses;
		avanzarCalendario(diferenciaMeses);
		boolean flag=true;
		int cont =0;
		while(flag) {
			cont++;
			String diaPantalla = find(By.xpath(xpath_DiaCalendario+(3+acumuladoDiferencias)+"]/div[3]/div["+cont+"]")).getAttribute("aria-label");
			if(diaPantalla!=null && Integer.parseInt(diaPantalla)==Integer.parseInt(arrayFecha[2])) {
				find(By.xpath(xpath_DiaCalendario+(3+acumuladoDiferencias)+"]/div[3]/div["+cont+"]")).click();
				flag=false;
			}
		}
	}
	
	public void seleccionarCantidadPasajeros(String cantidadAdultos, String cantidadNinos, String cantidadBebes) {
		find(By.xpath(xpath_Pasajeros)).click();
		pulsarBotonPlus("1", Integer.parseInt(cantidadAdultos)-1);
		pulsarBotonPlus("2", Integer.parseInt(cantidadNinos));
		pulsarBotonPlus("3", Integer.parseInt(cantidadBebes));
		find(By.xpath(xpath_BotonContinuarPasajeros)).click();
		JOptionPane.showMessageDialog(null, "Avianca detecta el robot en el siguiente paso", "Pop Up Advertencia", 1);
	}
	
	public void seleccionarTiqueteEconomico() {
		pulsarBotonBuscarVuelos();
		pulsarBotonSeleccionar();
		pulsarRadioButtonEconomy();
		pulsarBotonEquipajeL();
	}
	
	public void aceptarEmergente() {
		try {
			driver.wait(6000);
			driver.findElement(By.id("alertButton")).click();
			Alert simpleAlert = driver.switchTo().alert();
			simpleAlert.accept();
		}catch(Exception e) {
			System.out.println("No encontre Ventana Emergente");
		}
	}
	
	public void avanzarCalendario(int contador) {
		for(int i=0;i<contador;i++) {
			find(By.xpath(xpath_BotonAvanzarCalendario)).click();
			try {	
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void pulsarBotonPlus(String categoria, int cantidad) {
		String xpathCategorizado = xpath_BotonPlus+categoria+"]/div[2]/div[3]";
		for(int i = 0; i<cantidad; i++)
			find(By.xpath(xpathCategorizado)).click();
	}
	
	public void pulsarBotonBuscarVuelos() {
		find(By.xpath(xpath_BotonBuscarVuelos)).click();
	}
	
	public void pulsarBotonSeleccionar() {
		try {
			Thread.sleep(6000);
			find(By.xpath(xpath_BotonSeleccionar)).click();
			Alert simpleAlert = driver.switchTo().alert();
			simpleAlert.accept();
		}catch(Exception e) {
			System.out.println("No encontre Boton Seleccionar");
		}
	}
	
	public void pulsarRadioButtonEconomy() {
		find(By.xpath(xpath_RadioButtonEconomy)).click();
	}
	
	public void pulsarBotonEquipajeL() {
		find(By.xpath(xpath_BotonEquipajeL)).click();
	}
	
}
