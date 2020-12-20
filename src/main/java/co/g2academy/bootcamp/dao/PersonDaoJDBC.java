package co.g2academy.bootcamp.dao;

import co.g2academy.bootcamp.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoJDBC {

    // 1. declaration variable
    private Connection connection;
    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement getByUserNameStatement;
    private PreparedStatement getAllStatement;

    // 2. initialize method
    private final String insertQuery = "insert into T_PERSON(name,password) " + " values(?,?)";
    private final String updateQuery = "update T_PERSON set name=?, " + " password=? where id=?";
    private final String deleteQuery = "delete from T_PERSON where id=?";
    private final String getByIdQuery = "select * from T_PERSON where id =?";
    private final String getByUserNameQuery = "select * from T_PERSON where name =?";
    private final String getAllQuery = "select * from T_PERSON";

    // 3. set up connection, untuk menyatukan antara method dan connection
    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
        insertStatement = this.connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
        updateStatement = this.connection.prepareStatement(updateQuery);
        deleteStatement = this.connection.prepareStatement(deleteQuery);
        getByIdStatement = this.connection.prepareStatement(getByIdQuery);
        getByUserNameStatement = this.connection.prepareStatement(getByUserNameQuery);
        getAllStatement = this.connection.prepareStatement(getAllQuery);
    }


    public Person save(Person person) throws SQLException{
        if (person.getId() == null) {
            insertStatement.setString(1, person.getName());
            insertStatement.setString(2, person.getPassword());
            int id = insertStatement.executeUpdate();
            person.setId(id);
        } else {
            updateStatement.setString(1, person.getName());
            updateStatement.setString(2, person.getPassword());
            updateStatement.setInt(3, person.getId());
            updateStatement.executeUpdate();
        }
        return person;
    }

    public Person delete(Person person) throws SQLException {
        deleteStatement.setInt(1, person.getId());
        deleteStatement.executeUpdate();
        return person;
    }

    public Person getById(Integer id) throws SQLException {
        getByIdStatement.setInt(1, id);
        ResultSet resultSet = getByIdStatement.executeQuery();
        // proses mapping dari relational ke object
        if (resultSet.next()) {
            return getPersonFromResultSet(resultSet);
        }
        return null;
    }
    
    public Person getByUserName(String userName) throws SQLException {
        getByUserNameStatement.setString(1, userName);
        ResultSet resultSet = getByUserNameStatement.executeQuery();
        // proses mapping dari relational ke object
        if (resultSet.next()) {
            return getPersonFromResultSet(resultSet);
        }
        return null;
    }

    public List<Person> getAll() throws SQLException {
        List<Person> persons = new ArrayList<Person>();
        ResultSet resultSet = getAllStatement.executeQuery();
        while (resultSet.next()) {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setPassword(resultSet.getString("password"));
            persons.add(person);
        }
        return persons;
    }

    private Person getPersonFromResultSet(ResultSet resultSet) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setPassword(resultSet.getString("password"));
        return person;
    }



}
