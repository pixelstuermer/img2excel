package com.github.pixelstuermer.img2excel.core.converter;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;

import com.github.pixelstuermer.img2excel.core.model.MetaData;
import com.github.pixelstuermer.img2excel.core.util.FeedbackHandler;
import com.github.pixelstuermer.img2excel.core.util.FileHandler;
import com.github.pixelstuermer.img2excel.core.util.ImageHandler;
import com.github.pixelstuermer.img2excel.core.util.MetaDataHandler;
import com.github.pixelstuermer.img2excel.core.util.SheetsHandler;

public class Img2ExcelConverter {

   private FileHandler fileHandler;
   private SheetsHandler sheetsHandler;
   private MetaDataHandler metaDataHandler;
   private ImageHandler imageHandler;
   private FeedbackHandler feedbackHandler;
   private HashSet<Integer> colorsMap;

   public Img2ExcelConverter( File sourceFile ) {
      fileHandler = new FileHandler( sourceFile );
      sheetsHandler = new SheetsHandler();
      metaDataHandler = null;
      imageHandler = null;
      feedbackHandler = null;
      colorsMap = new HashSet<>();
   }

   public void convertImageToExcel() throws IOException {
      imageHandler = new ImageHandler( fileHandler.getSourceFile() );
      feedbackHandler = new FeedbackHandler( imageHandler.getScaledDimension() );

      long startMs = System.currentTimeMillis();
      for ( int i = 0; i < imageHandler.getScaledHeight(); i++ ) {
         Row row = sheetsHandler.getMainSheet().createRow( i );
         for ( int k = 0; k < imageHandler.getScaledWidth(); k++ ) {
            feedbackHandler.incrementCounter( k, i );
            Cell cell = row.createCell( k );
            cell.setCellStyle( createCellStyle( k, i ) );
         }
      }
      long stopMs = System.currentTimeMillis();
      long duration = (stopMs - startMs) / 1000;

      MetaData metaData = MetaData.builder()
         .sourceFile( fileHandler.getSourceFile().getAbsolutePath() )
         .duration( duration )
         .colors( colorsMap.size() )
         .width( imageHandler.getScaledWidth() )
         .height( imageHandler.getScaledHeight() ).build();

      metaDataHandler = new MetaDataHandler( sheetsHandler, metaData );
      metaDataHandler.writeMetaDataToSheet();
      feedbackHandler.printMetaData( metaData );

      fileHandler.writeWorkbookToFile( sheetsHandler );
   }

   @SuppressWarnings( "deprecation" )
   private XSSFCellStyle createCellStyle( int x, int y ) {
      XSSFCellStyle cellStyle = sheetsHandler.getWorkbook().createCellStyle();
      Color color = new Color( imageHandler.getScaledImage().getRGB( x, y ) );
      colorsMap.add( color.getRGB() );
      XSSFColor xssfColor = new XSSFColor( color );
      cellStyle.setFillForegroundColor( xssfColor );
      cellStyle.setFillPattern( CellStyle.SOLID_FOREGROUND );
      return cellStyle;
   }

}
