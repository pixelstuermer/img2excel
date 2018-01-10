package com.github.pixelstuermer.img2excel.cli.application;

import java.io.File;

import com.github.pixelstuermer.img2excel.cli.util.CliHandler;
import com.github.pixelstuermer.img2excel.core.converter.Img2ExcelConverter;

public class Img2ExcelApplicationStarter {

   private static CliHandler cliHandler;
   private static Img2ExcelConverter img2ExcelConverter;

   public static void main( String[] args ) {
      cliHandler = new CliHandler();
      cliHandler.printCredits();

      if ( args != null && args.length > 0
         && args[0] != null && args[0].length() > 0 ) {
         try {
            img2ExcelConverter = new Img2ExcelConverter( new File( args[0] ) );
            img2ExcelConverter.convertImageToExcel();
            cliHandler.printSuccessMessage();
         }
         catch ( Exception e ) {
            cliHandler.printFileNotFoundError();
         }
      }
      else {
         cliHandler.printNoArgumentError();
      }

   }

}
