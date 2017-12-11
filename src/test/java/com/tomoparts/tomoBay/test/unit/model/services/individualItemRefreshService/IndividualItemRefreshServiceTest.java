package com.tomoparts.tomoBay.test.unit.model.services.individualItemRefreshService;

import com.tomoparts.tomoBay.model.services.ServiceFactory;
import com.tomoparts.tomoBay.model.services.ServiceFactory.ConfiguredServiceType;
import com.tomoparts.tomoBay.model.services.TriggerService;
import com.tomoparts.tomoBay.model.services.individualItemRefreshService.IndividualItemRefreshConfig;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class IndividualItemRefreshServiceTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
		
		long value = 331606242311l;
		TriggerService.start(ServiceFactory.make(ConfiguredServiceType.INDVIDUAL_ITEM_REFRESH_SERVICE, 
												new IndividualItemRefreshConfig().configure(value)));

	}

}