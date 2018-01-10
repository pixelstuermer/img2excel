package com.github.pixelstuermer.img2excel.core.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import com.github.pixelstuermer.img2excel.core.constants.FileConstants;

public class FeedbackHandler {

   private double counter;
   private double dimension;

   private DecimalFormat decimalFormat;

   public FeedbackHandler( double dimension ) {
      counter = 0;
      this.dimension = dimension;
      defineDecimalFormat();
   }

   private void defineDecimalFormat() {
      DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
      decimalFormatSymbols.setDecimalSeparator( FileConstants.DECIMAL_FORMAT_DECIMAL_SEPARATOR );

      decimalFormat = new DecimalFormat( FileConstants.DECIMAL_FORMAT_PERCENTAGE );
      decimalFormat.setDecimalFormatSymbols( decimalFormatSymbols );
   }

   public void incrementCounter( int x, int y ) {
      counter++;
      double currentPerc = counter / dimension * 100;
      System.out.print( decimalFormat.format( currentPerc ) + "%"
         + " (Row " + y + ", Column " + x + ")"
         + FileConstants.FEEDBACK_CARRIAGE_RETURN );
   }

}
