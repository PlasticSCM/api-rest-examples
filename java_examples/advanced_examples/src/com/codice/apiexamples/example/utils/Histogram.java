package com.codice.apiexamples.example.utils;

import java.util.ArrayList;

/**
 * A basic stdout histogram representation.
 */
public class Histogram {

    private int mMaxLineLen;
    private char mChar;

    private double mMaxValue;

    private boolean mWithValue;

    private int mMaxCategoryNameLen;

    private ArrayList<Double> mValues;
    private ArrayList<String> mCategories;

    /**
     *
     * @param lineLength the maximum number of characters that can occupy each line of the histogram.
     * @param barChar the character to fill the histogram bars with.
     * @param withValue whether or not the value should be displayed at the end of each bar.
     */
    public Histogram(int lineLength, char barChar, boolean withValue) {
        mValues = new ArrayList<>();
        mCategories = new ArrayList<>();
        mMaxLineLen = lineLength;
        mChar = barChar;
        mWithValue = withValue;
    }

    /**
     * Sets the value of the specified category. If the category already exists
     * in the histogram, it will be repeated.
     *
     * @param category the category of the value.
     * @param value the value.
     */
    public void addCategory(String category, double value) {
        mCategories.add(category);
        mValues.add(value);

        mMaxValue = (value > mMaxValue) ? value : mMaxValue;

        mMaxCategoryNameLen = getMaxNameLength(category);
    }

    @Override
    public String toString() {
        int maxBarSize = mMaxLineLen - mMaxCategoryNameLen - 3;
        StringBuilder result = new StringBuilder();
        String formatStr = getFormatString();
        String category;
        Double value, barSize;

        for (int i = 0; i < mValues.size(); i++) {
            category = mCategories.get(i);
            value = mValues.get(i);
            barSize = (value / mMaxValue) * maxBarSize;

            if (mWithValue) {
                result.append(String.format(
                    formatStr,
                    category,
                    repeatString(mChar, barSize.intValue()), value));
                continue;
            }
            result.append(String.format(
                formatStr,
                category,
                repeatString(mChar, barSize.intValue())));
        }

        return result.toString();
    }

    private int getMaxNameLength(String category) {
        if (category.length() <= mMaxCategoryNameLen)
            return mMaxCategoryNameLen;
        return category.length();
    }
    
    private String getFormatString() {
        if (mWithValue)
            return "%-" + mMaxCategoryNameLen + "s : %s %.0f\n";
        return "%-" + mMaxCategoryNameLen + "s : %s\n";
    }

    private String repeatString(char character, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(character);
        }
        return sb.toString();
    }
}
