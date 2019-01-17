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
	}

	public Set<TeamMember> playFindCelebrity(String filePath, String connectorType){
		DataConnectorAdapter connector = Factory.getInstance().getDataConnector(filePath, connectorType);
	
		Set<TeamMember> people = connector.getData();
		return this.findCelebrity(people);
	} 
	
	public  Set<TeamMember> findCelebrity(Set<TeamMember>peopleList){
		Set<TeamMember> result = new HashSet<>();
				
		for (TeamMember teamMember : peopleList) {
			if(teamMember.getKnownPeople().isEmpty()) {
				teamMember.setCelebrity(isTeamMemberACelebrity(teamMember, peopleList));
				
				if(teamMember.isCelebrity())
					result.add(teamMember);
			}
		}
		
		return result;
	}
	
	public boolean isTeamMemberACelebrity(TeamMember teamMember, Set<TeamMember> peopleList) {
	
		for (TeamMember teamMember2 : peopleList) {
			if(!teamMember.equals(teamMember2) && !teamMember2.getKnownPeople().isEmpty() && !teamMember2.getKnownPeople().contains(teamMember)) 
				return false;
		}
		return true;
	}
	
}
