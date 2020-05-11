package com.uniovi.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class GetFilesInternet {
	private final TestUtil testUtil;

	public GetFilesInternet(TestUtil testUtil) {
		this.testUtil = testUtil;
	}

	private static void getFile(String url, String nameFile) {
		try (BufferedInputStream inputStream = new BufferedInputStream(
				new URL(url).openStream());
				FileOutputStream fileOS = new FileOutputStream(nameFile)) {
			byte data[] = new byte[1024];
			int byteContent;
			while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
				fileOS.write(data, 0, byteContent);
			}
		} catch (IOException e) {
			System.err.println("Error al descargar el fichero " + nameFile);
		}
	}

	public static void delete(String url) {
		File file = new File(url);
		file.delete();
	}

	public void insertImgToFile(String url, String nameFile) {
		GetFilesInternet.getFile(url, nameFile);
		String cwd = new File("").getAbsolutePath();
		testUtil.selectFile(cwd + "\\" + nameFile);
	}
}
