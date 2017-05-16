package com.oodles;

import java.security.Permission;

public class StopExitSecurityManager extends SecurityManager
{
    private SecurityManager _prevMgr = System.getSecurityManager();

    @Override
    public void checkPermission(Permission perm)
    {
    	
    }

    @Override
    public void checkExit(int status)
    {
        super.checkExit(status);
        throw new ExitTrappedException();
    }

    public SecurityManager getPreviousMgr() { return _prevMgr; }
}