package clase16.parser.impl;

import clase16.parser.FileBase;
import clase16.parser.IParser;
import clase16.type.PDF;

public class PDFFileParser extends FileBase implements IParser<PDF> {

	public PDFFileParser(String fileString) {
		super(fileString);
	}

	@Override
	public PDF parse() {
		// TODO Auto-generated method stub
		return null;
	}

}
