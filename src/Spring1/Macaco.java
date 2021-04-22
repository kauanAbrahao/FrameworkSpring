package Spring1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Macaco implements Mamifero{

    @Autowired
    @Qualifier("petshopParaGatos")
    private Petshop petshop;

    @Override
    public String alimentacao() {
        return "Comendo banana!";
    }

    @Override
    public String dataDoBanho() {
        return petshop.getBanho();
    }
}
