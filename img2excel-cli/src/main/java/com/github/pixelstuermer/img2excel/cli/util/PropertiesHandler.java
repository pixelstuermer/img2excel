package com.github.pixelstuermer.img2excel.cli.util;

import java.io.InputStream;
import java.util.Properties;

import com.github.pixelstuermer.img2excel.cli.constants.PropertiesConstants;

import lombok.AccessLevel;
import lombok.Getter;

@Getter
public class PropertiesHandler {

   @Getter( value = AccessLevel.NONE )
   private InputStream inputStream;
   @Getter( value = AccessLevel.NONE )
   private Properties properties;

   private String name;
   private String version;
   private String author;
   private String repository;

   public PropertiesHandler() {
      inputStream = this.getClass().getResourceAsStream( PropertiesConstants.PROPERTIES_FILENAME );
      properties = new Properties();
      loadProperties();
   }

   private void loadProperties() {
      try {
         properties.load( inputStream );

         name = properties.getProperty( PropertiesConstants.PROPERTY_NAME );
         version = properties.getProperty( PropertiesConstants.PROPERTY_VERSION );
         author = properties.getProperty( PropertiesConstants.PROPERTY_AUTHOR );
         repository = properties.getProperty( PropertiesConstants.PROPERTY_REPOSITORY );
      }
      catch ( Exception e ) {
         name = PropertiesConstants.FALLBACK_PROPERTY_NAME;
         version = PropertiesConstants.FALLBACK_PROPERTY_VERSION;
         author = PropertiesConstants.FALLBACK_PROPERTY_AUTHOR;
         repository = PropertiesConstants.FALLBACK_PROPERTY_REPOSITORY;
      }
   }

}
