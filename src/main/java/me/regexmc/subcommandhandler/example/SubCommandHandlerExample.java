package me.regexmc.subcommandhandler.example;

import me.regexmc.subcommandhandler.example.commands.examplecommand.ExampleCommand;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(
        modid = SubCommandHandlerExample.MODID,
        name = SubCommandHandlerExample.NAME,
        version = SubCommandHandlerExample.VERSION,
        clientSideOnly = true
)
public class SubCommandHandlerExample {
    public static final String MODID = "subcommandhandlerexamplemod";
    public static final String NAME = "SubCommandHandlerExample";
    public static final String VERSION = "1.0";

    public static void sendMessage(String message) {
        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(message));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new ExampleCommand());
    }
}
