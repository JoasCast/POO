import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Fone{ 
    String id;
    String numero;

    Fone(String numero, String id){
        if(!validarNumero(numero)){
            System.out.println("erro");
            return;
        }
        this.numero = numero;
        this.id = id;
    }
    boolean validarNumero(String numero){
        String valido = "1234567890";
        for(int i = 0; i<numero.length(); i++){
        if(valido.contains(""+numero.charAt(i))== false){
            return false;
        }
    }
    return true;
    }
 
    public String toString(){
        return id + ":" + numero + "]";
    }
}
class Contato{
    String nome;
    ArrayList<Fone> fone;
    
    public Contato(String nome){
        this.nome = nome;
        this.fone = new ArrayList<>();
    } 
    public String toString (){
        String aux = "- " + this.nome + " ";
        int contador = 0;
        for(Fone telefone : this.fone){
            aux += "[" + contador + ":" + telefone.id + ":" + telefone.numero + "]";
            contador += 1;
        }
        return aux;
      }
}
class OrdemAlfabetica implements Comparator<Contato>{
    public int compare(Contato one, Contato two){
        return one.nome.compareTo(two.nome);
    }
    
}

public class Agenda{
    ArrayList<Contato> contatos;  
    public Agenda(){
        this.contatos = new ArrayList<Contato>();
    }  
    void agenda(){
        Collections.sort(contatos, new OrdemAlfabetica());
        for (Contato c : contatos){
            System.out.println("- " + c);
        }
    }
    public String toString(){
        return ""+ contatos;
    }
    void adicionarNumero(String name, String id, String numero){
        if (verContato(name) == true){
            acharContato(name).fone.add(new Fone(numero, id));
            return;
        }
    }
    void removerNumero(String name, String indice){
        if(verContato(name)==true){
            acharContato(name).fone.remove(Integer.parseInt(indice));
            return;
        }
    }
    void addContato(String name){
        if(verContato(name) == true){
            System.out.println("contato ja existe");
            return;
        }
        contatos.add(new Contato(name));
    }
    void removerContato(String s){
        int j= acharContatoPos(s);
        if(verContato(s) != true){
            System.out.println("contato n existe");
            return;
        }
        contatos.remove(j);
    }

    
    boolean verContato(String name){
        for(int i = 0; i < contatos.size(); i++){
            if(name.equals(contatos.get(i).nome)){
                return true;
            }
        }
        return false;
    }
    Contato acharContato(String name){
        for(int i = 0; i < contatos.size(); i++){
            if(name.equals(contatos.get(i).nome)){
                return contatos.get(i);
            }
        }
        return null;   
    }
    int acharContatoPos (String name){//acha o contato com o nome retorna a possição
        for(int i = 0; i < contatos.size(); i++){
            if(contatos.get(i).nome.equals(name)){
                return i;
            }
        }
        return -1;
    }
      void procura(String acha){
          ArrayList<Contato> auxiliar = new ArrayList<Contato>();
          for(Contato c : contatos){
              if(c.nome.contains(acha)){
                  auxiliar.add(c);
              }
              ArrayList<Fone> achaFone = c.fone;
              for(Fone f : achaFone){
                  if(f.numero.contains(acha)){
                      auxiliar.add(c);
                  }
                  if(f.id.contains(acha)){
                      auxiliar.add(c);
                  }
              }
          }
          for (Contato c : auxiliar) {
              System.out.println("-"+ c);
          }
          
      }
                                                                                                                                                             
    public static void main(String[] args) {
         Agenda agenda = new Agenda();
         agenda.addContato("wermy");
         agenda.addContato("joas");
         agenda.adicionarNumero("wermy", "tim", "8892183");
         agenda.adicionarNumero("wermy", "atim", "834183");
         agenda.adicionarNumero("wermy", "saude", "9102183");
         agenda.removerNumero("wermy", "1");
         System.out.println(agenda);
    }
}