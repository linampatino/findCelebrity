/**
 * 
 */
package com.celebrity.findCelebrity.repository;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.opencsv.CSVReader;

import lombok.Data;

/**
 * This class read a csv file
 * @author lina.patino
 *
 */
@Data
public class CsvAdaptee {	   
	private String filePath;
	
	public CsvAdaptee(String filePath) {
		this.filePath = filePath;
	}
	
	public ArrayList<String[]> readFile() {
		ArrayList<String[]> result = new ArrayList<String[]>();
		CSVReader reader = null;
		try {
			
			reader = new CSVReader(new FileReader(this.filePath));
			String[] line = null;
			while((line = reader.readNext()) != null) {
				result.add(line);
			}
		}catch(Exception e){
			//return null;
			System.out.println(e.getMessage());
		}finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("error2");
				}
			}			
			return result;
		}
	}	
}
