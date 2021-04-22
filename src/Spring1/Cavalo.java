package Spring1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("cavalinho")
public class Cavalo implements Mamifero {

    @Autowired
    @Qualifier("petshopParaGatos")
    private Petshop petshop;

    @Value("${variavel.nomeCavalo}")
    private String nome;


    public String getNome() {
        return nome;
    }

    @Override
    public String alimentacao() {
        return "Comendo grama";
    }

    @Override
    public String dataDoBanho() {
        return petshop.getBanho();
    }
}
