package pl.skapustka.excel;

import java.io.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileHelper {

	public static File simpleUpload(MultipartFile file, HttpServletRequest request, String upload_folder) {
		String filename = null;
		File serverFile = null;
		try {
			if (!file.isEmpty()) {
				String applicationPath = request.getServletContext().getRealPath("");
				filename = file.getOriginalFilename();

				byte[] bytes = file.getBytes();
				String rootPath = applicationPath;
				File dir = new File(rootPath + File.separator + upload_folder);

				if (!dir.exists())
					dir.mkdirs();
				serverFile = new File(dir.getAbsolutePath() + File.separator + filename);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				return serverFile;
			} else {
				serverFile = null;
			}
		} catch (Exception e) {
			serverFile = null;
		}
		return serverFile;
	}
}
