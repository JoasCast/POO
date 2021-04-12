import java.util.ArrayList;

class Passageiro{
    String nome;
    int idade;

    public Passageiro(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String aux){
         this.nome=aux;
    }
    public int getIdade(){
        return idade;
    }
    public void setIdade(int aux){
         this.idade = aux;
    }
    public boolean prioridade(){
        if(idade >= 60){
            System.out.println("é prioridade");
            return true;
        }else{
            System.out.println("não é prioridade");
            return false;
        }
    }
    public String toString(){
        return "idade: " + idade + " nome: " + nome;  
    }
}
public class Topic {
    int capacidade;
    int cadeiraPre;
     ArrayList<Passageiro> normal;
     ArrayList<Passageiro> preferencial;

    public Topic(int capacidade, int cadeiraPre){
        this.capacidade = capacidade;
        this.cadeiraPre = cadeiraPre;
        normal = new ArrayList<>();
        for(int i=0; i < (this.capacidade - this.cadeiraPre); i++){
            normal.add(null);
        }
        preferencial = new ArrayList<>();
        for(int i=0; i < this.cadeiraPre; i++){
            preferencial.add(null);
        }
    }
    int acharLugar (ArrayList<Passageiro> passageiros ){
        
        for(int i = 0; i< passageiros.size(); i++){
            if(passageiros.get(i) == null){
                return i;
            }
        }
                return -1; 
    } 
    int acharPessoa(ArrayList<Passageiro> passageiros, String pessoa){
        for(int i = 0; i < passageiros.size(); i++){
            if(passageiros.get(i) != null && pessoa.equals(passageiros.get(i).nome)){
                return i;
            }
        }
        return -1;
    }
    void inserirPassageiro (String nome, int idade){
        Passageiro passageiro = new Passageiro(nome, idade);
        if(acharPessoa(preferencial, passageiro.getNome()) != -1){
            System.out.println("ja tamo na topic bro");
            return ;
        }
        if(acharPessoa(normal, passageiro.getNome()) != -1){
            System.out.println("ja tamo na topic bro");
            return; 
        }
        if(acharLugar(preferencial)  == -1 && acharLugar(normal) == -1){
            System.out.println("ta lotado bro");
            return;
        }
        if(passageiro.prioridade()){
            if(acharLugar(preferencial) == -1 && acharLugar(normal) != -1){
                System.out.println("n tem vaga preferencial bro, mas tem normal");
                normal.set(acharLugar(normal), passageiro); 
            }
               else if(acharLugar(preferencial) != -1){
                    System.out.println("tem vaga preferencial sim bro");
                    preferencial.set(acharLugar(preferencial), passageiro);
                }
            }else{ if(acharLugar(normal) != -1){
                    System.out.println("tem vaga normal sim bro");
                    normal.set(acharLugar(normal), passageiro);
                }
                else if(acharLugar(normal) == -1 && acharLugar(preferencial) != -1){
                    System.out.println("não tem vaga normal, mas tem preferencial bro");
                    preferencial.set(acharLugar(preferencial), passageiro);
                }
        }
        
    }
    void retiraPassageiro(String nome){
        int a = acharPessoa(normal, nome);
        if(a == -1){
            System.out.println("ta aqui n bro");
        }else{
        normal.remove(a);
        }
        int b =acharPessoa(preferencial, nome);
        if(b == -1){
            System.out.println("ta aqui n bro");
        }else{
        preferencial.remove(b);
        }
         }
    public String toString(){
        String retorno = "";
        for(Passageiro a : normal){
            if(a == null){
            retorno += "="; 
            }else{
                retorno += "=" + a + " ";
            }
        }
        for(Passageiro b : preferencial){
            if(b == null){
                retorno += "@";  
            }else{
                retorno += "@" + b +" ";
            }
            }
            return retorno + " "; 
    }
    public static void main(String[] args) {
        Topic topic = new Topic(50, 10);
    topic.inserirPassageiro("joas", 19);
    topic.inserirPassageiro("Eliano", 60);
    topic.inserirPassageiro("Hevelen", 17);
    topic.inserirPassageiro("Alanna",8);
    topic.inserirPassageiro("clelia", 60);
    topic.inserirPassageiro("João", 60);
    topic.inserirPassageiro("Ana", 60);
    topic.inserirPassageiro("Maria", 60);
    topic.inserirPassageiro("cauan", 60);
    topic.inserirPassageiro("Rafael", 60);
    topic.inserirPassageiro("carol", 60);
    topic.inserirPassageiro("Ari", 60);
    topic.inserirPassageiro("fulano", 60);
    topic.inserirPassageiro("Marcos", 60);
    topic.inserirPassageiro("Wermyssn", 60);
    topic.retiraPassageiro("carol");
    topic.retiraPassageiro("Alanna");
        System.out.println(topic);
      
    } 

    
}