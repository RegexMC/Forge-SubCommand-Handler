package me.regexmc.subcommandhandler.example.commands.examplecommand;

import me.regexmc.subcommandhandler.example.SubCommandHandlerExample;
import me.regexmc.subcommandhandler.example.subcommandhandler.SubCommand;

public class ExampleSubCmdExampleTwoSubCmdTwo implements SubCommand {
    @Override
    public void run(Object sender, String[] args, int index) {
        System.out.println(this.getClass().getSimpleName() + " ran.");
        SubCommandHandlerExample.sendMessage(this.getClass().getSimpleName() + " ran.");
    }
}
