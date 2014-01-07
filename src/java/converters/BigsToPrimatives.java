/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package converters;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Andrew
 */
public  class  BigsToPrimatives {
    
    public static BigInteger fromLongToBigInteger(long x){
        return BigInteger.valueOf(x);
    }
    
    public static long fromBigIntToLong(BigInteger x){
        String temp = ""+x;
        return Long.parseLong(temp);
    }
    
    public static BigDecimal fromDoubleToBigDecimal(double x){
        return BigDecimal.valueOf(x);
    }
    
    public static double fromBigDecimalToDouble(BigDecimal x){
        String temp = ""+x;
        return Double.parseDouble(temp);
    }
}
