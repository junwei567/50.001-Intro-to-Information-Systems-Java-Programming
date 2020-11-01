package pset2A;

import java.util.Comparator;

public class OctagonComparator implements Comparator<Octagon> {
    @Override
    public int compare(Octagon octagon, Octagon noctagon) {
        if (octagon.getSide() > noctagon.getSide()) return 1;
        else if (octagon.getSide() < noctagon.getSide()) return -1;
        else return 0;
    }
}
