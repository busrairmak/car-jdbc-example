import java.sql.SQLException;

/**
 * Created by Mebitech on 20.07.2017.
 */
public interface CarDao {
    public void insertCar(Car car) throws SQLException;

    public void deleteCar(Integer id) throws SQLException;

    public Car selectCar(Integer id) throws SQLException;

    public void updateCar(Integer id, Car car) throws SQLException;

}
