/**
 * 
 */
package com.celebrity.findCelebrity.resources;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celebrity.findCelebrity.model.TeamMember;
import com.celebrity.findCelebrity.services.Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * @author lina.patino
 *
 */

@RestController
@RequestMapping("/api/celebreties")
@Api(tags = "celebreties")
public class CelebrityResources {
	private final Service SERVICE;
	
	public CelebrityResources (Service service) {
		this.SERVICE = service;
	}
	
	
	@GetMapping
	@ApiOperation(value = "Find Celebrity", notes = "this service find all celebrities in a team")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "ok"),
			@ApiResponse(code = 404, message = "not found celebrities")
	})
	public ResponseEntity<Set<TeamMember>> findCelebrity(@ApiParam(value="path", required=true) @PathVariable("path") String path, 
														 @ApiParam(value="connectorType", required=true) @PathVariable("connectorType") String connectorType){
		return ResponseEntity.ok(this.SERVICE.playFindCelebrity(path, connectorType));
	}
}
