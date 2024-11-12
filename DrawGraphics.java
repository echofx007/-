import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
    ArrayList<Mover> movingSprite = new ArrayList<>();

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        Rectangle box1 = new Rectangle(15, 20, Color.RED);
	Oval ov1 = new Oval(10, 20, Color.BLUE);
	Rectangle box2 = new Rectangle(10, 20, Color.YELLOW);
	Oval ov2 = new Oval(15, 20, Color.GREEN);
        movingSprite.add(new Bouncer(100, 170, box1));
	movingSprite.add(new Bouncer(100, 170, ov1));
	movingSprite.add(new StraightMover(100, 170, box2));
	movingSprite.add(new StraightMover(100, 170, ov2));
	movingSprite.get(0).setMovementVector(3,1);
	movingSprite.get(1).setMovementVector(-1,3);
        movingSprite.get(2).setMovementVector(-3,-1);
	movingSprite.get(3).setMovementVector(3,-1);
    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
        for (Mover a : movingSprite) {
	    a.draw(surface);
    }

}
}
