package java8.lambdaExpr;

import java.util.Random;

// This is a random player class with two functionalities
// playGames and playMusic
class RandomPlayer {

    public void playGame(String gameName)
            throws InterruptedException
    {

        System.out.println(gameName + " game started");

        // Assuming game is being played for 500
        // milliseconds
        Thread.sleep(500); // this statement may throw
        // interrupted exception, so
        // throws declaration is added

        System.out.println(gameName + " game ended");
    }

    public void playMusic(String trackName)
            throws InterruptedException
    {

        System.out.println(trackName + " track started");

        // Assuming music is being played for 500
        // milliseconds
        Thread.sleep(500); // this statement may throw
        // interrupted exception, so
        // throws declaration is added

        System.out.println(trackName + " track ended");
    }
}

    public class TestThreadinUsingRunnable {

        // games and tracks arrays which are being used for
        // picking random items
        static String[] games
                = { "COD",	 "Prince Of Persia", "GTA-V5",
                "Valorant", "FIFA 22",		 "Fortnite" };
        static String[] tracks
                = { "Believer", "Cradles", "Taki Taki", "Sorry",
                "Let Me Love You" };

        public static void main(String[] args)
        {

            RandomPlayer player
                    = new RandomPlayer(); // Instance of
            // RandomPlayer to access
            // its functionalities

            // Random class for choosing random items from above
            // arrays
            Random random = new Random();

            // Creating two lambda expressions for runnable
            // interfaces
            Runnable gameRunner = () ->
            {

                try {

                    player.playGame(games[random.nextInt(
                            games.length)]); // Choosing game track
                    // for playing
                }
                catch (InterruptedException e) {

                    e.getMessage();
                }
            };

            Runnable musicPlayer = () ->
            {

                try {

                    player.playMusic(tracks[random.nextInt(
                            tracks.length)]); // Choosing random
                    // music track for
                    // playing
                }
                catch (InterruptedException e) {

                    e.getMessage();
                }
            };

            // Instantiating two thread classes with runnable
            // references
            Thread game = new Thread(gameRunner);
            Thread music = new Thread(musicPlayer);

            // Starting two different threads
            game.start();
            music.start();

            /*
             *Note: As we are dealing with threads output may
             *differ every single time we run the program
             */
        }
}
