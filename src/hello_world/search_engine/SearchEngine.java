package hello_world.search_engine;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class SearchEngine {
    public static void main(String[] args) throws IOException {
        String filePath = "/home/sara/Warsztaty_1/src/hello_world/search_engine/Main5.txt";


        String url = "https://www.wykop.pl/";
        String titleSelector = "a[title]";

        writeWordsFromSite("https://www.onet.pl/", "span.title");
        writeWordsFromSite(url, titleSelector);


    }

    private static void writeWordsFromSite(String url, String titleSelector) {
        Connection connect = Jsoup.connect(url);
        try {
            Document document = connect.get();
            Elements links = document.select(titleSelector);

            FileWriter out = new FileWriter("/home/sara/Warsztaty_1/src/hello_world/search_engine/Main5.txt", true);
            for (Element elem : links) {
                writeWordsToFile(out, elem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeWordsToFile(FileWriter out, Element elem) throws IOException {
        String[] splitSentence = elem.text().split(" "); //ctrl+alt+v
        for (int i = 0; i < splitSentence.length; i++) {
            out.append(splitSentence[i] + "\n");
            if (!splitSentence[i].isEmpty()) {

            }
        }
    }
}
//    Wczytaj utworzony plik popular_words.txt i na jego podstawie utwórz plik filtered_popular_words.txt,
//        który zawierać będzie wszystkie znalezione słowa, pomijając słowa wykluczone.