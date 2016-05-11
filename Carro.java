public class Carro {
    double x; 
    double y;
    int largura;
    static int altura = 100;
    double vx;
    double vy;
    Cor cor;
    
    public Carro(double _x, double _y, int _largura, double _vx) {
        largura = _largura;
        vx = _vx;
        x = _x;
        y = _y;
        cor = new Cor(Math.random(), Math.random(), Math.random());
    }
    
    public void desenhar(Tela t) {
        t.retangulo(x, y, largura, altura, cor);
    }
    
    public void mover(double dt, int telaLargura){
        x += telaLargura * (dt/vx);
        if(telaLargura < x){
            x = -largura;
        }
    }
}