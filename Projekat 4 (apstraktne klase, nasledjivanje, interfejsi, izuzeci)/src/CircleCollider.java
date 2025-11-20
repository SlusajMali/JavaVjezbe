public class CircleCollider implements Collidable {
	
	
    private int centerX; 
    private int centerY;
    private int poluprecnik;

    
    
    public CircleCollider(int centerX, int centerY, int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("batice, poluprecnik moraju biti vece od nule");
        }
        this.centerX = centerX;
        this.centerY = centerY;
        this.poluprecnik = radius;
    }

    
    
    public int getCenterX() {
    	return centerX; 
    }
    public int getCenterY() {
    	return centerY; 
    }
    public int getRadius() {
    	return poluprecnik; 
    }

    //organicavanje vrijednosti ovog intervala
    private static int ProvjeraPresjekaIvice(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
    
    

    @Override
    public boolean intersects(Collidable other) {
    	
        if (other instanceof CircleCollider) {
        	
            CircleCollider krug = (CircleCollider) other;
            
            int dx = this.centerX - krug.centerX;
            int dy = this.centerY - krug.centerY;
            int kvadratnoOdstojanje = dx * dx + dy * dy;
            int SumaPoluprecnika = this.poluprecnik + krug.poluprecnik;
            
            return kvadratnoOdstojanje <= SumaPoluprecnika * SumaPoluprecnika;
            
        } else if (other instanceof RectangleCollider) {
        	
            RectangleCollider rc = (RectangleCollider) other;
            
            int najblizeX = ProvjeraPresjekaIvice(this.centerX, rc.getX(), rc.getX() + rc.getWidth());
            int najblizeY = ProvjeraPresjekaIvice(this.centerY, rc.getY(), rc.getY() + rc.getHeight());
            int dx = this.centerX - najblizeX;
            int dy = this.centerY - najblizeY;
            
            return dx * dx + dy * dy <= poluprecnik * poluprecnik;
        }
        
        return false;
    }

    
    
    @Override
    public String toString() {
        return "Circle[" + centerX + "," + centerY + ", r=" + poluprecnik + "]";
    }
    
}
