import java.util.HashMap;

/**
* Program that gets the microwave reheat time,
* given a food choice and quantity.
*
* @author  Atri Sarker
* @version 1.0
* @since   2025-09-23
*/
public final class Microwave {

  /**
   * Dictionary/Hashmap for food reheat time.
   * keys: Valid food choices.
   * values: amount of reheat time in seconds.
   */
  public static final HashMap<String, Integer> FOOD_REHEAT_TIME_HASH_MAP =
      new HashMap<>();
  
  // Define food - reheat time pairs
  static {
    FOOD_REHEAT_TIME_HASH_MAP.put("sub", 60);
    FOOD_REHEAT_TIME_HASH_MAP.put("pizza", 45);
    FOOD_REHEAT_TIME_HASH_MAP.put("soup", 105);
  }

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
    // CODE GOES HERE
  }
}
