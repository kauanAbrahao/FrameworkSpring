package Spring1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("Spring1")
@PropertySource("classpath:petsProperties") //Para buscar valores no petsProperties
public class MamiferoConfig {

    @Bean
    public Petshop petshopParaBaleias(){
        return new PetshopParaBaleias();
    }

    @Bean
    public Mamifero baleia(){
        Baleia baleia = new Baleia();
        baleia.setPetshop(petshopParaBaleias());
        return baleia;
    }
}
