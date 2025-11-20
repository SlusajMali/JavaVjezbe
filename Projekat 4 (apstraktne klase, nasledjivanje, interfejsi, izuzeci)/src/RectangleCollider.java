public class RectangleCollider implements Collidable {
	
	
	
    private int x;
    private int y;
    private int width;
    private int height;

    
    
    public RectangleCollider(int x, int y, int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("batice, velicine moraju biti vece od nule");
        }
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    
    
    public int getX() { 
    	return x; 
    }
    public int getY() { 
    	return y; 
    }
    public int getWidth() {
    	return width; 
    }
    public int getHeight() { 
    	return height;
    }

    
    
    @Override
    public boolean intersects(Collidable other) {
    	
        if (other instanceof RectangleCollider) {
        	
            RectangleCollider provaougaonik = (RectangleCollider) other;
            
            return this.x < provaougaonik.x + provaougaonik.width &&  this.x + this.width > provaougaonik.x && 
            		this.y < provaougaonik.y + provaougaonik.height && this.y + this.height > provaougaonik.y;
                  
        } else if (other instanceof CircleCollider) {
            return other.intersects(this); 
        }
        
        return false;
    }

    
    @Override
    public String toString() {
        return "Rectangle[" + x + "," + y + ", " + width + "x" + height + "]";
    }
}
