package me.regexmc.subcommandhandler.example.subcommandhandler;

import java.lang.reflect.InvocationTargetException;

public interface SubCommand {
    void run(Object sender, String[] args, int index) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
