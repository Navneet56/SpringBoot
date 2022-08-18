package com.zee.zee5app.restcontroller;

import java.time.LocalDate;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.UnableToRegisterMBeanException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.EntryExistsException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;
import com.zee.zee5app.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping("/add") // it is combination of post method and requestmapping .spring 4.3
	
	public ResponseEntity<?> createUser(@RequestBody User user )
	{
		try {
			userService.insertUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		} catch (UnableToGenerateIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			HashMap<String, String> resData= new HashMap<>();
			resData.put("status","internal id creation problem");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resData);
		}
		catch (EntryExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			HashMap<String, String> resData= new HashMap<>();
			resData.put("status","record already exist");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resData);
		}
	}
	@DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") String id)
    {
		try {
			userService.deleteUserById(id);
			return "Success"; 
			
		} catch (NoDataFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "unSuccess"; 
    }
	@GetMapping("/{id}")
	 public User getUserByuserId(@PathVariable("id") String  userId)
    {
		return userService.getUserById(userId);
    }
	@PutMapping
	 public String updateUserByuserId(String  userId)
    {
		return "success";
    }

}
