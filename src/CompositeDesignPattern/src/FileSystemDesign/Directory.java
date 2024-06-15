package FileSystemDesign;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{

    String directoryName;
    List<FileSystem> fileSystemList;
    public Directory(String DirectoryName) {
        fileSystemList = new ArrayList<FileSystem>();
        this.directoryName = DirectoryName;
    }

    public void add(FileSystem fileSystem) {
        fileSystemList.add(fileSystem);
    }

    @Override
    public void ls() {
        System.out.println("Directory name: " + directoryName);
        for (FileSystem fileSystemObj : fileSystemList) {
            fileSystemObj.ls();
        }
    }
}
