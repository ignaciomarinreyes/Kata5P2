package kata5.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5.model.Mail;

public class MailListReaderBD {

    private static Connection connect() throws SQLException {
        String urlConection = "jdbc:sqlite:KATA5.db";
        return DriverManager.getConnection(urlConection);
    }

    public static List<Mail> read() {
        List<Mail> mailList = new ArrayList<>();
        String query = "select * from email";
        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                mailList.add(new Mail(rs.getString("Mail")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mailList;
    }

}
