package org.example.virtualkey.screens;

import org.example.virtualkey.services.DirectoryService;
import org.example.virtualkey.services.ScreenService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WelcomeScreen implements Screen{
    private final String welcomestring = "Welcome!";
    private final String author = "gang hu";

    private ArrayList<String> options = new ArrayList<>();

    public WelcomeScreen() {
        options.add("1. Show Files");
        options.add("2. Show File Options Menu");
        options.add("3. Quit");
    }

    public void welcome_information() {
        System.out.println(welcomestring);
        System.out.println(author);
        System.out.println("\n");
        show();
    }

    @Override
    public void show() {
        System.out.println("Main Menu");
        for (String s : options)  {
            System.out.println(s);
        }
    }

    @Override
    public void NavigateOption(int option) {
        switch (option)
        {
            case 1:
                this.ShowFiles();

                this.show();

                break;
            case 2:
                ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
                ScreenService.getCurrentScreen().show();
                ScreenService.getCurrentScreen().GetUserInput();

                this.show();

                break;

            default:
                System.out.println("Invalid Option");
                break;
        }
    }

    @Override
    public void GetUserInput() {
        int selectedoption = 0;
        while ((selectedoption = getOption()) != 3)
        {
            this.NavigateOption(selectedoption);
        }
    }

    public void ShowFiles()
    {
        System.out.println("List of Files: ");
        DirectoryService.PrintFiles();
    }


    private int getOption()
    {
        Scanner in = new Scanner(System.in);

        int Option = 0;
        try {
            System.out.print( "Please enter your option : " );
            Option = in.nextInt();
        }
        catch (InputMismatchException ex) {
            System.out.println("error occured in the function getOption");
        }
        return Option;
    }
}
