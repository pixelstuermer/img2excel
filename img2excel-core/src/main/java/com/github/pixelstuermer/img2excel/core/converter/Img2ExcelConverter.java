package com.github.pixelstuermer.img2excel.core.converter;

import java.awt.Color;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;

import com.github.pixelstuermer.img2excel.core.util.FeedbackHandler;
import com.github.pixelstuermer.img2excel.core.util.FileHandler;
import com.github.pixelstuermer.img2excel.core.util.ImageHandler;
import com.github.pixelstuermer.img2excel.core.util.SheetsHandler;

public class Img2ExcelConverter {

   private FileHandler fileHandler;
   private SheetsHandler sheetsHandler;
   private ImageHandler imageHandler;
   private FeedbackHandler feedbackHandler;

   public Img2ExcelConverter( File sourceFile ) {
      fileHandler = new FileHandler( sourceFile );
      sheetsHandler = new SheetsHandler();
      imageHandler = null;
      feedbackHandler = null;
   }

   public void convertImageToExcel() throws IOException, InterruptedException {
      imageHandler = new ImageHandler( fileHandler.getSourceFile() );
      feedbackHandler = new FeedbackHandler( imageHandler.getScaledDimension() );

      // TODO refactor PixelGrabber feature
      int[] pixels = new int[imageHandler.getScaledDimension()];
      PixelGrabber pixelGrabber = new PixelGrabber( imageHandler.getScaledImage(), 0, 0, imageHandler.getScaledWidth(),
         imageHandler.getScaledHeight(), pixels, 0, imageHandler.getScaledWidth() );
      pixelGrabber.grabPixels();

      int counter = 0;
      System.out.println( pixels.length );

      for ( int i = 0; i < imageHandler.getScaledHeight(); i++ ) {
         Row row = sheetsHandler.getMainSheet().createRow( i );
         for ( int k = 0; k < imageHandler.getScaledWidth(); k++ ) {
            feedbackHandler.incrementCounter( k, i );
            Cell cell = row.createCell( k );
            cell.setCellStyle( createCellStyle( pixels[counter] ) );
            counter++;
         }
      }

      fileHandler.writeWorkbookToFile( sheetsHandler );
   }

   @SuppressWarnings( "deprecation" )
   private XSSFCellStyle createCellStyle( int counterPosition ) {
      XSSFCellStyle cellStyle = sheetsHandler.getWorkbook().createCellStyle();
      Color color = new Color( counterPosition );
      XSSFColor xssfColor = new XSSFColor( color );
      cellStyle.setFillForegroundColor( xssfColor );
      cellStyle.setFillPattern( CellStyle.SOLID_FOREGROUND );
      return cellStyle;
   }

}
