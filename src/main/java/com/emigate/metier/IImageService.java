package com.emigate.metier;

import java.io.IOException;
 
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.emigate.entite.Image;


public interface IImageService {
	
	
	void enrigestrer(MultipartFile file, String nom) throws IOException;
	
	public Image getUserImage();
	
	public void deleteImage(String nom);

	Resource telecharger(String nom);


}
