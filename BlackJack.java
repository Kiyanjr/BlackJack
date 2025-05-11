import java.util.Scanner;

public class BlackJack {

  public static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("\nWelcome to the java Casino!");
    System.out.println(
      "Do you have a knack for the Black Jack?" + "\nWe  shall see.."
    );
    System.out.println("Ready? Press anything to begin.");
    scan.nextLine();

    int Card1 = drawRandomCard();
    int Card2 = drawRandomCard();

    System.out.println("\nYou got a: ");
    System.out.println(cardString(Card1));
    System.out.println("\nAnd a: ");
    System.out.println(cardString(Card2));

    int Handvalue = Math.min(Card1, 10) + Math.min(Card2, 10);
    System.out.println("Your total hand value is: " + Handvalue);

    int DealersCard1 = drawRandomCard();
    int DealersCard2 = drawRandomCard();
    System.out.println("\nThe dealer shows: ");
    System.out.println(cardString(DealersCard1));
    System.out.println("And has a card face down: ");
    System.out.println(faceDown());
    int Totaldealer = Math.min(DealersCard1, 10) + Math.min(DealersCard2, 10);

    System.out.println("\nThe dealers total is hidden");

    //hit or stayF
    while (true) {
      String option = hitOrStay();
      if (option.equals("stay")) {
        break;
      }
      int newCard = drawRandomCard();
      Handvalue += Math.min(newCard, 10);
      System.out.println("\nYou get a new card: ");
      System.out.println(cardString(newCard));
      System.out.println("\nAnd your total now is: " + Handvalue);
      if (Handvalue > 21) {
        System.out.println("BUST, Player losers.");
        System.exit(0);
      }
    }
    System.out.println("\nIts dealers turn.");
    System.out.println("\nDealers got: ");
    System.out.println(cardString(DealersCard1));
    System.out.println(cardString(DealersCard2));
    System.out.println("The dealers total is: " + Totaldealer);

    while (Totaldealer < 10) {
      int newcard = drawRandomCard();
      Totaldealer += Math.min(newcard, 10);
      System.out.println("\nDealer new card: ");
      System.out.println(cardString(newcard));
      System.out.println("\nAnd the Total is: " + Totaldealer);
    }

    if (Totaldealer > 21) {
      System.out.println("BUST,Dealer loses");
      System.exit(0);
    }

    if (Handvalue > Totaldealer) {
      System.out.println("Player wins!");
    } else {
      System.out.println("Dealers wins!!");
    }

    scan.close();
  }

  public static int drawRandomCard() {
    double randomNumber = Math.random() * 13; //0-12.999999
    randomNumber += 1; //1-13
    return (int) randomNumber;
  }

  public static String cardString(int cardNumber) {
    switch (cardNumber) {
      case 1:
        return (
          "   _____\n" +
          "  |A _  |\n" +
          "  | ( ) |\n" +
          "  |(_'_)|\n" +
          "  |  |  |\n" +
          "  |____V|\n"
        );
      case 2:
        return (
          "   _____\n" +
          "  |2    |\n" +
          "  |  o  |\n" +
          "  |     |\n" +
          "  |  o  |\n" +
          "  |____Z|\n"
        );
      case 3:
        return (
          "   _____\n" +
          "  |3    |\n" +
          "  | o o |\n" +
          "  |     |\n" +
          "  |  o  |\n" +
          "  |____E|\n"
        );
      case 4:
        return (
          "   _____\n" +
          "  |4    |\n" +
          "  | o o |\n" +
          "  |     |\n" +
          "  | o o |\n" +
          "  |____h|\n"
        );
      case 5:
        return (
          "   _____ \n" +
          "  |5    |\n" +
          "  | o o |\n" +
          "  |  o  |\n" +
          "  | o o |\n" +
          "  |____S|\n"
        );
      case 6:
        return (
          "   _____ \n" +
          "  |6    |\n" +
          "  | o o |\n" +
          "  | o o |\n" +
          "  | o o |\n" +
          "  |____6|\n"
        );
      case 7:
        return (
          "   _____ \n" +
          "  |7    |\n" +
          "  | o o |\n" +
          "  |o o o|\n" +
          "  | o o |\n" +
          "  |____7|\n"
        );
      case 8:
        return (
          "   _____ \n" +
          "  |8    |\n" +
          "  |o o o|\n" +
          "  | o o |\n" +
          "  |o o o|\n" +
          "  |____8|\n"
        );
      case 9:
        return (
          "   _____ \n" +
          "  |9    |\n" +
          "  |o o o|\n" +
          "  |o o o|\n" +
          "  |o o o|\n" +
          "  |____9|\n"
        );
      case 10:
        return (
          "   _____ \n" +
          "  |10  o|\n" +
          "  |o o o|\n" +
          "  |o o o|\n" +
          "  |o o o|\n" +
          "  |___10|\n"
        );
      case 11:
        return (
          "   _____\n" +
          "  |J  ww|\n" +
          "  | o {)|\n" +
          "  |o o% |\n" +
          "  | | % |\n" +
          "  |__%%[|\n"
        );
      case 12:
        return (
          "   _____\n" +
          "  |Q  ww|\n" +
          "  | o {(|\n" +
          "  |o o%%|\n" +
          "  | |%%%|\n" +
          "  |_%%%O|\n"
        );
      case 13:
        return (
          "   _____\n" +
          "  |K  WW|\n" +
          "  | o {)|\n" +
          "  |o o%%|\n" +
          "  | |%%%|\n" +
          "  |_%%%>|\n"
        );
      default:
        return "not possible";
    }
  }

  public static String faceDown() {
    return (
      "   _____\n" +
      "  |     |\n" +
      "  |  J  |\n" +
      "  | JJJ |\n" +
      "  |  J  |\n" +
      "  |_____|\n"
    );
  }

  public static String hitOrStay() {
    System.out.println("Do you wanna Hit or Stay?");
    String Asnwer = scan.nextLine();
    while (!(Asnwer.equals("hit") || Asnwer.equals("stay"))) {
      System.out.println("PLEASE WRITE hit or stay");
      Asnwer = scan.nextLine();
    }
    return Asnwer;
  }
}
