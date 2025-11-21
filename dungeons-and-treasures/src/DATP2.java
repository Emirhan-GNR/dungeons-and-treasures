package datp1;

import java.util.Scanner;

public class DATP2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String direction;
        int menu_selection;

        System.out.println("******* Dragons Or Treasure Part 2 ******\n");

        while (true) {

            System.out.println("\n(1) Start Game");
            System.out.println("(2) Exit Game ");
            menu_selection = input.nextInt();

            switch (menu_selection) {

                case 1: {

                    System.out.print("Enter number of players: ");
                    int numPlayers = input.nextInt();

                    int[] x_player = new int[numPlayers];
                    int[] y_player = new int[numPlayers];
                    int[] treasure_visited = new int[numPlayers];
                    int[] dragon_visited = new int[numPlayers];
                    int[] treasure_point = new int[numPlayers];
                    int[] trap_visited = new int[numPlayers];
                    boolean[] playerFinished = new boolean[numPlayers];

                    for (int i = 0; i < numPlayers; i++) {
                        x_player[i] = (int) (Math.random() * 7) + 1;
                        y_player[i] = random_y(x_player[i]);
                        treasure_point[i] = 20;
                    }

                    int dx1 = (int) (Math.random() * 7) + 1;
                    int dy1 = random_y(dx1);

                    int dx2 = (int) (Math.random() * 7) + 1;
                    int dy2 = random_y(dx2);

                    int dx3 = (int) (Math.random() * 7) + 1;
                    int dy3 = random_y(dx3);

                    int dx4 = (int) (Math.random() * 7) + 1;
                    int dy4 = random_y(dx4);

                    int dx5 = (int) (Math.random() * 7) + 1;
                    int dy5 = random_y(dx5);

                    int tx1 = (int) (Math.random() * 7) + 1;
                    int ty1 = random_y(tx1);

                    int tx2 = (int) (Math.random() * 7) + 1;
                    int ty2 = random_y(tx2);

                    int tx3 = (int) (Math.random() * 7) + 1;
                    int ty3 = random_y(tx3);

                    int ex1 = (int) (Math.random() * 7) + 1;
                    int ey1 = random_y(ex1);

                    int cx1 = (int) (Math.random() * 7) + 1;
                    int cy1 = random_y(cx1);

                    boolean gameOn = true;

                    while (gameOn) {
                        for (int i = 0; i < numPlayers; i++) {

                            if (treasure_point[i] < 0) {
                                playerFinished[i] = true;
                            }

                            if (playerFinished[i]) {
                                continue;
                            }

                            System.out.println("\nPlayer " + (i + 1) + " turn:");
                            System.out.println("Player position -----> (" + x_player[i] + ", " + y_player[i] + ")");
                            System.out.println("Treasure Point ------> " + treasure_point[i]);
                            System.out.println("Treasure Visited ----> " + treasure_visited[i]);
                            System.out.println("Dragon Visited ------> " + dragon_visited[i]);
                            System.out.println("Trap Visited --------> " + trap_visited[i]);

                            System.out.print("Choose your direction (w,a,s,d) : ");
                            direction = input.next();

                            if (canMove(x_player[i], y_player[i], direction)) {
                                switch (direction) {
                                    case "w":
                                        y_player[i] += 1;
                                        break;
                                    case "a":
                                        x_player[i] -= 1;
                                        break;
                                    case "s":
                                        y_player[i] -= 1;
                                        break;
                                    case "d":
                                        x_player[i] += 1;
                                        break;
                                }

                                if (isTrap(tx1, ty1, tx2, ty2, tx3, ty3, x_player[i], y_player[i])) {
                                    trap_visited[i] += 1;
                                    treasure_point[i] -= 5;
                                }

                                if (isDragon(dx1, dy1, dx2, dy2, dx3, dy3, dx4, dy4, dx5, dy5, x_player[i], y_player[i])) {
                                    dragon_visited[i] += 1;
                                    int lost = (int) (Math.random() * 10);
                                    treasure_point[i] -= lost;
                                    System.out.println("You lost " + lost + " points !");
                                }

                                if (isTreasure(x_player[i], y_player[i])) {
                                    System.out.println("You found a treasure !");
                                    treasure_visited[i] += 1;
                                    System.out.println("Enter 4 digit code :");
                                    int answer = input.nextInt();
                                    if (fourDigitNumber(answer)) {
                                        treasure_point[i] += 10;
                                        System.out.println("Correct! You gained 10 points!");
                                    } else {
                                        System.out.println("Wrong answer !");
                                    }
                                }

                                if (isCliffExit(input, cx1, cy1, x_player[i], y_player[i])) {
                                    playerFinished[i] = true;
                                }

                                if (!playerFinished[i] &&
                                    isEscapeExit(input, ex1, ey1, x_player[i], y_player[i])) {

                                    System.out.println("\n*************STATS**********\n");
                                    System.out.println("Player " + (i + 1) + " Stats:");
                                    System.out.println("Treasure Point ------> " + treasure_point[i]);
                                    System.out.println("Treasure Visited ----> " + treasure_visited[i]);
                                    System.out.println("Dragon Visited ------> " + dragon_visited[i]);
                                    System.out.println("Trap Visited --------> " + trap_visited[i]);

                                    playerFinished[i] = true;
                                }

                            } else {
                                System.out.println("You can not move there !");
                            }
                        }

                        if (allPlayersEscapedOrLost(playerFinished, treasure_point)) {
                            gameOn = false;
                        }
                    }

                    int winner = findWinner(treasure_point);
                    int treasureCollector = findTreasureCollector(treasure_visited);
                    int dragonBriber = findDragonBriber(dragon_visited);
                    int unfortunatePlayer = findUnfortunatePlayer(trap_visited);

                    System.out.println("\n************* FINAL STATS *************");
                    System.out.println("Winner: Player " + (winner + 1));
                    System.out.println("Treasure Collector: Player " + (treasureCollector + 1));
                    System.out.println("Dragon Briber: Player " + (dragonBriber + 1));
                    System.out.println("Unfortunate Player: Player " + (unfortunatePlayer + 1));
                    break;
                }

                case 2:
                    System.out.println("Good bye !");
                    input.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please select 1 or 2!");
                    break;
            }
        }
    }

    public static boolean isTreasure(int x_player, int y_player) {
        return (x_player == 3 && y_player == 3) ||
               (x_player == 3 && y_player == 5) ||
               (x_player == 5 && y_player == 3) ||
               (x_player == 5 && y_player == 5);
    }

    public static boolean canMove(int x_player, int y_player, String direction) {
        switch (direction) {

            case "w":
                switch (x_player) {
                    case 1: return y_player < 4;
                    case 2: return y_player < 5;
                    case 3: return y_player < 6;
                    case 4: return y_player < 7;
                    case 5: return y_player < 6;
                    case 6: return y_player < 5;
                    case 7: return y_player < 4;
                    default: return y_player < 7;
                }

            case "s":
                switch (x_player) {
                    case 1: return y_player > 4;
                    case 2: return y_player > 3;
                    case 3: return y_player > 2;
                    case 4: return y_player > 1;
                    case 5: return y_player > 2;
                    case 6: return y_player > 3;
                    case 7: return y_player > 4;
                    default: return y_player > 1;
                }

            case "a":
                switch (y_player) {
                    case 1: return x_player > 4;
                    case 2: return x_player > 3;
                    case 3: return x_player > 2;
                    case 4: return x_player > 1;
                    case 5: return x_player > 2;
                    case 6: return x_player > 3;
                    case 7: return x_player > 4;
                    default: return x_player > 1;
                }

            case "d":
                switch (y_player) {
                    case 1: return x_player < 4;
                    case 2: return x_player < 5;
                    case 3: return x_player < 6;
                    case 4: return x_player < 7;
                    case 5: return x_player < 6;
                    case 6: return x_player < 5;
                    case 7: return x_player < 4;
                    default: return x_player < 7;
                }
        }

        return false;
    }

    public static int random_y(int horizon) {
        switch (horizon) {
            case 1:
                return 4;
            case 2:
                return (int) (Math.random() * 3) + 3;
            case 3:
                return (int) (Math.random() * 5) + 2;
            case 4:
                return (int) (Math.random() * 7) + 1;
            case 5:
                return (int) (Math.random() * 5) + 2;
            case 6:
                return (int) (Math.random() * 3) + 3;
            case 7:
                return 4;
            default:
                return 0;
        }
    }

    public static boolean isDragon(int dx1, int dy1,
                                   int dx2, int dy2,
                                   int dx3, int dy3,
                                   int dx4, int dy4,
                                   int dx5, int dy5,
                                   int x_player, int y_player) {

        if ((x_player == dx1 && y_player == dy1) ||
            (x_player == dx2 && y_player == dy2) ||
            (x_player == dx3 && y_player == dy3) ||
            (x_player == dx4 && y_player == dy4) ||
            (x_player == dx5 && y_player == dy5)) {

            System.out.println("\nYou bribed the dragon !");
            return true;
        }

        return false;
    }

    public static boolean isTrap(int tx1, int ty1,
                                 int tx2, int ty2,
                                 int tx3, int ty3,
                                 int x_player, int y_player) {

        if ((x_player == tx1 && y_player == ty1) ||
            (x_player == tx2 && y_player == ty2) ||
            (x_player == tx3 && y_player == ty3)) {

            System.out.println("\nYou pressed on a trap !");
            System.out.println("You lost 5 points !\n");
            return true;
        }
        return false;
    }

    public static boolean isEscapeExit(Scanner input,
                                       int ex1, int ey1,
                                       int x_player, int y_player) {

        if (x_player == ex1 && y_player == ey1) {
            System.out.println("\nPlayer position -----> (" + x_player + ", " + y_player + ")");
            System.out.println("You found an exit !");
            System.out.println("Do you want to exit ? ( y / n )");
            String selection = input.next();

            switch (selection) {
                case "y":
                    System.out.println("You escaped !");
                    return true;
                case "n":
                    System.out.println("You returned to the game !");
                    return false;
                default:
                    System.out.println("Invalid choice. You returned to the game !");
                    return false;
            }
        }
        return false;
    }

    public static boolean isCliffExit(Scanner input,
                                      int cx1, int cy1,
                                      int x_player, int y_player) {

        if (x_player == cx1 && y_player == cy1) {
            System.out.println("\nPlayer position -----> (" + x_player + ", " + y_player + ")");
            System.out.println("You found an exit !");
            System.out.println("Do you want to exit ? ( y / n )");

            String selection = input.next();

            switch (selection) {
                case "y":
                    System.out.println("\nYou fell off a cliff !");
                    System.out.println("You lost the game !\n");
                    return true;
                case "n":
                    System.out.println("\nYou returned to the game !\n");
                    return false;
                default:
                    System.out.println("\nInvalid choice. You returned to the game !\n");
                    return false;
            }
        }
        return false;
    }

    public static boolean fourDigitNumber(int answer) {
        int number = (int) (Math.random() * 9000) + 1000;
        return answer == number;
    }

    public static int findWinner(int[] treasure_point) {
        int max = treasure_point[0];
        int maxIndex = 0;

        for (int i = 1; i < treasure_point.length; i++) {
            if (treasure_point[i] > max) {
                max = treasure_point[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int findTreasureCollector(int[] treasure_visited) {
        int max = treasure_visited[0];
        int maxIndex = 0;

        for (int i = 1; i < treasure_visited.length; i++) {
            if (treasure_visited[i] > max) {
                max = treasure_visited[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int findDragonBriber(int[] dragon_visited) {
        int max = dragon_visited[0];
        int maxIndex = 0;

        for (int i = 1; i < dragon_visited.length; i++) {
            if (dragon_visited[i] > max) {
                max = dragon_visited[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int findUnfortunatePlayer(int[] trap_visited) {
        int max = trap_visited[0];
        int maxIndex = 0;

        for (int i = 1; i < trap_visited.length; i++) {
            if (trap_visited[i] > max) {
                max = trap_visited[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static boolean allPlayersEscapedOrLost(boolean[] finished, int[] treasure_point) {
        for (int i = 0; i < finished.length; i++) {
            if (!finished[i] && treasure_point[i] >= 0) {
                return false;
            }
        }
        return true;
    }
}