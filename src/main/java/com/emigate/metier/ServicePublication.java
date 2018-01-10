package com.emigate.metier;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.emigate.Repository.PublicationRepository;
import com.emigate.entite.Publication;

	@Service
	@Transactional
	@Primary
	public class ServicePublication implements IPublication {

		private final Path rootLocation = Paths.get("publication");
		@Autowired
		private com.emigate.Repository.PublicationRepo publicationRepo;

		@Autowired
		PublicationRepository pr;
		
		public List<Publication> findAll() {
			return publicationRepo.findAll();
		}

		public List<Publication> findLatest5() {
			return null;
		}

		public Publication findById(Long id) {
			return publicationRepo.getOne(id);
		}

		public Publication create(Publication Publication) {
			return publicationRepo.save(Publication);
		}

		public Publication edit(Publication Publication) {
			return publicationRepo.save(Publication);
		}

		public void deleteById(Long id) {
			publicationRepo.deleteById(id);
		}

		public void enregistrer(MultipartFile file, String nom) {
			String[] imgFormats = { "jpg", "png", "jpeg", "PNG" };
			String[] partie = file.getOriginalFilename().split("\\.");
			String format = partie[1];

			if (Arrays.asList(imgFormats).contains(format)) {
				try {
					Files.copy(file.getInputStream(), this.rootLocation.resolve(nom));
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else
				throw new RuntimeException(" Vérifier le format de votre image ");
		}

		public Resource telecharger(String nom) {
			try {
				Path file = rootLocation.resolve(nom);
				Resource resource = new UrlResource(file.toUri());
				if (resource.exists() || resource.isReadable()) {
					return resource;
				} else {
					throw new RuntimeException(" votre fichier inexistant");
				}
			} catch (MalformedURLException e) {
				throw new RuntimeException("votre fichier inexistant");
			}
		}

		@Override
		public List<Publication> getPublicationsByUserId(Long id) {
			// TODO Auto-generated method stub
			return publicationRepo.TrouverPublicationbyByCvId(id);
		}
		
		@Override
		public List<Publication> searchPublication(String rech) {
			
		return pr.chercherPublication(rech);
		}
		@Override
		public List<Publication> searchTitle(String rech) {
			
		return pr.chercherTitle(rech);
		}
		@Override
		public List<Publication> searchBody(String rech) {
			
		return pr.chercherBody(rech);
		}
}
