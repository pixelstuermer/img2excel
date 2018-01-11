package com.github.pixelstuermer.img2excel.core.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.github.pixelstuermer.img2excel.core.constants.ExcelConstants;
import com.github.pixelstuermer.img2excel.core.model.MetaData;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MetaDataHandler {

   private SheetsHandler sheetsHandler;
   private MetaData metaData;

   public void writeMetaDataToSheet() {
      int counter = 0;

      Row rowSourceFile = sheetsHandler.getMetaDataSheet().createRow( counter++ );
      Cell cellSourceFileKey = rowSourceFile.createCell( 0 );
      cellSourceFileKey.setCellValue( ExcelConstants.METADATA_SHEET_KEY_SOURCEFILE );
      Cell cellSourceFileValue = rowSourceFile.createCell( 1 );
      cellSourceFileValue.setCellValue( metaData.getSourceFile() );

      Row rowDuration = sheetsHandler.getMetaDataSheet().createRow( counter++ );
      Cell cellDurationKey = rowDuration.createCell( 0 );
      cellDurationKey.setCellValue( ExcelConstants.METADATA_SHEET_KEY_DURATION );
      Cell cellDurationValue = rowDuration.createCell( 1 );
      cellDurationValue.setCellValue( metaData.getDuration() );

      Row rowColors = sheetsHandler.getMetaDataSheet().createRow( counter++ );
      Cell cellColorsKey = rowColors.createCell( 0 );
      cellColorsKey.setCellValue( ExcelConstants.METADATA_SHEET_KEY_COLORS );
      Cell cellColorsValue = rowColors.createCell( 1 );
      cellColorsValue.setCellValue( metaData.getColors() );

      Row rowWidth = sheetsHandler.getMetaDataSheet().createRow( counter++ );
      Cell cellWidthKey = rowWidth.createCell( 0 );
      cellWidthKey.setCellValue( ExcelConstants.METADATA_SHEET_KEY_WIDTH );
      Cell cellWidthValue = rowWidth.createCell( 1 );
      cellWidthValue.setCellValue( metaData.getWidth() );

      Row rowHeight = sheetsHandler.getMetaDataSheet().createRow( counter++ );
      Cell cellHeightKey = rowHeight.createCell( 0 );
      cellHeightKey.setCellValue( ExcelConstants.METADATA_SHEET_KEY_HEIGHT );
      Cell cellHeightValue = rowHeight.createCell( 1 );
      cellHeightValue.setCellValue( metaData.getHeight() );
   }

}
