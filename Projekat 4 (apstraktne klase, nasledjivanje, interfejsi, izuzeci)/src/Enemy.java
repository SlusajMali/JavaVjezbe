public class Enemy extends GameObject implements Attacker {


    private String tip;
    private int damage;
    private int health;

    
    
    public Enemy(int x, int y, Collidable collider, String type, int damage, int health) {
        super(x, y, collider);
        setType(type);
        setDamage(damage);
        setHealth(health);
    }
    

    public String getType() {
        return tip;
    }
    public int getDamage() {
        return damage;
    }
    public int getHealth() {
        return health;
    }

    
    public void setType(String type) {
    	
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("tip neprijatelja ne može biti prazan");
        }
        this.tip = type.trim();
    }

    
    public void setDamage(int damage) {
        if (damage < 0 || damage > 100) {
            throw new IllegalArgumentException("damage mora biti u opsegu između 0 i 100");
        }
        this.damage = damage;
    }

    
    public void setHealth(int health) {
        if (health < 0 || health > 100) {
            throw new IllegalArgumentException("health mora biti u opsegu između 0 i 100");
        }
        this.health = health;
       
    }

    
    @Override
    public int getEffectiveDamage() {
        return damage;
    }

    
    @Override
    public String getDisplayName() {
        return tip;
    }

    
    @Override
    public String toString() {
        return "Enemy[" + tip + "] @ (" + getX() + ", " + getY() + ") [" + getCollider() + "] DMG=" + damage + " HP=" + health;
    }

}
