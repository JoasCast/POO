public class Pet {
    int energia;
    boolean estaVivo;
    int felicidade;
    int alimentacao;
    int energiaMax;
    int alimentacaoMax;
    Pet(int energia, boolean estaVivo, int felicidade, int alimentacao){
        this.energia = energia;
        this.estaVivo = true;
        this.felicidade = felicidade;
        this.alimentacao = alimentacao;
        this.energiaMax = 100;
        this.alimentacaoMax = 100;
     }
     void comer(){
         if(alimentacao <= 0){
             estaVivo = false;
         }else if(alimentacao == alimentacaoMax){
             System.out.println("esatou cheio");
         }else {
             System.out.println("hummm delicia");
             alimentacao += 20;
         }
     }
    void dormir(){
        if(energia == energiaMax ){
            System.out.println("já dormi demais");
            energia = energiaMax;
        }else{
            System.out.println("a mimnir");
            energia += 20;
        }
    }
    void jogar(){
        if(!estaVivo){
            System.out.println("não posso brincar pq morri");
        }else if(energia <= 30){
            System.out.println("estou muito cansado pra brincar");
        }else if(alimentacao <= 30){
            System.out.println("estou com muita fome não posso brncar");
        }else if(energia <= 0){
            estaVivo = false;
        } else{
            System.out.println("brincar é muito divertido");
            felicidade += 20;
            energia -= 10;
        }
    }
    public String toString(){
        return "pet : energia" + energia + estaVivo + "feliz" + felicidade + "fome"+ alimentacao;
    }
    public static void main(String[] args) {
        Pet bob = new Pet(100,true, 100, 100);
        bob.jogar();
        bob.jogar();
        bob.dormir();
        bob.comer();
    }
    
}
