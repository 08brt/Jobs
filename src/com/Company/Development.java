package com.Unisys;

import java.util.ArrayList;
import java.util.Scanner;

public class Development {

    ArrayList<String> jobs;
    ArrayList<String> runningJobs;
    Scanner scanner = new Scanner(System.in);

    public Development() {
        PopulateJobs();
        GetRunningJobs();
        CheckExactMatch();
        CheckMinusOneCharacterMatch();
    }

    private void DisplayCorrectJobsMissing(ArrayList<String> jobsRemovedLastCharacter) {
        if (!jobsRemovedLastCharacter.isEmpty()) {
            System.out.println("JOBS NOT RUNNING ON DEVELOPMENT:");

            for(int i = 0; i < jobsRemovedLastCharacter.size(); i++) {
                for(int b = 0; b < jobs.size(); b++) {

                    if(jobs.get(b).contains(jobsRemovedLastCharacter.get(i))) {
                        System.out.println(jobs.get(b));
                    }

                }
            }
        }
    }
    //There are two stages
    //The first stage removes the last character from running jobs and compares it to jobs
    //The second stage removes the last character from running jobs and jobs then compares it
    //This is because when a job is 6 character the last letter increments alphabetically
    //But if the character is less than 6 characters an additional character is added at the end
    //Its confusing i know soorrrrryyy i didnt design this system
    private void CheckMinusOneCharacterMatch() {
        //
        //FIRST STAGE
        //

        //REMOVE LAST CHARACTER FROM RUNNING JOBS
        ArrayList<String> present = new ArrayList<>();
        ArrayList<String> runningJobsRemovedLastCharacter = new ArrayList<>();
        for(int i = 0; i < runningJobs.size(); i++) {
            runningJobsRemovedLastCharacter.add(removeLastChar(runningJobs.get(i)));
        }

        //COMPARE
        for (int i = 0; i < jobs.size(); i++) {
            for(int b = 0; b < runningJobsRemovedLastCharacter.size(); b++) {
                if (jobs.get(i).equals(runningJobsRemovedLastCharacter.get(b))) {
                    present.add(jobs.get(i));
                }
            }
        }

        //REMOVE
        for(int i = 0; i < present.size(); i++) {
            jobs.remove(present.get(i));
        }

        //
        //SECOND STAGE
        //

        //REMOVE LAST CHARACTER FROM JOBS
        ArrayList<String> jobsRemovedLastCharacter = new ArrayList<>();
        for(int i = 0; i < jobs.size(); i++) {
            jobsRemovedLastCharacter.add(removeLastChar(jobs.get(i)));
        }

        //COMPARE
        for (int i = 0; i < jobsRemovedLastCharacter.size(); i++) {
            for(int b = 0; b < runningJobsRemovedLastCharacter.size(); b++) {
                if (jobsRemovedLastCharacter.get(i).equals(runningJobsRemovedLastCharacter.get(b))) {
                    present.add(jobsRemovedLastCharacter.get(i));
                }
            }
        }

        //REMOVE
        for(int i = 0; i < present.size(); i++) {
            jobsRemovedLastCharacter.remove(present.get(i));
        }

        DisplayCorrectJobsMissing(jobsRemovedLastCharacter);
    }

    private void CheckExactMatch() {
        ArrayList<String> present = new ArrayList<>();

        //Get all jobs that are a exact match and put them into new array
        //Array is called 'present'
        for (int i = 0; i < jobs.size(); i++) {
            for(int b = 0; b < runningJobs.size(); b++) {
                if (jobs.get(i).equals(runningJobs.get(b))) {
                    present.add(jobs.get(i));
                }
            }
        }

        //Now run a loop and remove the present jobs
        //from the running jobs array for further testing
        for(int i = 0; i < present.size(); i++) {
            this.jobs.remove(present.get(i));
            this.runningJobs.remove(present.get(i));
        }
    }

    private String removeLastChar(String s) {
        return (s == null || s.length() == 0)
                ? null
                : (s.substring(0, s.length() - 1));
    }

    private void GetRunningJobs() {
        this.runningJobs = new ArrayList<>();

        while (true) {
            String line = scanner.next();
            line = line.split("/")[0];
            line = line.replaceAll("\\s+","");

            if (line.equalsIgnoreCase("quit")) {
                break;
            }

            this.runningJobs.add(line);
        }
    }

    public void PopulateJobs() {
        this.jobs = new ArrayList<>();

        //INSERT JOBS HERE
    }
}
