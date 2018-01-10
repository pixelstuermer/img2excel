package com.github.pixelstuermer.img2excel.core.application;

import java.io.File;
import java.io.IOException;

import com.github.pixelstuermer.img2excel.core.converter.Img2ExcelConverter;

public class Runner {

   public static void main( String[] args ) throws IOException {
      Img2ExcelConverter img2ExcelConverter = new Img2ExcelConverter( new File( args[0] ) );
      img2ExcelConverter.convertImageToExcel();
   }

}
