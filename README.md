
# CodeKata project

[CodeKata](http://codekata.com/) is Kata sets for practicing programing introduced by Dave Thomas, who is known for an author of the famous book "The Pragmatic Programmer".

> How do you get to be a great musician? It helps to know the theory, and to understand the mechanics of your instrument. It helps to have talent. But ultimately, greatness comes from practicing; applying the theory over and over again, using feedback to get better every time.

> How do you get to be an All-Star sports person? Obviously fitness and talent help. But the great athletes spend hours and hours every day, practicing.

> But in the software industry we take developers trained in the theory and throw them straight in to the deep-end, working on a project. It’s like taking a group of fit kids and telling them that they have four quarters to beat the Redskins (hey, we manage by objectives, right?). In software we do our practicing on the job, and that’s why we make mistakes on the job. We need to find ways of splitting the practice from the profession. We need practice sessions.

So the word "Kata" is comming from Japanese traditional martial arts practice. As an Japanese and a softwear engineer who is trying to become better, I decided to follow these Katas introduced in the blog.
All Katas are not stored at this repository as some of them are not including coding exercise.

# Coverd Katas

The below Katas are covered and stored at this repository so far.

* [Kata02: Karate Chop](http://codekata.com/kata/kata02-karate-chop/)
> This Kata is straightforward. Implement a binary search routine (using the specification below) in the language and technique of your choice. Tomorrow, implement it again, using a totally different technique. Do the same the next day, until you have five totally unique implementations of a binary chop. (For example, one solution might be the traditional iterative approach, one might be recursive, one might use a functional style passing array slices around, and so on).

* [Kata04: Data Munging](http://codekata.com/kata/kata04-data-munging/)
> Part One: Weather Data
In weather.dat you’ll find daily weather data for Morristown, NJ for June 2002. Download this text file, then write a program to output the day number (column one) with the smallest temperature spread (the maximum temperature is the second column, the minimum the third column).

> Part Two: Soccer League Table
The file football.dat contains the results from the English Premier League for 2001/2. The columns labeled ‘F’ and ‘A’ contain the total number of goals scored for and against each team in that season (so Arsenal scored 79 goals against opponents, and had 36 goals scored against them). Write a program to print the name of the team with the smallest difference in ‘for’ and ‘against’ goals.

> Part Three: DRY Fusion
Take the two programs written previously and factor out as much common code as possible, leaving you with two smaller programs and some kind of shared functionality.

* [Kata05: Bloom Filters](http://codekata.com/kata/kata05-bloom-filters/)
> So, this kata is fairly straightforward. Implement a Bloom filter based spell checker. You’ll need some kind of bitmap, some hash functions, and a simple way of reading in the dictionary and then the words to check. For the hash function, remember that you can always use something that generates a fairly long hash (such as MD5) and then take your smaller hash values by extracting sequences of bits from the result.

* [Kata06: Anagrams](http://codekata.com/kata/kata06-anagrams/)
> The challenge is fairly simple: given a file containing one word per line, print out all the combinations of words that are anagrams; each line in the output contains all the words from the input that are anagrams of each other. 

* [Kata09: Back to the Checkout](http://codekata.com/kata/kata09-back-to-the-checkout/)
> This week, let’s implement the code for a supermarket checkout that calculates the total price of a number of items. In a normal supermarket, things are identified using Stock Keeping Units, or SKUs. In our store, we’ll use individual letters of the alphabet (A, B, C, and so on). Our goods are priced individually. In addition, some items are multipriced: buy n of them, and they’ll cost you y cents. For example, item ‘A’ might cost 50 cents individually, but this week we have a special offer: buy three ‘A’s and they’ll cost you $1.30. In fact this week’s prices are:
>
```
Item   Unit      Special
       Price     Price
  --------------------------
    A     50       3 for 130
    B     30       2 for 45
    C     20
    D     15
```

* [Kata11: Sorting It Out](http://codekata.com/kata/kata11-sorting-it-out/)


> ① Sorting Balls: In the Pragmatic Lottery (motto: There’s One Born Every Minute, and it Might Just Be You!), we select each week’s winning combination by drawing balls. There are sixty balls, numbered (not surprisingly, as we are programmers) 0 to 59. The balls are drawn by the personable, but somewhat distracted, Daisy Mae. As a result, some weeks five numbers are drawn, while other weeks seven, nine, or even fifteen balls make it to the winner’s rack. Regardless of the number of balls drawn, our viewers need to see the list of winning numbers in sorted order just as soon as possible. So, your challenge is to come up with some code that accepts each number as it is drawn and presents the sorted list of numbers so far. The tests might look something like:
```ruby
rack = Rack.new
assert_equal([], rack.balls)
rack.add(20)
assert_equal([ 20 ], rack.balls)
rack.add(10)
assert_equal([ 10, 20 ], rack.balls)
rack.add(30)
assert_equal([ 10, 20, 30 ], rack.balls)
```

>② Sorting Characters: Our resident conspiracy expert, Dr. X, is looking for hidden messages in the collected publications of Hugh Hefner. Dr. X believes the message is hidden in the individual letters, so rather than get distracted by the words, he’s asked us to write a program to take a block of text and return the letters it contains, sorted. Given the text:
>
```
When not studying nuclear physics, Bambi likes to play
beach volleyball.
```

>our program would return:
>
```
aaaaabbbbcccdeeeeeghhhiiiiklllllllmnnnnooopprsssstttuuvwyyyy
```
> The program ignores punctuation, and maps upper case to lower case.

* [Kata13: Counting Code Lines](http://codekata.com/kata/kata13-counting-code-lines/)
>This week let’s write something vaguely useful: a utility that counts the number of lines of actual code in a Java source file. For the purpose of this exercise, a line is counted if it contains something other than whitespace or text in a comment. Some simple examples:
>
```java
  // This file contains 3 lines of code
  public interface Dave {
    /**
     * count the number of lines in a file
     */
    int countLines(File inFile); // not the real signature!
   }
``` 
> and…
>
```java
/*****
* This is a test program with 5 lines of code
*  \/* no nesting allowed!
//*****//***/// Slightly pathological comment ending...
>
public class Hello {
    public static final void main(String [] args) { // gotta love Java
      // Say hello
      System./*wait*/out./*for*/println/*it*/("Hello/*");
    }
> 
}
```

* [Kata14: Tom Swift Under the Milkwood](http://codekata.com/kata/kata14-tom-swift-under-the-milkwood/)
> Trigram analysis is very simple. Look at each set of three adjacent words in a document. Use the first two words of the set as a key, and remember the fact that the third word followed that key. Once you’ve finished, you know the list of individual words that can follow each two word sequence in the document. For example, given the input:
>
```
I wish I may I wish I might
```
You might generate:
>
```
"I wish" => ["I", "I"]
"wish I" => ["may", "might"]
"may I"  => ["wish"]
"I may"  => ["I"]
```
This says that the words “I wish” are twice followed by the word “I”, the words “wish I” are followed once by “may” and once by “might” and so on.
To generate new text from this analysis, choose an arbitrary word pair as a starting point. Use these to look up a random next word (using the table above) and append this new word to the text so far. This now gives you a new word pair at the end of the text, so look up a potential next word based on these. Add this to the list, and so on.....

* [Kata18: Transitive Dependencies](http://codekata.com/kata/kata18-transitive-dependencies/)
> Let’s write some code that calculates how dependencies propagate between things such as classes in a program.
......
One of the insidious things about dependencies is that they are transitive—if A depends on B and B depends on C, then A also depends on C. So, let’s write some code that calculates the full set of dependencies for a group of items. The code takes as input a set of lines where the first token is the name of an item. The remaining tokens are the names of things that this first item depends on. Given the following input, we know that A directly depends on B and C, B depends on C and E, and so on.
>
```
  A   B   C
  B   C   E
  C   G
  D   A   F
  E   F
  F   H
```
The program should use this data to calculate the full set of dependencies. For example, looking at B, we see it directly depends on C and E. C in turn relies on G, E relies on F, and F relies on H. This means that B ultimately relies on C, E, F, G, and H. In fact, the full set of dependencies for the previous example is:
>
```
  A   B C E F G H
  B   C E F G H
  C   G
  D   A B C E F G H
  E   F H
  F   H
```

# Note

The Copyright of the content of [CodeKata](http://codekata.com/) must be attributed to  Dave Thomas.


# Author

* Takuya Natsume
* Company：[Brisys](https://www.brisys.co.jp/)
* Twitter:https://twitter.com/xxtyzs
* Qiita:https://qiita.com/Takuyaaaa
