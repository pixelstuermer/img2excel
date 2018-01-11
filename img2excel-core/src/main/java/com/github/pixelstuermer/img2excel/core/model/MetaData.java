package com.github.pixelstuermer.img2excel.core.model;

import com.github.pixelstuermer.img2excel.core.constants.ExcelConstants;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MetaData {

   private String sourceFile;
   private long duration;
   private int colors;
   private int width;
   private int height;

   @Override
   public String toString() {
      return ExcelConstants.METADATA_SHEET_KEY_SOURCEFILE + ": "
         + sourceFile + "\n"
         + ExcelConstants.METADATA_SHEET_KEY_DURATION + ": "
         + duration + "\n"
         + ExcelConstants.METADATA_SHEET_KEY_COLORS + ": "
         + colors + "\n"
         + ExcelConstants.METADATA_SHEET_KEY_WIDTH + ": "
         + width + "\n"
         + ExcelConstants.METADATA_SHEET_KEY_HEIGHT + ": "
         + height;
   }

}
