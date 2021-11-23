package org.example.virtualkey.entities;


import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class Directory {
    public static final String pathname = "src/main/directory/";
    private ArrayList<File> files = new ArrayList<File>();

    Path path = FileSystems.getDefault().getPath(pathname).toAbsolutePath();

    File directory_files = path.toFile();

    public String pathname() {
        return pathname;
    }

    public void print()
    {
        System.out.println("Existing Files: ");
        files.forEach(f -> System.out.println(f));
    }

    public ArrayList<File> fillFiles()
    {
        File[] directortFiles = directory_files.listFiles();

        files.clear();
        for (int i = 0; i < directortFiles.length; i++) {
            if (directortFiles[i].isFile())
            {
                files.add(directortFiles[i]);
            }
        }

        Collections.sort(files);

        return files;

    }

    public ArrayList<File> getFiles() {
        fillFiles();
        return files;
    }
}
