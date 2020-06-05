package main;




import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import stockTicker.StockTicker;
import window.WindowMain;

/*	So I'm getting a little burnt out on redux and I'm gonna have to grind at 
 * that to get into it, however I'm having fun with java, so I'll be doing 
 * tiny little (and I mean little) projects here
*/
public class EntryPoint {
	
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
	 	@SuppressWarnings("unused")
		WindowMain mainWindow = new WindowMain();
	 	StockTicker st = new StockTicker();
	}

}
;