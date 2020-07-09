package com.tensorflow.util;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class expOverTimeListener implements ServletContextListener {
	
	private Timer timer = null;

    public expOverTimeListener() {
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
         timer = new Timer();
         timer.schedule(new DeletePodTimerTask(arg0.getServletContext()), 10000, 30000);
    }
	
}
