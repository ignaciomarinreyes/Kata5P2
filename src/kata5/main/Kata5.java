package kata5.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kata5.model.Histogram;
import kata5.model.Mail;
import kata5.view.HistogramDisplay;
import kata5.view.MailHistogramBuilder;
import kata5.view.MailListReaderBD;

public class Kata5 {

    private List<Mail> mailList;
    private Histogram<String> histogram;
    private HistogramDisplay histoDisplay;

    public static void main(String[] args) {
        Kata5 kata5 = new Kata5();
        kata5.execute();
    }

    public void execute() {
        input();
        process();
        output();
    }

    public void input() {
        mailList = MailListReaderBD.read();
    }

    public void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }

    public void output() {
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}
