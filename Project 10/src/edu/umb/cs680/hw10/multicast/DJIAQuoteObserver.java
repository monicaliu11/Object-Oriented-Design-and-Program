package edu.umb.cs680.hw10.multicast;

import edu.umb.cs680.hw10.DJIAEvent;

public interface DJIAQuoteObserver {
    void updateDJIA(DJIAEvent event);
}
