/*
 * This code and all components (c) Copyright 2006 - 2016, Wowza Media Systems, LLC. All rights reserved.
 * This code is licensed pursuant to the Wowza Public License version 1.0, available at www.wowza.com/legal.
*/
package com.wowza.wms.plugin;

import com.wowza.util.StringUtils;
import com.wowza.wms.application.IApplicationInstance;
import com.wowza.wms.httpstreamer.cupertinostreaming.httpstreamer.HTTPStreamerSessionCupertino;
import com.wowza.wms.logging.WMSLogger;
import com.wowza.wms.logging.WMSLoggerFactory;
import com.wowza.wms.module.ModuleBase;

public class CupertinoAutoMultibitrateFilter extends ModuleBase
{

	public static final String MODULE_NAME = "ModuleCupertinoAutoMultibitrateFilter";
	public static final String PROP_NAME_PREFIX = "cupertinoAutoMultibitrateFilter";
	
	private WMSLogger logger;
	private String[] userAgents = { "Macintosh;", "iPhone;", "iPad;", "iPod;", "AppleTV" };
	private boolean debugLog = false;

	public void onAppStart(IApplicationInstance appInstance)
	{
		logger = WMSLoggerFactory.getLoggerObj(appInstance);
		String userAgentsStr = appInstance.getProperties().getPropertyStr(PROP_NAME_PREFIX + "UserAgents", "");
		if (!StringUtils.isEmpty(userAgentsStr))
		{
			userAgents = userAgentsStr.split("\\|");
		}

		debugLog = appInstance.getProperties().getPropertyBoolean(PROP_NAME_PREFIX + "DebugLog", debugLog);
		if(logger.isDebugEnabled())
			debugLog = true;
	}

	public void onHTTPCupertinoStreamingSessionCreate(HTTPStreamerSessionCupertino httpSession)
	{
		String userAgent = httpSession.getUserAgent();

		if (userAgent != null)
		{
			boolean foundUserAgent = false;

			for (int i = 0; i < userAgents.length; i++)
			{
				if (userAgent.indexOf(userAgents[i].trim()) >= 0)
				{
					foundUserAgent = true;
					break;
				}
			}
			
			if(this.debugLog)
				logger.info(MODULE_NAME + ".onHTTPCupertinoStreamingSessionCreate: setAutoCreateMultibitratePlaylist:" + foundUserAgent + " userAgent:" + userAgent);

			httpSession.setAutoCreateMultibitratePlaylist(foundUserAgent);
		}
	}
}
