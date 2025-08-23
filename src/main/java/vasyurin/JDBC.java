package vasyurin;

import vasyurin.apiclient.ApiClient;

import java.sql.*;

public class JDBC {

    String url = "jdbc:postgresql://localhost:5432/TimeDataBase";
    String name = "postgres";
    String password = "postgres";


    public void WriteTimeDto(TimeDto timeDto) {

        String sql = "INSERT INTO timedto(id,currentdatetime, utcoffset, isdaylightsavingstime, dayoftheweek, timezonename, currentfiletime, ordinaldate, serviceresponse)" +
                "VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            Connection con = DriverManager.getConnection(url, name, password);
            PreparedStatement ps = con.prepareStatement(sql);
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
        }
    }

    public void ReadTimeDto() throws SQLException {
        String sql = "select * from timedto where id =1";

        Connection con = DriverManager.getConnection(url, name, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        System.out.println(rs.getArray( 2));
    }

}
