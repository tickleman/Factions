package com.massivecraft.factions.cmd;

import com.massivecraft.factions.struct.Permission;

public class CmdSetPowerMax extends FCommand
{
	public CmdSetPowerMax()
	{
		super();
		this.aliases.add("max");
		
		this.requiredArgs.add("player");
		this.requiredArgs.add("powermax");
		
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
			(argAsFPlayer(0)).setPowerMax(argAsDouble(1));
			fme.msg("<i>You set " + argAsPlayer(0).getName() + " powerMax to " + argAsDouble(1));
		} else {
			fme.msg("<b>You can't set player " + argAsString(0) + " powerMax to " + argAsDouble(1));
		}
	}

}
