package com.emigate.metier;

import com.emigate.entite.users_role;

public interface IUserRole {
	
	public void create(users_role ur);
	public void modifier(String username,Long id);
	
}
