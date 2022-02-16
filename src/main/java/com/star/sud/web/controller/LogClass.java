package com.star.sud.web.controller;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LogClass {
   private static org.apache.log4j.Logger log = Logger.getLogger(LogClass.class);
   
   public static void main(String[] args) {
	  BasicConfigurator.configure();
	  int a=5;
      log.trace("Trace Message!");
      log.debug("Debug Message!");
      log.info("Info Message!");
      log.info("Variable a which is of type int !" +a);
      log.warn("Warn Message!");
      log.error("Error Message!");
      log.fatal("Fatal Message!");
   }
}
