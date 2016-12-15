import javax.swing.*;
import java.awt.*;
import java.util.Vector;


/**
 * Created by pietyszukm on 14.12.2016.
 */
public class Kafelki extends JPanel {

    private Vector<Vector<Title>> matrix;
    private int tilesize;
    // kafelek podświetlony (myszką)
    private int hx = -1, hy = -1;

    // inicjalizacja macierzy
    public Kafelki(int cols, int rows, int tilesize) {
        this.setPreferredSize(new Dimension(cols * tilesize, rows * tilesize));
        this.tilesize = tilesize;
        matrix = new Vector<>();
        for (int i = 0; i < rows; ++i) {
            Vector<Title> matrixRow = new Vector<>();
            for (int j = 0; j < cols; ++j) {
                matrixRow.add(j, new Title());
            }
            matrix.addElement(matrixRow);
        }
        matrix.size();
    }

    // rysowanie macierzy (oraz jednego podświetlonego)
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < matrix.size(); i++) {
            int j = 0;
            int size = matrix.get(i).size();
            for (; j < size; j++) {
                if (i == hy && j == hx) {
                    g.setColor(matrix.get(i).get(j).getColor().brighter());
                } else {
                    g.setColor(matrix.get(i).get(j).getColor());
                }
                g.fillRect(j * tilesize, i * tilesize + 1, tilesize - 1, tilesize - 1);
            }
        }
    }

    // podświetl
    public void highlight(int x, int y) {
        hx = x;
        hy = y;
        repaint();
    }

    // za to pojawi się metoda pobierająca iterator
    // public Iterator<Tile> iterator( ...
    public Iterator create_iterator(){
        return new Iterator(this, matrix);
    }

    public IteratorSpiral create_iteratorSpiral(){
        return new IteratorSpiral(this, matrix);
    }
}
