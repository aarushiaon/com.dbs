package callSOIProject.com.dbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

import net.webservicex.GetWeather;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;
import net.webservicex.ObjectFactory;
@ControllerAdvice
@Component
public class SoapClient {

    

	@Autowired
    private GlobalWeatherSoap globalWeatherSoap;

    public String getWeather() {

    	System.out.println("Inside soap client method------------------");
        ObjectFactory factory = new ObjectFactory();
        GetWeather weather = factory.createGetWeather();

        weather.setCountryName("india");
        weather.setCityName("goa");

        globalWeatherSoap=(GlobalWeatherSoap) new GlobalWeather();

        String greeting =globalWeatherSoap.getWeather(weather.getCityName(), weather.getCountryName());
                
        System.out.println(greeting);
        
        return greeting;
    }
}