package com.badwitsoftware.flightreservation.user;

public class PrimeDecomp {
    public static String factors(int n) {
      StringBuilder builder = new StringBuilder();
      
      // reduce by factor of 2
      int count = 0;
      while (n % 2 == 0) {
        n = n/2;
        count++;
      }
      if (count > 0) {
        builder.append(constructFactor(2, count));
        count = 0;
      }

      // deal with odd numbered factors
      for(int i = 3; i <= Math.sqrt(n); i += 2){
        count = 0;
        while(n % i == 0) {
          n = n/i;
          count++;
        }
        builder.append(constructFactor(i, count));
      }
      
      if (n > 2) {
        builder.append(constructFactor(n, 1));
      }      
      return builder.toString();
    }
    
    private static String constructFactor(int n, int count){
      StringBuilder factor = new StringBuilder();
      factor.append("(" + n );
      if(count > 1) {
        factor.append("**" + count);
      }
      factor.append(")");
      
      return factor.toString();
    }
}
