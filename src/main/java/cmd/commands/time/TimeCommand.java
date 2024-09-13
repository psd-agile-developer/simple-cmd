package cmd.commands.time;

import picocli.CommandLine;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@CommandLine.Command(
        name = "time",
        description = "command shows the current time",
        mixinStandardHelpOptions = true)
public class TimeCommand implements Runnable{

    private static String standard_pattern = "HH:mm:ss";

    @CommandLine.Option(names = {"-f", "--format"}, description = "Time format")
    private String format;

    public TimeCommand(){

    }

    @Override
    public void run() {

        String pattern = "HH:mm:ss";

        if(format != null && format.trim().length() > 0){
            pattern = format;
        }
        DateTimeFormatter dtf = null;
        try {
            dtf = DateTimeFormatter.ofPattern(pattern);
        }catch (Exception e){
            System.out.println("Your date format is invalid. Standard format used.");
            dtf = DateTimeFormatter.ofPattern(standard_pattern);
        }

        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
}