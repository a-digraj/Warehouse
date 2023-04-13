package com.tyss.warehouse.boot.warehouse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.warehouse.boot.warehouse.config.ResponseStructure;
import com.tyss.warehouse.boot.warehouse.dao.AdminDao;
import com.tyss.warehouse.boot.warehouse.dto.AdminDto;
import com.tyss.warehouse.boot.warehouse.dto.UserDto;
import com.tyss.warehouse.boot.warehouse.entity.Admin;
import com.tyss.warehouse.boot.warehouse.entity.User;
import com.tyss.warehouse.boot.warehouse.exception.AdminAlreadyExistsException;
import com.tyss.warehouse.boot.warehouse.exception.AdminCredentialsNotValid;
import com.tyss.warehouse.boot.warehouse.exception.AdminIdNotFoundException;
import com.tyss.warehouse.boot.warehouse.exception.IdNotFoundException;
import com.tyss.warehouse.boot.warehouse.exception.UserNotFoundException;

@Service
public class AdminService {
	@Autowired
	private AdminDao dao;
	@Autowired
	private AdminDto dto;

	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(Admin admin) {
		long adminNumbers = dao.checkAdmin();
		if (adminNumbers < 1) {
//		System.out.println("-=-=-=-=-number of admins is -=-=-=-="+ adminNumbers);
			admin = dao.saveAdmin(admin);
			dto.setAdminId(admin.getAdminId());
			dto.setAdminName(admin.getAdminName());

			ResponseStructure<AdminDto> responseStructure = new ResponseStructure<>();
			responseStructure.setData(dto);
			responseStructure.setMessage("admin saved successfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<AdminDto>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new AdminAlreadyExistsException("admin alredy exists");
		}
	}

	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(Admin admin, int id) {
		Admin admin2 = dao.getAdminById(id);
		if (admin2 != null) {

			dao.updateAdmin(admin, id);
			dto.setAdminId(admin2.getAdminId());
			dto.setAdminName(admin2.getAdminName());

			ResponseStructure<AdminDto> responseStructure = new ResponseStructure<>();
			responseStructure.setData(dto);
			responseStructure.setMessage("admin updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<AdminDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AdminIdNotFoundException("admin not present");
		}
	}

	public ResponseEntity<ResponseStructure<AdminDto>> getAdminById(int id) {
		Admin admin2 = dao.getAdminById(id);
		if (admin2 != null) {
			Admin admin = dao.getAdminById(id);
			dto.setAdminId(admin.getAdminId());
			dto.setAdminName(admin.getAdminName());

			ResponseStructure<AdminDto> responseStructure = new ResponseStructure<>();
			responseStructure.setData(dto);
			responseStructure.setMessage("admin found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<AdminDto>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new AdminIdNotFoundException("admin not present");
		}
	}

	public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(int id) {
		Admin admin2 = dao.getAdminById(id);
		if (admin2 != null) {
			dao.deleteAdmin(id);
			 dto.setAdminId(admin2.getAdminId());
			 dto.setAdminName(admin2.getAdminName());

			ResponseStructure<AdminDto> responseStructure = new ResponseStructure<>();
			responseStructure.setData(dto);
			responseStructure.setMessage("admin delete success");
			responseStructure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<AdminDto>>(responseStructure, HttpStatus.OK);

		} else {
			throw new AdminIdNotFoundException("no admin found");
		}

	}

	public ResponseEntity<ResponseStructure<List<UserDto>>> findAllUsers() {
		List<User> users = dao.allUsers();
		List<UserDto> dtos = new ArrayList<>();
		if (users != null) {
			for (User u : users) {
				UserDto dto = new UserDto();
				dto.setCart(u.getCart());
				dto.setUserId(u.getUserId());
				dto.setUserName(u.getUserName());
				dtos.add(dto);
			}
			ResponseStructure<List<UserDto>> responseStructure = new ResponseStructure<>();
			responseStructure.setData(dtos);
			responseStructure.setMessage("users found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<UserDto>>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new UserNotFoundException("users not present");
		}
	}
	public ResponseEntity<ResponseStructure<AdminDto>> findbyNameAndPassword(String name, String password){
		Admin admin = dao.findbyNameAndPassword(name, password);
		if(admin!=null) {
			ResponseStructure<AdminDto> structure = new ResponseStructure<>();
			dto.setAdminId(admin.getAdminId());
			dto.setAdminName(admin.getAdminName());
			
			
			structure.setData(dto);
			structure.setMessage("users found");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.FOUND);
		}
		else throw new AdminCredentialsNotValid("wrong credentials for admin");
	}

}
