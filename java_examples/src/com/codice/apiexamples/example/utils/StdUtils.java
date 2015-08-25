package com.codice.apiexamples.example.utils;

import com.codice.apiexamples.api.models.*;

import java.util.List;
import java.util.Scanner;

/**
 * Utils class to easily print information about PlasticSCM
 */
public class StdUtils {

    public static void printRepositoryList(List<Repository> repositoryList) {
        StringBuilder sb = new StringBuilder();
        for (Repository repo : repositoryList) {
            sb.append(repo.getRepid().getId());
            sb.append(" ");
            sb.append(repo.getName());
            sb.append(" ");
            sb.append(repo.getServer());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void printBranchesList(List<Branch> branchList) {
        StringBuilder sb = new StringBuilder();
        for(Branch br : branchList) {
            sb.append(br.getId());
            sb.append(" ");
            sb.append(br.getName());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void printBranchInformation(Branch branch) {
        StringBuilder sb = new StringBuilder();
        sb.append("Complete name: ");
        sb.append(branch.getName());
        sb.append("@");
        sb.append(branch.getRepository().getName());
        sb.append("@");
        sb.append(branch.getRepository().getServer());
        sb.append(("\n"));
        sb.append("Creation date: ");
        sb.append(branch.getCreationDate());
        sb.append("\n");
        sb.append("Owner: ");
        sb.append(branch.getOwner().getName());
        sb.append("\n");
        System.out.println(sb.toString());
    }

    public static void printSwitchMessage(OperationStatus message) {
        StringBuilder sb = new StringBuilder();
        sb.append("Status: ");
        sb.append(message.getStatus());
        sb.append("\n");
        sb.append("Updated files: ");
        sb.append(message.getUpdatedFiles());
        sb.append("/");
        sb.append(message.getTotalFiles());
        sb.append("\n");
        sb.append("Updated bytes: ");
        sb.append(message.getUpdatedBytes());
        sb.append("/");
        sb.append(message.getTotalBytes());
        sb.append("\n");
        System.out.println(sb.toString());
    }

    public static int readIntegerFromConsole(String hint) {
        System.out.print(hint);
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static String readStringFromConsole(String hint) {
        System.out.print(hint);
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
