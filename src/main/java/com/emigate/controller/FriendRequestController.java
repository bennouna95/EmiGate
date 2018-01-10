package com.emigate.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.emigate.entite.Friendrequest;
import com.emigate.entite.Utilisateur;
import com.emigate.metier.IFriendRequest;

@RestController

public class FriendRequestController {
	
	@Autowired
	IFriendRequest mep;
	
	/*public ModelAndView requests(HttpServletRequest request,HttpSession session,ModelAndView model){
		model = new ModelAndView("accueil");
		List<Utilisateur> allfriends;
		List<Utilisateur> friends;
			HashMap<Long, String> fri = new HashMap<Long,String>();
			friends = mep.FriendRequests(new Long((long) session.getAttribute("id")));
			allfriends=mep.getAmis(new Long((long)session.getAttribute("id")));
			
			for(Utilisateur d : friends){
				fri.put(new Long(d.getId()), d.getNom());
			}

			model = new ModelAndView("accueil");
			model.addObject("fri", fri);
			model.addObject("allfriends", allfriends);

			request.setAttribute( "fri", fri );
			request.setAttribute( "allfriends", allfriends );

		 
		return model;
		
	}

	@RequestMapping(value="/accept",method=RequestMethod.POST)
	public ModelAndView acceptrequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException{
         session = request.getSession(true);
         ModelAndView model = new ModelAndView();
         Long personid = new Long((int)session.getAttribute("id"));

			Long targetid = new Long(Integer.parseInt(request.getParameter("idd")));
         
			mep.accepter(targetid,personid);
			model = requests(request,session,model);
         
			
         return model;
}
	@RequestMapping(value="/decline",method=RequestMethod.POST)
	public ModelAndView declinerequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException{
         session = request.getSession(true);
         ModelAndView model = new ModelAndView();
         Long personid = new Long((int)session.getAttribute("id"));

			Long targetid = new Long(Integer.parseInt(request.getParameter("idd")));
         
			mep.refuser(targetid,personid);
			model = requests(request,session,model);
         
			
         return model;
}
	@RequestMapping(value="/createfriendrequest",method=RequestMethod.POST)
	public ModelAndView createrequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException{
         session = request.getSession(true);
         ModelAndView model = new ModelAndView();
         Long personid = new Long((int)session.getAttribute("id"));

			Long targetid = new Long(Integer.parseInt(request.getParameter("idd")));
			mep.createFriendRequest(new Friendrequest(personid,targetid,0));
			model = new ModelAndView("cv");
         			
         return model;
}*/
}