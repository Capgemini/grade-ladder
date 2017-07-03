# Grade Ladder
This grade-ladder both took inspiration from, and evolved out of [Camille Fournier](http://twitter.com/skalille)'s [Rent the Runway grade ladder] (http://dresscode.renttherunway.com/blog/ladder) (which in turn took its inspiration from the original Foursquare Engineering Ladder made by Harry Heymann, Jason Liszka and Andrew Hogue).

For us in Capgemini UK, we had the following four User Stories which we wanted to address:

* Attraction of potential recruits – this is how we value your skills at Capgemini
* Pre-interview – what grade might I be at Capgemini?
* Onboarding – I’ve just started at Capgemini, what is expected of me?
* Promotion – I want to get promoted. How do I get to the next grade?

We acknowledge that, while we tried to make them as future-proof as possible, these documents will change over time.  That's why we're putting them on github.

The current released version of the ladders is v.1.0.0-beta.

The next scheduled version of the ladders is v.1.0.0 (planned for January 2017)

### Setup
Node, Java and [Calibre]("https://calibre-ebook.com/") are pre-requisites to run the gradle tasks below.

#### Mac
Quickest way to get setup on the mac is with Brew
```shell
brew update
brew install node
brew cask install java
brew cask install calibre
npm install -g gitbook-cli
```

### Usage
Serving gitbook locally @ 127.0.0.1:4000
```shell
./gradlew serveBook
```

Generating a pdf, mobi and epub together or individually.
```shell
./gradlew buildAll

./gradlew buildPdf

./gradlew buildMobi

./gradlew buildEpub


```

The output of all these commands are found in the /output directory.
More details on how to customize the gitbook format can be found [here]("https://toolchain.gitbook.com/"").


# Authors
* [Andrew Harmel-Law](https://github.com/andrewharmellaw)
* [Tom Phethean](https://github.com/tsphethean)

# Contributors (thanks!)
* [Malcolm Young](https://github.com/malcomio)
* [Rob Horn](https://github.com/robhorn-capgemini)
* [Clive Hackney](https://github.com/chackney)
* [Kevin Rudland](https://github.com/krudland1978)
* Paul Barker
* [James Gee](https://github.com/geeman201)
* [Ant Broome](https://github.com/broomyocymru)
* [Russ Hart](https://github.com/rhart)
