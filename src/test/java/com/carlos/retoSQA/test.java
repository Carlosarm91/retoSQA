package com.carlos.retoSQA;

import com.carlos.retoSQA.Utilidades.Leer_Excel;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));
		String dataExcel[] =  Leer_Excel.leerExcel();
		System.out.println(dataExcel[0]);
		System.out.println(dataExcel[1]);
		System.out.println(dataExcel[2]);
		System.out.println(dataExcel[3]);
		System.out.println(dataExcel[4]);
		System.out.println(dataExcel[5]);
		System.out.println(dataExcel[6]);
	}

}
