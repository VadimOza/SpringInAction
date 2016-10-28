package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import spittr.Spitter;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by root on 27.10.16.
 */
@Repository
@ComponentScan("spittr.config")
public class JdbcSpitterRepository implements SpitterRepository {

    private static final String SELECT_USER_BY_USERNAME = "select username,fname, lname, password, email from test where username = ?";

    private JdbcOperations jdbcOperations;

    @Inject
    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }



    @Override
    public Spitter save(Spitter unsaved) {
        jdbcOperations.update("insert into test (username, password, email, fname, lname) VALUE (?,?,?,?,?)",
        unsaved.getUserName(),unsaved.getPassword(),unsaved.getEmail(),unsaved.getFirstName(),unsaved.getLastName());
        return unsaved;
    }

    @Override
    public Spitter findByUsername(String userName) {
        return jdbcOperations.queryForObject(SELECT_USER_BY_USERNAME, (rs, rowNum) -> new Spitter().setUserName(rs.getString("username"))
                .setEmail(rs.getString("email"))
                .setPassword(rs.getString("password"))
                .setFirstName(rs.getString("fname"))
                .setLastName(rs.getString("lname")),userName);

//        SqlRowSet rs = jdbcOperations.queryForRowSet(SELECT_USER_BY_USERNAME, userName);
//        if( rs.next() ){
//            Spitter spitter = new Spitter();
//            spitter.setUserName(userName);
//            spitter.setPassword(rs.getString("password"));
//            spitter.setEmail(rs.getString("email"));
//            spitter.setFirstName(rs.getString("fname"));
//            spitter.setLastName(rs.getString("lname"));
//            return spitter;
//        }
//        return null;
    }
}
