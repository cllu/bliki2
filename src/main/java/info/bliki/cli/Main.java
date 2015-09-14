package info.bliki.cli;

import info.bliki.wiki.dump.IArticleFilter;
import info.bliki.wiki.dump.Siteinfo;
import info.bliki.wiki.dump.WikiArticle;
import info.bliki.wiki.dump.WikiXMLParser;
import org.xml.sax.SAXException;

import java.io.*;

/**
 */
public class Main {

    public static void main(String[] args) throws IOException, SAXException {
        if (args.length < 2) {
            System.err.println("Usage: Parser <xml-file.[bz2|gz]> <output>");
            System.exit(-1);
        }

        String dumpFilePath = args[0];
        String outputFilePath = args[1];

        final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath), "UTF-8"));
        new WikiXMLParser(new File(dumpFilePath), new IArticleFilter() {
            @Override
            public void process(WikiArticle page, Siteinfo siteinfo) throws SAXException {

                System.out.println(page.getTitle());

                String title = "w:" + page.getTitle().replace(" ", "_");
                String redirect;
                if (page.getRedirect() != null) {
                    redirect = "w:" + page.getRedirect().replace(" ", "_");
                } else {
                    redirect = "null";
                }
                String text = page.getText().replace("\\", "\\\\").replace("\n", "\\\\n").replace("\t", "\\\\t");

                StringBuilder sb = new StringBuilder();
                sb.append(page.getId()).append('\t')
                        .append(title).append('\t')
                        .append(redirect).append('\t')
                        .append(text).append('\n');

                try {
                    writer.write(sb.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).parse();

        writer.close();
    }
}
