import java.util.Random;

class inseto{
    int tamanho;
    int energia;

    inseto(int tamanho, int energia){
        this.tamanho= tamanho;
        this.energia= energia;
    }
    public String toString(){
        return "T:" + this.tamanho + "E:" + this.energia;
    }
}
public class calango {
    inseto bucho;
    int energia; //atributo
    int Maxenergia;
    int npatas;
    boolean estaVivo;
    boolean temRabo;
    boolean ehomem;
    String nome;
    //parametros
    calango(String nome, int energia, int npatas, boolean ehomem){
        this.nome = nome;
        this.energia = energia;
        this.Maxenergia = energia;
        this.estaVivo = true;
        this.temRabo = true;
        this.bucho = null;
        this.ehomem = ehomem;
    }
    void comer(inseto inseto){
        if(bucho != null){
            System.out.println("barriga cheia");
            return;
        }
        bucho = inseto;
    }
    calango coitar(calango other){
        if(!this.estaVivo || !other.estaVivo){
            System.out.println("calango morto");
            return null;
        }if(this.ehomem == other.ehomem) {
            System.out.println("não reproduz");
            return null;
        }Random random = new Random();
        String nome = this.nome.substring(0, this.nome.length()/2);
        nome += other.nome.substring(other.nome.length()/2);
        return new calango(10, 4, random.nextBoolean());

    }
    inseto vomitar(){
        if(bucho == null){
        System.out.println("to com fome");
        return null;
      }
      inseto aux = bucho;
      bucho = null;
      return aux;
    }
    void digerir(){
    if(bucho == null){
        System.out.println("Barriga esta vazia");
        return;
    }
    this.energia += bucho.energia;
    bucho.energia = 0;
    bucho = null; //evacuo
}

    void correr(){
        if(npatas>2){
            System.out.println("não posso correr no momento");
        }
        if(energia > 0){
        System.out.println("dando uma carreira");
        energia-=1;
        }else{
            System.out.println("não da mais");
        }
    }
    void descansar(int turnos){
        System.out.println("pausa pra água");
        energia += turnos;
        if(energia > Maxenergia){
        energia = Maxenergia;} 
    }
    void pancada(calango other){
        if(!this.estaVivo){
            System.out.println("RIP");
            return;
        }
        if(other.npatas>0){
            other.npatas-=1;
            System.out.println("tirei tua pata");
        }else if(other.temRabo){
            temRabo = false;
            System.out.println("arranquei teu rabo");
        }else {
            other.estaVivo = false;
            System.out.println("comi seu coração :(");
        }
    }
    void regenerar(){
        if(!estaVivo){
            System.out.println("morri");
            return ;
        }
        if(npatas<4){
            npatas+=1;
            System.out.println("pata nova");
        }else if(!temRabo){
            temRabo = true;
            System.out.println("olha a raba");
        }else{
            System.out.println("ja tô pronto pra outra");
        }
    }
    public String toString(){
        return "calango" + nome + "energia:" + energia + "patas" + npatas + "rabo" + this.temRabo + "bucho" + bucho;
    }
    public static void main(String[] args){
     //tipo nome da variavel = valor float f = 5.4f; int x = 5;
      calango Jeff = new calango("Jeff", 20, 4, true);
      calango Karla = new calango("Karla", 15, 4, false);
      Jeff.coitar(Karla);
      calango bebe = Jeff.coitar(Karla);
      System.out.println(bebe);
    }
}
