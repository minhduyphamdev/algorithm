
import java.util.Arrays;

public class MaximumPointsAfterEnemyBattles {
  public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
    Arrays.sort(enemyEnergies);
    long maxPoints  = 0;
    if(currentEnergy < enemyEnergies[0]) {
      return 0;
    }

    int lastElement = enemyEnergies.length - 1;
    while(lastElement >=0) {

      if(currentEnergy >= enemyEnergies[0]) {
        maxPoints += currentEnergy / enemyEnergies[0];
        currentEnergy = currentEnergy % enemyEnergies[0];
      } else {
        currentEnergy += enemyEnergies[lastElement];
        lastElement--;
      }
    }
    
      

    return maxPoints;
  }

  // public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
  //   long x = 0;
  //   Arrays.sort(enemyEnergies);
  //   int j = enemyEnergies.length - 1;
  //   int i = 0;
  //   // Iterate while i is less than or equal to j
  //   while (i <= j) {
  //       // If the current energy is sufficient to defeat the enemy at position i
  //       if (currentEnergy >= enemyEnergies[i]) {
  //           // Calculate how many enemies of this type can be defeated and add to points
  //           x += currentEnergy / enemyEnergies[i];
  //           // Update the remaining energy after defeating the enemies
  //           currentEnergy = currentEnergy % enemyEnergies[i];
  //       } else {
  //           // If current energy is not enough for the enemy at position i,
  //           // Increase the energy by adding the energy of the enemy at position j
  //           currentEnergy += enemyEnergies[j--];
  //       }
  //       // If no points are gained, break the loop early
  //       if (x == 0) break;
  //   }
  //   return x;
  // }

  public static void main(String[] args) {
    MaximumPointsAfterEnemyBattles mp = new MaximumPointsAfterEnemyBattles();
    int[] enemyEnergies = {3,2,2};
    int currentEnergy = 2;
    System.out.println("length "+ String.valueOf(mp.maximumPoints(enemyEnergies, currentEnergy)));
  }
}
