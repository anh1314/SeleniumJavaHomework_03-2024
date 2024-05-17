package constants;

import helpers.PropertiesHelper;

public class ConfigData {

      static {
            PropertiesHelper.loadAllFiles();
      }

      public static String URL = PropertiesHelper.getValue("url");
      public static String Email = PropertiesHelper.getValue("email");
      public static String Password = PropertiesHelper.getValue("password");
}