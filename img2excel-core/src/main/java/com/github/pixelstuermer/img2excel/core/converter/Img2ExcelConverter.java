package com.github.pixelstuermer.img2excel.core.converter;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;

import com.github.pixelstuermer.img2excel.core.util.FileHandler;
import com.github.pixelstuermer.img2excel.core.util.ImageHandler;
import com.github.pixelstuermer.img2excel.core.util.SheetsHandler;

public class Img2ExcelConverter {

   private FileHandler fileHandler;
   private SheetsHandler sheetsHandler;
   private ImageHandler imageHandler;

   public Img2ExcelConverter( File sourceFile ) {
      fileHandler = new FileHandler( sourceFile );
      sheetsHandler = new SheetsHandler();
      imageHandler = null;
   }

   public void convertImageToExcel() throws IOException {
      imageHandler = new ImageHandler( fileHandler.getSourceFile() );

      double counter = 0;
      double dimension = imageHandler.getScaledDimension();

      for ( int i = 0; i < imageHandler.getScaledHeight(); i++ ) {
         Row row = sheetsHandler.getMainSheet().createRow( i );
         for ( int k = 0; k < imageHandler.getScaledWidth(); k++ ) {
            counter++;
            Cell cell = row.createCell( k );
            cell.setCellStyle( createCellStyle( k, i ) );
            System.out.println( "Row " + k + ", Cell " + i + " >>> "
               + Double.valueOf( Double.valueOf( counter / dimension * 10000 ).intValue() ) / 100 + "%" );
         }
      }

      fileHandler.writeWorkbookToFile( sheetsHandler );
   }

   @SuppressWarnings( "deprecation" )
   private XSSFCellStyle createCellStyle( int x, int y ) {
      XSSFCellStyle cellStyle = sheetsHandler.getWorkbook().createCellStyle();
      Color color = new Color( imageHandler.getScaledImage().getRGB( x, y ) );
      XSSFColor xssfColor = new XSSFColor( color );
      cellStyle.setFillForegroundColor( xssfColor );
      cellStyle.setFillPattern( CellStyle.SOLID_FOREGROUND );
      return cellStyle;
   }

}
