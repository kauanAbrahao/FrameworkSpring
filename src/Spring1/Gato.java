package Spring1;

public class Gato implements Mamifero {

    private Petshop petshop;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Gato (Petshop petshop){
        this.petshop = petshop;
    }

    @Override
    public String alimentacao() {
        return "Se alimentando de leite!!!";
    }

    public String dataDoBanho(){
        return petshop.getBanho();
    }
}
