public class Motinha {
    int gasosa = 5;
    int peças = 50;
    void mercanico(){
        System.out.println("pausa para o reparo");
        peças += 10;
    }
    void barruada(){
        System.out.println("me lasquei");
        peças -= 10;
    }
    void passear(){
        if(peças <= 10){
            System.out.println("preciso ir no mercânico");
        }
        if(gasosa >=1){
            System.out.println("dando um passeio");
            gasosa -=1;
        }else{
            System.out.println("preciso abastecer");
        }
    }
    void abastecer(){
        if(gasosa >= 5){
            System.out.println("o tanque está cheio");
        }else{
            gasosa+=1;
        }
    }
    public static void main(String[] args) {
        Motinha Pop = new Motinha();
    
        
    }
}
