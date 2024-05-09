package com.sueldos.liquidacion.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.sueldos.liquidacion.model.Colaborador;
import com.sueldos.liquidacion.model.Novedad;
import com.sueldos.liquidacion.service.NovedadService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ArchivosNovedadController {
	 
	 @Autowired
	    private NovedadService novedadService;

	  
	 @GetMapping("novedad/excel")
	 public ResponseEntity<byte[]> exportToExcel(@RequestParam int month, @RequestParam int year) {
	     LocalDate startDate = LocalDate.of(year, month, 1);
	     LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth()); // Último día del mes
	     List<Novedad> novedades = novedadService.listarPorPeriodo(startDate, endDate);

	     // Crear un nuevo libro de trabajo Excel
	     try (Workbook workbook = new XSSFWorkbook()) {
	         Sheet sheet = workbook.createSheet("Novedades");

	         // Crear la fila de encabezado
	         Row headerRow = sheet.createRow(0);
	         String[] headers = {"Legajo", "Nombre y Apellido", "CUIT", "Periodo", "Vacaciones", "Feriado", "Inasistencia Justificada", "Inasistencia Injustificada"};
	         for (int i = 0; i < headers.length; i++) {
	             Cell cell = headerRow.createCell(i);
	             cell.setCellValue(headers[i]);
	         }

	         // Llenar el contenido de las novedades junto con los datos de los colaboradores
	         int rowNum = 1;
	         for (Novedad novedad : novedades) {
	             Row row = sheet.createRow(rowNum++);
	             Colaborador colaborador = novedad.getColaborador(); // Obtener el colaborador asociado a la novedad
	             row.createCell(0).setCellValue(novedad.getIdNovedad());
	             row.createCell(1).setCellValue(colaborador.getNombre() + " " + colaborador.getApellido()); // Nombre completo del colaborador
	             row.createCell(2).setCellValue(colaborador.getCuit());
	             row.createCell(3).setCellValue(novedad.getPeriodo().toString());
	             row.createCell(4).setCellValue(novedad.getVacaciones());
	             row.createCell(5).setCellValue(novedad.getFeriado());
	             row.createCell(6).setCellValue(novedad.getInasistenciaJustificada());
	             row.createCell(7).setCellValue(novedad.getInasistenciaInjustificada());
	         }

	         // Escribir el libro de trabajo en un flujo de bytes
	         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	         workbook.write(outputStream);
	         byte[] bytes = outputStream.toByteArray();

	         // Configurar las cabeceras de la respuesta
	         HttpHeaders headers1 = new HttpHeaders();
	         headers1.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=novedades.xlsx");

	         return new ResponseEntity<>(bytes, headers1, HttpStatus.OK);
	     } catch (IOException e) {
	         e.printStackTrace();
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	     }
	 }
	 
	 
	 @GetMapping("/novedad/pdf")
	 public ResponseEntity<byte[]> exportToPDF(@RequestParam int month, @RequestParam int year) {
	     // Verificar si los parámetros son válidos
	     if (month < 1 || month > 12 || year < 0) {
	         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	     }

	     LocalDate startDate = LocalDate.of(year, month, 1);
	     LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth()); // Último día del mes
	     List<Novedad> novedades = novedadService.listarPorPeriodo(startDate, endDate);

	     ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	     Document document = new Document(PageSize.A4.rotate()); // Cambiar orientación a horizontal

	     try {
	         PdfWriter.getInstance(document, outputStream);
	         document.open();

	         document.add(new Paragraph("Reporte de Novedades - " + startDate.format(DateTimeFormatter.ofPattern("MM/yyyy"))));
	         document.add(new Paragraph("\n"));
	         // document.add(new Paragraph("Reporte de Novedades - " + startDate.format(DateTimeFormatter.ofPattern("MM/yyyy")) + " - " + endDate.format(DateTimeFormatter.ofPattern("MM/yyyy"))));
	         
	      // Crear una tabla para los datos de las novedades
	         PdfPTable table = new PdfPTable(7); // 5 columnas
	         table.setWidthPercentage(100);

	         // Agregar encabezados de columna
	         table.addCell("Legajo");
	         table.addCell("Apellido y Nombre");
	         table.addCell("CUIT");
	         table.addCell("Vacaciones");
	         table.addCell("Feriado");
	         table.addCell("Inasistencias Justificadas");
	         table.addCell("Inasistencias Injustificadas");

	         // Agregar datos de las novedades a la tabla

	         for (Novedad novedad : novedades) {
	        	 Colaborador colaborador = novedad.getColaborador();
	        	 table.addCell(String.valueOf(novedad.getIdNovedad()));
	             table.addCell(colaborador.getApellido() + " " + colaborador.getNombre());
	             table.addCell(colaborador.getCuit());
	             table.addCell(String.valueOf(novedad.getVacaciones())); // Convertir a String
	             table.addCell(String.valueOf(novedad.getFeriado()));
	             table.addCell(String.valueOf(novedad.getInasistenciaJustificada()));
	             table.addCell(String.valueOf(novedad.getInasistenciaInjustificada()));
	         }

	         document.add(table); // Agregar la tabla al documento

	         document.close();

	         HttpHeaders headers = new HttpHeaders();
	         headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=novedades.pdf");

	         return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
	     } catch (DocumentException e) {
	         e.printStackTrace();
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	     }
	 }


}
