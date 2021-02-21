# JavaCodeSamples

Task 1 - Anagrams

Write an application that reverses all the words of input text:

  E.g. "abcd efgh" => "dcba hgfe"

All non-letter symbols should stay on the same places:

  E.g. "a1bcd efg!h" => "d1cba hgf!e"

Use Latin alphabet for test only.

==================================================================

Task 2 - Char-counter

Write an application char-counter that takes a string and returns the number of unique characters in the string.

It is expected that a string with the same character sequence may be passed several times to the method.

Since the counting operation can be time-consuming, the method should cache the results, so that when the method is given a string previously encountered,

it will simply retrieve the stored result. Use collections and maps where appropriate.

==================================================================

Task 3 - Integer division

==================================================================

Task 4 - Formula 1

Write an application formula1. 

There are 2 log files start.log and end.log that contain start and end data of the best lap for each racer of Formula 1 - Monaco 2018 Racing. (Start and end times are fictional, but the best lap times are true). Data contains only the first 20 minutes that refers to the first stage of the qualification.

Q1: For the first 20 minutes (Q1), all cars together on the track try to set the fastest time. The slowest seven cars are eliminated, earning the bottom grid positions. Drivers are allowed to complete as many laps as they want during this short space of time.

Top 15 cars are going to the Q2 stage. If you are so curious, you can read the rules here https://www.thoughtco.com/developing-saga-of-formula1-qualifying-1347189

The third file abbreviations.txt contains abbreviation explanations.

Parse hint:
SVF2018-05-24_12:02:58.917

SVF - racer abbreviation 
2018-05-24 - date
12:02:58.917 - time

Your task is to read data from 2 files, order racers by time and print report that shows the top 15 racers and the rest after underline, for example:

1. Daniel Ricciardo      | RED BULL RACING TAG HEUER     | 1:12.013
2. Sebastian Vettel      | FERRARI                                         | 1:12.415
3. ...
------------------------------------------------------------------------
16. Brendon Hartley   | SCUDERIA TORO ROSSO HONDA | 1:13.179
17. Marcus Ericsson    | SAUBER FERRARI                           | 1:13.265

Use Java 8 API where appropriate.


