package Spring1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PetshopParaGatos implements Petshop  {

    @Override
    public String getBanho(){
        return "Tomará banho daqui 2 dias! Gatos 1x a cada 3 dias";
    }
}
