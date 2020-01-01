package kata5.main;

import java.util.List;
import kata5.model.Histogram;
import kata5.model.Mail;
import kata5.view.HistogramDisplay;
import kata5.view.MailHistogramBuilder;
import kata5.view.MailListReader;

public class Kata5 {

    private final String fileName;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private HistogramDisplay histoDisplay;

    public Kata5(String fileName) {
        this.fileName = fileName;
    }

    public static void main(String[] args) {
        Kata5 kata4 = new Kata5("email");
        kata4.execute();
    }

    public void execute() {
        input();
        process();
        output();
    }

    public void input() {
        mailList = MailListReader.read(fileName);
    }

    public void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }

    public void output() {
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}
