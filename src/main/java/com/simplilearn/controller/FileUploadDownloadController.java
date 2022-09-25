package com.simplilearn.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadDownloadController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		File newFile = new File("C:\\temp\\" + file.getOriginalFilename());
		newFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(newFile);
		fos.write(file.getBytes());
		fos.close();
		return "File uploaded successfully";
	}
	

	@RequestMapping(value="/download", method=RequestMethod.GET)
	public ResponseEntity<Object> downloadFile(@RequestParam() String fileName) throws FileNotFoundException {
		File file = new File("C:\\temp\\"+fileName);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename="+fileName);
		ResponseEntity<Object> 	responseEntity = ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType("application/txt")).body(resource);
		return responseEntity;
	}
	
}
