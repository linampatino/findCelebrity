/**
 * 
 */
package com.celebrity.findCelebrity.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.celebrity.findCelebrity.model.TeamMember;

/**
 * @author lina.patino
 *
 */
public class CsvAdapter extends CsvAdaptee implements DataConnectorAdapter {

	/**
	 * @param filePath
	 */
	public CsvAdapter(String filePath) {
		super(filePath);
	}

	/* (non-Javadoc)
	 * @see com.celebrity.findCelebrity.model.DataConnectorAdapter#getData()
	 * 
	 * File line structure: 
	 * personId, name, lastname, knownPersonId, knownPersonName, knownPersonLastname
	 */
	@Override
	public Set<TeamMember> getData() {
		ArrayList<String[]> fileInformation = (ArrayList<String[]>) readFile();
		Set<TeamMember> result = new HashSet<>();
				
		TeamMember teamMember = null;
		TeamMember temporal = null;
		
		Set<TeamMember> knownPeople = null;
		for (String[] fileLine : fileInformation) {
			teamMember = convertDataToTeamMember(fileLine);
			
			if(temporal == null) {
				knownPeople = new HashSet<>();
				temporal = teamMember;
			}
			if (!teamMember.equals(temporal)) {
				temporal.setKnownPeople(knownPeople);
				result.add(temporal);
				
				temporal = teamMember;
				knownPeople = new HashSet<>();
				addKnownPersonToTeamMember(fileLine, knownPeople);
				
			}else {
				addKnownPersonToTeamMember(fileLine, knownPeople);
			}
		}
		result.add(teamMember);
		return result;
	}
	
	public TeamMember convertDataToTeamMember(String[] fileLine) {
		//get team member info
		String id = fileLine[0];
		String name = fileLine[1];
		String lastname = fileLine[2];
		
		return new TeamMember(id, name, lastname);
	}
	
	public void addKnownPersonToTeamMember(String[] fileLine, Set<TeamMember> knownPeople) {
		TeamMember knownPerson = convertDataToKnownPerson(fileLine);
		if (knownPerson != null) 
			knownPeople.add(knownPerson);
	}
	
	public TeamMember convertDataToKnownPerson(String[] fileLine) {
		//get known person info
		String knownPersonId = fileLine[3];
		String knownPersonName = fileLine[4];
		String knownPersonLastname = fileLine[5];
		
		if(knownPersonId.trim().length()>0 && knownPersonName.trim().length()>0 && knownPersonLastname.trim().length()>0) 
			return new TeamMember(knownPersonId, knownPersonName, knownPersonLastname);
		else
			return null;
	}

	
}
