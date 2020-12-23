package me.regexmc.subcommandhandler.example.commands.examplecommand;

import me.regexmc.subcommandhandler.example.SubCommandHandlerExample;
import me.regexmc.subcommandhandler.example.subcommandhandler.SubCommand;
import me.regexmc.subcommandhandler.example.subcommandhandler.SubCommandHandler;

import java.lang.reflect.InvocationTargetException;

public class ExampleSubCmdExampleTwo implements SubCommand {
    @Override
    public void run(Object sender, String[] args, int index) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println(this.getClass().getSimpleName() + " ran.");
        SubCommandHandlerExample.sendMessage(this.getClass().getSimpleName() + " ran.");

        // /examplecommand exampletwo two
        SubCommandHandler.handleSubcommand(sender, args, "two", index + 1, ExampleSubCmdExampleTwoSubCmdTwo.class, args[index]);
    }
}
