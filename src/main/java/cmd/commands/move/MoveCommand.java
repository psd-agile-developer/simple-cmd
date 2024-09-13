package cmd.commands.move;

import picocli.CommandLine;

import java.io.File;

@CommandLine.Command(
        name = "move",
        description = "command moves a file or directory",
        mixinStandardHelpOptions = true)
public class MoveCommand implements Runnable{

    @CommandLine.Parameters(index = "0", description = "path of the file/directory to move")
    private File sourceFile;

    @CommandLine.Parameters(index = "1", description = "new name of the file/directory")
    private File target;

    @CommandLine.Option(names = {"-f", "--force"}, description = "force the renaming even if the target file already exists")
    private boolean force = false;

    public MoveCommand(){

    }

    @Override
    public void run() {


        if (sourceFile == null || !sourceFile.exists() || target == null) {
            System.out.println("mandatory parameters not given. Please retry with --help");
            return;
        }

        if (target.exists() && force){
            try{
                target.delete();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        boolean renameResult = false;
        try {
            // Files.move();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        if (renameResult){
            System.out.println("renaming successful");
        }
        else{
            System.out.println("renaming not possible");
        }
    }
}