package me.creepinson.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import me.creepinson.main.Main;
import me.creepinson.entities.TileEntityMobChamber;
import me.creepinson.handlers.GuiHandler;
import me.creepinson.handlers.ItemHandler;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockMobChamber extends ModBlocks implements ITileEntityProvider

{
 
	public BlockMobChamber(Material mat, String name, CreativeTabs tab, float hardness, float resistance, int harvest, String tool) {
		 
		super(mat, tool, tab, resistance, resistance);
		 this.setUnlocalizedName("MobChamber");
	        this.setHardness(2.0f);
	        this.setResistance(6.0f);
	       
	       
	       
	       
	       
		 }

   @Override
public TileEntity createTileEntity(World world, IBlockState state) {
	
	return new TileEntityMobChamber();
}

@Override
public TileEntity createNewTileEntity(World worldIn, int meta) {
	
	return new TileEntityMobChamber();
}


@Override
public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
{
	
		 player.openGui(Main.instance, GuiHandler.MOB_CHAMBER, world, pos.getX(), pos.getY(), pos.getZ());
	 
	

    return true;
}
@SideOnly(Side.CLIENT)
@Override
public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
{
	TileEntityMobChamber te = (TileEntityMobChamber) worldIn.getTileEntity(pos);
    if(te != null && te.isFormed())
    {
        //Spawn some particles
        for(int i = 0; i < rand.nextInt(20) + 10; i++)
            worldIn.spawnParticle(EnumParticleTypes.FLAME,
                    pos.getX() - 1 + (rand.nextDouble() * 3),
                    pos.getY() + 3.125,
                    pos.getZ() - 1 + (rand.nextDouble() * 3),
                    0, 0, 0);
    }
}
@Override
public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
	TileEntityMobChamber te = (TileEntityMobChamber) worldIn.getTileEntity(pos);
	IItemHandler handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null); 
	for(int slot = 0; slot < handler.getSlots() - 1; slot++)
	{
		ItemStack stack = handler.getStackInSlot(slot);
	InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	super.breakBlock(worldIn, pos, state);
}
private static List<ItemStack> chestInv = new ArrayList<ItemStack>();
public static void buildMob(BlockPos pos, World world, EntityPlayer player) {

	
		 ArrayList<ItemStack> mutantzombie_4l = new ArrayList<ItemStack>();
			mutantzombie_4l.add(new ItemStack(Items.EGG, 1));
			mutantzombie_4l.add(new ItemStack(Items.BONE, 2));
			mutantzombie_4l.add(new ItemStack(ItemHandler.Syringe, 1, 1));
			BlockPos posmain = pos.up(1);
	TileEntity tet =  world.getTileEntity(posmain);


ArrayList<ItemStack> checkie = new ArrayList<ItemStack>();

	for (int i = 0; i < ((TileEntityChest) tet).getSizeInventory(); i++) {
		
		ItemStack stackie = ((TileEntityChest) tet).getStackInSlot(i);
		
boolean cResult = BlockMobChamber.check(mutantzombie_4l, stackie);
if(cResult == true){
	  checkie.add(stackie);
}
			
}

	  for(int k = 0; k < mutantzombie_4l.size(); k++){
		ItemStack me = mutantzombie_4l.get(k);
		boolean cMeep = BlockMobChamber.check(checkie, me);
	 if(cMeep == true){
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.GREEN + "Building Mob"));
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.BLUE + "."));
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.BLUE + ".."));	
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.BLUE + "..."));
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.BLUE + "...."));
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.BLUE + "....."));
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.GREEN + "                          "));
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.GREEN + "                          "));
		 
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.GREEN + "Built Mob Successfully"));
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.GREEN + "                          "));
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.GREEN + "                          "));
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.GREEN + "Spawning Mob"));
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.BLUE + "."));
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.BLUE + ".."));	
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.BLUE + "..."));
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.BLUE + "...."));
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.BLUE + "....."));
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.BLUE + "......"));
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.GREEN + "                          "));
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.GREEN + "                          "));
			
		  
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.GREEN + "Built and Spawned Mob Successfully!"));
		world.spawnEntityInWorld(player);
	EntityZombie zombie = new EntityZombie(world);
	BlockPos mob = posmain.up(1);
	zombie.setPositionAndUpdate(mob.getX(), mob.getY(), mob.getZ());
		world.spawnEntityInWorld(zombie);
	 }
	 
	 else if(cMeep == false){
		 player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.RED + "Action Failed..."));
	return;	 	
	 }
	  }
			 
		
			
		  }
	 
	
		
	
	 
		 
	
				 
	
			  
	 
	 
					

	 



	



public static boolean check(ArrayList<ItemStack> mutantzombie_4l,  ItemStack meep)
{
    for(int i = 0; i < mutantzombie_4l.size(); i++)
    {
        if(ItemStack.areItemStacksEqual(mutantzombie_4l.get(i), meep))
        {
            return true;
        }
    }
    return false;
}
}