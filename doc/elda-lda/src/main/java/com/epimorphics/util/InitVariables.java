package com.epimorphics.util;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitVariables implements ServletContextListener
{

   @Override
   public void contextDestroyed(final ServletContextEvent event)
   {
   }

   @Override
   public void contextInitialized(final ServletContextEvent event)
   {
      final String props = "doc.properties";
      final Properties propsFromFile = new Properties();
      try
      {
         propsFromFile.load(getClass().getClassLoader().getResourceAsStream(props));
      }
      catch (final IOException e)
      {
          // can't get resource
      }
      for (String prop : propsFromFile.stringPropertyNames())
      {
         if (System.getProperty(prop) == null)
         {
             System.setProperty(prop, propsFromFile.getProperty(prop));
         }
      }
   }
}  
