package datp1;

import java.util.Scanner;

public class DATP1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String direction = null;
        int menu_selection = 1;
        
        System.out.println("******* Dragons Or Treasure Part 1 ******\n");

        while (true) {

            System.out.println("\n(1) Start Game");
            System.out.println("(2) Exit Game ");
            menu_selection = input.nextInt();

            switch (menu_selection) {

                case 1:
                    

        int x_player = (int) (Math.random() * 7) + 1;
        int y_player = random_y(x_player);
        
        int treasure_visited = 0;
        int dragon_visited = 0;
        int treasure_point = 20;
        int trap_visited = 0;
        int yea = 0;
        
        
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
                 
                    
                    while (treasure_point >= 0 && yea != 1) {
                        System.out.println("\nPlayer position -----> (" + x_player + ", " + y_player + ")");
                        System.out.println("Treasure Point ------> " + treasure_point);
                        System.out.println("Treasure Visited ----> " + treasure_visited);
                        System.out.println("Dragon Visited ------> " + dragon_visited);
                        System.out.println("Trap Visited --------> " + trap_visited);

                        System.out.println("Choose your direction (w,a,s,d) : ");
                        direction = input.next();

                        if (canMove(x_player, y_player, direction)) {
                            switch (direction) {

                                case "w":
                                    y_player += 1;
                                    break;

                                case "a":
                                    x_player -= 1;
                                    break;

                                case "s":
                                    y_player -= 1;
                                    break;

                                case "d":
                                    x_player += 1;
                                    break;
                            }
                            
                            
                            if (isTrap(tx1, ty1, tx2, ty2, tx3, ty3, x_player, y_player)) {
                                trap_visited += 1;
                                treasure_point -= 5;
                            }


                            if (isDragon(dx1, dy1, dx2, dy2, dx3, dy3, dx4, dy4, dx5, dy5, x_player, y_player)) {
                                dragon_visited += 1;
                                int lost = (int) (Math.random() * 10);
                                treasure_point -= lost;
                                System.out.println("You lost " + lost + " points !");
                            }


                            if (isTreasure(x_player, y_player, treasure_visited, treasure_point)) {
                                System.out.println("Guess the 4 digit number :");
                                treasure_visited += 1;
                                int answer = input.nextInt();
                                if (fourDigitNumber(answer)) {
                                    treasure_point += 10;
                                } else {
                                    System.out.println("Wrong answer !");
                                }
                            } 
                            
                            if (isCliffExit(cx1, cy1, x_player, y_player)) {
                                    yea += 1;
                            }

                            if (isEscapeExit(ex1, ey1, x_player, y_player, treasure_point, treasure_visited, dragon_visited, trap_visited)) {
                                System.out.println("\n*************STATS**********\n");
                                System.out.println("Treasure Point ------> " + treasure_point);
                                System.out.println("Treasure Visited ----> " + treasure_visited);
                                System.out.println("Dragon Visited ------> " + dragon_visited);
                                System.out.println("Trap Visited --------> " + trap_visited);
                                    yea += 1;
                            }
                            
                        } else {
                            System.out.println("You can not move there !");
                        }

                    }

            }

            switch (menu_selection) {
                case 2:
                    System.out.println("Good bye !");
                    System.exit(0);
                    break;
            }

        }
    }

    public static boolean isTreasure(int x_player, int y_player, int treasure_visited, int treasure_point) {

        if (x_player == 3 && y_player == 3 || x_player == 3 && y_player == 5 || x_player == 5 && y_player == 3 || x_player == 5 && y_player == 5) {
            System.out.println("\nYou found a treasure !");
            return true;
        }
        return false;
    }

    public static boolean canMove(int x_player, int y_player, String direction) {
        switch (direction) {

            case "w":
                switch (x_player) {
                    case 1:
                        return y_player < 4;
                    case 2:
                        return y_player < 5;
                    case 3:
                        return y_player < 6;
                    case 4:
                        return y_player < 7;
                    case 5:
                        return y_player < 6;
                    case 6:
                        return y_player < 5;
                    case 7:
                        return y_player < 4;
                    default:
                        return y_player < 7;
                }

            case "s":
                switch (x_player) {
                    case 1:
                        return y_player > 4;
                    case 2:
                        return y_player > 3;
                    case 3:
                        return y_player > 2;
                    case 4:
                        return y_player > 1;
                    case 5:
                        return y_player > 2;
                    case 6:
                        return y_player > 3;
                    case 7:
                        return y_player > 4;
                    default:
                        return y_player > 1;
                }

            case "a":
                switch (y_player) {
                    case 1:
                        return x_player > 4;
                    case 2:
                        return x_player > 3;
                    case 3:
                        return x_player > 2;
                    case 4:
                        return x_player > 1;
                    case 5:
                        return x_player > 2;
                    case 6:
                        return x_player > 3;
                    case 7:
                        return x_player > 4;
                    default:
                        return x_player > 1;
                }

            case "d":
                switch (y_player) {
                    case 1:
                        return x_player < 4;
                    case 2:
                        return x_player < 5;
                    case 3:
                        return x_player < 6;
                    case 4:
                        return x_player < 7;
                    case 5:
                        return x_player < 6;
                    case 6:
                        return x_player < 5;
                    case 7:
                        return x_player < 4;
                    default:
                        return x_player < 7;
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

    public static boolean isDragon(int dx1, int dy1, int dx2, int dy2, int dx3, int dy3, int dx4, int dy4, int dx5, int dy5, int x_player, int y_player) {
        if (x_player == dx1 && y_player == dy1 || x_player == dx2 && y_player == dy2 || x_player == dx3 && y_player == dy3 || x_player == dx4 && y_player == dy4 || x_player == dx5 && y_player == dy5) {
            System.out.println("\nYou bribed the dragon !");
            return true;
        }

        return false;
    }

    public static boolean isTrap(int tx1, int ty1, int tx2, int ty2, int tx3, int ty3, int x_player, int y_player) {
        if (x_player == tx1 && y_player == ty1 || x_player == tx2 && y_player == ty2 || x_player == tx3 && y_player == ty3) {
            System.out.println("\nYou pressed on a trap !");
            System.out.println("You lost 5 points !\n");
            return true;
        }
        return false;
    }

    public static boolean isEscapeExit(int ex1, int ey1, int x_player, int y_player, int treasure_point, int treasure_visited, int dragon_visited, int trap_visited) {
        if (x_player == ex1 && y_player == ey1) {
            Scanner input = new Scanner(System.in);
            System.out.println("\nPlayer position -----> (" + x_player + ", " + y_player + ")");
            System.out.println("Do you want to exit ? ( y / n )");
            String selection = input.next();

            switch (selection) {

                case "y":
                    System.out.println("You escaped !");
                    break;

                case "n":
                    System.out.println("You returned the game !");
                    break;

            }

            return true;
        }
        return false;
    }

    public static boolean isCliffExit(int cx1, int cy1, int x_player, int y_player) {
        if (x_player == cx1 && y_player == cy1) {
            Scanner input = new Scanner(System.in);
            System.out.println("\nPlayer position -----> (" + x_player + ", " + y_player + ")");
            System.out.println("You found exit !");
            System.out.println("Do you want to exit ? ( y / n )");

            String selection = input.next();

            switch (selection) {
                case "y":
                    System.out.println("\nYou fell off a cliff !");
                    System.out.println("You lost the game !\n");
                    return true;

                case "n":
                    System.out.println("\nYou returned the game !\n");
                    return true;

            }
        }
        return false;
    }

    public static boolean fourDigitNumber(int answer) {
        int number = (int) (Math.random() * 9000) + 1000;
        if (answer == number) {
            return true;
        }
        return false;
    }
}