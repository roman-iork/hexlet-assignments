package exercise;

import com.fasterxml.jackson.core.type.TypeReference;
import exercise.model.Person;
import exercise.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.junit.jupiter.Container;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.PostgreSQLContainer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@AutoConfigureMockMvc

// BEGIN
@Testcontainers
//@Transactional
// END
public class AppTest {

    @Autowired
    private MockMvc mockMvc;

    // BEGIN
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Container
    private static PostgreSQLContainer<?> containerizedDB = new PostgreSQLContainer<>("postgres")
            .withDatabaseName("db_name")
            .withUsername("so")
            .withPassword("so")
            .withInitScript("init.sql");

    @DynamicPropertySource
    public static void configureDB(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", containerizedDB::getJdbcUrl);
        registry.add("spring.datasource.username", containerizedDB::getUsername);
        registry.add("spring.datasource.password", containerizedDB::getPassword);
    }

    @Test
    public void testShowPerson() throws Exception {
        var expectedPerson = new Person();
        expectedPerson.setFirstName("Suzy");
        expectedPerson.setLastName("Fossling");
        personRepository.save(expectedPerson);
        var expectedPersonId = expectedPerson.getId();
        var response = mockMvc.perform(get("/people/" + expectedPersonId))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        var actualPerson = objectMapper.readValue(response, Person.class);
        //check response
        assertThat(actualPerson.getFirstName()).isEqualTo("Suzy");
        //check db
        assertThat(actualPerson).isEqualTo(personRepository.findById(expectedPersonId));
    }

    @Test
    public void testShowPeople() throws Exception {
        var response = mockMvc.perform(get("/people"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        var actualPeople = objectMapper.readValue(response, new TypeReference<List<Person>>() {
        });
        //check response
        assertThat(actualPeople.stream().map(Person::toString).collect(Collectors.joining()))
                .contains("John", "Simpson");
        //check db
        assertThat(actualPeople).containsExactlyInAnyOrderElementsOf(personRepository.findAll());
    }

    @Test
    public void testUpdatePerson() throws Exception {
        var testPerson = new Person();
        testPerson.setFirstName("Kelly");
        testPerson.setLastName("Joibik");
        personRepository.save(testPerson);
        var testPersonId = testPerson.getId();
        mockMvc.perform(patch("/people/" + testPersonId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"firstName": "Audry",
                                "lastName": "Thompson"}
                                """))
                .andExpect(status().isOk());
        var actualPerson = personRepository.findById(testPersonId);
        //check db
        assertThat(actualPerson.getFirstName()).isEqualTo("Audry");
        assertThat(actualPerson.getLastName()).isEqualTo("Thompson");
    }

    @Test
    public void testDeletePerson() throws Exception {
        var testPerson = new Person();
        testPerson.setFirstName("Ben");
        testPerson.setLastName("Gappock");
        personRepository.save(testPerson);
        var testPersonId = testPerson.getId();
        mockMvc.perform(delete("/people/" + testPersonId))
                .andExpect(status().isOk());
        var isActualPersonExisting = personRepository.existsById(testPersonId);
        //check db
        assertFalse(isActualPersonExisting);
    }
    // END

    @Test
    void testCreatePerson() throws Exception {
        MockHttpServletResponse responsePost = mockMvc
            .perform(
                post("/people")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"firstName\": \"Jackson\", \"lastName\": \"Bind\"}")
            )
            .andReturn()
            .getResponse();

        assertThat(responsePost.getStatus()).isEqualTo(200);

        MockHttpServletResponse response = mockMvc
            .perform(get("/people"))
            .andReturn()
            .getResponse();

        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.getContentType()).isEqualTo(MediaType.APPLICATION_JSON.toString());
        assertThat(response.getContentAsString()).contains("Jackson", "Bind");
    }
}
