package guru.springframework.sfgdi.datasource;

/**
 * Class(pojo) to simulate external data source config settings
 */
public class FakeDataSource {
    private String username;
    private String password;
    private String jdbcURL;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcURL() {
        return jdbcURL;
    }

    public void setJdbcURL(String jdbcURL) {
        this.jdbcURL = jdbcURL;
    }
}