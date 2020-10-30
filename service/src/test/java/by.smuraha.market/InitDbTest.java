package by.smuraha.market;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
@Sql(
        scripts ="/Populate_DB.sql",
        executionPhase =Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
public abstract class InitDbTest {
}
