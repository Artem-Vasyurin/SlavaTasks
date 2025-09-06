package vasyurin.persistence;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import vasyurin.dto.TimeDto;
import vasyurin.tasks.TimeRepositoryUpdater;

import java.io.IOException;
import java.sql.*;

@Component
public class JDBC  {

    private final CustomDataSource dataSource;

    public JDBC(@Value("${dbsource.url}") String url,
                @Value("${dbsource.username}") String username,
                @Value("${dbsource.password}") String password,
                @Value("${dbsource.driver-class-name}") String driver,
                @Value("${dbsource.pool.size}") int poolsize

    ) throws SQLException, ClassNotFoundException {

        Class.forName(driver);
        this.dataSource = new CustomDataSource(url,username,password,poolsize);
    }

    public Connection getConnection() throws SQLException, InterruptedException {
        return dataSource.getConnection();
    }

@Transactional(isolation = Isolation.SERIALIZABLE)
    public void save(TimeDto timeDto) throws IOException {

        String sql = "INSERT INTO timedto(id,currentdatetime, utcoffset, isdaylightsavingstime, dayoftheweek, timezonename, currentfiletime, ordinaldate, serviceresponse)" +
                "VALUES (?,?,?,?,?,?,?,?,?)";
        try (   Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1, Integer.parseInt(timeDto.$id()));
            ps.setString(2, timeDto.currentDateTime());
            ps.setString(3, timeDto.utcOffset());
            ps.setBoolean(4, timeDto.isDayLightSavingsTime());
            ps.setString(5, timeDto.dayOfTheWeek());
            ps.setString(6, timeDto.timeZoneName());
            ps.setLong(7, timeDto.currentFileTime());
            ps.setString(8, timeDto.ordinalDate());
            ps.setString(9, timeDto.serviceResponse());

            ps.executeUpdate();

            System.out.println("Data Inserted");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


@Transactional(readOnly = true)
    public void ReadTimeDto() throws SQLException, InterruptedException {
        String sql = "select * from timedto where id =1";
        Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        System.out.println(rs.getArray( 2));
    }

}
