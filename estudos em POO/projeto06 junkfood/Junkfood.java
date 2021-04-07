import java.util.ArrayList;

class Espiral {
    String nome;
    int qtd;
    float preco;

    public Espiral(String nome, int qtd, float preco) {
        this.nome = nome;
        this.qtd = qtd;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getQTD() {
        return qtd;
    }

    public float getPreco() {
        return preco;
    }
    public int getQTDconta(){
        return qtd --;
    }

    public String toString() {
        return "nome :" + nome + "quantidade :" + qtd + "preco :" + preco;
    }
}

public class Junkfood {
    private ArrayList<Espiral> espiral = new ArrayList<>();
    private float saldoCliente = 0.0f;
    private int maxProduto = 0;
    private int qtdEspirais;

    public Junkfood(int maxProduto, int qtdEspirais) {
        this.maxProduto = maxProduto;
        this.qtdEspirais = qtdEspirais;
        for (int i = 0; i < qtdEspirais; i++) {
            espiral.add(new Espiral(" - ", 0, 0f));
        }
    }

    public String toString() {
        String saida = "";
        for (Espiral f : espiral){
        saida += f + "\n";
        System.out.println(saida);
        }
        return saida + "saldo : " + saldoCliente;
    }

    public void inserirDinheiro(float dinheiro) {
        saldoCliente += dinheiro;
    }

    public void pedirTroco() {
        saldoCliente = 0;
        System.out.println("saldo :" + saldoCliente);
    }

    public void vender(int indice) {
        if (indice > qtdEspirais) {
            System.out.println("fall: não existe essa espiral");
        } else if (espiral.get(indice).getPreco() > saldoCliente) {
            System.out.println("fall: sem grana bro");
        }else if(espiral.get(indice).getNome().equals("-")){
            System.out.println("fall: prududo não existe bro"); 
        }else if(espiral.get(indice).getQTD() == 0){
            System.out.println("fall: sem conteudo bro");
        }else{
           saldoCliente -= espiral.get(indice).getPreco();
           System.out.println("você comprou o produto " + espiral.get(indice).getNome());
           espiral.get(indice).getQTDconta();
        }
    }

    public void alterarEspiral(int indice, String nome, int qtd, float preco) {
        if (indice > qtdEspirais) {
            System.out.println("fall: indice incorreto");
        } else if (maxProduto < qtd) {
            System.out.println("fall: muito produto");
        } else {
            espiral.set(indice, new Espiral(nome, qtd, preco));
        }
    }

    public void limparEspiral(int indice) {
        if (qtdEspirais < indice) {
            System.out.println("fall: indice incorreto");
        } else {
            espiral.set(indice, new Espiral("-", 0, 0f));
        }
    }

    public static void main(String[] args) {
       Junkfood junkfood = new Junkfood(3, 5);
       System.out.println(junkfood);
       junkfood.alterarEspiral(1, "xaverde", 3, 5f);
       junkfood.inserirDinheiro(5f);
       junkfood.inserirDinheiro(4f);
       System.out.println(junkfood);
       junkfood.pedirTroco();
       System.out.println(junkfood);
       junkfood.inserirDinheiro(8f);
       junkfood.vender(1);
       junkfood.vender(1);
       System.out.println(junkfood);
    }
}
