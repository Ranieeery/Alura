import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class CreateFig {
    void criarFig(InputStream inputStream, String nomeArquivo, String nota) throws IOException {
        // Texto da imagem
        String texto = nota;

        // Carrega a imagem
//        InputStream inputStream = new URL("https://cdn.discordapp.com/attachments/697857869848248350/1071195889957339206/23D013FF-6E12-491A-8C71-3522D3633A83.jpg").openStream();
        BufferedImage imagemFig = ImageIO.read(inputStream);

        // Cria a imagem
        int largura = imagemFig.getWidth();
        int altura = imagemFig.getHeight();
        BufferedImage imagemTexto = new BufferedImage(largura, altura, BufferedImage.TRANSLUCENT);

        // Inicia o posicionamento do texto
        Graphics2D g2d = (Graphics2D) imagemTexto.getGraphics();
        g2d.drawImage(imagemFig, 0, 0, null);

        // Configura a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 128);
        g2d.setFont(fonte);
        g2d.setColor(Color.YELLOW);

        // Desenha o texto
        FontMetrics fm = g2d.getFontMetrics();
        int larguraTexto = fm.stringWidth(texto);
        int x = (largura - larguraTexto) / 2;
        g2d.drawString(texto, x, altura - 90);

        // Salva a imagem
        ImageIO.write(imagemTexto, "png", new File(nomeArquivo));
    }
}