package com.github.pixelstuermer.img2excel.cli.application;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import com.github.pixelstuermer.img2excel.core.converter.Img2ExcelConverter;

public class Img2ExcelApplicationStarter {

   public static void main( String[] args ) throws IOException {
      java.io.InputStream is = Img2ExcelApplicationStarter.class.getResourceAsStream( "my.properties" );
      java.util.Properties p = new Properties();
      p.load( is );
      String version = p.getProperty( "version" );
      System.out.println( version );
      Img2ExcelConverter img2ExcelConverter = new Img2ExcelConverter( new File( args[0] ) );
      img2ExcelConverter.convertImageToExcel();
   }

}
