package com.hackerrank.work_schedule;

import logger.MyLogger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class WorkSchedule extends MyLogger {

    public static void main(String[] args) {
        findSchedules(24, 4, "08??840").forEach(LOGGER::info);
    }

    private static List<String> findSchedules(final int maxWeekHours, final int maxDayHours, final String pattern) {
        final List<Integer> patternNumericValues = pattern
                .codePoints()
                .map(Character::getNumericValue)
                .boxed()
                .collect(toList());
        final int sumPatternHours = patternNumericValues
                .stream()
                .filter(n -> n > 0)
                .mapToInt(Integer::intValue)
                .sum();
        final List<Integer> indexesOfMissingDays = IntStream
                .range(0, 7)
                .map(i -> patternNumericValues.get(i) == -1 ? i : -1)
                .filter(i -> i >= 0)
                .boxed()
                .collect(toList());
        final int missingDaysCount = indexesOfMissingDays.size();
        final int missingHours = maxWeekHours - sumPatternHours;
        List<String> allAllowedCombinations = getAllAllowedCombinations(missingHours, missingDaysCount, maxDayHours);
        return replaceInPatternAndSort(pattern, indexesOfMissingDays, allAllowedCombinations);
    }

    private static List<String> getAllAllowedCombinations(int missingHours, int missingDaysCount, int maxDayHours) {
        List<Integer> allowedValues = IntStream
                .rangeClosed(0, maxDayHours)
                .boxed()
                .collect(Collectors.toList());
        List<List<Integer>> allPossibleCombinations = getAllPossibleCombinations(allowedValues, missingDaysCount);
        return allPossibleCombinations
                .stream()
                .filter(combination -> combination
                        .stream()
                        .mapToInt(Integer::intValue)
                        .sum() == missingHours)
                .map(combination -> combination
                        .stream()
                        .map(String::valueOf)
                        .reduce("", String::concat))
                .collect(toList());
    }

    private static List<List<Integer>> getAllPossibleCombinations(List<Integer> allowedValues, int missingDaysCount) {
        int allowedValuesCount = allowedValues.size();
        int max = (int) Math.pow(allowedValuesCount, missingDaysCount);
        return IntStream
                .range(0, max)
                .mapToObj(i -> IntStream
                        .range(0, missingDaysCount)
                        .mapToObj(j -> allowedValues.get((i / (int) Math.pow(allowedValuesCount, j)) % allowedValuesCount))
                        .collect(toList()))
                .collect(toList());
    }

    private static List<String> replaceInPatternAndSort(String pattern, List<Integer> indexesOfMissingDays, List<String> allAllowedCombinations) {
        return allAllowedCombinations
                .stream()
                .map(hours -> {
                    StringBuilder correctPattern = new StringBuilder(pattern);
                    IntStream
                            .range(0, indexesOfMissingDays.size())
                            .forEach(i -> correctPattern.replace(
                                    indexesOfMissingDays.get(i), indexesOfMissingDays.get(i) + 1, hours.substring(i, i + 1)));
                    return correctPattern.toString();
                })
                .sorted()
                .collect(toList());
    }
}