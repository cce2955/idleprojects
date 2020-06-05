package stockTicker;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/*
 * 	Stocks are pulled from
 * 	https://query1.finance.yahoo.com/v7/finance/quote?lang=ko-KR&region=
 *  KR&corsDomain=finance.yahoo.com
 *  add on &symbols= and then a stock Symbol(ex. SBUX)
*/
public class StockTicker {
	private String url;
    private String apiOutput;
    private int x;
    private int y;
	
	 
	public HashMap<String,String> getStock(String symbol) throws ClientProtocolException, 
	IOException {
		HashMap<String, String> jsonArray = new HashMap<>();
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//Get stock info from yahoo
		setUrl("https://query1.finance.yahoo.com/v7/"
				+ "finance/quote?lang=ko-KR&region=KR"
				+ "&corsDomain=finance.yahoo.com&symbols=" + 
				symbol);
			
			HttpGet httpGet = new HttpGet(getUrl());
			
			CloseableHttpResponse response1 = httpclient.execute(httpGet);
		
			
			
		try {
			//Print out response
		    System.out.println(response1.getStatusLine());	    
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    HttpEntity entity1 = response1.getEntity();
		    
		    setApiOutput(EntityUtils.toString(entity1));
		    //So for whatever reason I cannot get java
		    //to automatically parse my info into a usable way
		    //So I'm going to parse the data myself
		        
			    //System.out.println(sb);
		    StringBuilder sb = new StringBuilder();
		    sb.append(trimResults(apiOutput));
		    System.out.println(sb);
		    //If the stock is valid, enter the data
		    if(apiOutput.contains("symbol")){
		    	setX(0);
		    }else {
		    	//Else put this in the array and don't fill it with anything
		    	setX(getY() + 1);
		    	jsonArray.put("404", "Not a valid stock");
		    	
		    }
		    
		    while (getX() < getY()) {
		    	//Put the word after line start and before ":"
		    	//And then add the word before "," and after ":"
		    	//Trim the white space
		    	//Both words get added as a string pair to the hashmap
		    	jsonArray.put(String.valueOf(sb.subSequence(0,sb.indexOf(":")))
		    			.trim(), String.valueOf(sb.subSequence(sb.indexOf(":") 
		    					+ 1,sb.indexOf(","))).trim());
		    	sb.replace(0, sb.indexOf(",") + 1, " ");
		    	sb.trimToSize();
		    	x++;
		    }     
		} finally {
			
		    response1.close();
		}
		
		return jsonArray;
	}
private StringBuilder trimResults(String string) {
	StringBuilder sb = new StringBuilder();
    sb.append(getApiOutput());
    
	    //Knock out preliminary data that doesn't need
	    //to be in the hashmap
	    sb.replace(0, 27, " ");
	    sb.trimToSize();
	    //Delete the opening spaces which are irrelevant
	    sb.delete(0, 3);
	    for(int i = 0; i < sb.length(); i++) {
	    	String checker = String.valueOf(sb.charAt(i));
	    	//Get rid of all irrelevant characters
	    	if(checker.equals("\"") || checker.equals("[")
	    			|| checker.equals("}") || checker.equals("]")) {
	    		sb.deleteCharAt(i);
	    	}
	    }
	    setX(0);
	    setY(0);
	    //Cycle through the json data, find all the commas
	    //This will tell us how many entries the JSON array will have
	    //That way we can assign only as many entries as we need
	    //without hitting an indexoutofbounds
	    while (sb.length() > getX()) {
	    	if(String.valueOf(sb.charAt(getX())).equals(",")){
	    		incrementY();
	    	}
	    	incrementX();
	    }
	    
	    setX(0);
	    return sb;
	}

	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getApiOutput() {
		return apiOutput;
	}


	public void setApiOutput(String apiOutput) {
		this.apiOutput = apiOutput;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}
	public int incrementX() {
		return this.x++;
	}

	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
	
	public int incrementY() {
		return this.y++;
	}
	
	
}
