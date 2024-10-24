import java.util.*;

class MusicPlayer {
    private List<String> songs;
    private int currentIndex = -1;
    private boolean isPlaying = false;

    public MusicPlayer(List<String> songs) {
        this.songs = songs;
    }

    public void play(int index) {
        if (index >= 0 && index < songs.size()) {
            currentIndex = index;
            isPlaying = true;
            System.out.println("Playing: " + songs.get(currentIndex));
        } else {
            System.out.println("Invalid song index.");
        }
    }

    public void pause() {
        if (isPlaying) {
            isPlaying = false;
            System.out.println("Paused: " + songs.get(currentIndex));
        } else {
            System.out.println("No song is currently playing.");
        }
    }

    public void resume() {
        if (!isPlaying && currentIndex != -1) {
            isPlaying = true;
            System.out.println("Resumed: " + songs.get(currentIndex));
        } else if (currentIndex == -1) {
            System.out.println("No song selected to resume.");
        } else {
            System.out.println("Song is already playing.");
        }
    }

    public void stop() {
        if (isPlaying) {
            isPlaying = false;
            System.out.println("Stopped: " + songs.get(currentIndex));
        } else {
            System.out.println("No song is currently playing.");
        }
    }

    public void next() {
        if (currentIndex < songs.size() - 1) {
            play(currentIndex + 1);
        } else {
            System.out.println("This is the last song in the playlist.");
        }
    }

    public void previous() {
        if (currentIndex > 0) {
            play(currentIndex - 1);
        } else {
            System.out.println("This is the first song in the playlist.");
        }
    }

    public void replay() {
        if (currentIndex != -1) {
            System.out.println("Replaying: " + songs.get(currentIndex));
        } else {
            System.out.println("No song is selected to replay.");
        }
    }

    public void showAllSongs() {
        System.out.println("Playlist:");
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i));
        }
    }
}

public class MusicPlayerApp {
    public static void main(String[] args) {
        List<String> songList = Arrays.asList("Song 1", "Song 2", "Song 3", "Song 4", "Song 5");
        MusicPlayer player = new MusicPlayer(songList);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Play song\n2. Pause\n3. Resume\n4. Stop\n5. Next\n6. Previous\n7. Replay\n8. Show all songs\n9. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter song number:");
                    int songIndex = scanner.nextInt() - 1;
                    player.play(songIndex);
                    break;
                case 2:
                    player.pause();
                    break;
                case 3:
                    player.resume();
                    break;
                case 4:
                    player.stop();
                    break;
                case 5:
                    player.next();
                    break;
                case 6:
                    player.previous();
                    break;
                case 7:
                    player.replay();
                    break;
                case 8:
                    player.showAllSongs();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
