package me.creepinson.handlers;

import me.creepinson.gui.GuiMenu;
import me.creepinson.gui.GuiMobChamber;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	public static final int MENU = 0;
	public static final int MOB_CHAMBER = 1;
	
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	
		if(ID == MENU){
	
			
	}
	if(ID == MOB_CHAMBER){
	
	}
	return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos posget = new BlockPos(x, y, z);
		
		if(ID == MOB_CHAMBER){
			return new GuiMobChamber(posget);
		}
		if(ID == MENU){
			return new GuiMenu();
		}
	return null;
	
	}
	

	
	
	
}
