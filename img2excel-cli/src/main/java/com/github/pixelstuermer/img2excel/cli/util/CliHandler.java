package com.github.pixelstuermer.img2excel.cli.util;

import com.github.pixelstuermer.img2excel.cli.constants.CliConstants;

public class CliHandler {

   private PropertiesHandler propertiesHandler;

   public CliHandler() {
      propertiesHandler = new PropertiesHandler();
   }

   public void printCredits() {
      System.out.println(
         propertiesHandler.getName() + ", "
            + propertiesHandler.getVersion()
            + System.lineSeparator()
            + propertiesHandler.getAuthor() + ", "
            + propertiesHandler.getRepository() );
   }

   public void printSuccessMessage() {
      System.out.println( CliConstants.SUCCESS_MESSAGE );
   }

   public void printNoArgumentError() {
      System.out.println( CliConstants.ERROR_NO_IMAGE_AS_ARGUMENT );
   }

   public void printFileNotFoundError() {
      System.out.println( CliConstants.ERROR_IMAGE_NOT_FOUND );
   }

}
