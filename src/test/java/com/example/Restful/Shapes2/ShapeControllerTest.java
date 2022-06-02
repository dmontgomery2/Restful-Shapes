package com.example.Restful.Shapes2;


import com.example.Restful.Shapes2.controllers.ShapeController;
import com.example.Restful.Shapes2.controllers.models.PolygonModel;
import com.example.Restful.Shapes2.controllers.models.ShapeModel;
import com.example.Restful.Shapes2.entities.ShapeType;
import com.example.Restful.Shapes2.services.ShapeService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.io.UnsupportedEncodingException;


@WebMvcTest(value = ShapeController.class)
public class ShapeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShapeService shapeService;

    ShapeModel exampleSquare = new PolygonModel(ShapeType.SQUARE, 100d, 40d, 10);

    @Test
    public void callToListByIdEndpointShouldCallServiceAndReturnJson(){
        Mockito.when(shapeService.listById(Mockito.anyLong())).thenReturn(exampleSquare);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/list/1").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = null;

        try {
            result = mockMvc.perform(requestBuilder).andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String expected = "{shapeType:SQUARE, area:100, perimeter:40, side:10}";

        try {
            JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
