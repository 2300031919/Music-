package com.PlayForYouApp.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PlayForYouApp.project.entities.Users;
import com.PlayForYouApp.project.repositories.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService
{

	@Autowired
	UsersRepository repo;

	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "User is created and saved";
	}

	@Override
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		Users user = repo.findByEmail(email);
		System.out.println(user);
		String db_password = user.getPassword();
		if(db_password.equals(password))
		{
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String checkRole(String email) {
		return repo.findByEmail(email).getRole();
	}

	@Override
	public Users getUser(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
	}

	@Override
	public List<Users> getAllCustomers(String role) {
		return repo.findByRole(role);
	}


	
}

	