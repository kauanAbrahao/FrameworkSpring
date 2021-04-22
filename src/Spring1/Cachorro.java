package Spring1;

public class Cachorro implements Mamifero{


    private String nome;
    private Petshop petshop;

    @Override
    public String alimentacao() {
        return "Se alimentando de ração!";
    }

    @Override
    public String dataDoBanho() {
        return petshop.getBanho();
    }

    public void setPetshop(Petshop petshop) {
        this.petshop = petshop;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
