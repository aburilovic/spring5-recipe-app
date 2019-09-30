package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class IndexControllerTest {

    IndexController indexController;

    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() throws Exception {

        String viewPage = indexController.getIndexPage(model);

        verify(model, Mockito.times(1)).addAttribute(eq("recipes"), anySet());
        verify(recipeService, Mockito.times(1)).getRecipes();
        assertEquals("index", viewPage);
    }

}