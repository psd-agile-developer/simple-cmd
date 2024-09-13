package cmd.commands.rename;

import picocli.CommandLine;

import java.io.File;

@CommandLine.Command(
        name = "rename",
        description = "command renames the file or directory",
        mixinStandardHelpOptions = true)
public class RenameCommand implements Runnable{

    @CommandLine.Parameters(index = "0", description = "path of the file/directory to rename")
    private File sourceFile;

    @CommandLine.Parameters(index = "1", description = "new name of the file/directory")
    private File target;

    @CommandLine.Option(names = {"-f", "--force"}, description = "force the renaming even if the target file already exists")
    private boolean force = false;

    public RenameCommand(){

    }

    // alternatively call MoveCommand
    @Override
    public void run() {
        if (sourceFile == null || sourceFile.exists() == false || target == null) {
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
            renameResult = sourceFile.renameTo(target);
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