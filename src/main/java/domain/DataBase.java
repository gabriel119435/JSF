package domain;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
	public Connection connectDB() {
		try {
			// just for testing
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/database", "postgres", "postgres");
		} catch (Exception e) {
			System.out.println("connection failed - " + e);
			return null;
		}
	}
}


/*
 * POSTGRESQL INSTRUCTIONS TO CREATE CORRECT DATABASE SET UP 
 *
 * # create database database;
 * CREATE DATABASE
 * # \c database;
 * You are now connected to database "database" as user "postgres".
 * # create table mytable(msg text);
 * CREATE TABLE
 * 
 */