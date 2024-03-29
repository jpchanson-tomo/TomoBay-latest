package com.tomoparts.tomoBay.exceptions;
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
import com.tomoparts.tomoBay.helpers.NoImports;
/**
 * This exception relates to the winstock command payloads.
 * 
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public class PayloadException extends Exception
{
	/**
	 * needed to avoid warnings
	 */
	private static final long serialVersionUID = -1507552515269023845L;

	/**
	 * default ctor
	 */
	public PayloadException()
	{super();}
	
	/**
	 * ctor with message
	 * @param message
	 */
	public PayloadException(String message)
	{super(message);}
	
	/**
	 * ctor that uses the name provided as well as a throwable object to give a more detailed explanation
	 * of the exception
	 * @param message description of the problem
	 * @param e Exception usually an exception to provide a more detailed error
	 */
	public PayloadException(String message, Exception e)
	{super(message, e);}
}