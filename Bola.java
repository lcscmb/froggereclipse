public class Bola {
    double x;
    double y;
    double mark;
    static double vx = 2;
    static double vy = 2;
    int val = 0;
    Cor cor;
    int raio = 45;
    boolean marca2 = false, gameover = false;
    int moveLado = 0;
    
    public Bola(double _x, double _y, Cor _cor) {
        x = _x;
        y = _y;
        cor = _cor;
    }
    
    public void desenhar(Tela t) {
        t.circulo(x, y, raio, cor);
    }
    
    public boolean testaMovimento(double x, double y, int i, int Altura, int Largura){
        switch(i){
            case 1: if((y - 100) < 0) return false;
                    break;
            case 2: if((y + 100) > Altura) return false;
                    break;
            case 3 :if((x - 100 - raio) <= 0) return false;
                    break;
            case 4 :if((x + 100 + raio) >= Largura) return false;
                    break;
        }
        return true;
    }
    
    public void cima(double dt, int Altura){
        y -= Altura * (dt/vy);
        if(y <= mark-100){
            val = 0;
            y = mark-100;
            marca2 = false;
        }
    }
    
    public void baixo(double dt, int Altura){
        y += Altura * (dt/vy);
        if(y >= mark+100){
            val = 0;
            y = mark+100;
            marca2 = false;
        }
    }
    
    public void direita(double dt, int Largura){
        x += Largura * (dt/vx);
        if(x >= mark +100){
            val = 0;
            x = mark+100;
            marca2 = false;
        }
    }
    
    public void esquerda(double dt, int Largura){
        x -= Largura * (dt/vx);
        if(x <= mark-100){
            val = 0;
            x = mark-100;
            marca2 = false;
        }
    }
    
    public void movimenta(double dt, int Largura){
        if(moveLado == 1){
           x += Largura * (dt/vx);
        }
        else if(moveLado == 2){
           x += Largura * (dt/vx);
           if(x >= 100){
               x = 100;
               moveLado = 0;
            }
        }
        
        else if(moveLado == -1){
            x -= Largura * (dt/vx);
        }
        
        else if(moveLado == -2){
            x -= Largura * (dt/vx);
            if(x <= 700){
                x = 700;
                moveLado = 0;
            }
        }
    }    
}
