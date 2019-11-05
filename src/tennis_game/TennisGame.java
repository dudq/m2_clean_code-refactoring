package tennis_game;

public class TennisGame {
    final static int ZeroPoint = 0;
    final static int FirstPoint = 1;
    final static int SecondPoint = 2;
    final static int ThirdPoint = 3;

    public static String getScore(String firstPlayer, String secondPlayer, int scoreFirstPlayer, int scoreSecondPlayer) {
        String display = "";
        if (scoreFirstPlayer == scoreSecondPlayer) {
            display = displayDraw(scoreFirstPlayer);
        } else if (scoreFirstPlayer > ThirdPoint || scoreSecondPlayer > ThirdPoint) {
            display = displayBoardOverThirdPoint(scoreFirstPlayer, scoreSecondPlayer);
        } else {
            display = displayBoardUnderThirdPoint(scoreFirstPlayer, scoreSecondPlayer, display);
        }
        return display;
    }

    private static String displayBoardUnderThirdPoint(int scoreFirstPlayer, int scoreSecondPlayer, String display) {
        int currentPlayer;
        StringBuilder displayBuilder = new StringBuilder(display);

        for (int i = 1; i < 3; i++) {
            if (i == 1) currentPlayer = scoreFirstPlayer;
            else {
                displayBuilder.append("-");
                currentPlayer = scoreSecondPlayer;
            }
            displayScorePlayer(currentPlayer, displayBuilder);
        }
        display = displayBuilder.toString();
        return display;
    }

    private static void displayScorePlayer(int currentScore, StringBuilder displayBuilder) {
        switch (currentScore) {
            case ZeroPoint:
                displayBuilder.append("Love");
                break;
            case FirstPoint:
                displayBuilder.append("Fifteen");
                break;
            case SecondPoint:
                displayBuilder.append("Thirty");
                break;
            case ThirdPoint:
                displayBuilder.append("Forty");
                break;
        }
    }

    private static String displayBoardOverThirdPoint(int scoreFirstPlayer, int scoreSecondPlayer) {
        String display;
        int minusResult = scoreFirstPlayer - scoreSecondPlayer;
        if (minusResult == FirstPoint) display = "Advantage player1";
        else if (minusResult == -FirstPoint) display = "Advantage player2";
        else if (minusResult >= SecondPoint) display = "Win for player1";
        else display = "Win for player2";
        return display;
    }

    private static String displayDraw(int scoreFirstPlayer) {
        String display;
        switch (scoreFirstPlayer) {
            case ZeroPoint:
                display = "Love-All";
                break;
            case FirstPoint:
                display = "Fifteen-All";
                break;
            case SecondPoint:
                display = "Thirty-All";
                break;
            case ThirdPoint:
                display = "Forty-All";
                break;
            default:
                display = "Deuce";
                break;

        }
        return display;
    }

}
