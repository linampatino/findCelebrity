package com.celebrity.findCelebrity.repository;

public class Factory {

	private Factory() {
		
	}
	
	public static Factory getInstance() {
		return new Factory();
	}
	
	public static DataConnectorAdapter getDataConnector(String configurationParam, String connectorType){
		DataConnectorAdapter connector = null;
		switch (connectorType) {
			case "CSV":
				connector = new CsvAdapter(configurationParam);
				break;
			}
		return connector;
	}

	
}
