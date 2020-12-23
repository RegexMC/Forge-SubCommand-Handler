package me.regexmc.subcommandhandler.example.subcommandhandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SubCommandHandler {
    /**
     * <pre>
     * {@code
     * handleSubcommand(iCommandSender, args, "commandOne", 0, CommandOne.class, null);
     *
     * //CommandOne.class
     * @Override
     * public void run(Object sender, String[] args, int index, String previousArg) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
     *      handleSubcommand(iCommandSender, args, "subArgument", index+1, CommandOneSubCmdOne.class, args[index]);
     * }
     *
     * }
     * </pre>
     *
     * @param sender               Command Sender
     * @param args                 Arguments
     * @param subCommandName       Argument to match
     * @param index                Index of the sub command ( /cmd [0]sub [1]subsub [2]subsubsub ... )
     * @param subCommandClass      Class containing code to run when sub command called
     * @param callerSubCommandName Argument to match
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws java.lang.reflect.InvocationTargetException
     * @throws InstantiationException
     */
    public static void handleSubcommand(Object sender, String[] args, String subCommandName, int index, Class subCommandClass, String callerSubCommandName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (args.length > index) {
            if (args[index].equalsIgnoreCase(subCommandName)) {
                if (args.length > 1 && index > 0) {
                    if ((args[(index - 1)].equalsIgnoreCase(callerSubCommandName))) {
                        Method run = subCommandClass.getMethod("run", Object.class, String[].class, int.class);
                        run.invoke(subCommandClass.getDeclaredConstructor().newInstance(), sender, args, index);
                    }
                } else {
                    Method run = subCommandClass.getMethod("run", Object.class, String[].class, int.class);
                    run.invoke(subCommandClass.getDeclaredConstructor().newInstance(), sender, args, index);
                }
            }
        }
    }
}
