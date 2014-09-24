package net.beiker.xletview.util;

public interface Comparer {
  /**
   * The interface implementation should compare the two
   * objects and return an int using these rules:
   * if (a > b)  return > 0;
   * if (a == b) return 0;
   * if (a < b)  return < 0;
   * @param a
   * @param b
   * @return
   */
   public int compare(Object a, Object b);
}
