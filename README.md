
# Mastermind
# Notes
- using java 18
- check if need to add `junit` and `jupiter` on clone
## Assumptions 
Input is a string
- Could have to account for a variety of input, i.e. invalid input
  - i.e. sequences longer than 4, non-integer values, integer values outside 1-6

## Decisions made
- Since input is a `String`, I considered storing the secret code as a string 
but went with `int[]`  since comparing integer values is generally more efficient than string comparison
- Handle invalid input within the main.Main class,main.SecretCode.java shouldn't have to account for invalid input
- Invalid input also counts as a chance
- Secret code is generated on initialization of a SecretCode class. 
  - It's stored as an array, but a string representation of the code, i.e. "[1,2,3,4]" -> 1234 is made as well
    - primarily for testing purposes
    - converted into String on init so it doesn't need to be remade on each call to getter
## Check algorithm
1. First iterate through array and find matching characters between guess and secret code
   1. If a character doesn't match, we store the index & character in an ArrayList
   2. If a match is found, add a '+' onto the result
2. Then iterate through the unmatched indices
   1. If an index is unmatched, we check to see if we found that character somwhere else
      1. If found, we add a '-' onto the result
      2. Remove that character since it can only be scored once
3. Return the string 
## Testing
- Tested by running in console with example output below
- Wrote unit tests:
  - Tested for correct case & invalid case
## Example output
### Win example
```
Welcome to Mastermind! Please enter a 4 digit (1-6) number. You have 12 tries, good luck!
Enter your guess: 1111
++
Enter your guess: 1122
++
Enter your guess: 1133
+++
Enter your guess: 1134
+++
Enter your guess: 1135
You solved it!

Process finished with exit code 0
```

### Loss example
```
Welcome to Mastermind! Please enter a 4 digit (1-6) number. You have 12 tries, good luck!
Enter your guess: 1234
+-
Enter your guess: 1345
---
Enter your guess: 543
Your guess should be 4 integers.
Enter your guess: 5432
+-
Enter your guess: 5431
+--
Enter your guess: 1345
---
Enter your guess: 1435
---
Enter your guess: 3514
+--
Enter your guess: 5314
++-
Enter your guess: 5414
++-
Enter your guess: 5164
+++
Enter your guess: 5124
+++
You lose :(

Process finished with exit code 0
```

### Error handling
```
Welcome to Mastermind! Please enter a 4 digit (1-6) number. You have 12 tries, good luck!
Enter your guess: 
Your guess should be 4 integers.
Enter your guess: 12345
Your guess should be 4 integers.
Enter your guess: asdf
Your guess should not contain non-numeric characters.
Enter your guess: as12
Your guess should not contain non-numeric characters.
Enter your guess: 1111
+
Enter your guess: 1222
+
Enter your guess: 1333
++
Enter your guess: 1344
+++
Enter your guess: 1345
++--
Enter your guess: 1354
You solved it!
```