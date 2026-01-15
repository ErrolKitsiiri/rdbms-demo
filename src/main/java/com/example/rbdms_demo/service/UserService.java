package com.example.rbdms_demo.service;

import com.example.rbdms_demo.model.User;
import com.example.rdbms.engine.Database;
import com.example.rdbms.parser.SqlParser;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final Database db;
    private final SqlParser parser;

    public UserService(Database db, SqlParser parser) {
        this.db = db;
        this.parser = parser;
    }

    @PostConstruct
    public void init(){
        parser.execute("CREATE TABLE users (id INT PRIMARY KEY, name STRING, email STRING UNIQUE)");
    }

    public void createUser(User user){
        String sql = "INSERT INTO users VALUES ("
                + user.getUserId() + ", '"
                + user.getUserName() + "', '"
                + user.getUserEmail() + "')";
        parser.execute(sql);
    }

    public List<Map<String, Object>> getAllUsers(){
        return db.selectAll("users")
                .stream()
                .map(row -> row.getValues())
                .toList();
    }

    public void updateEmail(int id, String email) {
        parser.execute("UPDATE users SET email='" + email + "' WHERE id=" + id);
    }

    public void deleteUser(int id){
        parser.execute("DELETE FROM users WHERE id=" + id);
    }
}
