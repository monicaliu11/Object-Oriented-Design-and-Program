package edu.umb.cs680.hw13;

public class DrawerOpen implements State {

    private static DrawerOpen instance = new DrawerOpen();

    private DrawerOpen() {}

    public static DrawerOpen getInstance() {
        return instance;
    }

    @Override
    public void openCloseButtonPushed() {
        DVDPlay.getInstance().close();
        DVDPlay.getInstance().changeState(DrawerClosedNotPlaying.getInstance());
    }

    @Override
    public void playButtonPushed() {
        DVDPlay.getInstance().close();
        DVDPlay.getInstance().play();
        DVDPlay.getInstance().changeState(DrawerClosedPlaying.getInstance());
    }

    @Override
    public void stopButtonPushed() {

    }
}
