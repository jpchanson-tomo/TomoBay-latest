package com.tomoparts.tomoBay.model.net.email;
import java.security.NoSuchProviderException;

import com.tomoparts.tomoBay.exceptions.NullEmailObjectException;
import com.tomoparts.tomoBay.exceptions.NullEmailServerObjectException;
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
 * This class is responsible for sending creating email and mail server objects. At the moment
 * there is only a MailServerSend class but at some point it may be worth implementing a 
 * recieving interface as well.
 * 
 * In order to create email and server objects an AbstractEmailBuilder must be passed in. This
 * builder determines the specifics of the email server that the system is to connect to.
 * @author Jan P.C. Hanson
 *
 */
public final class EmailDirector
{	
	/**holder for the builder that determines the specific email server to connect to**/
	AbstractEmailBuilder builder_M;
	
	/**
	 * default ctor
	 * @throws NoSuchProviderException
	 */
	public EmailDirector() throws NoSuchProviderException
	{super();}
	
	/**
	 * initialises the email and server objects ready to be retrieved by the get methods.
	 */
	public void constructEmailAndServer(AbstractEmailBuilder builder)
	{
		builder.buildMailServerSendConnection();
		builder.buildEmail();
		this.builder_M = builder;
	}
	
	/**
	 * returns the email object after it has been initialised using the builder provided to the 
	 * constructEmailAndServer method. if no builder has been provided to this object then a 
	 * NullEmailObjectException is thrown.
	 * @return Email and fully initialised Email object
	 * @throws NullEmailObjectException Exception that means that no builder object has been provided
	 * to the EmailDirector before this method was called
	 */
	public Email getEmail() throws NullEmailObjectException
	{
		if(this.builder_M.email_M != null)
		{return this.builder_M.email_M;}
		else
		{throw new NullEmailObjectException("Email not created, so cannot be retrieved");}
	}
	
	/**
	 * Provides functionality to access a MailServerSend object, which allows the sending of an Email.
	 * @return MailServerSend used to send emails
	 * @throws NullEmailServerObjectException indicates that no mailServer
	 */
	public MailServerSend getMailSendServer() throws NullEmailServerObjectException
	{
		if(this.builder_M.mailServer_M == null)
		{throw new NullEmailServerObjectException("mail server not created, so cannot be retrieved");}
		else
		{return this.builder_M.mailServer_M;}
	}
}
