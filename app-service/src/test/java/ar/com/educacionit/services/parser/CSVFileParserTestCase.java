package ar.com.educacionit.services.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import ar.com.educacionit.services.exceptions.ParseException;


public class CSVFileParserTestCase {
	
	@Test
	public void when_nullfilename_then_throw_exception() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CSVFileParser(null);
		});
	}
	
	@Test
	public void when_blackfilename_then_throw_exception() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CSVFileParser("").parse();
		});
	}
	
	@Test
	public void when_file_doesnot_exist_then() {
		assertThrows(ParseException.class, () -> {
			new CSVFileParser("c:/bla/bla").parse();
		});
	}
	//Exista la isntancia cuando no sea vacio o nulo
	@Test
	public void when_create_doesnt_exist() {
		CSVFileParser csv = new CSVFileParser("a");
		assertNotNull(csv);
	}
	@Test
	public void when_filesexist_then_verify_size() throws ParseException {
		CSVFileParser csv = new CSVFileParser("F:Cursos de programacion/text.csv");
		Collection<Producto> list = csv.parse();
		assertEquals(2, list.size());
	}
}
