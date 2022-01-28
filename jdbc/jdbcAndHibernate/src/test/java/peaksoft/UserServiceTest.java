package peaksoft;

import org.junit.Assert;
import org.junit.Test;
import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.util.List;

public class UserServiceTest {

    private final UserService userService = new UserServiceImpl();

    private final String testName = "Erlan";
    private final String testLast_Name = "Omarbekov";
    private final byte testAge = 23;

    @Test
    public void dropUsersTable() {
        try {
            userService.dropUsersTable();
           //userService.dropUsersTable();
        } catch (Exception e) {
            Assert.fail("При тестировании удаления таблицы произошло исключение\n" + e);
        }
    }

    @Test
    public void createUsersTable() {
        try {
           // userService.dropUsersTable();
            userService.createUsersTable();
        } catch (Exception e) {
            Assert.fail("При тестировании создания таблицы пользователей произошло исключение\n" + e.getMessage());
        }
    }

    @Test
    public void saveUsers() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLast_Name, testAge);

            User user = userService.getAllUsers().get(0);

            if (!testName.equals(user.getName())
                    || !testLast_Name.equals(user.getLast_Name())
                    || testAge != user.getAge()
            ) {
                Assert.fail("Users был некорректно добавлен в базу данных");
            }

        } catch (Exception e) {
            Assert.fail("Во время тестирования сохранения пользователя произошло исключение\n" + e);
        }
    }

    @Test
    public void removeUsersById() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLast_Name, testAge);
            userService.removeUserById(1L);
        } catch (Exception e) {
            Assert.fail("При тестировании удаления пользователя по id произошло исключение\n" + e);
        }
    }

    @Test
    public void getAllUsers() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLast_Name, testAge);
            List<User> userList = userService.getAllUsers();

            if (userList.size() != 1) {
                Assert.fail("Проверьте корректность работы метода сохранения пользователя/удаления или создания таблицы");
            }
        } catch (Exception e) {
            Assert.fail("При попытке достать всех пользователей из базы данных произошло исключение\n" + e);
        }
    }

    @Test
    public void cleanUsersTable() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLast_Name, testAge);
            userService.cleanUsersTable();

            if (userService.getAllUsers().size() != 0) {
                Assert.fail("Метод очищения таблицы пользователей реализован не корректно");
            }
        } catch (Exception e) {
            Assert.fail("При тестировании очистки таблицы пользователей произошло исключение\n" + e);
        }
    }
}
