import java.util.*;

public class Main {
    public static ArrayList<Album> albums = new ArrayList<Album>();
    public static LinkedList<Song> playlist = new LinkedList<Song>();
//    public static ListIterator<Song> songListIterator = playlist.listIterator();

    public static void main(String[] args) {
        Album album = new Album("Scorpions");
        album.addSong("May be I may be u", 3.3);
        album.addSong("Still loving u", 3.4);
        album.addSong("Forest", 6.3);
        album.addSong("Let is", 3.2);
        albums.add(album);

        album = new Album("Noize mc");
        album.addSong("will", 3.3);
        album.addSong("hip hop opera", 3.4);
        album.addSong("mirror", 6.3);
        album.addSong("Le", 3.2);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("Forest", playList);
        albums.get(1).addToPlayList("Le", playList);
        albums.get(1).addToPlayList("mirror", playList);
        albums.get(0).addToPlayList("For", playList);

        play(playList);


    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
        }

        printMenu();
        while (!quit) {
            int action = scanner.nextInt();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());

                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;

                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;

                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Available actions: \n");
        System.out.println("Press:\n" +
                " 0 - to quit\n" +
                " 1 - to listen next song\n" +
                " 2 - to listen previous song\n" +
                " 3 - to replay the current song \n" +
                " 4 - list songs in the playlist \n" +
                " 5 - to print available actions "
        );
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("===============");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("===============");
    }


//    public static void goToNextTrack() {
//
//        if (songListIterator.hasNext()) {
//            System.out.println("Now playing " + songListIterator.next().getName());
//        }
//    }

//    public static void goToPreviousTrack() {
//     ListIterator<Song> linkedListIterator = playlist.listIterator();
//        if (songListIterator.hasPrevious()) {
//            System.out.println("Now playing " + songListIterator.previous().getName());
//        }
//    }

//    public static void repeatTrack() {
//       ListIterator<Song> linkedListIterator = playlist.listIterator();
//        System.out.println("Now playing" + songListIterator);
//
//    }

//    public static void addSongToPlaylist() {
//        System.out.println("Enter the album song is located: ");
//        String albumName = scanner.next();
//        System.out.println("Enter the song name");
//        String songName = scanner.next();
//        if (onFile(albumName, songName)) {
//            playlist.add(Song.createSong(songName));
//        }
//    }
//
//    public static void addSongToPlaylist(String albumName, String songName) {
//        if (onFile(albumName, songName)) {
//            playlist.add(queryAlbum(albumName).querySong(songName));
//        }
//    }
//
//    public static void addSongToAlbum() {
//        System.out.println("Enter the album song is located: ");
//        String albumName = scanner.next();
//        if(getIndexOfAlbum(albumName) > 0){
//            System.out.println("Enter the song name");
//            String songName = scanner.next();
//            if (albums.get(getIndexOfAlbum(albumName)).songExists(songName)) {
//                queryAlbum(albumName).addSong(Song.createSong(songName));
//            }
//        }
//        if (queryAlbum(albumName) == null) {
//            System.out.println("Enter the song name");
//            String songName = scanner.next();
//            queryAlbum(albumName).addSong(Song.createSong(songName));
//        }
//
//    }
//
//    public static void addSongToAlbum(String albumName, String songName) {
//        if (!onFile(albumName, songName)) {
//            queryAlbum(albumName).addSong(Song.createSong(songName));
//        }
//    }


//

//    public static void printPlaylist() {
//      ListIterator<Song> songListIterator = playlist.listIterator();
//        while (songListIterator.hasNext()) {
//            System.out.println(songListIterator.next().getName());
//        }
//    }
}

