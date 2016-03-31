package pl.skapustka.excel;

import org.springframework.web.multipart.*;

public class ExcelFile {
	
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
