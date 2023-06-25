package com.sueldos.liquidacion.controller;

import java.util.Date;

public record DatosColaborador(
		String nombre,
		String apellido,
		String dni,
		Date nacimiento,
		Integer edad,
		String direccion,
		String convenio) {

}
