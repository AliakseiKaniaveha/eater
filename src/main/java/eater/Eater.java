package eater;

import java.math.BigInteger;
import java.util.Vector;

/**
 * Resources 'eater', can 'eat' cpu and ram.
 */
public class Eater {

  private int memoryEaten = 0;
  private int runningHamstersCount = 0;

  private final Vector memoryHole = new Vector();

  public void eatMemoryMb(int amount) {
    int megabyte = 1024 * 1024;
    memoryHole.add(new byte[megabyte * amount]);

    memoryEaten += amount;
  }

  /** Runs {@code runningHamstersCount} 'hamsters in a wheel' to give cpu some fire. */
  public void eatCpu(int runningHamstersCount) {
    for (int i = 0; i < runningHamstersCount; ++i) {
      runOneMoreHamsterInAWheel();
    }
    this.runningHamstersCount += runningHamstersCount;
  }

  private void runOneMoreHamsterInAWheel() {
    new Thread(
            () -> {
              while (true) {
                runOneHamsterFullRound();
              }
            })
        .start();
  }

  private long runOneHamsterFullRound() {
    long startTime = System.currentTimeMillis();
    BigInteger hamster = new BigInteger("0");
    while (hamster.compareTo(new BigInteger("1000000")) < 0) {
      hamster = hamster.add(new BigInteger("1"));
    }
    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }

  public int getMemoryEaten() {
    return memoryEaten;
  }

  public int getRunningHamstersCount() {
    return runningHamstersCount;
  }

  public long getOneHamsterFullRoundTimeMs() {
    return runOneHamsterFullRound();
  }
}
