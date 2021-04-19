import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;
class Operacao{
    int id;
    String nome;
    float valore;
    float saldo;
    public Operacao(int id, String nome, float valore, float saldo){
        this.id = id;
        this.nome = nome;
        this.valore = valore;
        this.saldo = saldo;
    }
    public String toString(){
        return id + ": " + nome + ": " + valore + ": " + saldo; 
    }
}
class Conta{
    int id;
    int idConta;
    String nome;
    float saldo;
    ArrayList<Operacao> extrato;
    ArrayList<String> estorno;;
    public Conta(String nome, int idConta){
        this.id = 0;
        this.idConta = idConta;
        this.nome = nome;
        this.saldo = 0;
        this.extrato = new ArrayList<>();
        this.estorno = new ArrayList<>();
    }
    void retirarDin(int retira){
        if(retira<=0){
            throw new RuntimeException("n retirando nada");
        }
        if(retira >= this.saldo){
            throw new RuntimeException("saldo insulficiente");
        }
        this.saldo-=retira;
        this.extrato.add( new Operacao(this.id, "saque", retira, this.saldo));
        id += 1;
    }
    void colocarDin(int coloca){
        if(coloca<=0){
            throw new RuntimeException("n esta colocando nada");
        }
        this.saldo+=coloca;
        this.extrato.add(new Operacao(this.id, "deposito", coloca, this.saldo));
        this.id += 1;
    }
    void TransferirDinSai(int saida){
        if(saida<=0){
            throw new RuntimeException("n tem como transferir nd");
        }
        if(saida< this.saldo){
            throw new RuntimeException("saldo insulficiente para transferir");
        }
        this.saldo-=saida;
        this.extrato.add(new Operacao(this.id, "tranferencia saida", saida, this.saldo));
        this.id += 1;
    }
    void transferirDinEntra(int entrada){
        if(entrada <= 0){
            throw new RuntimeException("n tem como transferir nd (entra)");
        }
        saldo+=entrada;
        this.extrato.add(new Operacao(this.id, "trasferencia entrada", entrada, this.saldo));
        this.id+=1;
    }
    void extratoTotal(){
        for(int i = 0; i < extrato.size(); i++){
            System.out.println(extrato.get(i));
        }
    }
    void taxa(int tarifa){
        if(tarifa <= 0){
            throw new RuntimeException("tarifa igual 0)");
        }
        if(tarifa > this.saldo){
            throw new RuntimeException("saldo insulficiente");
        }
        this.saldo+=tarifa;
        this.extrato.add(new Operacao(this.id, "tarifa", tarifa, this.saldo));
        this.id+=1;
    }
    void pulaTempo(){
        this.saldo +=0;
    }
}
class ContaCorre extends Conta{
    public ContaCorre(String nome, int idConta){
        super(nome, idConta);
    }
    void pulaTempo(){
        this.saldo -= 20;
        this.extrato.add(new Operacao(this.id, "taxa", (-20), this.saldo));
        this.id += 1;
    }
    public String toString(){
        return idConta + nome + this.saldo + "ContaC";
    }
}
class ContaPoup extends Conta{
    public ContaPoup(String nome, int idConta){
        super(nome, idConta);
    }
    void pulaTempo(){
        this.saldo -= this.saldo/100;
        pulaTempoExtra();
    }
    void pulaTempoExtra(){
        this.extrato.add(new Operacao(this.id, "taxa", (-20), this.saldo));
        this.id += 1;
    }
    public String toString(){
        return idConta + nome + this.saldo + "ContaP";
    }
}
class Cliente{
    String nome;
    Map<String, Conta> contas;
    public Cliente(String nome){
    this.nome = nome;
    this.contas = new TreeMap<>();
    }
    boolean verconta(String id){
        if(contas.get(id) == null){
            return false;
        }
        return true;
    }
    Conta acharConta(String id){
        if(verconta(id)==false){
            throw new RuntimeException("conta não existe");
        }
        return contas.get(id);  
    }
}
public class Cadastro{
    Map<String, Cliente> clientes;
     Map<String, Conta> contas;
     String lastId;
     Cadastro(){
         this.contas = new TreeMap<>();
         this.clientes = new TreeMap<>();
         this.lastId = "-1";
     }
     boolean verConta(String s){
         if(contas.get(s)==null){
             return  false;
         }
         return true;
     }
     Conta acharConta (String s){
         if(verConta(s)==false){
            throw new RuntimeException("conta não existe");
         }
         return contas.get(s);
     }
     boolean verCliente(String nome){
         if(clientes.get(nome) == null){
             return false;
         }
         return true;
     }
     Cliente acharCliente(String nome){
         if(verCliente(nome)==false){
            throw new RuntimeException("cliente não existe");
         }
         return clientes.get(nome);
     }
     String gerarId(){
         this.lastId = String.valueOf(Integer.parseInt(lastId)+1);
         return this.lastId;
     }
     void addCliente(String nome){
         if(verCliente(nome)== true){
            throw new RuntimeException("cliente já existe");
         }
         clientes.put(nome, new Cliente(nome));
         String idContaC = gerarId();
         String idContaP = gerarId();
         Conta contaC = new ContaCorre(nome, Integer.parseInt(idContaC));
         Conta contaP = new ContaPoup(nome, Integer.parseInt(idContaP));
         this.contas.put(idContaC, contaC);
         this.contas.put(idContaP, contaP);
         Cliente cliente = acharCliente(nome);
         cliente.contas.put(idContaC, contaC);
         cliente.contas.put(idContaP, contaP);
     }
     void retirarDin(String s, String retira){
         Conta conta = acharConta(s);
         int retirar = Integer.parseInt(retira);
         conta.retirarDin(retirar);
     }
     void colocarDin(String s, String coloca){
         Conta conta = acharConta(s);
         int colocar = Integer.parseInt(coloca);
         conta.colocarDin(colocar);
     }
     void transferirDin(String r, String s, String retira){
         int retirar = Integer.parseInt(retira);
         Conta contaR = acharConta(r);
         Conta contaS = acharConta(s);
         contaR.TransferirDinSai(retirar);
         contaS.transferirDinEntra(retirar);
     }
     void visualizarConta(){
         for(Map.Entry<String, Conta> entry : this.contas.entrySet()){
             System.out.println("conta" + entry.getValue());
         }
     }
     void visualizarCliente(){
         for(Map.Entry<String, Cliente> entry : this.clientes.entrySet()){
             System.out.println("cliente" + entry.getValue());
         }
     }
     void extrato(String id){
        Conta conta = acharConta(id);
        conta.extratoTotal();
        }
     void taxa(String id, String vale){
            Conta conta = acharConta(id);
            int valor = Integer.parseInt(vale);
            conta.taxa(valor);
        }
        void pulaTempo(){
            for(Map.Entry<String, Conta> entry : this.contas.entrySet()){
                entry.getValue().pulaTempo();
            }
        }
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        cadastro.addCliente("Almir");
        cadastro.addCliente("Julia");
        cadastro.addCliente("Maria");
        cadastro.visualizarConta();
        cadastro.colocarDin("0", "100");
        cadastro.colocarDin("1", "200");
        cadastro.colocarDin("2", "50");
        cadastro.colocarDin("3", "300");
        cadastro.retirarDin("3", "50");
        cadastro.retirarDin("0", "70");
        cadastro.visualizarConta();
        cadastro.visualizarConta();
        cadastro.pulaTempo();
        cadastro.visualizarConta();
        cadastro.extrato("3");
        cadastro.taxa("3", "20");
        cadastro.taxa("3", "20");
        cadastro.extrato("3");
        
    }
}