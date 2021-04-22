package Spring1;

public class Rato implements Mamifero{

    @Override
    public String alimentacao() {
        return "Se alimentando de queijo!!";
    }

    @Override
    public String dataDoBanho() {
        return null;
    }
}
