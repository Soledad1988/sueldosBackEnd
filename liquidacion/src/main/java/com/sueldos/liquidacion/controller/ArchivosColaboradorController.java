package com.sueldos.liquidacion.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import com.sueldos.liquidacion.model.Colaborador;
import com.sueldos.liquidacion.service.ColaboradorService;

import java.text.SimpleDateFormat;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ArchivosColaboradorController {
 
	 @Autowired
	    private ColaboradorService colaboradorService;
	

	    @GetMapping("/excel/{id}")
	    public ResponseEntity<byte[]> generarExcelColaborador(@PathVariable Integer id) {
	        Colaborador colaborador = colaboradorService.buscar(id);
	        if (colaborador == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }

	        try {
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            Workbook workbook = new XSSFWorkbook();
	            Sheet sheet = workbook.createSheet("Colaborador");

	            Row headerRow = sheet.createRow(0);
	            headerRow.createCell(0).setCellValue("ID");
	            headerRow.createCell(1).setCellValue("Nombre");
	            headerRow.createCell(2).setCellValue("Apellido");
	            // Agrega más columnas según los datos que quieras incluir en el Excel

	            Row dataRow = sheet.createRow(1);
	            dataRow.createCell(0).setCellValue(colaborador.getId());
	            dataRow.createCell(1).setCellValue(colaborador.getNombre());
	            dataRow.createCell(2).setCellValue(colaborador.getApellido());
	            // Agrega más celdas según los datos que quieras incluir en el Excel

	            workbook.write(outputStream);
	            workbook.close();

	            byte[] bytes = outputStream.toByteArray();
	            HttpHeaders headers = new HttpHeaders();
	            headers.add("Content-Disposition", "attachment; filename=colaborador.xlsx");

	            return ResponseEntity
	                    .ok()
	                    .headers(headers)
	                    .body(bytes);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    
	    @GetMapping("generar/excel")
	    public ResponseEntity<byte[]> generarExcelTodosColaboradores() {
	        List<Colaborador> colaboradores = colaboradorService.listar();
	        if (colaboradores.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }

	        try {
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            Workbook workbook = new XSSFWorkbook();
	            Sheet sheet = workbook.createSheet("Colaboradores");

	            Row headerRow = sheet.createRow(0);
	            headerRow.createCell(0).setCellValue("ID");
	            headerRow.createCell(1).setCellValue("Nombre");
	            headerRow.createCell(2).setCellValue("Apellido");
	            headerRow.createCell(3).setCellValue("CUIT");
	            headerRow.createCell(4).setCellValue("Fecha Ingreso");
	            headerRow.createCell(5).setCellValue("Convenio");
	            headerRow.createCell(6).setCellValue("Categoria");
	            headerRow.createCell(7).setCellValue("Obra Social");
	            // Agrega más columnas según los datos que quieras incluir en el Excel

	            int rowNum = 1;
	            for (Colaborador colaborador : colaboradores) {
	                Row dataRow = sheet.createRow(rowNum++);
	                dataRow.createCell(0).setCellValue(colaborador.getId());
	                dataRow.createCell(1).setCellValue(colaborador.getNombre());
	                dataRow.createCell(2).setCellValue(colaborador.getApellido());
	                dataRow.createCell(3).setCellValue(colaborador.getCuit());
	                // Formatear la fecha de ingreso
	                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	                String fechaIngresoFormatted = dateFormat.format(colaborador.getFecha_ingreso());
	                dataRow.createCell(4).setCellValue(fechaIngresoFormatted);
	                dataRow.createCell(5).setCellValue(colaborador.getCategoria().getConvenio().getNombre());
	                dataRow.createCell(6).setCellValue(colaborador.getCategoria().getNombre()); // Suponiendo que el nombre de la categoría se llama "nombre"
	                dataRow.createCell(7).setCellValue(colaborador.getObraSocial().getNombre());
	                // Agrega más celdas según los datos que quieras incluir en el Excel
	            }

	            workbook.write(outputStream);
	            workbook.close();

	            byte[] bytes = outputStream.toByteArray();
	            HttpHeaders headers = new HttpHeaders();
	            headers.add("Content-Disposition", "attachment; filename=colaboradores.xlsx");

	            return ResponseEntity
	                    .ok()
	                    .headers(headers)
	                    .body(bytes);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    
	    @GetMapping("generar/pdf")
	    public ResponseEntity<byte[]> generarPdfTodosColaboradores() throws IOException {
	        List<Colaborador> colaboradores = colaboradorService.listar();
	        if (colaboradores.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }

	        try {
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            Document document = new Document();
	            PdfWriter.getInstance(document, outputStream);
	            document.open();

	            for (Colaborador colaborador : colaboradores) {
	                document.add(new Paragraph("ID: " + colaborador.getId()));
	                document.add(new Paragraph("Nombre: " + colaborador.getNombre()));
	                document.add(new Paragraph("Apellido: " + colaborador.getApellido()));
	                document.add(new Paragraph("CUIT: " + colaborador.getApellido()));
	                document.add(new Paragraph("Fecha de Ingreso: " + colaborador.getFecha_ingreso()));
	                document.add(new Paragraph("Convenio: " + colaborador.getCategoria().getConvenio().getNombre()));
	                document.add(new Paragraph("Categoria: " + colaborador.getCategoria().getNombre()));
	                document.add(new Paragraph("Obra Social: " + colaborador.getObraSocial().getNombre()));
	                // Agrega más líneas según los datos que quieras incluir en el PDF
	                document.add(new Paragraph("\n"));
	            }

	            document.close();

	            byte[] bytes = outputStream.toByteArray();
	            HttpHeaders headers = new HttpHeaders();
	            headers.add("Content-Disposition", "attachment; filename=colaboradores.pdf");

	            return ResponseEntity
	                    .ok()
	                    .headers(headers)
	                    .body(bytes);
	        } catch (DocumentException e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    

}
