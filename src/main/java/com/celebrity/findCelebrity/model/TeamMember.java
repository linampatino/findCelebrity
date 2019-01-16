/**
 * 
 */
package com.celebrity.findCelebrity.model;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;

/**
 * @author lina.patino
 *
 */

@Data
public class TeamMember {
	private String personId;
	private String name;
	private String lastname;
	private Set<TeamMember> knownPeople = new HashSet<TeamMember>();
	private boolean isCelebrity;
	
	public TeamMember() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TeamMember(String id, String name, String lastname) {
		this.personId = id;
		this.name = name;
		this.lastname = lastname;	
		this.isCelebrity = false;
	}

	public int hashCode() {
		return this.personId.hashCode();
	}
	
	public boolean equals(Object object) {
		if (object instanceof TeamMember) {
			TeamMember temporal = (TeamMember)object;
			return this.getPersonId().equals(temporal.getPersonId());
		}
		return false;
	}
}

