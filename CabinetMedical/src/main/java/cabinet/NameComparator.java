package cabinet;

import java.util.Comparator;

public class NameComparator implements Comparator<Medic> {


    @Override
    public int compare(Medic o1, Medic o2) {
        return o1.getNume().compareTo(o2.getNume());
    }

}
