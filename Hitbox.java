public class Hitbox{
    
    double x, y, x2, y2;
    int larg;
    
    public Hitbox(double _x, double _y, double _x2, double _y2, int _larg){
        x = _x;
        y = _y;
        x2 = _x2;
        y2 = _y2;
        larg = _larg;
    }
    
    public boolean testaColisao(){
        
       if((x+45) > x2 && (x-45) < (x2 + larg)){
           
           if((y-45) > y2 && y < (y2 + 145)){
               return true;
           }
       }
        
       /*if(y == y2){
           if((x+45) > x2 && (x-45) < (x2 + larg)){
               return true;
           }
       }*/
        
        return false;
        
    }
    
}