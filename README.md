# Forge Sub Command Handler
Why would you use this?????? 
...I made this because I was bored and the usage below sucks!

Anyway, basically this is an example mod for using the `me.regexmc.subcommandhandler.example.subcommandhandler.*` classes.

Usage

```java
/*************
 * Main.java *
 *************/

// ...

@Mod.EventHandler
public void init(FMLInitializationEvent event) {
    //Register command
    ClientCommandHandler.instance.registerCommand(new ExampleCommand());
}

```

```java
/***********************
 * ExampleCommand.java *
 ***********************/

// ...

@Override
public void processCommand(ICommandSender iCommandSender, String[] args) throws CommandException {
    try {
        // /examplecommand exampleone
        SubCommandHandler.handleSubcommand(iCommandSender, args, "exampleone", 0, ExampleSubCmdExampleOne.class, null);
        /*                                                        ^^           ^^             ^^
                                                            argument to match  index        code to run
                                                                 at index                when arg matches */
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
        e.printStackTrace();
    }
}

```

```java
/********************************
 * ExampleSubCmdExampleOne.java *
 ********************************/
public class ExampleSubCmdExampleOne implements SubCommand {
    @Override
    public void run(Object sender, String[] args, int index) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println(this.getClass().getSimpleName() + " ran."); // ExampleSubCmdExampleOne ran.

        /* /examplecommand exampleone   one
                            ^^          ^^
                            currently   to run
                            matched             */
        SubCommandHandler.handleSubcommand(sender, args, "one", index + 1, ExampleSubCmdExampleOneSubCmdOne.class, args[index]);
        /*                                                ^^           ^^             ^^
                                                    argument to match  index        code to run
                                                         at index                when arg matches */
    }
}
```

```java
/*****************************************
 * ExampleSubCmdExampleOneSubCmdOne.java *
 *****************************************/
public class ExampleSubCmdExampleOneSubCmdOne implements SubCommand { // /examplecommand exampleone one
    @Override
    public void run(Object sender, String[] args, int index) {
        System.out.println(this.getClass().getSimpleName() + " ran."); // ExampleSubCmdExampleOneSubCmdOne ran.
    }
}
```

