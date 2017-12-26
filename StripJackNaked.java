public class StripJackNaked {

    public static void main(String args[]) {

        //        System.out.println(game.player1.toString());
        //        System.out.println(game.player2.toString());

        System.out.println("Turns	|	Pay Ratio	|	Winner	|	CardsInHand");
        int games = 5;
        int shuffles = 10;
        int noShuffels = 0;
        int totalTurns = 0;
        int cardsInHand = 0;
        int winsP1 = 0;
        int winsP2 = 0;
        int payP1 = 0;
        int payP2 = 0;
        int cardsPayed = 0;
        for (int i = 1; i <= games; i++) {
            Game game = new Game();
            for (int j = 1; j <= shuffles; j++) {
                game.shuffleDeck();
                noShuffels++;
            }
            game.play();
            System.out.println("");
            System.out.print(game.player1.getTurns() + game.player2.getTurns()
                    + "\t|\t");
            totalTurns += game.player1.getTurns() + game.player2.getTurns();
            System.out.print(game.player1.getPayCount() + ":"
                    + game.player2.getPayCount() + "\t\t|\t");
            System.out.print(game.getWinnerName() + "\t|\t");
            

            if (game.getWinnerName().equals("P1")) winsP1++;
            if (game.getWinnerName().equals("P2")) winsP2++;

            payP1 += game.player1.getPayCount();
            payP2 += game.player2.getPayCount();

            System.out.println(game.getWinner().getCardsInHand());
            cardsInHand += game.getWinner().getCardsInHand();
            
            cardsPayed += game.player1.getCardsPayed();
            cardsPayed += game.player2.getCardsPayed();
            
            System.out.println("");
            System.out.print("-----------------------------------------------------------");
        }

        System.out.println("");
        System.out.println("Simulation statistics");
        System.out.println("Number of Shuffles    " + noShuffels);
        System.out.println("Total Turns           " + totalTurns);
        System.out.println("Turns Per Game        " + totalTurns / games);
        System.out.println("Win Ratio (P1:P2)     " + winsP1 + ":" + winsP2);
        System.out.println("Payout Ratio (P1:P2)  " + payP1 + ":" + payP2);
        System.out.println("Average Cards Paid    " + cardsPayed / games);
        System.out.println("Average Cards In Hand " + cardsInHand / games);

    }
}