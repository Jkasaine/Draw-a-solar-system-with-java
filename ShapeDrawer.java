import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ShapeDrawer {
    private BufferedImage image;
    private Graphics2D graphics;

    public ShapeDrawer(int width, int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
    }

    public void drawCircle(Point center, double radius, Color color) {
        graphics.setColor(color);
        int x = (int) Math.round(center.getX() - radius);
        int y = (int) Math.round(center.getY() - radius);
        int diameter = (int) Math.round(radius * 2);
        graphics.fillOval(x, y, diameter, diameter);
    }

    public void drawRing(Point center, double innerRadius, double outerRadius, Color color) {
        graphics.setColor(color);
        int x = (int) Math.round(center.getX() - outerRadius);
        int y = (int) Math.round(center.getY() - outerRadius);
        int diameter = (int) Math.round(outerRadius * 2);
        graphics.drawOval(x, y, diameter, diameter);

        // Decrease the inner radius to make the ring thinner
        x = (int) Math.round(center.getX() - innerRadius);
        y = (int) Math.round(center.getY() - innerRadius);
        diameter = (int) Math.round(innerRadius * 2);
        graphics.drawOval(x, y, diameter, diameter);
    }


    public void drawPoint(Point point, Color color) {
        graphics.setColor(color);
        int x = (int) Math.round(point.getX());
        int y = (int) Math.round(point.getY());
        graphics.drawLine(x, y, x, y);
    }

    public void saveToFile(String filename) throws IOException {
        ImageIO.write(image, "png", new File(filename));
    }

    public void setBackground(Color backgroundColor) {
        graphics.setColor(backgroundColor);
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
    }

}
