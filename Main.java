package callSOIProject.com.dbs;



import java.net.MalformedURLException;
import java.net.URL;

import net.webservicex.GetWeather;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;
import net.webservicex.ObjectFactory;

public class Main {

	
	static URL url = Main.class.getResource("wsdl/sample.wsdl");
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		
		
		//URL url = new URL("sample.wsdl");

		 GlobalWeather service = new GlobalWeather(url);
         GlobalWeatherSoap weatherSoap = service.getGlobalWeatherSoap();
         System.out.println("Weather for New York");
         System.out.println(weatherSoap.getWeather("goa", "india"));

	}

}
