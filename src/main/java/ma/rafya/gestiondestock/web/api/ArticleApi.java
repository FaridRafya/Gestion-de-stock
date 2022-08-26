package ma.rafya.gestiondestock.web.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ma.rafya.gestiondestock.Dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
 import static ma.rafya.gestiondestock.Utils.Constant.APP_ROOT ;
 @Api(APP_ROOT+"/articles")
public interface ArticleApi {

    @PostMapping(value =APP_ROOT+"/article/create" ,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces =MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Enregistrer un article" , notes = "cette methode permet d'enregistrer ou modifier  un article",response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "l'objet article est cree "),
            @ApiResponse(code = 400 ,message = "l'objet article n'est pas valid  ")
    })
    ArticleDto save(@RequestBody ArticleDto articleDto) ;
    @GetMapping(value =APP_ROOT+"/article/{id}" , produces =MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "chercher un article" , notes = "cette methode permet de chercher un article par ID",response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "l'article a ete trouve dans la base de donnes "),
            @ApiResponse(code = 404 ,message = "aucun article existe dans ddb aven ID")
    })
    ArticleDto findById(@PathVariable("id") Long id ) ;
    @GetMapping(value =APP_ROOT+"/article/{codeArticle}'" , produces =MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "chercher un article" , notes = "cette methode permet de chercher un article par code",response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "l'article a ete trouve dans la base de donnes "),
            @ApiResponse(code = 404 ,message = "aucun article existe dans ddb avec code")
    })
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String code) ;

    @GetMapping(value =APP_ROOT+"/article/all" , produces =MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "renvoi la liste des articles" , notes = "cette methode permet de renvoyer la liste des aticles",responseContainer = "List<ArticleDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "la liste des articles"),

    })
   List<ArticleDto> findAll() ;
    @DeleteMapping(value = APP_ROOT+"article/deleteArticle/{id}")
    @ApiOperation(value = "supprimer  article" , notes = "cette methode permet de supprimer l'article ")
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "article a ete supprimer"),

    })
    void delete(@PathVariable("id") Long id)  ;
}
