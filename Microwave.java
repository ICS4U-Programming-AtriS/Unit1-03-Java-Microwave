import java.util.InputMismatchException;
import java.util.Arrays;
import java.util.Scanner;

/**
* Program that gets the amount of time to reheat food in a microwave,
* given a food choice and quantity.
*
* @author  Atri Sarker
* @version 1.0
* @since   2025-09-23
*/
public final class Microwave {

  /**
   * Amount of time to reheat a single sub in seconds.
   */
  public static final int SUB_REHEAT_TIME = 60;
  /**
   * Amount of time to reheat a single slice of pizza in seconds.
   */
  public static final int PIZZA_REHEAT_TIME = 45;
  /**
   * Amount of time to reheat a single bowl of soup in seconds.
   * 1 minute and 45 seconds.
   */
  public static final int SOUP_REHEAT_TIME = 105;

  /**
   * Array to hold all the food choices.
   */
  public static final String[] FOOD_CHOICES = {
    "SUB",
    "PIZZA",
    "SOUP"
  };

  /**
   * Maximum quantity of food that the microwave can hold.
   */
  public static final int MAX_QUANTITY = 3;

  /**
   * Constant to define the amount of seconds in a minute.
   */
  public static final int SECONDS_PER_MINUTE = 60;

  /**
   * Private constructor to satisfy style checker.
   * @exception IllegalStateException for the utility class.
   * @see IllegalStateException
   */
  private Microwave() {
    // Prevents illegal states.
    throw new IllegalStateException("Utility class.");
  }

  /**
   * Entrypoint of the program.
   * @param args UNUSED.
   */
  public static void main(final String[] args) {
    // Display all food choices
    System.out.println("Food choices: " + Arrays.toString(FOOD_CHOICES));
    // Prompt for food choice.
    System.out.print("Enter your food choice: ");
    // Initialize Scanner for user input.
    Scanner scanner = new Scanner(System.in);
    // Get user's food choice as a string
    String userFoodChoice = scanner.nextLine();
    // Convert user input to uppercase to match array values.
    userFoodChoice = userFoodChoice.toUpperCase();
    // Check if the user input is a valid food choice.
    if (Arrays.asList(FOOD_CHOICES).contains(userFoodChoice)) {
      // Prompt for quantity.
      System.out.printf("Enter the quantity [1-%d]: ", MAX_QUANTITY);
      try {
        // Read quantity as an integer.
        final int quantity = scanner.nextInt();
        // Close scanner
        scanner.close();
        // Check if the quantity is in a valid range.
        if (quantity >= 1 && quantity <= MAX_QUANTITY) {
          // Initialize reheat time variable for a single item.
          int baseReheatTime = 0;
          // Determine reheat time based on food choice and quantity.
          // NOTE: .equals() is used instead of "=="
          // because "==" does not work here for string comparison.
          if (userFoodChoice.equals("SUB")) {
            baseReheatTime = SUB_REHEAT_TIME;
          } else if (userFoodChoice.equals("PIZZA")) {
            baseReheatTime = PIZZA_REHEAT_TIME;
          } else if (userFoodChoice.equals("SOUP")) {
            baseReheatTime = SOUP_REHEAT_TIME;
          }
          // Apply the quantity formula on the base reheat time.
          // To get the actual reheat time. [in seconds]
          final double actualReheatTime = baseReheatTime * (quantity + 1) * 0.5;
          // Convert pure seconds to a combination of minutes and seconds.
          final int minutes = (int) actualReheatTime / SECONDS_PER_MINUTE;
          final double seconds = actualReheatTime % SECONDS_PER_MINUTE;
          // Display the result. [IN BLUE]
          System.out.print("\033[0;34mReheat time: ");
          System.out.printf("%d minute(s) and %.1f second(s).",
              minutes, seconds);
          System.out.println("");
        } else {
          // Error message for invalid quantity. [IN RED]
          System.out.print("\033[0;31mERROR: INVALID QUANTITY, IT ");
          System.out.printf("MUST BE BETWEEN 1 AND %d", MAX_QUANTITY);
          System.out.println("");
        }
      } catch (InputMismatchException error) {
        // Error message for non-integer quantity. [IN RED]
        System.out.println("\033[0;31mERROR: QUANTITY MUST BE AN INTEGER.");
      }
    } else {
      // Error message for invalid food choice. [IN RED]
      System.out.println("\033[0;31mERROR: INVALID FOOD CHOICE.");
      // Close scanner
      scanner.close();
    }
  }
}
