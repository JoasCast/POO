class pessoa{
    String nome;
    fone fone;
    pessoa(String nome){
        this.nome = nome;
        this.fone = new fone();
    }
    void ouvirMusica(String nomeMusica, int numeroMusica){
        this.fone.setBateria(10*numeroMusica);
        System.out.println("Estou ouvindo " + nomeMusica + "\nMe restam: " + this.fone.bateria + "% de bateria");
    }
    
    public String toString(){
        return "nome: " + nome;
    }
}
public class fone {
       int volume;
       int bateria;
       int volumeMaximo;
       int bateriaMaxima;
       public fone(){
        this.volumeMaximo=100;
        this.bateriaMaxima=100;
        this.volume=volumeMaximo;
        this.bateria=bateriaMaxima;
           
       }
       void setBateria(int entrada){
        this.bateria -= entrada;
        if(this.bateria < 0){
            this.bateria = 0;
            System.out.println(bateria);
        }
        if(this.bateria > this.bateriaMaxima){
            this.bateria = this.bateriaMaxima;
            System.out.println(bateria);
        }
        }
        void setMudaVolume(int entrada){
            volume+=entrada;
            if(volume<0){
                volume=0;
                System.out.println("volume minimo");  
            }
            if(volume>volumeMaximo){
                volume=volumeMaximo;
                System.out.println("volume maximo");
            }    
        }
       void  aumentarVolume(int entrada){
           volume += entrada;
           System.out.println(volume + " %");
           if(volume == volumeMaximo){
               System.out.println("volume já esta no maximo");
           }else{if(bateria == 0){
               System.out.println("sem bateria");
           }else{
               volume += 10;
           }
        }
       }
       void  abaixarVolume(int entrada){
           volume += entrada;
           System.out.println(volume + " %");
        if(volume == 0){
            System.out.println("volume já esta no minimo");
        }else{if(bateria == 0){
            System.out.println("sem bateria");
        }else{
            volume -= 10;
        }
     }
    }
    void recarregar(int minutos){
        setBateria(-(5*minutos));
        System.out.println("Me restam: " + this.bateria + "% de bateria");
    }
    public String toString(){
        return "vol :" + volume + "bateria :" + bateria;
    }
    public static void main(String[] args) {
        pessoa joas = new pessoa("Joás");
        joas.ouvirMusica("União Flasco", 6);
        joas.fone.recarregar(2);
        joas.fone.recarregar(4);
        joas.fone.aumentarVolume(20);
        joas.fone.abaixarVolume(20);
    }
}