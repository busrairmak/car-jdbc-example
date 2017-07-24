import java.sql.SQLException;

/**
 * Created by Mebitech on 21.07.2017.
 */
public class Application {
    private static CarDao carDao;

    public static void main(String[] args) throws SQLException {
//        carDao = new CarDaoImpl();
////        Car car = new Car();
////        car.setModel("volvo");
////        car.setYear(1997);
////
////        carDao.insertCar(car);
//         carDao.deleteCar(4);
          Car cars = carDao.selectCar(3);
          System.out.println(cars);


    }

}
