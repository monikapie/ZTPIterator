import java.util.Vector;

/**
 * Created by pietyszukm on 15.12.2016.
 */
public class IteratorSpiral {
    private Kafelki set;
    private Vector<Vector<Title>> titles;
    //private java.util.Iterator m_it;
    private Title current;
    private int row = 0, column = 0;
    public IteratorSpiral(Kafelki in , Vector<Vector<Title>> titles) {
        set = in;
        this.titles = titles;
    }
    //public void first() { m_it = titles.get(0).iterator();  next(); }
    public boolean hasNext() {
        if(row%2==0){
            while(row < titles.size() && column >= titles.get(row).size()) {
                row ++; column = titles.get(row).size()-1;
            }
        }
        else if(row%2==1){
            while(row < titles.size() && column < 0) {
                row ++; column=0;
            }
        }
        if(row < titles.size() && row%2==0) {
            current = titles.get(row).elementAt(column++);
            return true;
        }else if(row < titles.size() && row%2==1){
            current = titles.get(row).elementAt(column--);
            return true;
        }else
            return false;
    }

    public Title currentItem() { return current; }
//        public void next() {
//            try{
//                current = (Title) m_it.next();
//            }
//            catch (NoSuchElementException ex){
//                current =  null;
//            }
//        }
}
