import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mebitech on 20.07.2017.
 */
public class CarDaoImpl implements CarDao {
    private DatabasesOperation databasesOperation;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public CarDaoImpl() {
        databasesOperation = new DatabasesOperation();
    }


    public void insertCar(Car car) throws SQLException {
        String sql = "INSERT INTO Car(model,year) VALUES(?,?)";
        databasesOperation.connect();
        preparedStatement = databasesOperation.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, car.getModel());
        preparedStatement.setInt(2, car.getYear());
        preparedStatement.execute();
        preparedStatement.close();
        databasesOperation.disconnect();


    }

    public void deleteCar(Integer id) throws SQLException {
        String sql = "DELETE FROM Car WHERE id=?";
        databasesOperation.connect();
        preparedStatement = databasesOperation.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.close();
        databasesOperation.disconnect();


    }

    public Car selectCar(Integer id) throws SQLException {
        Car car = null;
        String sql = "SELECT *FROM Car WHERE id=?";
        databasesOperation.connect();
        preparedStatement = databasesOperation.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Integer gettingid = resultSet.getInt("id");
            String model = resultSet.getString("model");
            Integer year = resultSet.getInt("year");
            car = new Car(id, model, year);
            databasesOperation.disconnect();
            return car;
        }
        databasesOperation.disconnect();
        return null;

    }

    public void updateCar(Integer id, Car car) throws SQLException {
        String sql = "UPDATE Car SET model=?,year=? WHERE id=?";
        databasesOperation.connect();
        preparedStatement = databasesOperation.getConnection().prepareStatement(sql);
        preparedStatement.setInt(3, id);
        preparedStatement.setInt(2, car.getYear());
        preparedStatement.setString(1, car.getModel());
        preparedStatement.execute();
        preparedStatement.close();

    }
}

