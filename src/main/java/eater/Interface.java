package eater;

import static java.lang.System.exit;

import java.util.Scanner;

/**
 * Responsible for operator-program communication.
 */
public class Interface {

  private final Eater eater = new Eater();

  public void startInteraction() {
    printHelp();
    while (true) {
      printSeparator();
      Scanner input = new Scanner(System.in);

      String firstToken = input.next();
      if (firstToken.equals("exit")) {
        exit(0);
      } else if (firstToken.equals("help")) {
        printHelp();
        continue;
      } else if (firstToken.equals("status")) {
        printStatus();
        continue;
      }

      int amount;
      try {
        amount = Integer.parseInt(firstToken);
      } catch (NumberFormatException e) {
        printRtfm();
        continue;
      }

      String secondToken = input.next();
      if (secondToken.equals("ram")) {
        if (amount > 1024) {
          System.out.println("Hey, that's too much!");
          printRtfm();
        } else {
          eater.eatMemoryMb(amount);
          printStatus();
        }
      } else if (secondToken.startsWith("cpu")) {
        if (amount > 10) {
          System.out.println("Hey, that's too much!");
          printRtfm();
        } else {
          eater.eatCpu(amount);
          printStatus();
        }
      } else {
        printRtfm();
      }
    }
  }

  private void printHelp() {
    System.out.println(
        ""
            + "\nWelcome to Eater, a tiny utility to 'eat' system resources - generate cpu load or consume memory."
            + "\nMight be useful to run some stress tests or for whatever you can think of."
            + "\nUsage - enter one of the following:"
            + "\n xxx ram - (max 1024) to eat another xxx megabytes of memory"
            + "\n xx cpu - (max 99) to eat some cpu by running xx 'hamsters in a wheel' - no matter what calculation making cpu busy"
            + "\n help - to display this message"
            + "\n status - to display amount of resources eaten so far + relative performance (how slower one 'hamster' makes full round under load)"
            + "\n exit - to exit and release resources");
  }

  private void printSeparator() {
    System.out.println("------------------------------------------------------------");
  }

  private void printStatus() {
    System.out.println(
        "Ate some cpu by "
            + eater.getRunningHamstersCount()
            + " running hamsters \uD83D\uDC39 so far (full round takes " + eater.getOneHamsterFullRoundTimeMs() + " milliseconds now)");
    System.out.println("Ate " + eater.getMemoryEaten() + " megabytes of memory so far");
  }

  private void printRtfm() {
    System.out.println("RTFM! (Enter 'help' to get help)");
  }
}
