package ua.rudikc.cinema.dao.sqlimplementation;

import org.junit.Test;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.entity.Seance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


public class SeanceSqlDaoTest {

    @Test
    public void extractFromResultSetTest() {
        Seance seance = null;
        SeanceSqlDao seanceSqlDao = new SeanceSqlDao();
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement("SELECT * FROM cinema_db.seances");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                seance = seanceSqlDao.extractFromResultSet(resultSet);
            }
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd mm:HH:ss");
        } catch (SQLException | DaoException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void shouldReturnTrueIfDate() {
        SeanceSqlDao seanceSqlDao = new SeanceSqlDao();
        try {
            List<Seance> seances = seanceSqlDao.findSeancesByDate("2019-08-12");
            for (Seance seance :
                    seances) {
                System.out.println(seance.getStart());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }
}