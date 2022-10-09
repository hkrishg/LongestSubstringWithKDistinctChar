import java.util.*;

class Main {

  private static int lengthLongestSubStringWIthDistinctChar(String input, int k) {
    if (input == null || input.length() == 0 || input.length() < k) {
      throw new IllegalArgumentException();
    }

    int windowStart = 0;
    int maxLength = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
      
      char rightChar = input.charAt(windowEnd);
      map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

      while (map.size() > k) { //start shrinking
        char leftChar = input.charAt(windowStart);
        map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
        if (map.get(leftChar) == 0) {
          map.remove(leftChar);
        }
        windowStart++;
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    // String="araaci", K=2 ------- > output = araa
    int result = Main.lengthLongestSubStringWIthDistinctChar("araaci", 2);
    System.out.println("----" + result);
  }
}