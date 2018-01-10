package com.github.pixelstuermer.img2excel.core.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import lombok.Data;

@Data
public class FileHandler {

   private File sourceFile;

   public FileHandler( File sourceFile ) {
      this.sourceFile = sourceFile;
   }

   public void writeWorkbookToFile( SheetsHandler sheetsHandler ) throws IOException {
      FileOutputStream outputStream = new FileOutputStream(
         sourceFile.getParent() + File.separator + sourceFile.getName().replaceAll( "\\.", "-" ) + ".xlsx" );
      sheetsHandler.getWorkbook().write( outputStream );
      sheetsHandler.getWorkbook().close();
      outputStream.flush();
      outputStream.close();
   }

   // TODO filename

}
