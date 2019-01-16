/**
 * 
 */
package com.celebrity.findCelebrity.services;

import java.util.HashSet;
import java.util.Set;

import com.celebrity.findCelebrity.model.TeamMember;
import com.celebrity.findCelebrity.repository.DataConnectorAdapter;
import com.celebrity.findCelebrity.repository.Factory;


/**
 * @author lina.patino
 *
 */

@org.springframework.stereotype.Service
public class Service {


	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}

	public  Set<TeamMember> playFindCelebrity(String filePath, String connectorType){
		DataConnectorAdapter connector = Factory.getInstance().getDataConnector(filePath, connectorType);
	
		Set<TeamMember> people = connector.getData();
		Set<TeamMember> result = this.findCelebrity(people);
		return result;
	} 
	
	public  Set<TeamMember> findCelebrity(Set<TeamMember>peopleList){
		Set<TeamMember> result = new HashSet<TeamMember>();
		boolean isCelebrity = true;
				
		for (TeamMember teamMember : peopleList) {
			//Check if teamMember knows people
			if(teamMember.getKnownPeople().size() == 0) {
				isCelebrity = true;
				
				//Check if the teamMember is a celebrity, that means everybody knows him/her
				for (TeamMember teamMember2 : peopleList) {
					if(!teamMember.equals(teamMember2)) {
						
						if(teamMember2.getKnownPeople().size() > 0 &&
						   !teamMember2.getKnownPeople().contains(teamMember)) {
							isCelebrity = false;
							break;
						}
							
					}
				}
				
				teamMember.setCelebrity(isCelebrity);
				
				if(isCelebrity)
					result.add(teamMember);
			}
		}
		
		return result;
	}
}
