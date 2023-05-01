package es.usj.pcuesta.imagelibrary.main.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-05-01
 */
public class ImageGenerator {

    private int minWidth;
    private int minHeight;
    private int maxWidth;
    private int maxHeight;
    private int maxPrimitives;
    private Color[] colors;
    private Random random;

    public ImageGenerator(int minWidth, int minHeight, int maxWidth, int maxHeight, int maxPrimitives, Color[] colors) {
        this.minWidth = minWidth;
        this.minHeight = minHeight;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.maxPrimitives = maxPrimitives;
        this.colors = colors;
        this.random = new Random();
    }

    public void createImage(String filePath) {
        int width = random.nextInt(maxWidth - minWidth) + minWidth;
        int height = random.nextInt(maxHeight - minHeight) + minHeight;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D graphics = image.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);

        int numberOfPrimitives = random.nextInt(maxPrimitives) + 1;

        for (int i = 0; i < numberOfPrimitives; i++) {
            drawRandomPrimitive(graphics, width, height);
        }

        graphics.dispose();

        try {
            ImageIO.write(image, "jpg", new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void drawRandomPrimitive(Graphics2D graphics, int width, int height) {
        int primitiveType = random.nextInt(3);
        graphics.setColor(colors[random.nextInt(colors.length)]);

        switch (primitiveType) {
            case 0:
                drawRandomLine(graphics, width, height);
                break;
            case 1:
                drawRandomRectangle(graphics, width, height);
                break;
            case 2:
                drawRandomOval(graphics, width, height);
                break;
        }
    }

    private void drawRandomLine(Graphics2D graphics, int width, int height) {
        int x1 = random.nextInt(width);
        int y1 = random.nextInt(height);
        int x2 = random.nextInt(width);
        int y2 = random.nextInt(height);
        graphics.drawLine(x1, y1, x2, y2);
    }

    private void drawRandomRectangle(Graphics2D graphics, int width, int height) {
        int x = random.nextInt(width / 2);
        int y = random.nextInt(height / 2);
        int w = random.nextInt(width - x);
        int h = random.nextInt(height - y);
        graphics.drawRect(x, y, w, h);
    }

    private void drawRandomOval(Graphics2D graphics, int width, int height) {
        int x = random.nextInt(width / 2);
        int y = random.nextInt(height / 2);
        int w = random.nextInt(width - x);
        int h = random.nextInt(height - y);
        graphics.drawOval(x, y, w, h);
    }
}