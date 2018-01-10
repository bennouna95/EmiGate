package com.emigate.metier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emigate.Repository.UserRoleRepository;
import com.emigate.entite.users_role;


@Service
@Transactional
public class MetierUserRole implements IUserRole {
	
	
	@Autowired
	UserRoleRepository urr;
	

	@Override
	public void create(users_role ur) {
		urr.save(ur);
	}

	@Override
	public void modifier(String username, Long id) {
		// TODO Auto-generated method stub
		urr.ModifierUsersRole(username, id);
	}
	
	

}
