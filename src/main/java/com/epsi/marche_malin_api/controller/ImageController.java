package com.epsi.marche_malin_api.controller;

import com.epsi.marche_malin_api.dtos.AddImageDTO;
import com.epsi.marche_malin_api.entities.Image;
import com.epsi.marche_malin_api.repositories.ImageRepo;
import com.epsi.marche_malin_api.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/images")
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping("/public/addImage")
    public String AddImage(@RequestBody AddImageDTO dto){
        imageService.AddImage(dto);
        return "ok";
    }
}
