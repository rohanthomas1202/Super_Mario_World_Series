# Super_Mario_World_Series
Calculate baseball leaders from away and home teams using Hash Tables

**Objective:Utilize common features of a hash table in the design of an object-oriented program**


**Problem:** Now that the Mushroom Kingdom League has ended and crowned a new champion, it is time to determine the league leaders in several different baseball categories.  Being the only person in the Mushroom Kingdom that knows how to write a computer program, you have been asked by Princess Peach herself to write a program that will determine the league leaders.

**Details**
- This program will calculate baseball stats based on the game play-by-play
  - Each possible plate appearance is provided in a file named keyfile.txt
- Start the program by prompting the user for the input filename.
  - Each player’s plate appearance will be given in a file
  - Analyze each plate appearance to determine the result (hit, out, strikeout, etc.)
  - Record the information for each player and determine leaders
- A ***hash table*** will be used for quick lookup of results
  - After reading the play, a hash table will be used to determine the result (i.e. H, O, K, etc.)
    - For example, a play of 1B (single) is a hit (H) (which as you know is also an at-bat and a plate appearance)
  - The result is then recorded for the player
- Another ***hash table*** is used to find and update the player stats




**Stats will be calculated for the following categories:**
  - Batting Average (BA)
    - Batting average = hits / at-bats
  - On-base percentage (OB%)
    - On-base percentage = (hits + walks + hit by pitch) / plate appearances
  - Strikeouts (K)
  - Walks (BB)
  - Hit by Pitch (HBP)
  - Hits (H)
  
  
***Input:***
   - All input will be read from a file.
   - Each line in the file will represent a plate appearanceand will follow the same format.
   - Line format: ``` <H/A><space><player name><space><plate appearance> ```
     - H Mario 6-3
   - The name will be a single word.
   - The plate appearance will be a sequence of characters (a code) describing what happened
     - All plate appearance “codes” will be valid and will be present in the results file provided
   - Errors are NOT considered an at-bat
   - Walks, sacrifices and hit by pitches are not considered an at-bat
   - Each line in the file will end in a newline (exceptthe last line which may or may not have a newline)
   - The total number of plate appearances may be different for each player
   - The input file willhave multiple entries for the same person
     - Combine data for each player
