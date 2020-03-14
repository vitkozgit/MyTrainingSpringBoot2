package my.standard.crud.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class HelloRepositoryImpl implements HelloRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public HelloRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public HelloObject retrieveHelloObject(int id) {
        String sql = "SELECT * FROM HelloObject WHERE id=?";
        HelloObject helloObject = jdbcTemplate.queryForObject(sql, new HelloObjectRowMapper(), id);
        return helloObject;
    }

    @Override
    public HelloObject createHelloObject(HelloObject helloObject) {
        String sql = "INSERT INTO HelloObject (name,surname) VALUES (?,?)";
        jdbcTemplate.update(sql, helloObject.getName(), helloObject.getSurname());
        return helloObject;
    }

    @Override
    public HelloObject deleteHelloObject(int id) {
        return null;
    }

    @Override
    public HelloObject updateHelloObject(HelloObject helloObject) {
        return null;
    }

    private class HelloObjectRowMapper implements RowMapper<HelloObject> {

        @Override
        public HelloObject mapRow(ResultSet rs, int rowNum) throws SQLException {
            HelloObject helloObject = new HelloObject();
            helloObject.setId(rs.getInt("id"));
            helloObject.setName(rs.getString("name"));
            helloObject.setId(rs.getInt("id"));
            return null;
        }
    }
}
