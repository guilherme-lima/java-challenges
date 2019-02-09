# Work Schedule

Work Schedule is a challenge proposed by HackerRank in order to verify VanHack's users coding skills. The summary of the instructions to this challenge is:

## Instructions

A completed schedule consists of exactly 7 digits in the range 0 to 8 representing each day's hours to be worked. You will get a pattern string similar to the schedule, but with some of the digits replaced by a question mark, ?, (ascii 63 decimal). Given a maximum number of hours you can work in a day, replace the question marks with digits so that the sum of the scheduled hours is exactly the hours you must work in a week. Return a string array with all possible schedules you can create, ordered lexicographically.

### Example: 
#### Input:
```bash
24
4
08??840
```

Your partial schedule, (String) pattern = "08??840", your required hours, (int) work_hours = 24, and you can only work, at most, (int) day_hours = 4 hours per day during the two days in question. You have two days on which you must work 24 - 20 = 4 more hours for the week. All of your possible schedules are listed below:

#### Output: 
```bash
0804840
0813840
0822840
0831840
0840840
```

### Constrains

* 1 ≤ work_hours ≤ 56
* 1 ≤ day_hours ≤ 8
* | pattern | = 7
* Each character of pattern ∈ {0, 1,...,8}
* There is at least one correct schedule.