package edu.umb.cs680.hw13;

public class DrawerClosedNotPlaying implements State {

    private static DrawerClosedNotPlaying instance = new DrawerClosedNotPlaying();

    private DrawerClosedNotPlaying() {}

    public static DrawerClosedNotPlaying getInstance() {
        return instance;
    }

    @Override
    public void openCloseButtonPushed() {
        DVDPlay.getInstance().open();
        DVDPlay.getInstance().changeState(DrawerOpen.getInstance());
    }

    @Override
    public void playButtonPushed() {
        DVDPlay.getInstance().play();
        DVDPlay.getInstance().changeState(DrawerClosedPlaying.getInstance());
    }

    @Override
    public void stopButtonPushed() {

    }
}
