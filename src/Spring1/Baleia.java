package Spring1;

import org.springframework.beans.factory.annotation.Value;

public class Baleia implements Mamifero{

    private Petshop petshop;

    @Value("${variavel.baleia.idade}")
    private String idade;

    public String getIdade() {
        return idade;
    }

    public void setPetshop(Petshop petshop) {
        this.petshop = petshop;
    }

    @Override
    public String alimentacao() {
        return "Filtrando a água para se alimentar de pequenos crustáceos!!";
    }

    @Override
    public String dataDoBanho() {
        return petshop.getBanho();
    }
}
