package com.ibm.beans.impl;

import java.util.Set;
import org.springframework.stereotype.Service;
import com.ibm.nosql.json.api.BasicDBList;
import com.ibm.nosql.json.api.BasicDBObject;
import com.ibm.nosql.json.util.JSON;

@Service
public class DB2FactoryService {
	
	private static String vcap_services = System.getenv("VCAP_SERVICES");
	private static BasicDBObject json_params = (BasicDBObject) JSON.parse(vcap_services);
		
	public String getUserName() {
		return (String) getCredentials().get("username");
	}
	
	public String getPassWord() {
		
		return (String) getCredentials().get("password");
	}

	public String getPort() {
		
		return (String) getCredentials().get("port");
	}
	
	public String getJDBCUrl() {
		return (String) getCredentials().get("jdbcurl");
	}

	public String getUri() {
		
		return (String) getCredentials().get("uri");
	}
	
	private String getSQLDB2Key(){
		String key= null;
		Set<String> keys = json_params.keySet();
        for (String eachkey : keys) {
      	       if (eachkey.toUpperCase().contains("SQLDB")) {
      	    	 key = eachkey;
      	       }
        }
        return key;
	}
	
	private BasicDBObject getCredentials() {
		BasicDBObject credentials = null;
		BasicDBList list = (BasicDBList) json_params.get(getSQLDB2Key());
		credentials = (BasicDBObject) list.get("0");
		credentials = (BasicDBObject) credentials.get("credentials");
		return credentials;
	}

}
