package com.github.pixelstuermer.img2excel.core.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class FeedbackHandler {

   private double counter;
   private double dimension;

   DecimalFormat decimalFormat;

   public FeedbackHandler( double dimension ) {
      counter = 0;
      this.dimension = dimension;
      defineDecimalFormat();
   }

   private void defineDecimalFormat() {
      DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
      decimalFormatSymbols.setDecimalSeparator( '.' );

      decimalFormat = new DecimalFormat( "00.00" );
      decimalFormat.setDecimalFormatSymbols( decimalFormatSymbols );
   }

   public void incrementCounter() {
      counter++;
      double currentPerc = counter / dimension * 100;
      System.out.print( decimalFormat.format( currentPerc ) + "\r" );
   }

}
