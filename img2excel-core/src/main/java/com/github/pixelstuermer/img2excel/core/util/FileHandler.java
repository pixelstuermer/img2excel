package com.github.pixelstuermer.img2excel.core.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.github.pixelstuermer.img2excel.core.constants.FileConstants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FileHandler {

   private File sourceFile;

   public void writeWorkbookToFile( SheetsHandler sheetsHandler ) throws IOException {
      String suffix = sourceFile.getName().substring( sourceFile.getName().lastIndexOf( "." ) + 1 );
      String path = sourceFile.getAbsolutePath().replaceAll( suffix, FileConstants.EXCEL_FILE_SUFFIX );

      FileOutputStream outputStream = new FileOutputStream( path );
      sheetsHandler.getWorkbook().write( outputStream );
      outputStream.flush();
      outputStream.close();
      sheetsHandler.getWorkbook().close();
   }

   // TODO what if no file given
   // TODO Print metadata at end

}
