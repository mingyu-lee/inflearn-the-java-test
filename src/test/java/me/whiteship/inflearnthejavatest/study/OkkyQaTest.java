package me.whiteship.inflearnthejavatest.study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Okky QA 중 Spring MVC에 Form post 요청시 일반 객체는 안되고, MultiValueMap은 가능한 상황 테스트 코드
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class OkkyQaTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void requestBodyToObject_PostData_ShouldThrow415Error() throws Exception {
        mockMvc.perform(post("/api/v1/posts")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content("title=제목&author=작가&content=내용")
        )
                .andExpect(status().is(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()));
    }

    @Test
    void requestBodyToMultiValueMap_PostData_ShouldReturnPostData() throws Exception {
        mockMvc.perform(post("/api/v2/posts")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .content("title=제목&author=작가&content=내용")
        )
                .andExpect(status().isOk());
    }
}
