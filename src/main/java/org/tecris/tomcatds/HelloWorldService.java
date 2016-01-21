package org.tecris.tomcatds;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.tecris.tomcatds.entity.Book;

@Path("/book")
public class HelloWorldService {

    private Context context = null;
    private DataSource datasource = null;
    private Connection connect = null;
    private Statement statement = null;

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMsg(@PathParam("param") String msg) {
        return Response.ok(getData().get(0)).status(200).build();
    }

    private List<Book> getData() {

        List<Book> bookList = new ArrayList<>();

        try {

            // Create the statement to be used to get the results.
            statement = getConnection().createStatement();
            String query = "SELECT * FROM book";

            // Execute the query and get the result set.
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                bookList.add(
                        new Book(resultSet.getString("name"), resultSet.getString("author"), resultSet.getInt("year")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the connection and release the resources used.
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bookList;
    }

    private Connection getConnection() throws Exception {
        if (connect == null) {
            context = new InitialContext();
            datasource = (DataSource) context.lookup("java:/comp/env/jdbc/MySqlDS");
            connect = datasource.getConnection();
        }
        return connect;
    }
}
