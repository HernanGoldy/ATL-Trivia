package com.company;

import com.company.entities.Categoria;
import com.company.entities.Pregunta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriviaController {

    @GetMapping("/categories")
    public Categoria[] getCategories() {
        Categoria cat = new Categoria();
        cat.setCategory("Arte");
        cat.setDescription("Preguntas relacionadas con arte, literatura, musica y otras expresiones culturales");

        Categoria cat2 = new Categoria();
        cat2.setCategory("Deportes");
        cat2.setDescription("Preguntas relacionadas con arte, literatura, musica y otras expresiones culturales");

        Categoria[] categorias = new Categoria[2];
        categorias[0] = cat;
        categorias[1] = cat2;

        return categorias;
    }

    @GetMapping("/question/{categoria}")
    public Pregunta getPregunta(@PathVariable String categoria) {
        if (categoria.equalsIgnoreCase("Arte")) {
            Pregunta pregunta = new Pregunta();
            pregunta.setCategory("Cultura");
            pregunta.setQuestion("¿Qué ingredientes se necesitan para hacer una michelada?");
            pregunta.setAnswer(0);
            pregunta.setExplanation("La michelada, originaria de México, " +
                    "nacida de la creatividad y el deseo de refrescar, " +
                    "se convirtió en una popular bebida que cautivó a los amantes de la cerveza con su combinación única de sabores y su espíritu festivo.");

            String[] options = new String[3];
            options[0] = "Cerveza, lima/limón, sal, chile en polvo, salsa tipo inglesa, picante";
            options[1] = "Cerveza, lima/limón y limon";
            options[2] = "Cerveza, sal, tabasco y lima/limón";
            pregunta.setOptions(options);

            return pregunta;
        } else {
            Pregunta pregunta = new Pregunta();
            pregunta.setCategory("Deportes");
            pregunta.setQuestion("¿Qué jugador es el mejor de la historia del fútbol latinoamericano?");
            pregunta.setAnswer(1);
            pregunta.setExplanation("Gracias Messi Queridoo por la copa del mundoooo");

            String[] options = new String[3];
            options[0] = "Pele";
            options[1] = "Messi";
            options[2] = "Maradona";
            pregunta.setOptions(options);

            return pregunta;
        }
    }
}
