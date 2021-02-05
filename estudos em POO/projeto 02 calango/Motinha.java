public class Motinha {
    int gasosa;
    int peças;
    boolean bater;
    Motinha(int gasosa, int peças){
        this.gasosa = gasosa;
        this.peças = peças;
        this.bater = false;
    }
    void mercanico(){
        System.out.println("pausa para o reparo");
        peças += 10;
    }
    void barruada(Motinha other){
        if(other.peças >= 10){
            System.out.println("não posso andar");
        }
        if(this.bater){
        System.out.println("bati na bis");
        other.peças -= 10;}
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
        Motinha pop = new Motinha(5, 50);
        Motinha bis = new Motinha(5, 50);
        bis.passear();
        pop.passear();
    }
}
