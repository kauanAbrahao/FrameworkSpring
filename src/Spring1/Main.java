package Spring1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
/*      Para configurar o Spring, nós vamos desenvolver os beans e os beanContainers.

        Existem 3 formas de fazer:

            1. Através de arquivos xml (applicationContext.xml);
            2. Através de annotations;
            3. Através de classes no Java.

        Qualquer que seja a forma escolhida, nós vamos seguir 3 passos:

            1. Configurar os nossos beans;
            2. Criar um Spring Container;
            3. Buscar o bean no Spring Container.

        Para fazer a injeção de depedências, nós temos 3 alternativas:

            1. Construtor
            2. Setter
            3. Autowiring

*/

/* ============================= ** CONFIGURANDO POR XML ** ======================================
==================================================================================================

       - primeiro passo é criar o arquivo applicationContext.xml e os beans: <bean></bean>
        - segundo passo é configurar os beans dentro do applicationContext.xml
        - terceiro passo é criar o Spring Container:            */
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

//      - quarto passo é buscar o bean, através de seu id e da Interface que ele implementa
        Mamifero mamifero = applicationContext.getBean("rato", Mamifero.class);
        Cachorro mamifero1 = applicationContext.getBean("cachorro", Cachorro.class);

        System.out.println(mamifero.getClass().toString() + " " + mamifero.alimentacao());
        System.out.println(mamifero1.getClass().toString() + " " + mamifero1.alimentacao());


/*

     INJEÇÃO DE DEPENDÊNCIAS
     --------------------------------
     Nossa classe Gato possui uma dependência com a interface Petshop. Como fazer a injeção de dependências
     nesse caso? Lembrando que seria interessante que Gato tivesse relação com a implementação PetshopParaGatos.

          1. Método Construtor
        - primeiro passo é criar um construtor na classe que possui a dependência (no nosso exemplo, Gato).
        - segundo passo é criar um bean para a implementação PetshopParaGatos de Petshop no xml.
        - terceiro passo é marcar o bean de Gato no xml com um constructor-arg, dessa forma, no construtor da classe,
        o bean de PetshopParaGatos será utilizado.
*/

        Gato mamifero2 = applicationContext.getBean("gato", Gato.class);
        System.out.println(mamifero2.getClass().toString() + " " + mamifero2.alimentacao());
        System.out.println(mamifero2.dataDoBanho());


/*
       Agora, nossa classe Cachorro também possui a mesma dependência. Vamos usar a PetshopParaCaes

           2. Método Setter
            - primeiro passo é criar setters na classe que possui a dependência (no nosso exemplo, Gato).
            - segundo passo é criar um bean para a implementação PetshopParaCaes de Petshop no xml.
            - terceiro passo é marcar o bean de Cachorro no xml com um property name, onde name precisa
            ser o nome do método setter sem o set e o ref é o id do bean PetshopParaCaes.
*/
        System.out.println(mamifero1.dataDoBanho());

/*      Existe uma terceira forma, menos comum, que é adotar um valor literal para a dependência.
        Para testarmos, vamos criar uma variavel String nome em Cachorro, com seus getters e setters.
        Queremos que todos nossos cachorros tenham o nome de Koda.

        3. Método de Valor Literal
        - primeiro passo é criar getters e setters para a dependência na classe.
        - segundo passo é criar configurar o bean da classe (no nosso exemplo, o bean de Cachorro),
        com <property name = nomeDaDependecia value = "valorLiteral".
 */
        System.out.println(mamifero1.getNome());

