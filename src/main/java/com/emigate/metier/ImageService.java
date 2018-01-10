package com.emigate.metier;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.emigate.Repository.ImageRepo;
import com.emigate.entite.Image;

@Service   
@Transactional
public class ImageService  implements IImageService{
	
	
	private final Path rootLocation = Paths.get("photosProfils");

	@Autowired
	ImageRepo ir;
	
	public ResourceLoader resourceLoader;

	@Override
	public void enrigestrer(MultipartFile file, String nom) throws IOException {

		String[] imgFormats = { "jpg", "png", "jpeg" };
		String[] partie = file.getOriginalFilename().split("\\.");
		String format = partie[1];

		if (Arrays.asList(imgFormats).contains(format)) {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(nom + "." + format));
			ir.save(new Image(nom + "." + format));
		} else
			throw new RuntimeException(" Vérifier le format de votre image ");

	}
	
	@Override
	public Image getUserImage() {
		Image image =  ir.findAll().get(0);
		if(image==null) return null;
		else
		return image;

	}
	
	public void deleteImage(String nom) {
		try {
			Image image = getUserImage();
			Files.deleteIfExists(this.rootLocation.resolve(image.getNom()));

			ir.delete(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Resource telecharger(String nom) {
		try {
			Path file = rootLocation.resolve(nom);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException(" votre fichier inéxistant");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("votre fichier inéxistant");
		}
	}


}
