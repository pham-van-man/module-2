package ss8_clean_code_refactoring.bai_tap;

public class TennisGame {
    private static final byte LOVE_SCORE = 0;
    private static final byte FIFTEEN_SCORE = 1;
    private static final byte THIRTY_SCORE = 2;
    private static final byte FORTY_SCORE = 3;
    private static final byte ADVANTAGE_SCORE = 1;
    private static final byte WIN_SCORE = 2;

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        if (player1Score == player2Score) {
            return getScoreWhenPlayerScoreTied(player1Score);
        } else if (player1Score >= 4 || player2Score >= 4) {
            return getScoreWhenPlayerScoreAdvantage(player1Score, player2Score);
        } else {
            return " Score Player 1 is " + getScorePlayer(player1Score) + " and score player 2 is " + getScorePlayer(player2Score);
        }
    }

    private static String getScorePlayer(int playerScore) {
        return switch (playerScore) {
            case LOVE_SCORE -> "Love";
            case FIFTEEN_SCORE -> "Fifteen";
            case THIRTY_SCORE -> "Thirty";
            case FORTY_SCORE -> "Forty";
            default -> null;
        };
    }

    private static String getScoreWhenPlayerScoreAdvantage(int player1Score, int player2Score) {
        int differenceScore = player1Score - player2Score;
        if (differenceScore == ADVANTAGE_SCORE) {
            return "Advantage player1";
        } else if (differenceScore == -ADVANTAGE_SCORE) {
            return "Advantage player2";
        } else if (differenceScore >= WIN_SCORE) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private static String getScoreWhenPlayerScoreTied(int player1Score) {
        return switch (player1Score) {
            case LOVE_SCORE -> "Love-All";
            case FIFTEEN_SCORE -> "Fifteen-All";
            case THIRTY_SCORE -> "Thirty-All";
            case FORTY_SCORE -> "Forty-All";
            default -> "Deuce";
        };
    }
}