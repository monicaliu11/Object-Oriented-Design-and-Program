package edu.umb.cs680.hw13;

import org.junit.jupiter.api.Test;

public class DVDPlayTest {

    @Test
    public void test() {
        DVDPlay.getInstance().playButtonPushed();
        DVDPlay.getInstance().openCloseButtonPushed();
        DVDPlay.getInstance().playButtonPushed();
        DVDPlay.getInstance().stopButtonPushed();
    }
}
