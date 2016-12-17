#Grade Ladder Generator

##About
This generator is used to create MarkDown documents describing the Software Engineering Ladder.  Using a single source of data it creates documents to support 2 use cases:

* _Checking for consistency_ - It creates a file called: SoftwareEngineeringFullLadder.md that lists out all expectations grouped by "trait" and then grade.
* Defining expectations for a given grade - It creates 10 files (one per grade) named like Software_Engineering_Ladder_A#.md5 that lists out all expectations gouped by "trait" for that grade.

The source data is a csv file of the form:

>"Expectation Text",1|2,DEX,SubTrait
> 
>Column 1: Expectation text - can be quote wrapped.
>
>Column 2: Pipe delimited grades.  The expectation will apply to all grades specified.
>
>Column 3: Trait - can be one of:
>
>* DEX = Technical Skills
>* T   = Soft Skills
>* STR = Getting Code Live
>* WIS = Impact
>* FEL = Team Leadership
>* CHA = Advocacy and Ambassadorship
>
>Column 4: Sub Trait - Only applies to WIS trait, and must be set.


##Build
Simply build using maven:

%> mvn clean install

##Run
%> mvn exec:java -Dexec.args="../input/expectations.csv ../"

#Authors
* [Rob Horn](https://github.com/robhorn-capgemini)

#Contributors (thanks!)
* [Andrew Harmel-Law](https://github.com/andrewharmellaw)
* [Ant Broome](https://github.com/broomyocymru)

