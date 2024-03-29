package com.tomoparts.tomoBay.model.sql;
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
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tomoparts.tomoBay.helpers.Config;
import com.tomoparts.tomoBay.helpers.ConfigReader;
/**
 * This class provides access to a pool of database connections. It is a threadsafe singleton
 * so always use the instance method to get an instance of this class, NEVER STORE THE INSTANCE.
 * @author Jan P.C. Hanson
 *
 */
public class ConnectionManager
{
	/**Singleton instance with eager instanciation**/
	private static ConnectionManager connMan_M = new ConnectionManager();
	/**C3P0 Data pool**/
	private ComboPooledDataSource cpds;
	
	/**
	 * singleton contstructor, initialises the connection pool
	 */
	private ConnectionManager()
	{
		
		cpds = new ComboPooledDataSource();
		try
		{cpds.setDriverClass("com.mysql.cj.jdbc.Driver");}
		catch (PropertyVetoException e)
		{e.printStackTrace();}
		
		cpds.setJdbcUrl(ConfigReader.getConf(Config.DB_QSTR));
		cpds.setUser(ConfigReader.getConf(Config.DB_USR));
		cpds.setPassword(ConfigReader.getConf(Config.DB_PWD));
		cpds.setMinPoolSize(Integer.parseInt(ConfigReader.getConf(Config.DB_CON_MIN)));
		cpds.setAcquireIncrement(Integer.parseInt(ConfigReader.getConf(Config.DB_AQUIRE_INC)));
		cpds.setMaxPoolSize(Integer.parseInt(ConfigReader.getConf(Config.DB_CON_MAX)));
		cpds.setMaxStatements(Integer.parseInt(ConfigReader.getConf(Config.DB_MAX_STMTS)));
	}
	
	/**
	 * instance method returns an instance of the ConnectionManager class
	 * @return ConnectionManager instance
	 */
	public static ConnectionManager instance()
	{return connMan_M;}
	
	/**
	 * retrieves a database connection from the pool of available connections. When
	 * Connection.close is called the connection is returned to the pool.
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException
	{return this.cpds.getConnection();}	
}
