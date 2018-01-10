package com.github.pixelstuermer.img2excel.core.util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.github.pixelstuermer.img2excel.core.constants.ExcelConstants;

import lombok.Getter;

@Getter
public class SheetsHandler {

   private XSSFWorkbook workbook;
   private XSSFSheet mainSheet;
   private XSSFSheet metaDataSheet;

   public SheetsHandler() {
      workbook = new XSSFWorkbook();
      mainSheet = workbook.createSheet( ExcelConstants.MAIN_SHEET_NAME );
      metaDataSheet = workbook.createSheet( ExcelConstants.METADATA_SHEET_NAME );
      setDefaultStyles();
   }

   private void setDefaultStyles() {
      mainSheet.setDefaultColumnWidth( ExcelConstants.MAIN_SHEET_COLUMN_WIDTH );
      mainSheet.setDefaultRowHeight( ExcelConstants.MAIN_SHEET_ROW_HEIGHT );
      mainSheet.setZoom( ExcelConstants.IMAGE_SHEET_ZOOM );
      metaDataSheet.setZoom( ExcelConstants.METADATA_SHEET_ZOOM );
   }

}
