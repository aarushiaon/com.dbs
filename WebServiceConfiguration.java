package callSOIProject.com.dbs;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

@Configuration
public class WebServiceConfiguration {
	
    @Bean
    public ServletRegistrationBean cxfServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/soap-api/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }    
    
    @Bean
    public GlobalWeatherSoap weatherService() {
    	return new GlobalWeatherServiceImpl();
    }
    
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), weatherService());        
        // CXF JAX-WS implementation relies on the correct ServiceName as QName-Object with
        // the name-AttributeÂ´s text <wsdl:service name="Weather"> and the targetNamespace
        // "http://www.codecentric.de/namespace/weatherservice/"
        // Also the WSDLLocation must be set'
       
        endpoint.setServiceName(weather().getServiceName());
        endpoint.setWsdlLocation("F:\\Workspace-SprngBootApacheCXF\\callSOI\\com.dbs\\wsdl\\sample.wsdl");
        endpoint.publish("/WeatherSoapService_1.0");
        return endpoint;
    }
    
    @Bean
    public GlobalWeather weather() {
        // Needed for correct ServiceName & WSDLLocation to publish contract first incl. original WSDL
        return new GlobalWeather();
    }
}
