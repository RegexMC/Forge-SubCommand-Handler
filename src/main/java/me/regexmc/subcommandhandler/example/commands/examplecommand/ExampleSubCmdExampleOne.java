package me.regexmc.subcommandhandler.example.commands.examplecommand;

import me.regexmc.subcommandhandler.example.SubCommandHandlerExample;
import me.regexmc.subcommandhandler.example.subcommandhandler.SubCommand;
import me.regexmc.subcommandhandler.example.subcommandhandler.SubCommandHandler;

import java.lang.reflect.InvocationTargetException;

public class ExampleSubCmdExampleOne implements SubCommand {
    @Override
    public void run(Object sender, String[] args, int index) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println(this.getClass().getSimpleName() + " ran.");
        SubCommandHandlerExample.sendMessage(this.getClass().getSimpleName() + " ran.");

        // /examplecommand exampleone one
        SubCommandHandler.handleSubcommand(sender, args, "one", index + 1, ExampleSubCmdExampleOneSubCmdOne.class, args[index]);
    }
}
