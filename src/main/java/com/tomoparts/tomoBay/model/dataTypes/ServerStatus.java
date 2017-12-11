package com.tomoparts.tomoBay.model.dataTypes;
/** Copyright(C) 2015 Jan P.C. Hanson & Tomo Motor Parts Limited
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

/**
 *  This class represents the status of the server (surprise surprise) and provides functionality to
 *  get/set the status of the server.
 *  
 *  The purpose of this is to allow other parts of the system to set the status of the server so 
 *  that different modules can react differently given different server settings.
 *  
 *  This class is a singleton which uses eager instantiaion to make it threadsafe. The setStatus and
 *  getStatus methods are synchronised for the same reason.
 *  
 * @author Jan P.C. Hanson
 *
 */
public final class ServerStatus
{
	/**singleton instance variable**/
	private static final ServerStatus instance_M = new ServerStatus();
	/**status variable**/
	private static RunLevel status_M;
	/**enum providing allowed ServerStatus values**/
	public enum RunLevel {ERROR, RUNNING, PAUSED, STOPPED};
	
	/**
	 * private constructor ensures singleton is never instantiated
	 */
	private ServerStatus()
	{super();}
	
	/**
	 * retrieve an instance of this object
	 * @return ServerStatus
	 */
	public static ServerStatus instance()
	{return ServerStatus.instance_M;}
	
	/**
	 * allows a part of the system to set the status of the server. This method is synchronised to 
	 * ensure threadsafety
	 * @param status defined by the ServerStatus.RunLevel enum
	 */
	public synchronized void setStatus(ServerStatus.RunLevel status)
	{ServerStatus.status_M=status;}
	
	/**
	 * Allows a part of the system to query the current status of the server. This method is
	 * synchronised to ensure threadsafety.
	 * @return ServerStatus.Runlevel enum constant
	 */
	public static synchronized ServerStatus.RunLevel getStatus()
	{return ServerStatus.status_M;}
	
	/**
	 * returns the name of the os that the server is being run on.
	 * @return String containing the os name.
	 */
	public static String os() {return System.getProperty("os.name");}
}
