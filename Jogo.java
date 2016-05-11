import java.util.HashSet;

public class Jogo {
    
    Bola sapo;
    Carro[] car;
    Hitbox Hitbox;
    int vida = 3, pt = 0;
    boolean marca;
    
    
    public Jogo(){
        sapo = new Bola(getLargura()/2,getAltura() - 50, new Cor(0, 255, 0));
        car = new Carro [9];
        car[0] = new Carro(100.0, 100.0, 100, 5); //o 2 é a porra da velocidade
        car[1] = new Carro(500.0, 100.0, 100, 5); //o 2 é a porra da velocidade
        car[2] = new Carro(200.0, 200.0, 150, 2); //o 2 é a porra da velocidade
        car[3] = new Carro(0.0, 300.0, 60, 8); //o 2 é a porra da velocidade
        car[4] = new Carro(350.0, 300.0, 60, 8); //o 2 é a porra da velocidade
        car[5] = new Carro(700.0, 300.0, 60, 8); //o 2 é a porra da velocidade
        car[6] = new Carro(50.0, 400.0, 60, 6); //o 2 é a porra da velocidade
        car[7] = new Carro(300.0, 400.0, 60, 6); //o 2 é a porra da velocidade
        car[8] = new Carro(600.0, 400.0, 60, 6); //o 2 é a porra da velocidade
    }
    public String getTitulo() {
        return "Frogger";
    }
    
    public int getLargura() {
        return 800;
    }
    
    public int getAltura() {
        return 600;
    }
    
    public void tique(HashSet<String> teclas, double dt) {
        for(int i = 0 ; i < 9 ; i++){
            car[i].mover(dt, getLargura());
        }
        if(sapo.val == 1 && sapo.marca2 == true && sapo.moveLado == 0 ){
            if(marca == true){
                sapo.mark = sapo.y;
                marca = false;
            }
            sapo.cima(dt, getAltura());
        }
        else if(sapo.val == 2 && sapo.marca2 == true && sapo.moveLado == 0){
            if(marca == true){
                sapo.mark = sapo.y;
                marca = false;
            }
            sapo.baixo(dt, getAltura());
        }
        else if(sapo.val == 3 && sapo.marca2 == true && sapo.moveLado == 0){
            if(marca == true){
                sapo.mark = sapo.x;
                marca = false;
            }
            sapo.esquerda(dt, getLargura());
        }
        else if(sapo.val == 4 && sapo.marca2 ==true && sapo.moveLado == 0){
            if(marca == true){
                sapo.mark = sapo.x;
                marca = false;
            }
            sapo.direita(dt, getLargura());
        }
        
        else if(sapo.moveLado > 0){
            if(sapo.x > 850){
                sapo.moveLado = 2;
                sapo.x = -50;
            }
            sapo.movimenta(dt, getLargura());
        }
        
        else if(sapo.moveLado < 0){
            if(sapo.x < - 50){
                sapo.moveLado = -2;
                sapo.x = 850;
            }
            sapo.movimenta(dt, getLargura());
        }

        
        for(int i = 0 ; i < 9 ; i++){
            Hitbox = new Hitbox(sapo.x, sapo.y, car[i].x, car[i].y, car[i].largura);
            if(Hitbox.testaColisao() == true){
                vida --;
                sapo = new Bola(getLargura()/2,getAltura() - 50, new Cor(0, 255, 0));
                if(vida == 0) sapo.gameover = true;
            }
        }
        
        //System.out.println(sapo.y);
    }
    
    public void desenhar(Tela tela) {
        for(int i = 0 ; i < 9 ; i++){
            car[i].desenhar(tela);
        }
        tela.retangulo(0, getAltura()-600, getLargura(), 100, new Cor(255,228,225));
        tela.retangulo(0, 500, getLargura(), 100, new Cor(255,228,225));
        sapo.desenhar(tela);
        tela.texto("" + vida, getLargura() - 100, getAltura() - 35, 60, new Cor(0,139,139));
        tela.texto("" + pt, 100, getAltura() - 35, 60, new Cor(0,139,139));
        if(sapo.gameover){
            tela.texto("GAME OVER", 65, getAltura()/2, 100, new Cor(178,34,34)); 
        }
    }
    
    public void tecla(String tecla) {
        if(sapo.marca2 == false && sapo.gameover == false && sapo.moveLado == 0){
            if(tecla.equals("w")){
                sapo.val = 1;
                if(sapo.testaMovimento(sapo.x, sapo.y, sapo.val, getAltura(), getLargura()) == true){
                    marca = sapo.marca2 = true;
                }
            }
            if(tecla.equals("s")){
                sapo.val = 2;
                if(sapo.testaMovimento(sapo.x, sapo.y, sapo.val, getAltura(), getLargura()) == true){
                    marca = sapo.marca2 = true;
                }
            }
            if(tecla.equals("a")){
                sapo.val = 3;
                if(sapo.testaMovimento(sapo.x, sapo.y, sapo.val, getAltura(), getLargura()) == true){
                    marca = sapo.marca2 = true;
                }
                else{
                    sapo.moveLado = -1;
                }
            }
            if(tecla.equals("d")){
                sapo.val = 4;
                if(sapo.testaMovimento(sapo.x, sapo.y, sapo.val, getAltura(), getLargura()) == true){
                    marca = sapo.marca2 = true;
                }
                else{
                    sapo.moveLado = 1;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        new Motor(new Jogo());
    }
}