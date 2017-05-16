package com.oodles;

public class CustomController
{
    public CustomController()
    {
        super();
    }

    public void disableSystemExit()
    {
        SecurityManager securityManager = new StopExitSecurityManager();
        System.setSecurityManager(securityManager) ;
    }    
    
    public void enableSystemExit()
    {
    	System.out.println("enable called");
        SecurityManager mgr = System.getSecurityManager();
        if ((mgr != null) && (mgr instanceof StopExitSecurityManager))
        {
            StopExitSecurityManager smgr = (StopExitSecurityManager)mgr;
            System.setSecurityManager(smgr.getPreviousMgr());
        }
        else
            System.setSecurityManager(null);
    }
}
