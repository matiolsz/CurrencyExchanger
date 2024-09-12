package pl.mateusz.exchange.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.mateusz.exchange.model.dto.UserInput;

import java.math.BigDecimal;
import java.nio.charset.Charset;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.mateusz.exchange.model.values.Currency.EUR;
import static pl.mateusz.exchange.model.values.Currency.PLN;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnMessageWhenCalled() throws Exception {
        this.mockMvc.perform(get("/currency-exchange/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("hello")));
    }
    @Test
    public void responseIsCorrectWhenJsonRequestIsSend() throws Exception {
        String url = "http://localhost:8080/currency-exchange";
        UserInput userInputObject = new UserInput(
                BigDecimal.valueOf(100), PLN, EUR);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(userInputObject );

        mockMvc.perform(get(url).contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk());
    }
}
