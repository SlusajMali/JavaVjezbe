public abstract class GameObject {
	
	
    private int x, y;
    private Collidable collider;

    
    public GameObject(int x, int y, Collidable collider) {
        this.x = x;
        this.y = y;
        
        if (collider == null) {
            throw new IllegalArgumentException("NE dozvoljavam ovakvo nepostovanje, kako collider da bude null? Izmjeni to");
        }
        this.collider = collider;
    }

    
    
    public int getX() { 
    	return x; 
    }
    public int getY() { 
    	return y; 
    }
    public Collidable getCollider() { 
    	return collider; 
    }
    
    
    
    public void setX(int x) { 
    	this.x = x; 
    }
    public void setY(int y) { 
    	this.y = y; 
    }
    public void setCollider(Collidable collider) {
    	
        if (collider == null) {
            throw new IllegalArgumentException("NE dozvoljavam ovakvo nepostovanje, kako collider da bude null? Izmjeni to");
        }
        this.collider = collider;
    }

    
    
    public boolean intersects(GameObject other) {
        return this.collider.intersects(other.collider);
    }

    
    
    public abstract String getDisplayName();

    
    @Override
    public String toString() {
        return "GameObject @ (" + x + ", " + y + ") [" + collider + "]";
    }
}
