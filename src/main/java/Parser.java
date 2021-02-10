import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Parser {
    public static void main(String[] args) throws IOException {


        String url = "https://www.marathonbet.ru/su/popular/Football+-+11?interval=ALL_TIME";

        Document page = getPage(url);

        Element tableTitle = page.select("table[class=coupon-row-item coupone-labels]").first();

        Element nameFirst = tableTitle.select("th[class=first ]").first();
        System.out.println(nameFirst.text());

        Elements names = tableTitle.select("th[class=coupone coupone-width-10]");

        for (Element name : names) {
            Element nameShort = name.select("span[class=hint]").first();
            System.out.println(nameShort.text());
        }

    }

    private static Document getPage(String url) throws IOException {

        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }
}
