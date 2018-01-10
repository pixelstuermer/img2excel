package com.github.pixelstuermer.img2excel.core.converter;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;

import com.github.pixelstuermer.img2excel.core.util.ImageHandler;
import com.github.pixelstuermer.img2excel.core.util.SheetsHandler;

public class Img2ExcelConverter {

   private File imageFile;
   private ImageHandler imageHandler;
   private SheetsHandler sheetsHandler;

   public Img2ExcelConverter( File imageFile ) {
      this.imageFile = imageFile;
      imageHandler = null;
      sheetsHandler = new SheetsHandler();
   }

   public void convertImageToExcel() throws IOException {
      imageHandler = new ImageHandler( imageFile );

      double counter = 0;
      double dimension = imageHandler.getScaledDimension();

      for ( int i = 0; i < imageHandler.getScaledHeight(); i++ ) {
         Row row = sheetsHandler.getMainSheet().createRow( i );
         for ( int k = 0; k < imageHandler.getScaledWidth(); k++ ) {
            counter++;
            XSSFCellStyle cellStyle = sheetsHandler.getWorkbook().createCellStyle();
            Color color = new Color( imageHandler.getScaledImage().getRGB( k, i ) );
            XSSFColor xssfColor = new XSSFColor( color );
            cellStyle.setFillForegroundColor( xssfColor );
            cellStyle.setFillPattern( CellStyle.SOLID_FOREGROUND );
            Cell cell = row.createCell( k );
            cell.setCellStyle( cellStyle );
            System.out.println( "Row " + k + ", Cell " + i +
               " >>> " + Double.valueOf( Double.valueOf( counter / dimension * 10000 ).intValue() ) / 100 + "%" );
         }
      }

      FileOutputStream outputStream = new FileOutputStream(
         imageFile.getParent() + File.separator + imageFile.getName().replaceAll( "\\.", "-" ) + ".xlsx" );
      sheetsHandler.getWorkbook().write( outputStream );
      sheetsHandler.getWorkbook().close();
      outputStream.flush();
      outputStream.close();
   }

}
