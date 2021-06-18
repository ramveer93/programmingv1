package gfg.amazon;
class Sample{
      public static void main(String args[])
      {
          int a = 5;
          int b = 10;
          first: {
              second: {
                  if (a == b >> 1)
                      break second;
               }
              System.out.println(a);
          }
          System.out.println(b);
          }
  }
