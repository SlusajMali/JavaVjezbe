public class BossEnemy extends Enemy {
	
    public BossEnemy(int x, int y, Collidable collider, String type, int damage, int health) {
        super(x, y, collider, type, damage, health);
    }
    
    
    @Override
    public int getEffectiveDamage() {
        return 2 * getDamage();
    }
    
    
    @Override
    public String toString() {
        return "BossEnemy[" + getType() + "] @ (" + getX() + ", " + getY() + ") [" + getCollider() + "] DMG=" + getDamage() + "x2 HP=" + getHealth();
    }
}
