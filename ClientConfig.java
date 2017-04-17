package callSOIProject.com.dbs;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;



//@Configuration
public class ClientConfig {

    @Value("http://localhost:8080/services")
    private String helloworldServiceAddress;

    @Bean(name = "globalWeatherSoap")
    public GlobalWeatherSoap opportunityPortType() {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(GlobalWeatherSoap.class);
        jaxWsProxyFactoryBean.setAddress(helloworldServiceAddress);

        return (GlobalWeatherSoap) jaxWsProxyFactoryBean.create();
   
    }

}
