import java.util.ArrayList;
import java.util.List;

public class TheGame {
	

    private final Player player;
    private final List<Enemy> enemies;
    private final List<String> eventLog;

  

    public TheGame(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("kako je player null, ne može null, mjenjaj to");
        }
        this.player = player;
        this.enemies = new ArrayList<>();
        this.eventLog = new ArrayList<>();
    }

    

    public Player getPlayer() {
        return player;
    }
    public List<Enemy> getEnemies() {
        return enemies;
    }
    public List<String> getEventLog() {
        return eventLog;
    }

    

    public void addEnemy(Enemy e) {
        if (e == null) {
            throw new IllegalArgumentException("kako je enemy null, ne može null, mjenjaj to, momentalno");
        }
        for (Enemy existing : enemies) {
			if (existing.getX() == e.getX() && existing.getY() == e.getY()) {
				throw new IllegalArgumentException("ne mogu dva neprijatelja biti na istim koordinatama");
			}
        enemies.add(e);
        eventLog.add(String.format("Dodato: Enemy %s at (%d, %d)", e.getDisplayName(), e.getX(), e.getY()));
        }
    }

    
    public List<Enemy> findByType(String query) {
        List<Enemy> result = new ArrayList<>();
        String q = query.toLowerCase();

        for (Enemy e : enemies) {
            if (e.getType().toLowerCase().contains(q)) {
                result.add(e);
            }
        }
        return result;
    }

  
    

    public boolean checkCollision(Player p, Enemy e) {
        return p.intersects(e);
    }

    
    
    
    public List<Enemy> collidingWithPlayer() {
        List<Enemy> presjeci = new ArrayList<>();
        for (Enemy i : enemies) {
            if (checkCollision(player, i)) {
            	presjeci.add(i);
            }
        }
        return presjeci;
    }

    
    
    public void resolveCollisions() {
        for (Enemy i : collidingWithPlayer()) {
            decreaseHealth(player, i);
        }
    }

    
    public void decreaseHealth(Player p, Enemy e) {
        if (p == null || e == null) {
            throw new IllegalArgumentException("player i enemy ne mogu biti null");
        }
        
        int stariHelti = p.getHealth();
        int damage = e.getEffectiveDamage();
        int noviHelti = Math.max(0, stariHelti - damage);
        p.setHealth(noviHelti);

        String logMessage = String.format("Pogodak: Player by %s for %d -> HP %d -> %d",
                e.getDisplayName(), damage, stariHelti, noviHelti);
        eventLog.add(logMessage);
    }



    public static Enemy parseEnemy(String line) {
        try {
            String[] djelovi = line.split(";");
            if (djelovi.length != 5)
                throw new IllegalArgumentException("nepravilan format ulaznog stringa");

            String type = djelovi[0].trim();
            String[] pos = djelovi[1].split(",");
            int x = Integer.parseInt(pos[0].trim());
            int y = Integer.parseInt(pos[1].trim());
            String[] dim = djelovi[2].split("x");
            int w = Integer.parseInt(dim[0].trim());
            int h = Integer.parseInt(dim[1].trim());
            int damage = Integer.parseInt(djelovi[3].trim());
            String kind = djelovi[4].trim().toLowerCase();

            Collidable collider;

            if ("boss".equals(kind)) {
                collider = new RectangleCollider(x, y, w, h);
                return new BossEnemy(x, y, collider, type, damage, 100);
            } else if ("melee".equals(kind) || "enemy".equals(kind)) {
                collider = new RectangleCollider(x, y, w, h);
                return new MeleeEnemy(x, y, collider, type, damage, 100);
            } else if ("circle".equals(kind)) {
                collider = new CircleCollider(x, y, w / 2);
                return new Enemy(x, y, collider, type, damage, 100);
            } else {
                collider = new RectangleCollider(x, y, w, h);
                return new Enemy(x, y, collider, type, damage, 100);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("nepravilan format broja u ulaznom stringu");
        }
    }


    

    public void printEventLog() {
        System.out.println("*** EVENT LOG ***");
        for (String event : eventLog) {
            System.out.println(event);
        }
    }

    
    
    
    
    public static void main(String[] args) {
    	
        Player player = new Player(10, 5, new RectangleCollider(10, 5, 32, 32), " Petar   Petrović   ", 100);
        
        TheGame game = new TheGame(player);
        
        System.out.println("  INICIJALNO STANJE IGRAČA  ");
        System.out.println(player);
        System.out.println();
        
        Enemy enemy1 = new MeleeEnemy(11, 5, new RectangleCollider(12, 5, 16, 16), "Goblin", 20, 60);
        game.addEnemy(enemy1);
        String enemyInput = "Goblin King; 14,8; 32x32; 25; boss";
        
        Enemy enemy2 = parseEnemy(enemyInput);
        game.addEnemy(enemy2);
        
        
        Enemy enemy3 = new MeleeEnemy(11, 6, new RectangleCollider(11, 6, 8, 8), "gob", 12, 60);
        game.addEnemy(enemy3);

        
        System.out.println("   SVI NEPRIJATELJI   ");
        
        for (Enemy e : game.getEnemies()) {
            System.out.println(e);
        }
        
        System.out.println();
        System.out.println("    PRETRAGA: Neprijatelji tipa 'gob'   ");
        
        
        
        List<Enemy> found = game.findByType("gob");
        
        if (found.isEmpty()) {
            System.out.println("Nema neprijatelja tog tipa");
        } else {
            for (Enemy e : found) {
                System.out.println(e);
            }
        }
        
        
        
        System.out.println();
        System.out.println("   PROVJERA KOLIZIJA   ");
        
        
        for (Enemy e : game.getEnemies()) {
            boolean collision = game.checkCollision(player, e);
            System.out.printf("Sudara li se %s s igračem? %b%n", e.getDisplayName(), collision);
        }
        
        System.out.println();
        System.out.println("HP igrača pred kolizije: " + player.getHealth());
        game.resolveCollisions();
        System.out.println("HP igrača poslije kolizija: " + player.getHealth());
        System.out.println();
        game.printEventLog();
    }

 
 
    
}
