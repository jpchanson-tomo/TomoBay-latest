package com.tomoparts.tomoBay.model.net.email;
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
import java.security.NoSuchProviderException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.tomoparts.tomoBay.exceptions.NullEmailObjectException;
import com.tomoparts.tomoBay.exceptions.NullEmailServerObjectException;
import com.tomoparts.tomoBay.helpers.Config;
import com.tomoparts.tomoBay.helpers.ConfigReader;

/**
 * Client class to the builder pattern used to create and send Emails. has one public method send()  
 * which allows the user to send an email.
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class MailClient
{
	public MailClient()
	{super();}
	
	/**
	 * sends an email containing a message and subject.
	 * @param message the body of the email 
	 * @param subject the subject of the email
	 * @param to array of Strings containing email addresses
	 * @param cc array of Strings containing email addresses to CC
	 * @param bcc array of Strings containing email addresses to BCC
	 * @param builder the builder responsible to 
	 * @return String saying "sent"
	 */
	public static String send
	(String message, String subject, String[] to, String[] cc, String[] bcc, AbstractEmailBuilder builder)
	{
		try
		{
			EmailDirector mailmanager = new EmailDirector();
			mailmanager.constructEmailAndServer(builder);
			MailServerSend mailServer = mailmanager.getMailSendServer();
			Email email = MailClient.setUpEmail(message,subject,to,cc,bcc, mailmanager);
			String address = ConfigReader.getConf(Config.MAIL_ADDR);
			String pwd = ConfigReader.getConf(Config.MAIL_PWD);
			mailServer.send(email, address, pwd);
		}
		catch (NoSuchProviderException e){e.printStackTrace();} 
		catch (NullEmailObjectException e){e.printStackTrace();} 
		catch (NullEmailServerObjectException e){e.printStackTrace();} 
		catch (AddressException e){e.printStackTrace();} 
		catch (MessagingException e){e.printStackTrace();}
		
		return "sent";
	}
	
	/**
	 * set up the email ready to use in the rest of the mail client
	 * @param message The message that is the main body of the email
	 * @param subject the subject line of the email
	 * @param to array of email addresses that this email should be sent to
	 * @param cc array of email addresses that should be CC'd in this email
	 * @param bcc array of email addresses that should be BCC'd in this email
	 * @param mailmanager The EmailDirector that is responsible for this email
	 * @return Email completely se up email object that is ready to send
	 * @throws AddressException
	 * @throws MessagingException
	 * @throws NullEmailObjectException
	 */
	private static Email setUpEmail(String message, String subject, String[] to, String[] cc, String[] bcc, EmailDirector mailmanager) 
			throws AddressException, MessagingException, NullEmailObjectException
	{
		Email email = mailmanager.getEmail();
		for(String t : to) {email.setRecipient(Message.RecipientType.TO, t);}
		for(String c : cc) {email.setRecipient(Message.RecipientType.CC, c);}
		for(String b : bcc) {email.setRecipient(Message.RecipientType.BCC, b);}
		email.setSubject(subject);
		email.setMessage(message);
		return email;
	}
}
