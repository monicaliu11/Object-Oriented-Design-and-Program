package edu.umb.cs680.hw15;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<ApfsElement> {
    @Override
    public int compare(ApfsElement o1, ApfsElement o2) {
        return o1.getLastModifiedTimestamp().compareTo(o2.getLastModifiedTimestamp());
    }
}