/*      Colocamos também um nome para o gato, Zuko.

        3.1.Método de Valor Literal por um Arquivo de Propriedades
        - primeiro passo é criar um propertiesFile
        - segundo passo é configurar as variáveis e seus respectivos valores no propertiesFile
        - terceiro passo é carregar o propertiesFile no applicationContext, através da anotação:
        <context: property-placeholder Location = "classpath:propertiesFile"/>
        - quarto passo é configurar no bean (no nosso exemplo, Gato) com:
        <property name = "nome" value = "${variavelQueEstaNopropertiesFile}" />
 */
        System.out.println(mamifero2.getNome());






        /* ==================== ** CONFIGURANDO POR ANNOTATIONS** =======================
==================================================================================================
        De fato, a configuração dos Beans via XML pode ser bastante verbosa em projetos maiores.
        As annotations minimizam as configurações no XML.

            - primeiro passo é permitir o component scanning no arquivo XML com:
            <context: component-scan base-package = "nomeDoPacote" />
            - segundo passo é adicionar @Component("idDoBean") nas classes Javas de implementação
            - terceiro passo é buscar o bean no container, da mesma forma que fizemos com XML:
            Objeto objeto = applicationContext.getBean("idDoBean", Interface.class);

            Faremos um exemplo desse com a classe Cavalo.

            PS: se não for fornecido um idDoBean em @Component, o padrão é o nome minúsculo da classe.
            No nosso exemplo, seria "cavalo".

            PS2: repare que não foi necessário criar um <bean> no XML, apenas com a anotação e seu id
            o Spring já reconhece com qual implementação ele deve criar o objeto.
 */

        Cavalo cavalo = applicationContext.getBean("cavalinho", Cavalo.class);
        System.out.println(cavalo.getClass().toString() + " " + cavalo.alimentacao());


/*        INJEÇÃO DE DEPENDÊNCIAS
          --------------------------------

          1. AUTOWIRING
          Funciona da seguinte forma:
            - Uma classe possui uma dependência anotada com @Autowired;
            - O Spring vai buscar por todos as @Components.
            - O Spring irá verificar se alguma classe anotada com @Components implementa a interface
            da dependência.
            - Caso sim, essa implementação é injetada.

            Podemos anotar com @Autowired:
                a. Um construtor;
                b. Um setter;
                c. Uma variável -> mais utilizado

            PS: diferente das injeções por configuração de XML, como visto anteriormente,
            o @Autowiring é bem menos verboso.

            PS2: E se exsitir mais de uma implementação da interface?? Podemos utilizar @Qualifier
            na dependência, indicando o bean da implementação preferida.
            ex:

            @Qualifier("idDaImplementacao")
            @Autowired
            private Petshop petshop;

            Faremos um exemplo com a classe Cavalo, que possui uma dependência de petShop.
*/

            System.out.println(cavalo.dataDoBanho()); //Indicamos ao Spring que gostaríamos de usar a PetshopParaGatos!
            System.out.println(cavalo.getNome());



/* ============================== ** CONFIGURANDO POR CLASSES JAVA** ===============================
====================================================================================================
        Ambas as connfigurações vistas anteriormente utilizam XML (a primeira mais, a segunda menos).

        E se não quisermos arquivos de config XML?

            - primeiro passo é criar uma classe Java com @Configuration, que vai substituir o XML
            - Adicionar suporte ao @ComponentScan (opcional)
            pois podemos, ao invés de usar @ComponentScan e @Components, configurar os Beans manualmente,
            através de @Bean.

            - segundo passo é ler a classe de configuração
            - quarto passo é buscar o bean do container.
            Há mudanças aqui. Faremos:

            AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ClasseConfig.class);

            Nós usaremos a classe MamiferoConfig e Macaco como exemplo (@ComponentScan)
            e a classe Baleia (@Bean).
*/

        AnnotationConfigApplicationContext applicationContext1 =
                new AnnotationConfigApplicationContext(MamiferoConfig.class);

        Mamifero macaco = applicationContext1.getBean("macaco", Mamifero.class);
        System.out.println(macaco.alimentacao() + " " + macaco.dataDoBanho());
        Baleia baleia = applicationContext1.getBean("baleia", Baleia.class);
        System.out.println(baleia.alimentacao() + " " + baleia.getIdade() + " " + baleia.dataDoBanho());
    }
}
