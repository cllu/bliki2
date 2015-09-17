# Bliki2

[![Build Status](https://travis-ci.org/cllu/bliki2.svg?branch=master)](https://travis-ci.org/cllu/bliki2)

This is a fork of [info.bliki.wiki](https://bitbucket.org/axelclk/info.bliki.wiki).

- Remove the following packages: api, wiki2html, html2wiki, template extension etc
- Add command to convert xml dump to tsv format file, in order to be consumed by MapReduce tools like Spark

Targets:
- Provides a MediaWiki text parser
- Clean MediaWiki text to plain text
- Can read MediaWiki dump file

### Convert xml dump to tsv format

To convert a xml dump to tsv format (only the main content in namespace 0): 

    $ mvn compile
    $ mvn exec:java -Dexec.mainClass="info.bliki.cli.Main" -Dexec.args="src/test/resources/dump/enwiki-20150112-pages-articles1.xml.bz2 data/enwiki-pages.tsv"
    
    
The output format is like:

```
pageId\tTitle\tRedirect\tText
```

- only pages in namespace 0 will be dumped
- title is in the format of `w:Title_with_underscore`
- redirect is also in the format of `w:Redirect_Title`, if there is no redirect, then Redirect will be `null`
- if there is no text, then Text will be `null`