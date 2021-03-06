import java.awt.Rectangle;
import javax.swing.*;


public class Pea {
	public int x;
	public Game game;
	public int lane;
	
	public Pea(Game gm,int Lane,int startX){
		x = startX;
		this.lane = Lane;
		this.game = gm;
	}
	
	public void move(){
		Rectangle pRect = new Rectangle(x,120 + lane*120,28,28);
		for (int i = 0; i < game.laneZombies.get(lane).size(); i++){
			Zombie z = game.laneZombies.get(lane).get(i);
			Rectangle zRect = new Rectangle(z.x,109 + lane*120,400,120);
			if (pRect.intersects(zRect)){
				z.health -= 500;
				boolean exit = false;
				if (z.health < 0){
					game.laneZombies.get(lane).remove(i);
					Game.checkLevel(1);
					exit = true;
				}
				game.lanePeas.get(lane).remove(this);
				if (exit) break;
			}
		}
		x += 17;
	}
}

