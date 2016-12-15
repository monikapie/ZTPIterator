import java.util.Enumeration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

public class Iterator {
        private Kafelki set;
        private Vector<Vector<Title>> titles;
        //private java.util.Iterator m_it;
        private Title current;
        private int row = 0, column = 0;
        public Iterator(Kafelki in , Vector<Vector<Title>> titles) {
            set = in;
            this.titles = titles;
        }
        //public void first() { m_it = titles.get(0).iterator();  next(); }
        public boolean hasNext() {
            while(row < titles.size() && column >= titles.get(row).size()) {
                row ++; column = 0;
            }
            if(row < titles.size()) {
                current = titles.get(row).elementAt(column++);
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
