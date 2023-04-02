import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickersGeneration {
    public void Create(InputStream inputStream, String fileName) throws Exception
    {
        // var imageOriginal = ImageIO.read(new File("../entry/movie_large.jpg"));
        // var inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
        var imageOriginal = ImageIO.read(inputStream);

        int width = imageOriginal.getWidth();
        int height = imageOriginal.getHeight();
        int newHeight = height + 200;
        var newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        var graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(imageOriginal, 0, 0, null);

        ImageIO.write(newImage, "png", new File("../output/" + fileName));

        var text = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.RED);
        graphics.setFont(text);
        graphics.drawString("TOPZERA", 100, newHeight - 100);
    }
}
