package guru.springframework.spring5recipeapp.services;

import guru.springframework.spring5recipeapp.model.Recipe;
import guru.springframework.spring5recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long recipeId, MultipartFile file) {
        log.debug("Saving image for recipe: " + recipeId + " " + file.getOriginalFilename());
        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();
            Byte[] byteObject = new Byte[file.getBytes().length];
            int i=0;

            for(byte b : file.getBytes()){
                byteObject[i++] = b;
            }
            recipe.setImage(byteObject);
            recipeRepository.save(recipe);
        } catch (IOException e){
            //todo handle better
            log.error("Error occurred", e);
            e.printStackTrace();
        }
    }
}
