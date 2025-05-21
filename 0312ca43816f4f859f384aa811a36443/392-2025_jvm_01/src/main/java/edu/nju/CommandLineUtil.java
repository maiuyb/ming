package edu.nju;

import org.apache.commons.cli.*;

public class CommandLineUtil {
    private static CommandLine commandLine;
    private static CommandLineParser parser = new DefaultParser();
    private static Options options = new Options();
    private boolean sideEffect;
    public static final String WRONG_MESSAGE = "Invalid input.";

    /**
     * you can define options here
     * or you can create a func such as [static void defineOptions()] and call it before parse input
     */
    static {
    }

    /**
     * step1 add some option rules (you can do it in static{})
     * step2 parse the input
     * step3 handle options
     * @param args input of program
     */
    public void main(String[] args){

    }

    /**
     * Print the usage of all options
     * Actually, you can print anything to pass the test
     * but you are recommended to use HelpFormatter to see what will happen
     */
    private static void printHelpMessage() {
    }

    /**
     * Parse the input and handle exception
     * @param args origin args form input
     */
    public void parseInput(String[] args) {
    }

    /**
     * You can handle options here or create your own func
     */
    public void handleOptions() {
    }

    /**
     * edit to return the actual side effect flag
     */
    public boolean getSideEffectFlag(){
        return false;
    }

}