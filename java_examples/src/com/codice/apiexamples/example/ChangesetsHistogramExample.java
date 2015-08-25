package com.codice.apiexamples.example;


import com.codice.apiexamples.api.ApiService;
import com.codice.apiexamples.api.models.Changeset;
import com.codice.apiexamples.api.models.Repository;
import com.codice.apiexamples.example.utils.Histogram;
import com.codice.apiexamples.example.utils.Utils;

import java.text.ParseException;
import java.util.*;

/**
 * An example showing how are repositories and their changesets retrieved from the API.
 */
public class ChangesetsHistogramExample {

    private static ApiService api;

    private static String[] months = {
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "Septemgber",
            "October",
            "November",
            "December"
    };

    private static void printRepositoriesStats(List<Repository> repositories) {
        for (Repository repository : repositories) {
            try {
                printChangesetStats(repository);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printChangesetStats(Repository repository)
            throws ParseException {
        List<Changeset> changesets = api.getAllChangesets(repository.getName());
        Histogram histogram;

        System.out.println(
            "Contributions per month in '" + repository.getName() + "'");
        histogram = generateChangesetsPerMonthHistogram(changesets);
        System.out.println(histogram.toString());

        System.out.println(
            "Contributions per owner in '" + repository.getName() + "'");
        histogram = generateChangesetsPerOwnerHistogram(changesets);
        System.out.println(histogram.toString());
    }

    private static Histogram generateChangesetsPerMonthHistogram(
            List<Changeset> changesets) throws ParseException {
        int[] values = new int[12];

        for (Changeset cs : changesets) {
            values[cs.getCreationDate().getMonth()]++;
        }

        Histogram hs = new Histogram(80, '#', true);

        for (int i = 0; i < 12; i++) {
            hs.addCategory(months[i], values[i]);
        }

        return hs;
    }

    private static Histogram generateChangesetsPerOwnerHistogram(
            List<Changeset> changesets) {
        HashMap<String, Integer> contributors = new HashMap<String, Integer>();

        String owner;
        for (Changeset cs : changesets) {
            owner = cs.getOwner().getName();
            if (contributors.containsKey(owner)) {
                contributors.put(owner, contributors.get(owner) + 1);
                continue;
            }
            contributors.put(owner, 1);
        }

        Iterator it = contributors.entrySet().iterator();
        Histogram hs = new Histogram(80, '#', true);

        while(it.hasNext()) {
            Map.Entry<String, Integer> contributor =
                (Map.Entry<String, Integer>) it.next();
            hs.addCategory(contributor.getKey(), contributor.getValue());
        }

        return hs;
    }

    public static void main(String[] args) {
        api = Utils.getApiInstance();
        printRepositoriesStats(api.getAllRepositories());
    }
}
