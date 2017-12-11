/** 
 * Copyright(C) 2016 Jan P.C. Hanson 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tomoparts.tomoBay;

import java.io.File;

/**
 * this class's only purpose is contained within the internal enum, which provides the cross platform
 * paths and names of external files.
 * 
 * @author Jan P.C. Hanson
 *
 **/
public class External
{
	/**the cross platfor root directory for the tomoBay project**/
	private static final String PROJ_ROOT = System.getProperty("user.dir");
	
	/**
	 * 
	 * @author Jan P.C. Hanson
	 *
	 **/
	public enum Files
	{
		/**the name of the config file**/
		CONFIG_NAME("tomoBay.conf"),
		/**the path to the directory of the config file**/
		CONFIG_PATH(PROJ_ROOT+"|config|"),
		/**the absolute path to the config file**/
		CONFIG_FULL(PROJ_ROOT+"|config|tomoBay.conf"),
		
		/**the name of the royal mail csv file**/
		ROYAL_MAIL_CSV_NAME("RoyalMail.csv"),
		/**the path to the directory of the royal mail csv file**/
		ROYAL_MAIL_CSV_PATH(PROJ_ROOT+"|views|resources|"),
		/**the absolute path to the royal mail csv file**/
		ROYAL_MAIL_CSV_FULL(PROJ_ROOT+"|views|resources|RoyalMail.csv"),
		
		/**the name of the SSL certificate used by jetty**/
		JETTY_SSL_CERT_NAME("tomobay"),
		/**the absolute path to the java keystore that holds the SSL certificates**/
		JETTY_SSL_KEYSTORE(PROJ_ROOT+"|keystore|keystore.jks"),
		
		/**path to the directory holding the web client**/
		WEB_CLIENT_PATH(PROJ_ROOT+"|views|"),
		/**path of the tomobay public API endpoint**/
		PUBLIC_API_ENDPOINT("/res/*"),
		
		/**path of unsecured API endpoint**/
		RETARD_API_ENDPOINT("/retard/*")
		;
		
		/**holder for current instance name**/
		private final String file_M;
		
		/**the cross platform file seperator**/
		private static final String SEP = File.separator;
		/**
		 * private constructor allows access to the parenthetical value for the current enum const
		 * @param file the name of the enum const
		 **/
		private Files(String file)
		{this.file_M = file;}
		
		/**
		 * @return the String value of the current enum const
		 **/
		public String get()
		{return this.file_M.replace("|", SEP);}
	}
}
