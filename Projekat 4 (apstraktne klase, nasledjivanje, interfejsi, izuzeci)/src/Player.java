public class Player extends GameObject {
	
	
    private String name;
    private int health;

    
    public Player(int x, int y, Collidable collider, String name, int health) {
        super(x, y, collider);
        setName(name);
        setHealth(health);
    }

    public String getName() { 
    	return name; 
    }
    public int getHealth() {
    	return health; 
    }
   
    
    public void setName(String name) {
    	
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("ime za igraca ne moze bit prazno");
        }
        
        String[] rijeci = name.trim().split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (String rijec : rijeci) {
            if (!rijec.isEmpty()) {
            	builder.append(Character.toUpperCase(rijec.charAt(0))).append(rijec.substring(1).toLowerCase()).append(" ");
            }
        }
        
        String formatiran = builder.toString().trim();
        if (formatiran.isEmpty()) {
            throw new IllegalArgumentException("ime za igraca ne moze bit prazno");
        }
        this.name = formatiran;
    }

    
    public void setHealth(int health) {
        if (health < 0 || health > 100)
            throw new IllegalArgumentException("health mora bit u opsegu izmedju 0 i 100");
        this.health = health;
    }

    
    
    @Override
    public String getDisplayName() {
        return name;
    }

    
    @Override
    public String toString() {
        return "Player[" + name + "] @ (" + getX() + ", " + getY() + ") [" + getCollider() + "] HP=" + health;
    }
    
    
}
