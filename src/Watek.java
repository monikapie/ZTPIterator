/**
 * Created by pietyszukm on 14.12.2016.
 */
// ten wątek nie wykorzystuje iteratora
public class Watek implements Runnable {

    private Kafelki p;
    private int x, y;

    // x, y to początkowa pozycja do iteracji
    public Watek(Kafelki k, int x, int y) {
        this.p = k;
        this.x = x;
        this.y = y;
    }

    public void run() {
        // klasyczna podwójna pętla do iteracji
        // tutaj kontrolujemy kolejność odwiedzin
        // zostanie to zastąpione pętlą z użyciem iteratora
        Iterator it1 = p.create_iterator();
        IteratorSpiral its = p.create_iteratorSpiral();
        //for (it1.first(); !it1.isDone(); it1.next()){
        while (its.hasNext()) {
            its.currentItem().flip();
            p.repaint();
            System.out.print(its.currentItem() + "  ");
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
