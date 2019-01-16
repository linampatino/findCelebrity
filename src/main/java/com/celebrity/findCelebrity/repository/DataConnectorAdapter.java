/**
 * 
 */
package com.celebrity.findCelebrity.repository;

import java.util.Set;

import com.celebrity.findCelebrity.model.TeamMember;

/**
 * @author lina.patino
 *
 */
public interface DataConnectorAdapter {
	public Set<TeamMember> getData();
}
