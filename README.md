# Bliki2

[![Build Status](https://travis-ci.org/cllu/bliki2.svg?branch=master)](https://travis-ci.org/cllu/bliki2)

This is a fork of [info.bliki.wiki](https://bitbucket.org/axelclk/info.bliki.wiki).

- Remove the following packages: api, wiki2html, html2wiki, template extension etc
- Add command to convert xml dump to tsv format file, in order to be consumed by MapReduce tools like Spark

To convert a xml dump to tsv format: 

    $ mvn compile
    $ mvn exec:java -Dexec.mainClass="info.bliki.cli.Main" -Dexec.args="src/test/resources/dump/enwiki-20150112-pages-articles1.xml.bz2 data/enwiki-pages.tsv"
