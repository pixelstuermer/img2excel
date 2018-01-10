package com.github.pixelstuermer.img2excel.core.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.pixelstuermer.img2excel.core.constants.ExcelConstants;
import com.github.pixelstuermer.img2excel.core.constants.ImageConstants;

import lombok.Getter;

@Getter
public class ImageHandler {

   private BufferedImage scaledImage;

   private int scaledWidth;
   private int scaledHeight;
   private int scaledDimension;

   public ImageHandler( File imageFile ) throws IOException {
      this.scaledImage = null;
      scaledWidth = 0;
      scaledHeight = 0;
      scaledDimension = 0;
      createResizedImage( imageFile );
   }

   private void createResizedImage( File imageFile ) throws IOException {
      BufferedImage originalImage = ImageIO.read( imageFile );
      calculateDimensions( originalImage );
      Image tempImage = originalImage.getScaledInstance( scaledWidth, scaledHeight, Image.SCALE_SMOOTH );
      scaledImage = new BufferedImage( scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB );
      Graphics2D g2d = scaledImage.createGraphics();
      g2d.drawImage( tempImage, 0, 0, null );
      g2d.dispose();
   }

   private void calculateDimensions( BufferedImage originalImage ) {
      if ( (originalImage.getWidth() * originalImage.getHeight()) >= ExcelConstants.STYLES_LIMIT ) {
         int newWidht = originalImage.getWidth();
         int newHeight = originalImage.getHeight();
         double iterator = ImageConstants.ITERATOR_START;
         while ( (newWidht * newHeight) >= ExcelConstants.STYLES_LIMIT ) {
            iterator -= ImageConstants.ITERATOR_DELTA;
            newWidht = new Double( originalImage.getWidth() * iterator ).intValue();
            newHeight = new Double( originalImage.getHeight() * iterator ).intValue();
         }
         scaledWidth = newWidht;
         scaledHeight = newHeight;
      }
      else {
         scaledWidth = originalImage.getWidth();
         scaledHeight = originalImage.getHeight();
      }
      scaledDimension = scaledWidth * scaledHeight;
   }

}
