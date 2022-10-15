
import Lesson_02.Lesson_02.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Domain.User;

public class Main {

	public static void main(String[] args) throws DAOEXCEPTION {
		List<User> userList = new ArrayList<>();
		userList.add(new User("Jon", "Lex", "Jo_Lex@gmail.com", "123456", "USER"));
		userList.add(new User("Marta", "Jey", "MarJey@gmail.com", "123456", "USER"));

		DAOUSER userDAO = new DAOUSER();
		userList.forEach(user -> {
			try {
				System.out.println(userDAO.insert(user.getFirstName(), user.getLastName(), user.getEmail(),
						user.getPassword(), user.getAccessLevel()));
			} catch (DAOEXCEPTION e) {
				e.printStackTrace();
			}
		});
		
		System.out.println(userDAO.readByID(2));
		System.out.println(userDAO.readByEmail("Jo_Lex2@gmail.com"));
		userDAO.updateByID(1, "Dayvi", "Hobs", "Jo_Lex2@gmail.com", "123456", "АDMIN");
		userDAO.updateByEmail("Marta", "Jeylex", "MarJeylex@gmail.com", "123456", "USER");
		userDAO.delete(1);
		userDAO.readAll().forEach(System.out::println);

		DAOMAGAZINE magazineDAO = new DAOMAGAZINE();
		System.out.println(
				magazineDAO.insert("Times", "Times is the.....!",
						LocalDate.parse("2019-04-01"), 6005));
		magazineDAO.readAll().forEach(System.out::println);

		DAOSUBSCRIBE subscribeDAO = new DAOSUBSCRIBE();
		System.out.println(subscribeDAO.insert(2, 1, true, LocalDate.parse("2019-04-26"), 12));
		subscribeDAO.readAll().forEach(System.out::println);
	
	}
}
