package ar.com.educacionit.services.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ar.com.educacionit.services.exceptions.ParseException;

public class XLSFileParser extends BaseFile implements IParser<Collection<Producto>> {

	public XLSFileParser(String filePath) {
		super(filePath);
	}

	@Override
	public Collection<Producto> parse() throws ParseException {
		Collection<Producto> list = new ArrayList<>();
		// Workbook hoja entera

		// SHEET row una fila de una hooja

		// Row hoja dentro de una hoja mayor

		// Cell celdas

		File file = super.getFile();
		try (InputStream is = new FileInputStream(file); Workbook workbook = new XSSFWorkbook(is)) {
			// Pido primer hoja
			Sheet sheet1 = workbook.getSheetAt(0); // pedimos la primer hoja de forma fija
			// recorro la filas de cada hoja
			Iterator<Row> itRows = sheet1.iterator();

			boolean isFirstRow = true;
			while (itRows.hasNext()) {
				// row es binario
				Row row = itRows.next();
				if (isFirstRow) {
					isFirstRow = false;
					continue;
				}

				Iterator<Cell> itCells = row.cellIterator();
				while (itCells.hasNext()) {
					Producto p = productoFromCell(itCells);
					list.add(p);
				}

			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw new ParseException("no se ha podido convertir el archivo: " + file.getPath(), e);
		}

	}

	private Producto productoFromCell(Iterator<Cell> itCells) {
		Producto p = new Producto();
		
		Cell cell = itCells.next();
		
		switch (cell.getColumnIndex()) {
			case 0: //id
				p.setId((long)cell.getNumericCellValue());
				break;
			case 1: //nombre
				p.setTitulo(cell.getStringCellValue());
				break;
			case 2: //codigo
				p.setCodigo(""+cell.getNumericCellValue());
				break;
			case 3: //precio
				p.setPrecio(cell.getNumericCellValue());
				break;
			default:
				break;
			}
		return p;
	}
	

}
