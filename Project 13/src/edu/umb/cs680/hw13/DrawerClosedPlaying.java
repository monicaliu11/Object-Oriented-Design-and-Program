package edu.umb.cs680.hw13;

public class DrawerClosedPlaying implements State {

    private static DrawerClosedPlaying instance = new DrawerClosedPlaying();

    private DrawerClosedPlaying() {}

    public static DrawerClosedPlaying getInstance() {
        return instance;
    }

    @Override
    public void openCloseButtonPushed() {
        DVDPlay.getInstance().stop();
        DVDPlay.getInstance().open();
        DVDPlay.getInstance().changeState(DrawerOpen.getInstance());
    }

    @Override
    public void playButtonPushed() {

    }

    @Override
    public void stopButtonPushed() {
        DVDPlay.getInstance().stop();
        DVDPlay.getInstance().changeState(DrawerClosedNotPlaying.getInstance());
    }
}
