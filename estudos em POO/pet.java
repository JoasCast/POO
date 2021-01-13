public class pet {
    int energia;
    boolean estaVivo;
    int felicidade;
    int alimentação;
    int energiaMax;
    int alimentaçãoMax;
    pet(int energia, boolean estaVivo, int felicidade, int alimentação){
        this.energia = energia;
        this.estaVivo = true;
        this.felicidade = felicidade;
        this.alimentação = alimentação;
        this.energiaMax = 100;
        this.alimentaçãoMax = 100;
     }
     void comer(){
         if(alimentação <= 0){
             estaVivo = false;
         }else if(alimentação == alimentaçãoMax){
             System.out.println("esatou cheio");
         }else {
             System.out.println("hummm delicia");
             alimentação += 20;
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
        }else if(alimentação <= 30){
            System.out.println("estou com muita fome não posso brncar");
        }else {
            System.out.println("brincar é muito divertido");
            felicidade += 20;
            energia -= 10;
        }if(energia <= 0){
            estaVivo = false;
        }
    }
    public String toString(){
        return "pet : energia" + energia + estaVivo + "feliz" + felicidade + "fome"+ alimentação;
    }
    public static void main(String[] args) {
        pet bob = new pet(100,true, 100, 100);
        bob.jogar();
        bob.jogar();
    }
    
}
