package com.celebrity.findCelebrity;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.celebrity.findCelebrity.model.TeamMember;
import com.celebrity.findCelebrity.services.Service;

@SpringBootApplication
public class FindCelebrityApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindCelebrityApplication.class, args);
		
		/*Service servicio = new Service();
		Set<TeamMember> result = servicio.run("C:\\Users\\lina.patino\\Documents\\fits\\vivid-seat\\findCelebrity\\findCelebrity", "CSV");
		
		System.out.println("celebrities:::: " + result.size());
		for (TeamMember teamMember : result) {
			System.out.println("celebrities:::: " + teamMember.getName());
		}*/
	}

}

