public static void main(String[] args) {
    MusicPlayer player = new MusicPlayer("path/to/music.mp3");
    player.play();
    // wait for a few seconds
    try {
        Thread.sleep(5000);
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    }
    player.pause();
    // wait for a few seconds
    try {
        Thread.sleep(5000);
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    }
    player.resume();
    // wait for a few seconds
    try {
        Thread.sleep(5000);
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    }
    player.setVolume(-10f); // reduce volume by 10 decibels
    // wait for a few seconds
    try {
        Thread.sleep(5000);
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    }
    player.stop();
}
