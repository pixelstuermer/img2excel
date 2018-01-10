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
      String plainFilename = sourceFile.getName()
         .substring( 0, sourceFile.getName().lastIndexOf( "." ) )
         .replace( "\\.", "-" );
      String parentPath = sourceFile.getParent();
      String newPath = parentPath
         + FileConstants.PATH_SEPARATOR
         + plainFilename
         + "."
         + FileConstants.EXCEL_FILE_SUFFIX;

      FileOutputStream outputStream = new FileOutputStream( newPath );
      sheetsHandler.getWorkbook().write( outputStream );
      outputStream.flush();
      outputStream.close();
      sheetsHandler.getWorkbook().close();
   }

}
