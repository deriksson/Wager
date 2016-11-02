# Wager: Convert Bets to Probabilities

This command line Java application calculates the probabilities implied 
by actual odds quoted for a particular event.


## Installation

Compile the source code and create a JAR file using Maven:

```
mvn package
```


## Usage

On 2 November 2016, an online bookmaker offered the following odds for 
the US presidential election: Hillary Clinton 4/11 and Donald Trump 9/4.
Using the simplifying assumption that these were the only possible 
outcomes, the corresponding probabilities may be calculated using the 
following command:

```
java -cp target/wager-1.0.jar se.abc.wager.OddsToProbabilities 4/11 9/4
```

The output would be:

```
0.70
0.30
```

Instead of fractional odds it is also possible to use decimal odds:

```
java -cp target/wager-1.0.jar se.abc.wager.OddsToProbabilities 1.36 3.25
```