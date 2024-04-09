package com.test;

import java.util.logging.Logger;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class JavaMain {
 
	/**
	 * 
	 */
	public static String arg_pathToCfgFiles=null; 


	
    public static void main(String... args) {

        Quarkus.run(args);


    }
}