package ma.rafya.gestiondestock.web.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ma.rafya.gestiondestock.Dto.ArticleDto;
import ma.rafya.gestiondestock.Dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static ma.rafya.gestiondestock.Utils.Constant.APP_ROOT;

@Api(APP_ROOT+"/categories")
public interface CategoryApi {

    @PostMapping(value =APP_ROOT+"/category/create" ,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces =MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Enregistrer une category" , notes = "cette methode permet d'enregistrer ou modifier  une category",response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "l'objet category est cree "),
            @ApiResponse(code = 400 ,message = "l'objet category n'est pas valid  ")
    })
    CategoryDto save(@RequestBody CategoryDto categoryDto);

    @GetMapping(value =APP_ROOT+"/category/{id}" , produces =MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "chercher une category" , notes = "cette methode permet de chercher une category par ID",response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "category a ete trouve dans la base de donnes "),
            @ApiResponse(code = 404 ,message = "aucun category existe dans ddb aven ID")
    })
    CategoryDto findById(@PathVariable("id")  Long id);

    @GetMapping(value =APP_ROOT+"/category/{codeCategory}" , produces =MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "chercher une category" , notes = "cette methode permet de chercher une category par CODE",response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "category a ete trouve dans la base de donnes "),
            @ApiResponse(code = 404 ,message = "aucun category existe dans ddb aven Icode")
    })
    CategoryDto findByCodeCategory(@PathVariable("codeCategory")  String code);

    @GetMapping(value =APP_ROOT+"/category/all" , produces =MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "renvoi la liste des category" , notes = "cette methode permet de renvoyer la liste des aticles",responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "la liste des categories"),

    })
    CategoryDto findall();

    @DeleteMapping(value = APP_ROOT+"article/deleteCategory/{id}")
    @ApiOperation(value = "supprimer  category" , notes = "cette methode permet de supprimer category ")
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "category a ete supprimer"),

    })
    void delete(@PathVariable("id")  Long id);
}
