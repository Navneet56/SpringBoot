package com.zee.zee5app;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Employee;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.enums.Genres;
import com.zee.zee5app.exceptions.EntryExistsException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;
import com.zee.zee5app.repos.EmployeeRepository;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.UserServiceImpl;



@SpringBootApplication
public class Zee5appApplication {

	public static void main(String[] args)  {
		
		SpringApplication.run(Zee5appApplication.class, args);
		
	}

}
