import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class DrawSolar {
    public static void main(String[] args) {
        ShapeDrawer drawer = new ShapeDrawer(800, 800);

        // Create a dark background with stars
        drawer.setBackground(Color.BLACK);
        Random random = new Random();
        for (int i = 0; i < 200; i++) {
            int x = random.nextInt(800);
            int y = random.nextInt(800);
            drawer.drawPoint(new Point(x, y), Color.WHITE);
        }

        // Sun
        Point sunCenter = new Point(400, 400);
        Circle sun = new Circle(sunCenter, 100);
        drawer.drawCircle(sunCenter, sun.getRadius(), Color.ORANGE);

        // Earth's elliptical orbit
        Ellipse2D.Double earthOrbit = new Ellipse2D.Double(sunCenter.getX() - 150, sunCenter.getY() - 250, 300, 500);
        drawer.drawRing(sunCenter, 150, 250, Color.WHITE); // Earth's orbit ring

        // Earth
        Point earthCenter = getRandomPointOnEllipse(earthOrbit);
        Circle earth = new Circle(earthCenter, 20);
        drawer.drawCircle(earthCenter, earth.getRadius(), Color.BLUE);

        // Moon
        Point moonCenter = getRandomPointOnEllipse(new Ellipse2D.Double(earthCenter.getX() - 30, earthCenter.getY(), 60, 60));
        Circle moon = new Circle(moonCenter, 5);
        drawer.drawCircle(moonCenter, moon.getRadius(), Color.GRAY);

        // Mars' elliptical orbit
        Ellipse2D.Double marsOrbit = new Ellipse2D.Double(sunCenter.getX() - 250, sunCenter.getY() - 350, 500, 700);
        drawer.drawRing(sunCenter, 250, 350, Color.WHITE); // Mars' orbit ring

        // Mars
        Point marsCenter = getRandomPointOnEllipse(marsOrbit);
        Circle mars = new Circle(marsCenter, 15);
        drawer.drawCircle(marsCenter, mars.getRadius(), Color.RED);

        // Asteroids
        for (int i = 0; i < 10; i++) {
            Point asteroidCenter = new Point(random.nextInt(800), random.nextInt(800));
            Circle asteroid = new Circle(asteroidCenter, random.nextInt(5) + 2);
            drawer.drawCircle(asteroidCenter, asteroid.getRadius(), Color.GRAY);
        }

        // Save the image to a file
        try {
            drawer.saveToFile("solar_system.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Point getRandomPointOnEllipse(Ellipse2D.Double ellipse) {
        Random random = new Random();
        double x = ellipse.getX() + random.nextDouble() * ellipse.getWidth();
        double y = ellipse.getY() + random.nextDouble() * ellipse.getHeight();
        return new Point(x, y);
    }
}
