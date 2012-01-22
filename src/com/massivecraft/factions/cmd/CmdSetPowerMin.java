package com.massivecraft.factions.cmd;

import com.massivecraft.factions.struct.Permission;

public class CmdSetPowerMin extends FCommand
{
	public CmdSetPowerMin()
	{
		super();
		this.aliases.add("min");
		
		this.requiredArgs.add("player");
		this.requiredArgs.add("powermin");
		
		this.permission = Permission.ADMIN.node;
		this.disableOnLock = false;
		
		senderMustBePlayer = true;
		senderMustBeMember = false;
		senderMustBeOfficer = false;
		senderMustBeLeader = false;
	}
	
	@Override
	public void perform()
	{
		if (argAsFPlayer(0) != null) {
			(argAsFPlayer(0)).setPowerMin(argAsDouble(1));
			fme.msg("<i>You set " + argAsPlayer(0).getName() + " powerMin to " + argAsDouble(1));
		} else {
			fme.msg("<b>You can't set player " + argAsString(0) + " powerMin to " + argAsDouble(1));
		}
	}

}
