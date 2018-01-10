package com.emigate.controller;

import java.io.IOException;

import java.nio.file.FileAlreadyExistsException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.emigate.Repository.UserRoleRepository;
import com.emigate.Repository.UsersRepository;
import com.emigate.Repository.UtilisateurRepository;
import com.emigate.entite.CV;
import com.emigate.entite.Competence;
import com.emigate.entite.Education;
import com.emigate.entite.ExperiencePro;
import com.emigate.entite.Friendrequest;
import com.emigate.entite.Image;
import com.emigate.entite.Langue;
import com.emigate.entite.Notifications;
import com.emigate.entite.Publication;
import com.emigate.entite.Users;
import com.emigate.entite.Utilisateur;
import com.emigate.entite.users_role;
import com.emigate.metier.ICV;
import com.emigate.metier.ICompetence;
import com.emigate.metier.IExperiencePro;
import com.emigate.metier.IFriendRequest;
import com.emigate.metier.IImageService;
import com.emigate.metier.ILangue;
import com.emigate.metier.INotification;
import com.emigate.metier.IPublication;
import com.emigate.metier.IUserRole;
import com.emigate.metier.IUtilisateur;
import com.emigate.metier.MetierEducation;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
public class CvController 
 {

	@Autowired
	IPublication ps;

	@Autowired
	INotification in;

	@Autowired
	IFriendRequest ifr;

	@Autowired
	ICV icv;

	@Autowired
	IUserRole urr;

	@Autowired
	IUtilisateur iu;

	@Autowired
	ICompetence mc;

	@Autowired
	IExperiencePro mep;

	@Autowired
	MetierEducation me;

	@Autowired
	ILangue ml;

	@Autowired
	UsersRepository cr;

	@Autowired
	UtilisateurRepository ur;

	@Autowired
	IImageService is;

	Authentication auth;
	String name;
	Utilisateur utilisateur;
	CV cv;

 	
	@RequestMapping("/cvcv")
	public String cvInedex(Model model) {

		auth = SecurityContextHolder.getContext().getAuthentication();
		name = auth.getName();
		utilisateur = ur.TrouverUserParEmail(name);

		System.out.println(utilisateur.getEmail());
		model.addAttribute("username", name);
		model.addAttribute("idconn", utilisateur.getId());
		model.addAttribute("utilisateur", utilisateur);
		model.addAttribute("experiences", mep.getExpById(utilisateur.getId()));
		model.addAttribute("educations", me.getEducationById(utilisateur.getId()));
		model.addAttribute("competences", mc.TrouverCompetenceById(utilisateur.getId()));
		model.addAttribute("langues", ml.getLangueByCvId(utilisateur.getId()));
		model.addAttribute("notifications", in.getNotificationsByUserId(utilisateur.getId()));

		model.addAttribute("image", MvcUriComponentsBuilder
				.fromMethodName(CvController.class, "getFile", utilisateur.getImage()).build().toString());

		return "cv";
	}

	@RequestMapping("/cv")
	public String cv(Model model) {

		auth = SecurityContextHolder.getContext().getAuthentication();
		name = auth.getName();
		utilisateur = ur.TrouverUserParEmail(name);

		model.addAttribute("username", name);
		model.addAttribute("utilisateur", utilisateur);
		model.addAttribute("idconn", utilisateur.getId());

		model.addAttribute("experiences", mep.getExpById(utilisateur.getId()));
		model.addAttribute("educations", me.getEducationById(utilisateur.getId()));
		model.addAttribute("competences", mc.TrouverCompetenceById(utilisateur.getId()));
		model.addAttribute("langues", ml.getLangueByCvId(utilisateur.getId()));
		model.addAttribute("notifications", in.getNotificationsByUserId(utilisateur.getId()));

		System.out.println("----ccvv------");

		for (Notifications no : in.getNotificationsByUserId(utilisateur.getId())) {
			System.out.println(no.getDescription());
		}

		model.addAttribute("image", MvcUriComponentsBuilder
				.fromMethodName(CvController.class, "getFile", utilisateur.getImage()).build().toString());

		return "cv";
	}

	@RequestMapping("/cv/{id}")
	public String ConsulterUnCv(@org.springframework.web.bind.annotation.PathVariable String id, Model model) {

		auth = SecurityContextHolder.getContext().getAuthentication();
		name = auth.getName();
		utilisateur = ur.TrouverUserParEmail(name);
		Long i = new Long(Integer.parseInt(id));
		// if((ifr.EstAmi(utilisateur.getId(), i)) ||
		// i.equals(utilisateur.getId())){

		boolean attenteamis = ifr.EstAttenteAmi(utilisateur.getId(), i);
		boolean amis = ifr.EstAmi(utilisateur.getId(), i);

		model.addAttribute("username", ur.getOne(i).getNom());
		model.addAttribute("estamis", amis);
		model.addAttribute("estattenteamis", attenteamis);
		model.addAttribute("idconn", utilisateur.getId());
		model.addAttribute("utilisateur", ur.getOne(i));
		model.addAttribute("experiences", mep.getExpById(i));
		model.addAttribute("educations", me.getEducationById(i));
		model.addAttribute("competences", mc.TrouverCompetenceById(i));
		model.addAttribute("langues", ml.getLangueByCvId(i));

		model.addAttribute("image", MvcUriComponentsBuilder
				.fromMethodName(CvController.class, "getFile", ur.getOne(i).getImage()).build().toString());
		return "cv";
		// }
		// return "redirect:/publication";
	}
	
	@RequestMapping(value="/search")
	public String doH(){
		return "redirect:/";
	}

	@RequestMapping(value = "/ajouterExp", method = RequestMethod.POST)
	public String ajouterExp(String fonction, Date dd, Date df, String description, Model model) {
		CV cv = icv.trouverById(utilisateur.getId());
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dd1 = formatter.format(dd);
		String df1 = formatter.format(df);

		in.EnvoyerNotification(utilisateur.getNom() + " a ajouté une expérience", ifr.getAmis(utilisateur.getId()));

		ExperiencePro ep = new ExperiencePro(fonction, dd1, df1, description, cv);
		mep.AjouterExperiencePro(ep);
		return "redirect:/cv";
	}

	@RequestMapping(value = "/ajouterEducation", method = RequestMethod.POST)
	public String ajouterEducation(String ecole, Date dd, Date df, String description, Model model) {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		CV cv = icv.trouverById(utilisateur.getId());
		String dd1 = formatter.format(dd);
		String df1 = formatter.format(df);
		in.EnvoyerNotification(utilisateur.getNom() + " a ajouté une formation", ifr.getAmis(utilisateur.getId()));
		Education e = new Education(ecole, dd1, df1, description, cv);
		me.AjouterEducation(e);
		return "redirect:/cv";
	}

	@RequestMapping(value = "/ajouterCompetence", method = RequestMethod.POST)
	public String ajouterCompetence(String competence, String niveau) {
		CV cv = icv.trouverById(utilisateur.getId());
		Competence c = new Competence(competence, Integer.parseInt(niveau), cv);
		mc.AjouterCompetence(c);
		in.EnvoyerNotification(utilisateur.getNom() + " a ajouté une compétence", ifr.getAmis(utilisateur.getId()));
		return "redirect:/cv";
	}

	@RequestMapping(value = "/ajouterLangue", method = RequestMethod.POST)
	public String ajouterLangue(String langue, String niveau) {
		CV cv = icv.trouverById(utilisateur.getId());

		Langue l = new Langue(langue, Integer.parseInt(niveau), cv);
		ml.AjouterLangue(l);
		in.EnvoyerNotification(utilisateur.getNom() + " a ajouté une langue", ifr.getAmis(utilisateur.getId()));
		return "redirect:/cv";
	}

	@RequestMapping(value = "/supprimerLangue/{id}", method = RequestMethod.GET)
	public String supprimerLangue(@org.springframework.web.bind.annotation.PathVariable String id) {
		ml.supprimerLangue(new Long(Integer.parseInt(id)));
		return "redirect:/cv";
	}

	@RequestMapping(value = "/supprimerExp/{id}", method = RequestMethod.GET)
	public String ajouterLangue(@org.springframework.web.bind.annotation.PathVariable("id") String id) {
		mep.supprimerExperiencePro(new Long(Integer.parseInt(id)));

		return "redirect:/cv";
	}

	@RequestMapping(value = "/supprimerEducation/{id}", method = RequestMethod.GET)
	public String supprimerEducation(@org.springframework.web.bind.annotation.PathVariable String id) {
		me.supprimerEducation(new Long(Integer.parseInt(id)));

		return "redirect:/cv";
	}

	@RequestMapping(value = "/supprimerCompetence/{id}", method = RequestMethod.GET)
	public String ajouterCompetence(@org.springframework.web.bind.annotation.PathVariable("id") String id) {
		mc.supprimerCompetence(new Long(Integer.parseInt(id)));

		return "redirect:/cv";
	}

	@RequestMapping(value = "/modifierExp", method = RequestMethod.POST)
	public String modifierExp(String fonction, Date dd, Date df, String description, String id, Model model) {

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dd1 = formatter.format(dd);
		String df1 = formatter.format(df);

		ExperiencePro ep = new ExperiencePro(new Long(Integer.parseInt(id)), fonction, dd1, df1, description);
		mep.MAJExperiencePro(ep);
		return "redirect:/cv";
	}

	@RequestMapping(value = "/modifierEducation", method = RequestMethod.POST)
	public String modifierEducation(String ecole, Date dd, Date df, String description, String id, Model model) {

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dd1 = formatter.format(dd);
		String df1 = formatter.format(df);

		me.MAJEducation(new Education(new Long(Integer.parseInt(id)), ecole, dd1, df1, description));
		return "redirect:/";
	}

	@RequestMapping(value = "/modifierLangue", method = RequestMethod.POST)
	public String modifierLangue(String langue, String niveau, String id) {
		ml.MAJLangue(new Langue(langue, Integer.parseInt(niveau), new Long(Integer.parseInt(id))));

		return "redirect:/cv";
	}

	@RequestMapping(value = "/modifierCompetence", method = RequestMethod.POST)
	public String modifierCompetence(String competence, String niveau, String id) {
		mc.MAJCompetence(new Competence(competence, Integer.parseInt(niveau), new Long(Integer.parseInt(id))));
		return "redirect:/cv";
	}

	@PostMapping("/ajouterImage")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		try {
			iu.enrigestrer(file, utilisateur.getNom(), utilisateur.getId());
		} catch (FileAlreadyExistsException e) {
			iu.deleteImage(utilisateur.getImage());
			iu.enrigestrer(file, utilisateur.getNom(), utilisateur.getId());
		}
		return "redirect:/cv";
	}

	@GetMapping("/inscription")
	public String inscription() throws IOException {
		return "inscription";
	}

	@PostMapping("/inscription")
	public String inscription(String email, String motdepasse, String nom, String prenom, String Sexe, String phone,
			String mois, String jour, String annee,String genie, String adresse, Model model) throws IOException {
		System.out.println("L'inscription");
		String img;
		String dateNaissance = new String(jour + "/" + mois + "/" + annee);

		users_role ur = new users_role(email, "ROLE_USER");
		// Utilisateur user = new Utilisateur(email,motdepasse,nom);
		if (Sexe.equals("masculin"))
			img = new String("p2.png");
		else
			img = new String("p1.jpg");
		Utilisateur user1 = new Utilisateur(nom, prenom, phone, dateNaissance, Sexe, motdepasse, email, img,genie,adresse);
		iu.ajouterUtilisateur(user1);
		CV cv = new CV(user1);
		icv.AjouterCV(cv);

		urr.create(ur);
		return "redirect:/";
	}

	@RequestMapping(value = { "/login" })
	public String login() {
		return "login";
	}

	@PostMapping("/modifierPersoInfo")
	public String modifierPersoInfo(String genie, String adresse, String tel, Model model) throws IOException {
		iu.ModifierPersoInfo(genie, adresse, tel, utilisateur.getId());
		System.out.println(name);
		return "redirect:/cv";
	}

	@RequestMapping("/")
	public String index(Model model){	

	    auth = SecurityContextHolder.getContext().getAuthentication();
	    name = auth.getName();
		utilisateur = ur.TrouverUserParEmail(name);
		
			
		List<Utilisateur> allfriends;
		List<Utilisateur> friends;
			HashMap<Long, Utilisateur> fri = new HashMap<Long,Utilisateur>();
			friends = ifr.FriendRequests(utilisateur.getId());
			allfriends=ifr.getAmis(new Long(utilisateur.getId()));
			
			Hashtable<Publication,Utilisateur> hpubs = new Hashtable<Publication,Utilisateur>();
			
			for( Publication p : ps.getPublicationsByUserId(utilisateur.getId())){
				hpubs.put(p, utilisateur);
			}
			for(Utilisateur d : friends){
				fri.put(new Long(d.getId()), d);
			}
			
			for(Utilisateur u : allfriends){
				for(Publication p : ps.getPublicationsByUserId(u.getId())){
					hpubs.put(p, u);
				}
				}

			model.addAttribute("fri", fri);
			model.addAttribute("allfriends", allfriends);
		
		List<Publication> pubs = ps.getPublicationsByUserId(utilisateur.getId());
		model.addAttribute("utilisateur",utilisateur);
		model.addAttribute(utilisateur.getImg(), MvcUriComponentsBuilder
                .fromMethodName(CvController.class, "getFile", utilisateur.getImg()).build().toString());
		
		
		model.addAttribute("posts",hpubs);
		for(Publication Publication:pubs){
		model.addAttribute(Publication.getImg(), MvcUriComponentsBuilder
                .fromMethodName(CvController.class, "getFilePub", Publication.getImg()).build().toString());
		
		}
     	model.addAttribute("notifications",utilisateur.getNotificationList());
		return "index";}
	
	@RequestMapping("/AjouterPublication")
	public String AjouterPublication(String title, String body, @RequestParam("file") MultipartFile file) {
		String img = file.getOriginalFilename();
		Publication p = new Publication(title, body, img, utilisateur);
		ps.create(p);
		ps.enregistrer(file, file.getOriginalFilename());
		in.EnvoyerNotification(utilisateur.getNom() + " a ajouté une publication", ifr.getAmis(utilisateur.getId()));
		return "redirect:/";
	}

	@RequestMapping("/supprimerPublication/{id}")
	public String supprimer(@org.springframework.web.bind.annotation.PathVariable("id") String id) {
		int ID = Integer.parseInt(id);
		ps.deleteById(new Long(ID));
		return "redirect:/";
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = iu.telecharger(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@RequestMapping(value = "/accept", method = RequestMethod.POST)
	public String acceptrequest(String idd) throws SQLException {

		Long personid = utilisateur.getId();

		Long targetid = new Long(Integer.parseInt(idd));

		ifr.accepter(targetid, personid);
		in.EnvoyerNotification(utilisateur.getNom() + " a accepté votre demande", ifr.getAmis(targetid));


		return "redirect:/";
	}

	@RequestMapping(value = "/decline", method = RequestMethod.POST)
	public String declinerequest(String idd) throws SQLException {
		Long personid = new Long(utilisateur.getId());
		System.out.println(idd);
		Long targetid = new Long(Integer.parseInt(idd));

		ifr.refuser(targetid, personid);

		return "redirect:/";
	}

	@RequestMapping(value = "/createfriendrequest", method = RequestMethod.POST)
	public String createrequest(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws SQLException {
		session = request.getSession(true);
		Long personid = new Long((utilisateur.getId()));

		Long targetid = new Long(Integer.parseInt(request.getParameter("idd")));
		ifr.createFriendRequest(new Friendrequest(personid, targetid, 0));
		in.EnvoyerNotification(utilisateur.getNom() + " a envoyé une demande d'ajout ", ifr.getAmis(targetid));

		return "redirect:/cv/" + targetid;
	}

	@GetMapping("/fichiers/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFilePub(@PathVariable String filename) {
		Resource file = iu.telechargerImagePub(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
 

}
