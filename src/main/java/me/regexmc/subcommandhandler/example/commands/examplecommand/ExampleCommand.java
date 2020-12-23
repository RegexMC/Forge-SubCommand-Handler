package me.regexmc.subcommandhandler.example.commands.examplecommand;

import me.regexmc.subcommandhandler.example.subcommandhandler.SubCommandHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExampleCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "examplecommand";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/" + getCommandName();
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        List<String> defaultSubcommands = new ArrayList<>(Arrays.asList("exampleone", "exampletwo", "examplethree"));

        if (args.length == 1) {
            return getListOfStringsMatchingLastWord(args, defaultSubcommands.toArray(new String[0]));
        } else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("exampleone")) {
                List<String> whitelistSubcommands = new ArrayList<>(Collections.singletonList("one"));
                return getListOfStringsMatchingLastWord(args, whitelistSubcommands.toArray(new String[0]));
            } else if (args[0].equalsIgnoreCase("exampletwo")) {
                List<String> whitelistSubcommands = new ArrayList<>(Collections.singletonList("two"));
                return getListOfStringsMatchingLastWord(args, whitelistSubcommands.toArray(new String[0]));
            } else if (args[0].equalsIgnoreCase("examplethree")) {
                List<String> whitelistSubcommands = new ArrayList<>(Collections.singletonList("three"));
                return getListOfStringsMatchingLastWord(args, whitelistSubcommands.toArray(new String[0]));
            }
        }
        return null;
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] args) throws CommandException {
        try {
            // /examplecommand exampleone
            SubCommandHandler.handleSubcommand(iCommandSender, args, "exampleone", 0, ExampleSubCmdExampleOne.class, null);
            // /examplecommand exampletwo
            SubCommandHandler.handleSubcommand(iCommandSender, args, "exampletwo", 0, ExampleSubCmdExampleTwo.class, null);
            // /examplecommand examplethree
            SubCommandHandler.handleSubcommand(iCommandSender, args, "examplethree", 0, ExampleSubCmdExampleThree.class, null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}

