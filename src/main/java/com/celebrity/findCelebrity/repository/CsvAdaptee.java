/**
 * 
 */
package com.celebrity.findCelebrity.repository;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.CSVReader;

import lombok.Data;

/**
 * This class read a csv file
 * @author lina.patino
 *
 */
@Data
public class CsvAdaptee {	   
	public Logger LOGGER = LoggerFactory.getLogger(DataConnectorAdapter.class);
	private String filePath;
	
	public CsvAdaptee(String filePath) {
		this.filePath = filePath;
	}
	
	public List<String[]> readFile() {
		ArrayList<String[]> result = new ArrayList<>();
		
		try (CSVReader reader = new CSVReader(new FileReader(this.filePath))){
			
			
			String[] line = null;
			while((line = reader.readNext()) != null) {
				result.add(line);
			}
		}catch(Exception e){
			this.LOGGER.error(e.getMessage());
		}
		
		return result;
	}	
}
