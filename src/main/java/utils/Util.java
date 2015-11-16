package utils;

public class Util {
  public static int parseInt(String s) {
    if (s.isEmpty()) {
      return 0;
    } else {
      return Integer.parseInt(s);
    }
  }
}
