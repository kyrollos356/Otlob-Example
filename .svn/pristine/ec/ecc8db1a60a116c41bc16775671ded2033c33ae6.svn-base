package com.poet.ordering.system.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

import javax.servlet.http.Part;

public class ImageUtility {

	public void uploadImage(User user, Part filePart) throws IOException {
		InputStream file = new FileInputStream(new File("D:\\OrderiingSystem\\imagepath.properties"));
		Properties props = new Properties();
		props.load(file);

		String Directory = props.getProperty("Directory");

		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		if (!fileName.isEmpty()) {

			user.setPicture(props.getProperty("serverPath") + fileName);
			try {
				filePart.write(Directory + fileName);

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public static String getServerPath() {
		InputStream file;
		Properties props = new Properties();
		try {
			file = new FileInputStream(new File("D:\\OrderiingSystem\\imagepath.properties"));

			props.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return props.getProperty("serverPath");
	}

}
